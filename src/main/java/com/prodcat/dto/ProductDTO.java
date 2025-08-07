package com.prodcat.dto;

import com.prodcat.entity.Product;

public class ProductDTO {
    public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	private Long prodId;
    private String name;
    private double price;
    private String description;
    private String categoryName;
    private String categoryDescription; 

    public ProductDTO(Long prodId, String name, double price, String description, String categoryName, String categoryDescription) {
        this.prodId = prodId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

}
