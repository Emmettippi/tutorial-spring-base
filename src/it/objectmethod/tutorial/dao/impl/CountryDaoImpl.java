package it.objectmethod.tutorial.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.tutorial.dao.ICountryDao;
import it.objectmethod.tutorial.model.Country;
import it.objectmethod.tutorial.model.mapper.CountryMapper;

public class CountryDaoImpl extends NamedParameterJdbcDaoSupport implements ICountryDao {

	@Override
	public Country getCountryByCode(String code) {
		Country country = null;
		if (code != null && !code.isEmpty()) {
			String sql = "SELECT * FROM country WHERE code = :code";
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("code", code); // refer to :code
			BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
			country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		}
		return country;
	}

	@Override
	public Integer getMaxCountryId() {
		String sql = "SELECT MAX(idcountry) AS maximum FROM country";
		MapSqlParameterSource params = new MapSqlParameterSource();
		// BeanPropertyRowMapper<Integer> rm = new BeanPropertyRowMapper<Integer>(Integer.class);
		int max = getNamedParameterJdbcTemplate().queryForObject(sql, params, Integer.class);
		return max;
	}

	@Override
	public boolean insertCountry(Country country) {
		String sql = "INSERT INTO country (idcountry, code, name) "
			+ "VALUES (:idcountry, :code, :name)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idcountry", getMaxCountryId() + 1); // refer to :idcountry
		params.addValue("code", country.getCode()); // refer to :code
		params.addValue("name", country.getName()); // refer to :name
		// BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		int rows = getNamedParameterJdbcTemplate().update(sql, params);

		return rows == 1;
	}

	@Override
	public List<Country> findAll() {
		String sql = "SELECT * FROM country";
		// MapSqlParameterSource params = new MapSqlParameterSource();
		// BeanPropertyRowMapper<List<Country>> rm = new BeanPropertyRowMapper<List<Country>>(ArrayList<Country>.class);
		List<Country> countries = getNamedParameterJdbcTemplate().query(sql, new CountryMapper());
		for (Country c : countries) {
			System.out.println(c);
		}
		return countries;
	}
}
