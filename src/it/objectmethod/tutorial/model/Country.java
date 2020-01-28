package it.objectmethod.tutorial.model;

public class Country {

	private Long idcountry;
	private String code;
	private String name;

	public Long getIdcountry() {
		return idcountry;
	}

	public void setIdcountry(Long idcountry) {
		this.idcountry = idcountry;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void deleteCountryById(Long idcountry) {
		this.idcountry = idcountry;
	}
}
