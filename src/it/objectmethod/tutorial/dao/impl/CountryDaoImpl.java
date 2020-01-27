package it.objectmethod.tutorial.dao.impl;

import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import it.objectmethod.tutorial.dao.ICountryDao;
import it.objectmethod.tutorial.model.Country;
import it.objectmethod.tutorial.model.mapper.CountryMapper;

public class CountryDaoImpl extends NamedParameterJdbcDaoSupport implements ICountryDao {


	@Override
	public Country getCountryByCode(String code) {
		String sql = "SELECT * FROM country WHERE code = :code";
		MapSqlParameterSource params = new MapSqlParameterSource();
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		Country country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);

		// Better implementation
		//	String sql = "SELECT code codice, name nome FROM country WHERE code = :codiceInserito";
		//	MapSqlParameterSource params = new MapSqlParameterSource();
		//	params.addValue("codiceInserito", code);
		//	BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		//	country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);

		return country;
	}

	@Override
	public Integer getMaxCountryById() {
		String sql = "SELECT MAX(idcountry) AS maximum FROM country";
		MapSqlParameterSource params = new MapSqlParameterSource();
		//BeanPropertyRowMapper<Integer> rm = new BeanPropertyRowMapper<Integer>(Integer.class);
		int max = getNamedParameterJdbcTemplate().queryForObject(sql, Integer.class);
		return max;
	}

	@Override
	public Country save(Country country) {
		String sql = "INSERT INTO country(idcountry, name, code) VALUES (:idcountry, :name, :code)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idcountry", getMaxCountryById() + 1);
		params.addValue("name", country.getNome());
		params.addValue("code", country.getCodice());
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		return country;
	}

}
