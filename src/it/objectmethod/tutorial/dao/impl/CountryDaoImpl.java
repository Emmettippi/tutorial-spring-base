package it.objectmethod.tutorial.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.tutorial.dao.ICountryDao;
import it.objectmethod.tutorial.model.Country;

public class CountryDaoImpl extends NamedParameterJdbcDaoSupport implements ICountryDao {

	
	

	@Override
	public Country getCountryByCode(String code) {
		Country country = null;
		String sql = "SELECT * FROM country WHERE code = ?";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("code", country.getCodice());
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		
		

		// Better implementation
		//	String sql = "SELECT code codice, name nome FROM country WHERE code = :codiceInserito";
		//	MapSqlParameterSource params = new MapSqlParameterSource();
		//	params.addValue("codiceInserito", code);
		//	BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		//	country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);

		return country;
	}
	
	
	@Override
	public Country insertCountry(Country country) {
		String sql = "INSERT INTO country (idcountry, code, name)"+"VALUES (:idcountry, :code, :name)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idcountry", getMaxCountryId()+1 );
		params.addValue("code", country.getCodice());
		params.addValue("name", country.getNome());
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		return country;
	}
	
	@Override
	public Integer getMaxCountryId() {
		String sql= "SELECT MAX(idcountry) AS maximum FROM country";
		MapSqlParameterSource params = new MapSqlParameterSource();
		BeanPropertyRowMapper<Integer> rm = new BeanPropertyRowMapper<Integer> (Integer.class);
		Integer max = getNamedParameterJdbcTemplate().queryForObject(sql, params, Integer.class);
		return max;
	}

}
