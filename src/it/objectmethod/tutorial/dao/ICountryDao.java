package it.objectmethod.tutorial.dao;

import it.objectmethod.tutorial.model.Country;

public interface ICountryDao {

	public Country getCountryByCode(String code);
	public  Integer getMaxCountryId();
	public  Country insertCountry(Country country);
	
}
