package com.sprint1.movie.booking.ticket1.booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.ticket1.booking.entities.Movie;
import com.sprint1.movie.booking.ticket1.booking.entities.Screen;
import com.sprint1.movie.booking.ticket1.booking.entities.Show;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.ScreenServiceImplementation;
@SpringBootTest
class ScreenServiceTest {

@Autowired
ScreenServiceImplementation screenServiceImplementation;
	
//	@Test
	void testAddScreen() {
		Movie movie=new Movie(1,"movie", "asda", "asdsa", "sadas", "asdas");
		Show show=new Show();
		List<Show> showList=new ArrayList<>();
		showList.add(show);
		Screen screen=new Screen(1, "screen 2", showList, 4, 5);
		screenServiceImplementation.addScreen(screen);
	}
	
	//@Test
	void testUpdateScreen() {
		Show show=new Show(LocalDateTime.now(), LocalDateTime.now(), "zzzz", null, 0, 0);
		Show show1=new Show(LocalDateTime.now(), LocalDateTime.now(), "abbbb", null, 0, 0);
		List<Show>shows=new ArrayList<Show>();
		shows.add(show1);
		shows.add(show);
		Screen screen=new Screen(6, 0, "updated", shows, 0, 0);
		screenServiceImplementation.updateScreen(screen);
		System.out.println();
	}


//	@Test
	void testViewScreenById() {
		int screenId=66;
		System.out.println(screenServiceImplementation.viewScreenById(screenId));
	}
	
//	@Test
	void testViewScreenListAll() {
		screenServiceImplementation.viewScreenListAll();
		System.out.println(screenServiceImplementation.viewScreenListAll());
	}
	
//	@Test
	void testViewScreenListByTheatreId() {
		int theatreId=4;
		screenServiceImplementation.viewScreenList(theatreId);
	}
	
//	@Test
	void testRemoveScreenById() {
		int screenId=3;
		screenServiceImplementation.removeScreen(screenId);
	}
	
}