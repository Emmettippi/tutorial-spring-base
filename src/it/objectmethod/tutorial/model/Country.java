package it.objectmethod.tutorial.model;

public class Country {

	private Long idCountry;
	private String code;
	private String name;

	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long id) {
		this.idCountry = id;
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
}
