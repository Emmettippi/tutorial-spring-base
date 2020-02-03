package it.objectmethod.tutorial.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.tutorial.dao.ICittaDao;
import it.objectmethod.tutorial.model.Citta;
import it.objectmethod.tutorial.model.mapper.CittaMapper;

public class CittaDaoImpl extends NamedParameterJdbcDaoSupport implements ICittaDao{
	 

		@Override
		public Citta getCittaByCode(String code) {
			Citta citta = null;
			if (code != null && !code.isEmpty()) {
				String sql = "SELECT * FROM citta WHERE code = :code";
				MapSqlParameterSource params = new MapSqlParameterSource();
				params.addValue("code", code); // refer to :code
				BeanPropertyRowMapper<Citta> rm = new BeanPropertyRowMapper<Citta>(Citta.class);
				citta = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
			}
			return citta;
			
		}

		@Override
		public Integer getMaxCittaId() {
			String sql = "SELECT MAX(idcitta) AS maximum FROM citta";
			MapSqlParameterSource params = new MapSqlParameterSource();
			// BeanPropertyRowMapper<Integer> rm = new BeanPropertyRowMapper<Integer>(Integer.class);
			int max = getNamedParameterJdbcTemplate().queryForObject(sql, params, Integer.class);
			return max;
		}

		@Override
		public boolean insertCitta(Citta citta) {
			String sql = "INSERT INTO citta (idcitta, code, name) "
				+ "VALUES (:idcitta, :code, :name)";
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("idcitta", getMaxCittaId() + 1); // refer to :idcitta
			params.addValue("code", citta.getCode()); // refer to :code
			params.addValue("name", citta.getName()); // refer to :name
			// BeanPropertyRowMapper<Citta> rm = new BeanPropertyRowMapper<Citta>(Citta.class);
			int rows = getNamedParameterJdbcTemplate().update(sql, params);

			return rows == 1;
		}

		@Override
		public List<Citta> findAll() {
			String sql = "SELECT * FROM citta";
			List<Citta> cittas = getNamedParameterJdbcTemplate()
				.query(sql, new CittaMapper());
			return cittas;
		}

		@Override
		public boolean deleteCitta(Long idcitta) {
			String sql = "DELETE FROM citta WHERE idcitta = :idcitta";
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("idcitta", idcitta);
			int rows = getNamedParameterJdbcTemplate().update(sql, params);
			return rows == 1;
		}
	}



