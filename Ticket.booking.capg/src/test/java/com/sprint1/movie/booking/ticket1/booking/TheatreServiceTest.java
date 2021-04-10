package com.sprint1.movie.booking.ticket1.booking;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.ticket1.booking.entities.Movie;
import com.sprint1.movie.booking.ticket1.booking.entities.Screen;
import com.sprint1.movie.booking.ticket1.booking.entities.Theatre;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.TheatreServiceImplementation;
@SpringBootTest
class TheatreServiceTest {

	static final org.slf4j.Logger log = LoggerFactory.getLogger(TheatreServiceTest.class);	

	@Autowired
	TheatreServiceImplementation theatreServiceImplementation; 

	//@Test
	void testAddTheatre() {
		try {
			Movie movie1=new Movie(1,"3 Idiots", "Comedy", "2:30", "Hindi", "College");
			Movie movie2=new Movie(2,"Drishyam", "Thriller", "2:45", "Malayalam", "Crime");
			List<Movie>movies=new ArrayList<Movie>();
			movies.add(movie1);
			movies.add(movie2);
			Screen screen=new Screen(0, "screen 1", null, 10, 20);
			List<Screen> screens=new ArrayList<>();
			screens.add(screen);
			Theatre theatre=new Theatre("Cauvery", "bangalore", movies, screens, "manager1", "4984665");
			log.info(""+theatreServiceImplementation.addTheatre(theatre));
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}

	//	@Test
	void testUpdateTheatre() {
		try {
			Movie movie2=new Movie(2,"Drishyam", "Thriller", "2:45", "Malayalam", "Crime");
			List<Movie>movies=new ArrayList<Movie>();
			movies.add(movie2);

			Screen screen=new Screen(4, null, null, 0, 0);
			List<Screen> screens=new ArrayList<>();
			screens.add(screen);
			Theatre theatre=new Theatre(1,"theatre1_updated", "bengaluru", movies, screens, "manager1", "4984669995");
			theatreServiceImplementation.updateTheatre(theatre);
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}


	}


	//	@Test
	void testViewTheatreById() {
		try {
			int theatreId=2;
			log.info(""+theatreServiceImplementation.viewTheatreById(theatreId));
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}

	//	@Test
	void testViewTheatreList() {
		try {
			log.info(""+theatreServiceImplementation.viewTheatreList());
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}

	//	@Test
	void testViewTheatreListByCity() {
		try {
			log.info(""+theatreServiceImplementation.viewTheatreListByCity("banga"));

		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}

	//@Test
	void testRemoveTheatreById() {
		try {
			int theatreId=9;
			theatreServiceImplementation.removeTheatre(theatreId);
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}



//		@Test
	public void testTheatreRemoveMovie() {
		try {
			int theatreId=1;
			int movieId=1;
			log.info(""+theatreServiceImplementation.theatreRemoveMovie(theatreId, movieId));
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}



//		@Test
	public void testTheatreRemoveScreen() {
		try {
			int theatreId=1;
			int screenId=1;
			log.info(""+theatreServiceImplementation.theatreAddMovie(theatreId, screenId));
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}


	}
}

