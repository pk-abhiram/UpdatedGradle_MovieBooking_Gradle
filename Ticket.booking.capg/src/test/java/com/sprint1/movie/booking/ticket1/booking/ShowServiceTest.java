package com.sprint1.movie.booking.ticket1.booking;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.ticket1.booking.entities.Movie;
import com.sprint1.movie.booking.ticket1.booking.entities.Show;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.ShowServiceImplementation;
@SpringBootTest
class ShowServiceTest {

	static final org.slf4j.Logger log = LoggerFactory.getLogger(ShowServiceTest.class);

	@Autowired
	ShowServiceImplementation showServiceImplementation; 

	//	@Test
	void testAddShow() {
		try {
			Movie movie1=new Movie(1,"3 Idiots", "Comedy", "2:30", "Hindi", "College");
			Show show=new Show(LocalDateTime.now(), LocalDateTime.now(), "show1", movie1, 3, 3);
			log.info(showServiceImplementation.addShow(show)+"");
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}

		@Test
	void testUpdateShow() {
		try {
			Movie movie1=new Movie(2,"Drishyam", "Thriller", "2:45", "Malayalam", "Crime");

			Show show=new Show(18,LocalDateTime.now(), LocalDateTime.now(), "show2_updated", movie1, 3, 3);
			log.info(showServiceImplementation.updateShow(show)+"");
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}


	}

	//	@Test
	void testRemoveShow() {
		try {
			Movie movie2=new Movie("movie2", "as", "as", "sa", "as");
			Show show=new Show(null, null, "show1", movie2, 6, 4);
			log.info(""+showServiceImplementation.removeShow(show));
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}


	}

//	@Test
	void testRemoveShowById() {
		try {
			int showId=3;
			log.info(""+showServiceImplementation.deleteShowById(showId));
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}


	}

	
	//	@Test
	void testViewShow() {
		try {
			Show show=new Show(14,null, LocalDateTime.now(), "show2_updated", null, 6, 4);
			log.info(""+showServiceImplementation.viewShow(show));
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}

	//	@Test
	void testViewShowListByTheatreId() {
		try {
			int theatreid=4;
			log.info(""+showServiceImplementation.viewShowList(theatreid));
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}

	//	@Test
	void testViewShowListByLocalDate() {
		try {
			LocalDate date=LocalDate.now();
			log.info(""+showServiceImplementation.viewShowList(date));
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}
	//  @Test
	void testViewAllShows() {
		try {
			log.info(""+showServiceImplementation.viewAllShows());
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}
}
