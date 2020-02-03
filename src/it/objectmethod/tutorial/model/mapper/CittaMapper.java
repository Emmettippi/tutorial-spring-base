package it.objectmethod.tutorial.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.tutorial.model.Citta;


public class CittaMapper  implements RowMapper<Citta> { 
	@Override
	public Citta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Citta citta = new Citta();
		citta.setIdcitta(rs.getLong("idcitta"));
		citta.setCode(rs.getString("code"));
		// DB: column_name
		// Java: columnName
		citta.setName(rs.getString("name"));
		return citta;
	}

}
