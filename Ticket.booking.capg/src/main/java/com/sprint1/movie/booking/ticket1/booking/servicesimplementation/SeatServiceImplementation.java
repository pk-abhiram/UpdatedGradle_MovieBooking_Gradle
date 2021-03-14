package com.sprint1.movie.booking.ticket1.booking.servicesimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.movie.booking.ticket1.booking.entities.Seat;
import com.sprint1.movie.booking.ticket1.booking.exceptions.SeatNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.repository.SeatRepository;
import com.sprint1.movie.booking.ticket1.booking.service.SeatService;


@Service
public class SeatServiceImplementation implements SeatService{

	@Autowired
	SeatRepository seatRepository;

	public Seat addSeat(Seat seat) {
		
		return seatRepository.save(seat);
		
	}

	@Transactional
	public Seat updateSeat(Seat seat) {
		Optional<Seat> getUpdateSeat = seatRepository.findById(seat.getSeatId());
		Seat updateSeat = null;
		if(getUpdateSeat.isPresent()) {
			updateSeat = getUpdateSeat.get();
			if(seat.getSeatNumber()!=null) {
				updateSeat.setSeatNumber(seat.getSeatNumber());
			}
			if(seat.getType()!=null) {
				updateSeat.setType(seat.getType());
			}
			if(seat.getPrice()!=0) {
				updateSeat.setPrice(seat.getPrice());
			}
		}
		else {
			throw new SeatNotExistsException("Seat Don't Exist with ID : " +  seat.getSeatId());
		}
		return updateSeat;
	}

	public Seat removeSeat(Seat seat) {
		Optional<Seat> findSeat = seatRepository.findById(seat.getSeatId());
		Seat removeSeat = null;
		if(findSeat.isPresent()) {
			removeSeat = findSeat.get();
			seatRepository.delete(removeSeat);
		}
		else {
			throw new SeatNotExistsException("Seat Don't Exist with ID : " +  seat.getSeatId());
		}
		return removeSeat;

	}

	public Seat viewSeat(int seatId) {
		Optional<Seat> findSeat = seatRepository.findById(seatId);
		if(findSeat.isPresent()) {
			return findSeat.get();
		}
		else {
			throw new SeatNotExistsException("Seat Don't Exist with ID : " +  seatId);
		}
		
	}

	public List<Seat> viewSeatList(){
		return seatRepository.findAll();
	}

	public Seat removeSeat(int seatId) {
		Optional<Seat> findSeat = seatRepository.findById(seatId);
		if(findSeat.isPresent()) {
			seatRepository.deleteById(seatId);
		}
		else {
			throw new SeatNotExistsException("Seat Don't Exist with ID : " +  seatId);
		}
		return findSeat.get();
	}

		public List<Seat> viewSeatByType(String type){
		List<Seat> seats = seatRepository.findByType(type);
		if(seats.isEmpty()) {
			throw new SeatNotExistsException("Seats Don't Exist with type: " + type);
		}
		return seats;
		}
}