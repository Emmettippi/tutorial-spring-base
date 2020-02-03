package it.objectmethod.tutorial.model;

public class Citta {

	private Long idcitta;
	private String code;
	private String name;
	private Long idcountry;
	public Long getIdcitta() {
		return idcitta;
	}
	public void setIdcitta(Long idcitta) {
		this.idcitta = idcitta;
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
	public Long getIdcountry() {
		return idcountry;
	}
	public void setIdcountry(Long idcountry) {
		this.idcountry = idcountry;
	}
	public Citta(Long idcitta, String code, String name, Long idcountry) {
		super();
		this.idcitta = idcitta;
		this.code = code;
		this.name = name;
		this.idcountry = idcountry;
	}
	public Citta() {
		super();
	}
	@Override
	public String toString() {
		return "Citta [idcitta=" + idcitta + ", code=" + code + ", name=" + name + ", idcountry=" + idcountry + "]";
	}
	
}
