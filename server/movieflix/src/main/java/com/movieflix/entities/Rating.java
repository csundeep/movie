package com.movieflix.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "Rating.findByUserIdAndMovieId", query = "select r from Rating r where r.user.id = :userId and r.movie.id = :movieId"),
		@NamedQuery(name = "Rating.findAvgByMovieId", query = "select avg(r.totalRating) from Rating r where r.movie.id = :movieId") })
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Movie movie;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;

	@Column(name = "total_rating")
	private int totalRating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(int totalRating) {
		this.totalRating = totalRating;
	}

}
