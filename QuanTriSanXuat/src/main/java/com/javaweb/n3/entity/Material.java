/**
 * 
 */
package com.javaweb.n3.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author HungDinh
 *
 */

@Entity
public class Material implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2592245604053696185L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String materialName;

	private int amount;

	private String unit;

	private double price;
	
	@OneToMany(mappedBy = "material")
	@JsonIgnore
	private List<MaterialProduct> materialProduct;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<MaterialProduct> getMaterialProduct() {
		return materialProduct;
	}

	public void setMaterialProducts(List<MaterialProduct> materialProduct) {
		this.materialProduct = materialProduct;
	}

	
}
