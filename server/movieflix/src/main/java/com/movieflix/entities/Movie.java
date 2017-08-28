package com.movieflix.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:movieTitle ORDER BY m.year DESC"),
		@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.title ASC"),

		@NamedQuery(name = "Movie.findByMovieTypeAndSortByYear", query = "SELECT m FROM Movie m WHERE m.movieType=:movieType ORDER BY m.year DESC"),
		@NamedQuery(name = "Movie.findByMovieTypeAndSortByIMDBRating", query = "SELECT m FROM Movie m WHERE m.movieType=:movieType ORDER BY m.imdbRating DESC"),
		@NamedQuery(name = "Movie.findByMovieTypeAndSortByIMDBVotes", query = "SELECT m FROM Movie m WHERE m.movieType=:movieType ORDER BY m.imdbVotes DESC"),
		@NamedQuery(name = "Movie.findByMovieType", query = "SELECT m FROM Movie m WHERE m.movieType=:movieType ORDER BY m.title ASC"),

		@NamedQuery(name = "Movie.findByYearAndSortByYear", query = "SELECT m FROM Movie m WHERE m.year=:year ORDER BY m.year DESC"),
		@NamedQuery(name = "Movie.findByYearAndSortByIMDBRating", query = "SELECT m FROM Movie m WHERE m.year=:year ORDER BY m.imdbRating DESC"),
		@NamedQuery(name = "Movie.findByYearAndSortByIMDBVotes", query = "SELECT m FROM Movie m WHERE m.year=:year ORDER BY m.imdbVotes DESC"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:year ORDER BY m.title ASC"),

		@NamedQuery(name = "Movie.findBygenreAndSortByYear", query = "select m from Movie m inner join m.genre g where g.genereType = :genre ORDER BY m.year DESC"),
		@NamedQuery(name = "Movie.findBygenreAndSortByIMDBRating", query = "select m from Movie m inner join m.genre g where g.genereType = :genre ORDER BY m.imdbRating DESC"),
		@NamedQuery(name = "Movie.findBygenreAndSortByIMDBVotes", query = "select m from Movie m inner join m.genre g where g.genereType = :genre ORDER BY m.imdbVotes DESC"),
		@NamedQuery(name = "Movie.findByGenre", query = "select m from Movie m inner join m.genre g where g.genereType = :genre ORDER BY m.title ASC"),

		@NamedQuery(name = "Movie.findAllMoviesAndSortByYear", query = "SELECT m FROM Movie m ORDER BY m.year DESC"),
		@NamedQuery(name = "Movie.findAllMoviesAndSortByIMDBRating", query = "SELECT m FROM Movie m ORDER BY m.imdbRating DESC"),
		@NamedQuery(name = "Movie.findAllMoviesAndSortByIMDBVotes", query = "SELECT m FROM Movie m ORDER BY m.imdbVotes DESC") })
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private String title;
	@Column
	private String plot;
	@Column(name = "release_date")
	private String releaseDate;
	@Column
	private String year;
	@Column
	private String rating;
	@Column(name = "movie_duration")
	private String movieDuration;
	@Column
	private String language;
	@Column
	private String country;
	@Column(name = "movie_poster")
	private String moviePoster;
	@Column(name = "movie_type")
	private String movieType;
	@Column
	private String director;
	@Column(name = "imdb_url", unique = true)
	private String imdbURL;
	@Column(name = "imdb_rating")
	private double imdbRating;
	@Column(name = "meta_score")
	private int metaScore;
	@Column(name = "imdb_votes")
	private int imdbVotes;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Genre> genre;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Cast> casts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	
	

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getMetaScore() {
		return metaScore;
	}

	public String getImdbURL() {
		return imdbURL;
	}

	public void setImdbURL(String imdbURL) {
		this.imdbURL = imdbURL;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public int getMetascore() {
		return metaScore;
	}

	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public Set<Genre> getGenre() {
		return genre;
	}

	public void setGenre(Set<Genre> genre) {
		this.genre = genre;
	}

	public Set<Cast> getCasts() {
		return casts;
	}

	public void setCasts(Set<Cast> casts) {
		this.casts = casts;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", plot=" + plot + ", releaseDate=" + releaseDate + ", year="
				+ year + ", rating=" + rating + ", movieDuration=" + movieDuration + ", language=" + language
				+ ", country=" + country + ", moviePoster=" + moviePoster + ", movieType=" + movieType + ", director="
				+ director + ", imdbURL=" + imdbURL + ", imdbRating=" + imdbRating + ", metaScore=" + metaScore
				+ ", imdbVotes=" + imdbVotes + ", genre=" + genre + ", casts=" + casts + "]";
	}


}
