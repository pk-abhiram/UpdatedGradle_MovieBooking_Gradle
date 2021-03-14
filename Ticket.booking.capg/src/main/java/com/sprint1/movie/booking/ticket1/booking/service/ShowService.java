package com.sprint1.movie.booking.ticket1.booking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.ticket1.booking.entities.Show;

@Component
public interface ShowService {

	public Show addShow(Show show);
	@Transactional
	public Show updateShow(Show show);
	public Show removeShow(Show show);
	public Show viewShow(Show show);
	public List<Show> viewShowList(int theatreid);
	public List<Show> viewShowList(LocalDate date);
	public List<Show> viewAllShows();
}
