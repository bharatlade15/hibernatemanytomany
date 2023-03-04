package com.jspiders.hibaernatemanytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity

public class ProductDTO {

	@Id
	private int id;
	private String name;
	private String category;
	private double price;
	@ManyToMany
	List<CustomerDTO> customers;
}
