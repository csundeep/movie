package com.movieflix.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String genereType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenereType() {
		return genereType;
	}

	public void setGenereType(String genereType) {
		this.genereType = genereType;
	}

}
