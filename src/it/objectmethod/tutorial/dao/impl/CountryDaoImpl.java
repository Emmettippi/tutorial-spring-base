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
//c'è già in NamedParameterJdbcDaoSupport
//	private DataSource dataSource;
//	private JdbcTemplate jdbcTemplateObject;
//
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
//	}

	@Override
	public Country getCountryByCode(String code) {
		String sql = "SELECT * FROM country WHERE code = :code";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codiceInserito", code);
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		Country country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		return country;

		// Better implementation
		//	String sql = "SELECT code codice, name nome FROM country WHERE code = :codiceInserito";
		//	MapSqlParameterSource params = new MapSqlParameterSource();
		//	params.addValue("codiceInserito", code);
		//	BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		//	country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);

		
	}
	@Override
	public Integer getMaxCountryId() {
		String sql ="SELECT MAX(idcountry) AS maximum FROM country";
		MapSqlParameterSource params = new MapSqlParameterSource();
		int  max= getNamedParameterJdbcTemplate().queryForObject(sql, params, Integer.class);
		//BeanPropertyRowMapper<Integer> rm = new BeanPropertyRowMapper<Integer>(Integer.class);
		return max;
	}

	@Override
	public Country insertCountry(Country country) {
		String sql ="INSERT INTO Country (idcountry, name, code) VALUES (:idcountry, :name, :code)";//indica che stiamo inserendo una variabile e non una stringa al posto del punto interrogativo
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("idcountry", getMaxCountryId()+1 );
        params.addValue("name", country.getNome());
        params.addValue("code", country.getCodice());
        BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
        country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		return country;
	}
}
