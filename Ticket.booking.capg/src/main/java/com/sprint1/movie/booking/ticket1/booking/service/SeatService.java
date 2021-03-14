package com.sprint1.movie.booking.ticket1.booking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.sprint1.movie.booking.ticket1.booking.entities.Seat;

@Component
public interface SeatService {

	public Seat addSeat(Seat seat);
	@Transactional
	public Seat updateSeat(Seat seat);
	public Seat removeSeat(Seat seat);
	public Seat viewSeat(int seatId);
	public List<Seat> viewSeatList();
	public Seat removeSeat(int seatID);
	public List<Seat> viewSeatByType(String type);
}