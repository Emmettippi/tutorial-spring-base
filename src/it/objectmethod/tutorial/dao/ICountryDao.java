package it.objectmethod.tutorial.dao;

import it.objectmethod.tutorial.model.Country;

public interface ICountryDao {

	public Country getCountryByCode(String code);

	public Integer getMaxCountryId();

	public boolean insertCountry(Country country);
	
	public Country getCountryAll();
}
