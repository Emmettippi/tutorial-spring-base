package it.objectmethod.tutorial.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.tutorial.model.City;


public class CityMapper implements RowMapper<City> {

	@Override
	public City mapRow(ResultSet rs, int rowNum) throws SQLException {
		City city = new City();
		city.setIdcity(rs.getLong("idcity"));
		city.setCode(rs.getString("code"));
		// DB: column_name
		// Java: columnName
		city.setName(rs.getString("name"));
		return city;
	}
}