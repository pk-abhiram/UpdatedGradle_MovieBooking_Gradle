package com.sprint1.movie.booking.ticket1.booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.ticket1.booking.entities.Movie;
import com.sprint1.movie.booking.ticket1.booking.entities.Screen;
import com.sprint1.movie.booking.ticket1.booking.entities.Show;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.ScreenServiceImplementation;
@SpringBootTest
class ScreenServiceTest {
	static final org.slf4j.Logger log = LoggerFactory.getLogger(ScreenServiceTest.class);
	@Autowired
	ScreenServiceImplementation screenServiceImplementation;

//		@Test
	void testAddScreen() {
		try {
			Movie movie1=new Movie(1,"3 Idiots", "Comedy", "2:30", "Hindi", "College");
			Show show=new Show(LocalDateTime.now(), LocalDateTime.now(), "show1", movie1, 0, 0);
			List<Show> showList=new ArrayList<>();
			showList.add(show);
			Screen screen=new Screen(1, "screen 2", showList, 4, 5);
			log.info(screenServiceImplementation.addScreen(screen)+"");
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}


	}

	@Test
	void testUpdateScreen() {
		try {
			Movie movie1=new Movie(1,"3 Idiots", "Comedy", "2:30", "Hindi", "College");
			Show show=new Show(LocalDateTime.now(), LocalDateTime.now(), "second show", movie1, 0, 0);
			Show show1=new Show(LocalDateTime.now(), LocalDateTime.now(), "noon show", movie1, 0, 0);
			List<Show>shows=new ArrayList<Show>();
			shows.add(show1);
			shows.add(show);
			Screen screen=new Screen(13, 3, "updated Screen", shows, 30, 30);
			screenServiceImplementation.updateScreen(screen);
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}


//	@Test
	void testViewScreenById() {
		try {
			int screenId=67;
			log.info(screenServiceImplementation.viewScreenById(screenId)+"");
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}

	//	@Test
	void testViewScreenListAll() {
		try {
			screenServiceImplementation.viewScreenListAll();
			log.info(screenServiceImplementation.viewScreenListAll()+"");
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}

	//	@Test
	void testViewScreenListByTheatreId() {
		try {
			int theatreId=4;
			log.info(screenServiceImplementation.viewScreenList(theatreId)+"");
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}


	}

	//	@Test
	void testRemoveScreenById() {
		try {
			int screenId=3;
			screenServiceImplementation.removeScreen(screenId);
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}

	}

}