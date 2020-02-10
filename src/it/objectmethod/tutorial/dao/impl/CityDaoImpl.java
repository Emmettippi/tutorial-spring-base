package it.objectmethod.tutorial.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.tutorial.dao.ICityDao;
import it.objectmethod.tutorial.model.City;
import it.objectmethod.tutorial.model.mapper.CityMapper;

public class CityDaoImpl extends NamedParameterJdbcDaoSupport implements ICityDao {

	@Override
	public City getCityByCode(String code) {
		City city = null;
		if (code != null && !code.isEmpty()) {
			String sql = "SELECT * FROM city WHERE code = :code";
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("code", code); // refer to :code
			BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);
			city = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		}
		return city;
	}

	@Override
	public Integer getMaxCityId() {
		String sql = "SELECT MAX(idcity) AS maximum FROM city";
		MapSqlParameterSource params = new MapSqlParameterSource();
		// BeanPropertyRowMapper<Integer> rm = new BeanPropertyRowMapper<Integer>(Integer.class);
		int max = getNamedParameterJdbcTemplate().queryForObject(sql, params, Integer.class);
		return max;
	}

	@Override
	public boolean insertCity(City city) {
		String sql = "INSERT INTO city (idcity, code, name) "
			+ "VALUES (:idcity, :code, :name)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idcity", getMaxCityId() + 1); // refer to :idcity
		params.addValue("code", city.getCode()); // refer to :code
		params.addValue("name", city.getName()); // refer to :name
		// BeanPropertyRowMapper<city> rm = new BeanPropertyRowMapper<city>(city.class);
		int rows = getNamedParameterJdbcTemplate().update(sql, params);

		return rows == 1;
	}

	@Override
	public List<City> findAll() {
		String sql = "SELECT * FROM City";
		List<City> countries = getNamedParameterJdbcTemplate()
			.query(sql, new CityMapper());
		return countries;
	}

	@Override
	public boolean deleteCity(Long idcity) {
		String sql = "DELETE FROM city WHERE idcity = :idcity";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idcity", idcity);
		int rows = getNamedParameterJdbcTemplate().update(sql, params);
		return rows == 1;
	}
}