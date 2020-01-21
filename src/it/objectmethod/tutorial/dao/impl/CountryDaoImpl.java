package it.objectmethod.tutorial.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.objectmethod.tutorial.dao.ICountryDao;
import it.objectmethod.tutorial.model.Country;
import it.objectmethod.tutorial.model.mapper.CountryMapper;

public class CountryDaoImpl implements ICountryDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public Country getCountryByCode(String code) {
		Country country = null;
		String sql = "SELECT * FROM country WHERE code = ?";
		country = this.jdbcTemplateObject.queryForObject(sql, new Object[]{code}, new CountryMapper());	
		return country;
	}

}
