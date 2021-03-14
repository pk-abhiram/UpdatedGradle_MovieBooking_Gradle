package com.sprint1.movie.booking.ticket1.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.movie.booking.ticket1.booking.entities.Seat;


@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer>{
	
	public Seat findBySeatNumber(String seatNumber);
	
	public Seat findBySeatId(int seatId);
	public List<Seat>findByType(String type);

}