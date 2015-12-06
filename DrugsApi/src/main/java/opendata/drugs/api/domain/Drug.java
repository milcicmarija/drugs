package opendata.drugs.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registar_lekova")
public class Drug {

	@Id
	@Column(name = "naziv_leka")
	private String name;

	@Column(name = "inn")
	private String genericName;

	@Column(name = "rezim_izdavanja_leka")
	private String regimeOfDrug;

	@Column(name = "oblik_i_doza_leka")
	private String formAndDose;

	@Column(name = "proizvodjac")
	private String manufacturer;

	@Column(name = "atc")
	private String atc;

	@Column(name = "jkl")
	private Integer uniquClasification;

	@Column(name = "cena")
	private Double price;

	public Drug() {

	}

	public Drug(String name, String genericName, String regimeOfDrugs, String formAndDose, String manufacturer, String atc, Integer uniqeClasification, Double price) {

		this.name = name;
		this.genericName = genericName;
		this.regimeOfDrug = regimeOfDrugs;
		this.formAndDose = formAndDose;
		this.manufacturer = manufacturer;
		this.atc = atc;
		this.uniquClasification = uniqeClasification;
		this.price = price;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getRegimeOfDrug() {
		return regimeOfDrug;
	}

	public void setRegimeOfDrug(String regimeOfDrug) {
		this.regimeOfDrug = regimeOfDrug;
	}

	public String getFormAndDose() {
		return formAndDose;
	}

	public void setFormAndDose(String formAndDose) {
		this.formAndDose = formAndDose;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getAtc() {
		return atc;
	}

	public void setAtc(String atc) {
		this.atc = atc;
	}

	public Integer getUniquClasification() {
		return uniquClasification;
	}

	public void setUniquClasification(Integer uniquClasification) {
		this.uniquClasification = uniquClasification;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Drugs [name=" + name + ", generic name="
				+ genericName + ",regime of drugs =" + regimeOfDrug + ", manufacturer="
				+ manufacturer + ", form and dose="+ formAndDose + ","
				+ " unique clasification=" + uniquClasification + ", price=" + price + "]";
	}
}
