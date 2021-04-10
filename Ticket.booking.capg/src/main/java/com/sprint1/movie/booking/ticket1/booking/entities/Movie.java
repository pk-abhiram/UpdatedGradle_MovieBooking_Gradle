package com.sprint1.movie.booking.ticket1.booking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel("Movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	@Column(nullable = false)
	private String movieName;
	@Column(nullable = false)
	private String movieGenre;
	@Column(nullable = false)
	private String movieHours;
	@Column(nullable = false)
	private String language;
	@Column(nullable = false)
	private String description;
	
	private String imageUrl;
	
	
	
	
	public Movie() {
		super();
	}
	
	
	
	public Movie(int movieId, String movieName, String movieGenre, String movieHours, String language,
			String description, String imageUrl) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieHours = movieHours;
		this.language = language;
		this.description = description;
		this.imageUrl = imageUrl;
	}



	public Movie(String movieName, String movieGenre, String movieHours, String language, String description,
			String imageUrl) {
		super();
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieHours = movieHours;
		this.language = language;
		this.description = description;
		this.imageUrl = imageUrl;
	}



	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieHours() {
		return movieHours;
	}
	public void setMovieHours(String movieHours) {
		this.movieHours = movieHours;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre + ", movieHours="
				+ movieHours + ", language=" + language + ", description=" + description + "]";
	}



	@Override
	public int hashCode() {
		
		int result = 1;
		result = movieId;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (movieId != other.movieId)
			return false;
		return true;
	}
	
	

	
	
	
}
