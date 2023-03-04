package com.jspiders.hibaernatemanytomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CustomerDTO {

	@Id
	private int id;
	private String name;
	private long contact;
	private String city;
	
}
