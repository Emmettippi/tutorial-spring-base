package it.objectmethod.tutorial.dao;

import java.util.List;

import it.objectmethod.tutorial.model.Citta;

public interface ICittaDao {
	public Citta getCittaByCode(String code);

	public Integer getMaxCittaId();

	public boolean insertCitta(Citta citta);

	public List<Citta> findAll();

	public boolean deleteCitta(Long idcitta);

}
