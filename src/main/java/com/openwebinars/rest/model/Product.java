package com.openwebinars.rest.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Product {

	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	private float price;

	private String image;

	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

}
