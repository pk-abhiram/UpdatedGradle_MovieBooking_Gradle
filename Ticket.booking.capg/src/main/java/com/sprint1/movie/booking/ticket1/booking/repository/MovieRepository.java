package com.sprint1.movie.booking.ticket1.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.movie.booking.ticket1.booking.entities.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
