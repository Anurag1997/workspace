package com.vadantu.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products", catalog = "vadantu_db")
public class Inventory implements java.io.Serializable {

	private Long idProduct;
	private String description;
	private Integer quantity;
	private BigDecimal price;

	public Inventory() {
	}
	public Inventory(String description, BigDecimal price) {
		this.description = description;
		this.price = price;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idproduct", unique = true, nullable = false)
	public Long getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	@Column(name = "description", nullable = false, length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "price", nullable = false, precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
