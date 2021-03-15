package com.sprint1.movie.booking.ticket1.booking;



import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.ticket1.booking.entities.Movie;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.MovieServiceImplementation;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.ScreenServiceImplementation;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.ShowServiceImplementation;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.TheatreServiceImplementation;
@SpringBootTest
class MovieServiceTest {

	static final org.slf4j.Logger log = LoggerFactory.getLogger(MovieServiceTest.class);	
	
	@Autowired
	MovieServiceImplementation movieServiceImplementation;
	
	@Autowired
	ScreenServiceImplementation screenServiceImplementaion;
	
	@Autowired
	TheatreServiceImplementation theatreServiceImplementaion;
	
	@Autowired
	ShowServiceImplementation showServiceImplementaion;
	
//	@Test
	void testAddMovie() {
		Movie movie1=new Movie(1,"3 Idiots", "Comedy", "2:30", "Hindi", "College");
		Movie movie2=new Movie(2,"Drishyam", "Thriller", "2:45", "Malayalam", "Crime");
			//Movie m=new Movie(16,"uppenna","comedy","2:30:37","Hindi","xyz");
			log.info(movieServiceImplementation.addMovie(movie1).toString());
			log.info(movieServiceImplementation.addMovie(movie2).toString());
		
	}
//	@Test
	void testUpdateMovie() {
		
		
			
			Movie m=new Movie(20,"3 idiots",null,null,null,null);
			movieServiceImplementation.updateMovie(m);
			
	}
	
//	@Test
	void testViewMovie() {
		
		int id =109;
		System.out.println(movieServiceImplementation.viewMovie(id));
		
	}
//	@Test	
	void testViewAllMovie() {
		
		
		System.out.println(movieServiceImplementation.viewMovieList());
		
	}
	
//	@Test
	void testremoveMovie() {
		
		int id =6;
		movieServiceImplementation.removeMovie(id);
		
	}
	
//	@Test
	void testViewMovieByTheatreId() {
		
		int id =5;
//		Movie m=new Movie("idiot","Comedy","2:45:23","Hindi","College");
//		List<Movie> movie=new ArrayList<>();
//		movie.add(m);
////		movieServiceImplementation.addMovie(m);
//		Screen s=new Screen(1, "Golden Screen", null,5, 15);
//		List<Screen> screen=new ArrayList<>();
//		screen.add(s);
//		
//		//screenServiceImplementaion.addScreen(s);
//		Theatre t=new Theatre( "PVR", "Bangalore", movie,screen, "Shama", "99999 00000");
////		List<Theatre> theatre=new ArrayList<>();
////		theatre.add(t);
//		theatreServiceImplementation.addTheatre(t);
		
		
		
		System.out.println(movieServiceImplementation.viewMovieList(id));
		
	}
	
//	@Test
	void testViewMovieByShow() {
//		Movie m=new Movie("Abcd","Comedy","2:45:23","Hindi","College");
//		List<Movie> movie=new ArrayList<>();
//		Show s=new Show( LocalDateTime.now(), LocalDateTime.now(),"Noon Show", m,1, 1);
//	   showServiceImplementaion.addShow(s);
		
		
		System.out.println(movieServiceImplementation.viewMovieList(LocalDate.of(2021, 3, 8)));
		
	}
	
	
	
	
	

}