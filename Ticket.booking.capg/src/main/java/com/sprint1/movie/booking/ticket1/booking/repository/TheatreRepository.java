package com.sprint1.movie.booking.ticket1.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint1.movie.booking.ticket1.booking.entities.Theatre;
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer>{

	@Query("Select t from Theatre t where t.theatreCity like %?1%")
	public List<Theatre>findTheatreWithCity(String theatreCity);
}
