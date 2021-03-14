package com.sprint1.movie.booking.ticket1.booking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.ticket1.booking.entities.Movie;


@Component
public interface MovieService {
	public Movie addMovie(Movie movie);
	@Transactional
	public Movie updateMovie(Movie movie);
	public Movie removeMovie(int movieId);
	public Movie viewMovie(int movieId);
	public List<Movie>viewMovieList();
	public List<Movie>viewMovieList(int theatreId);
	public List<Movie>viewMovieList(LocalDate date);

}
