package com.sprint1.movie.booking.ticket1.booking.servicesimplementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.ticket1.booking.entities.Movie;
import com.sprint1.movie.booking.ticket1.booking.entities.Show;
import com.sprint1.movie.booking.ticket1.booking.entities.Theatre;
import com.sprint1.movie.booking.ticket1.booking.exceptions.MovieNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.exceptions.TheatreNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.repository.MovieRepository;
import com.sprint1.movie.booking.ticket1.booking.repository.ShowRepository;
import com.sprint1.movie.booking.ticket1.booking.repository.TheatreRepository;
import com.sprint1.movie.booking.ticket1.booking.service.MovieService;

@Service
public class MovieServiceImplementation implements MovieService {
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	TheatreServiceImplementation theatreServiceImplementation;
	
	@Autowired
	ShowServiceImplementation showServiceImplementation;
	
	public Movie addMovie(Movie movie) {
		
		return 	movieRepository.save(movie);
		
	}
	
	@Transactional
	public Movie updateMovie(Movie movie) {
		Optional<Movie> getUpdateMovie=movieRepository.findById(movie.getMovieId());
		Movie updateMovie=null;
		if(getUpdateMovie.isPresent()) {
		updateMovie=getUpdateMovie.get();
		if(movie.getDescription()!=null)
		{updateMovie.setDescription(movie.getDescription());}
		if(movie.getLanguage()!=null)
		{updateMovie.setLanguage(movie.getLanguage());}
		if(movie.getMovieGenre()!=null)
		{updateMovie.setMovieGenre(movie.getMovieGenre());}
		if(movie.getMovieHours()!=null)
		{updateMovie.setMovieHours(movie.getMovieHours());}
		if(movie.getMovieName()!=null)
		{updateMovie.setMovieName(movie.getMovieName());}
		}
		else {
			throw new MovieNotExistsException("Movie Already Exist with ID : " +  movie.getMovieId());
		}
		return updateMovie;
	}
	public Movie removeMovie(int movieId) {
		Optional<Movie> findRemoveMovie=movieRepository.findById(movieId);
		Movie removeMovie=null;
		if(findRemoveMovie.isPresent()) {
		removeMovie=findRemoveMovie.get();
		List<Show> shows=showServiceImplementation.viewAllShows();
		int theatreId;
		for(Show s:shows) {
			if(s.getMovie().getMovieId()==movieId) {
				theatreId=s.getTheatreId();
				showServiceImplementation.removeShow(s);
				theatreServiceImplementation.theatreRemoveMovie(theatreId, movieId);
			}
		}
		movieRepository.delete(removeMovie);
		}
		else {
			throw new MovieNotExistsException("Movie not Exist with ID : " +  movieId);
		}
		return removeMovie;
	}
	
	public Movie viewMovie(int movieId) {
		Optional<Movie> findRemoveMovie=movieRepository.findById(movieId);
		if(findRemoveMovie.isPresent()) {
			return findRemoveMovie.get();
		}
		else {
			throw new MovieNotExistsException("Movie Not Exist with ID : " + movieId);
		}
		
	}
	public List<Movie>viewMovieList(){
		return movieRepository.findAll();
	}
	@Transactional
	public List<Movie>viewMovieList(int theatreId){
		Optional<Theatre>theatres=theatreRepository.findById(theatreId);
		
		List<Movie>movies=null;
		if(theatres.isPresent())
		{	movies=theatres.get().getListOfMovies();}
		else {
			throw new TheatreNotExistsException("Movie Not Exist with ID : " + theatreId);
		}
		return movies;
	}
	public List<Movie>viewMovieList(LocalDate date){
		List<Show>shows=showRepository.findAll();
		List<Movie>movies = new ArrayList<>();
		if(!shows.isEmpty()) {
		for(Show show:shows) {
			if(show.getShowStartTime().toLocalDate().isEqual(date)) {
				movies.add(show.getMovie());
			}
		}
		}
		return movies;
	}
	
	public Movie findMovie(Movie movie) {
		 List<Movie>movies=movieRepository.findAll();
		 for(Movie m:movies) {
			 if(m.equals(movie)) {
				 return m;
			 }
		 }
		 throw new MovieNotExistsException("Movie Not Exist  : " + movie);
	}
}
