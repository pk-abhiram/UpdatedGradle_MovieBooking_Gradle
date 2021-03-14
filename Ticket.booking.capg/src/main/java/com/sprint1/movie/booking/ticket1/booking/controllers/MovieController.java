package com.sprint1.movie.booking.ticket1.booking.controllers;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.ticket1.booking.entities.Admin;
import com.sprint1.movie.booking.ticket1.booking.entities.Movie;
import com.sprint1.movie.booking.ticket1.booking.repository.MovieRepository;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.MovieServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Movie", tags = { "MovieAPI" })
@RequestMapping(value = "/movie")
public class MovieController {

	static final org.slf4j.Logger log = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	MovieServiceImplementation movieServiceImplementation;
	
	@Autowired
	MovieRepository movieRepository;
	
//	Adding a Movie
	@PostMapping(value="/")
	@ApiOperation(value = "Add a movie", notes = "Provide movie details", response = Movie.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie)  {
		ResponseEntity<Movie>  re;
		
			movieServiceImplementation.addMovie(movie);
			 re = new ResponseEntity<>(movie,HttpStatus.CREATED);
			 log.info(re+"");
		return re;	
	}
	
//	Updating a Movie using movie_id	
	@PutMapping(value="/" )
	@ApiOperation(value = "Update movie's details using id", notes = "Provide movie id, new description, new language, new genre, hours, name or give null", response = Movie.class)
	public ResponseEntity<Void> updateMovie(@RequestBody Movie movie)  {
		ResponseEntity<Void>  re;
		
		movieServiceImplementation.updateMovie(movie);
			re=new ResponseEntity<>(HttpStatus.OK);
			log.info(re+"");
		return re;
	}
	
//  Removing a Movie using movie_id 
	@DeleteMapping(value="/{movieId}")	
	@ApiOperation(value = "Delete a movie", notes = "Provide movie id", response = Movie.class)
	public ResponseEntity<Void> removeMovie(@PathVariable("movieId") int movieId) {
		ResponseEntity<Void>  re;
		
		movieServiceImplementation.removeMovie(movieId);
			re=new ResponseEntity<>(HttpStatus.OK);
			log.info(re+"");
		return re;
	}
	
//  Finding Movie using movie_id
	@GetMapping(value="/{movieId}")
	@ApiOperation(value = "View a movie using movie id", notes = "Provide movie id", response = Movie.class)
	public ResponseEntity<Movie> findMovieById(@PathVariable("movieId") int movieId) {
		ResponseEntity<Movie>  re;
		Movie getMovie=movieServiceImplementation.viewMovie(movieId);
			re=new ResponseEntity<>(getMovie,HttpStatus.OK);
			log.info(re+"");
		return re;
	}
//	Displaying all Movies present in the database
	@GetMapping(value="/")
	@ApiOperation(value = "View all movies", response = Movie.class)
	public ResponseEntity<List<Movie>> viewMovieList(){
		ResponseEntity<List<Movie>>  re;
		
		re=new ResponseEntity<>(movieServiceImplementation.viewMovieList(),HttpStatus.OK);
		log.info(re+"");
		return re;
	}
	
//  finding list of Movies using theatre_id
	@GetMapping(value="/theatre/{theatreid}")
	@ApiOperation(value = "View movies played in a theatre using theatre id", notes = "Provide theatre id", response = Movie.class)
	public ResponseEntity<List<Movie>> viewMovieList(@PathVariable("theatreid") int theatreid) {
		ResponseEntity<List<Movie>>  re;
		List<Movie>movies=movieServiceImplementation.viewMovieList(theatreid);
		
		re=new ResponseEntity<>(movies,HttpStatus.OK);
		log.info(re+"");
		return re;
	}
	
	@GetMapping(value="/date/{date}")
	@ApiOperation(value = "Delete an admin by date", notes = "Provide admin id", response = Admin.class)
	public ResponseEntity<List<Movie>> viewMovieList(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
		ResponseEntity<List<Movie>>  re;
		List<Movie>movies=movieServiceImplementation.viewMovieList(date);
		
		re=new ResponseEntity<>(movies,HttpStatus.OK);
		log.info(re+"");
		return re;
	}
	
	
}
