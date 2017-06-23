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
		@NamedQuery(name = "Comment.findByMovieId", query = "select c from Comment c inner join c.movie m where m.id = :movieId"),
		@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c") })
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Movie movie;

	@Column(name = "user_comment")
	private String userComment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

}
