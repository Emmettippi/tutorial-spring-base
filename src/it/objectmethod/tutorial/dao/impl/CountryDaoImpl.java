package it.objectmethod.tutorial.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.tutorial.dao.ICountryDao;
import it.objectmethod.tutorial.model.Country;

public class CountryDaoImpl extends NamedParameterJdbcDaoSupport implements ICountryDao {

	@Override
	public Country getCountryByCode(String code) {
		String sql = "SELECT * FROM country WHERE code = :code";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("code", code); // refer to :code
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		Country country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
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
	public Country insertCountry(Country country) {
		String sql = "INSERT INTO country (idcountry, code, name) "
			+ "VALUES (:idcountry, :code, :name)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idcountry", getMaxCountryId() + 1); // refer to :idcountry
		params.addValue("code", country.getCodice()); // refer to :code
		params.addValue("name", country.getNome()); // refer to :name
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		int rows = getNamedParameterJdbcTemplate().getJdbcTemplate().update(sql);
		return country;
	}
}
