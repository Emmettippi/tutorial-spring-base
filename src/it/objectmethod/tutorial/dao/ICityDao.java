package it.objectmethod.tutorial.dao;

import java.util.List;

import it.objectmethod.tutorial.model.City;

public interface ICityDao {

	public Integer getMaxCityId();
	
	public List<City> findAll();

	public boolean insertCity(City city);

	public City getCityByCode(String code);

	boolean deleteCity(Long idcity);}
