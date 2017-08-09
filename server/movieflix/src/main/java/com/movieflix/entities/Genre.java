package com.movieflix.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Genre.findAll", query = "SELECT m FROM Genre m ORDER BY m.genereType ASC") })
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

	@Override
	public String toString() {
		return "Genre [id=" + id + ", genereType=" + genereType + "]";
	}

	
}
