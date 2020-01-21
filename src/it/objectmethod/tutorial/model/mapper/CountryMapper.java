package it.objectmethod.tutorial.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.tutorial.model.Country;

public class CountryMapper implements RowMapper<Country>{

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country country = new Country();
		country.setCodice(rs.getString("Code"));
		country.setNome(rs.getString("Name"));
		return country;
	}

}
