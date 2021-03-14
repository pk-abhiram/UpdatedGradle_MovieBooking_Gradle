package com.sprint1.movie.booking.ticket1.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.ticket1.booking.entities.Seat;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.SeatServiceImplementation;
@SpringBootTest
class SeatServiceTest {
	@Autowired
	SeatServiceImplementation seatServiceImplementaion;

//		@Test
	void testAddSeat() {
		Seat seat = new Seat("L50", "Standard", 220.03);
		seatServiceImplementaion.addSeat(seat);
		System.out.println("Done");
	}

//	@Test
	void testUpdateSeat() {
		Seat seat = new Seat(2,"L50","Luxary" , 0);
		seatServiceImplementaion.updateSeat(seat);
		
	}

//		@Test
	void testRemoveSeat() {
		Seat seat=new Seat(16,null, null, 0);
		seatServiceImplementaion.removeSeat(seat);
		
	}
	
//      @Test
	void testRemoveSeatById() {
		int seatId=1;
		seatServiceImplementaion.removeSeat(seatId);
		
	}

//		@Test
	void testViewSeat() {
		int id = 18;
		Seat seat = seatServiceImplementaion.viewSeat(id);
		System.out.println(seat);
	}
	
//		@Test
	void testViewSeatList() {
		List<Seat> seats = seatServiceImplementaion.viewSeatList();
		System.out.println(seats);
	}
	
//	@Test
	void testViewSeatByType() {
		String type="Standard";
		List<Seat> seats = seatServiceImplementaion.viewSeatByType(type);
		System.out.println(seats);
	}
}