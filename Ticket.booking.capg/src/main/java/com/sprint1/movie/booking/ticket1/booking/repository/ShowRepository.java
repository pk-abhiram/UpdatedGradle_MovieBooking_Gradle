package com.sprint1.movie.booking.ticket1.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.movie.booking.ticket1.booking.entities.Show;
@Repository
public interface ShowRepository extends JpaRepository<Show, Integer>{

	public List<Show> findByTheatreId(int theatreId);
}
