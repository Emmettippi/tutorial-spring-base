package it.objectmethod.tutorial.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.tutorial.dao.ICountryDao;
import it.objectmethod.tutorial.model.Country;
import it.objectmethod.tutorial.model.mapper.CountryMapper;

public class CountryDaoFigoImpl extends NamedParameterJdbcDaoSupport implements ICountryDao {

//	@Override
//	public Country getCountryByCode(String code) {
//		Country country = null;
//		String sql = "SELECT * FROM country WHERE code = ?";
//		country = getJdbcTemplate().queryForObject(sql, new Object[]{code}, new CountryMapper());	
//		return country;
//	}

//	@Override
//	public Country getCountryByCode(String code) {
//		Country country = null;
//		String sql = "SELECT code codice, name nome FROM country WHERE code = ?";
//		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
//		country = getJdbcTemplate().queryForObject(sql, new Object[]{code}, rm);	
//		return country;
//	}
	
	@Override
	public Country getCountryByCode(String code) {
		Country country = null;
		String sql = "SELECT code codice, name nome FROM country WHERE code = :codiceInserito";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codiceInserito", code);
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		return country;
	}
}
