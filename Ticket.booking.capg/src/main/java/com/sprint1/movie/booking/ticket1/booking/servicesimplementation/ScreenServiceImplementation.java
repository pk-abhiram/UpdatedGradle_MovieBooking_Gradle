package com.sprint1.movie.booking.ticket1.booking.servicesimplementation;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.ticket1.booking.entities.Movie;
import com.sprint1.movie.booking.ticket1.booking.entities.Screen;
import com.sprint1.movie.booking.ticket1.booking.entities.Show;
import com.sprint1.movie.booking.ticket1.booking.entities.Theatre;
import com.sprint1.movie.booking.ticket1.booking.exceptions.ScreenNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.exceptions.ShowNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.repository.ScreenRepository;
import com.sprint1.movie.booking.ticket1.booking.repository.ShowRepository;
import com.sprint1.movie.booking.ticket1.booking.repository.TheatreRepository;
import com.sprint1.movie.booking.ticket1.booking.service.ScreenService;
import com.sprint1.movie.booking.ticket1.booking.service.TheatreService;

@Service
public class ScreenServiceImplementation implements ScreenService {
	@Autowired
	ScreenRepository screenRepository;
	
	@Autowired
	ShowRepository showRepository;

	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	ShowServiceImplementation showServiceImplementation;
	
	@Autowired
	TheatreServiceImplementation theatreServiceImplementation;
	
	@Autowired
	ScreenServiceImplementation screenServiceImplementation;
	
	@Autowired
	TheatreService theatreService;
	public Screen addScreen(Screen screen) {
		try {
		Theatre theatre=theatreServiceImplementation.viewTheatreById(screen.getTheatreId());
		List<Movie>movies=theatre.getListOfMovies();
		theatre.getListOfScreens().add(screen);
			Screen getScreen= screenRepository.save(screen);
			theatre.getListOfMovies().clear();
			if(screen.getShowList()!=null) {
			for(Show show:screen.getShowList()) {
				show.setScreenid(screen.getScreenId());
				show.setTheatreId(screen.getTheatreId());
				if(show.getMovie()!=null) {
				if(!movies.contains(show.getMovie())) {
					movies.add(show.getMovie());
				}
				}
			}}
			theatre.setListOfMovies(movies);
			theatreRepository.save(theatre);
			screenRepository.save(screen);
			return getScreen;
		}
		catch(InvalidDataAccessApiUsageException e) {
			throw new ShowNotExistsException("Show exist, pass a new Show:(Detached entity)");
		}
	}
	
	@Transactional
	public void updateScreen(Screen screen) {
		Optional<Screen> getUpdateScreen=screenRepository.findById(screen.getScreenId());
	
		Screen updateScreen;
		List<Show>shows=new ArrayList<>();
		
		
		if(getUpdateScreen.isPresent()) {
		updateScreen=getUpdateScreen.get();
	
		
		if(screen.getColumns()!=0)
		{updateScreen.setColumns(screen.getColumns());}
		
		if(screen.getRows()!=0)
		{updateScreen.setRows(screen.getRows());}
		
		if(screen.getScreenName()!=null)
		{updateScreen.setScreenName(screen.getScreenName());}
		
		if(screen.getShowList()!=null)
		{	for(Show show:screen.getShowList()) {
			show.setScreenid(screen.getScreenId());
			show.setTheatreId(screen.getTheatreId());
		}
			shows.addAll(screen.getShowList());
			updateScreen.setShowList(shows);
		}
		
		if(screen.getTheatreId()!=0)
		{updateScreen.setTheatreId(screen.getTheatreId());}
		
		}
		else {
			throw new ScreenNotExistsException("Screen not exist with Id: " +  screen.getScreenId());
		}
		
	}
	
	public void removeScreen(int screenId) {
		Optional<Screen> findRemoveScreen=screenRepository.findById(screenId);
		if(findRemoveScreen.isPresent()) {
			theatreServiceImplementation.theatreRemoveScreen(findRemoveScreen.get().getTheatreId(), findRemoveScreen.get().getScreenId());
		screenRepository.delete(findRemoveScreen.get());
		}
		else {
			throw new ScreenNotExistsException("Screen not exist with Id: " +  screenId);
		}
	}
	

	public Screen viewScreenById(int screenId) {
		
		Optional<Screen> findRemoveScreen=screenRepository.findById(screenId);
		if(findRemoveScreen.isPresent()) {
			return findRemoveScreen.get();
		}
		else {
			throw new ScreenNotExistsException("Screen not exist with Id: " +  screenId);
		}
	}
	public List<Screen>viewScreenListAll(){
		List<Screen>screens=screenRepository.findAll();
		return screens;
	}
	
	public List<Screen>viewScreenList(int theatreId){
		List<Screen>screens=screenRepository.findByTheatreId(theatreId);
	
		return screens;
	}
	
	public void deleteShowById(int screenId,int showId) {
		Screen screen=screenServiceImplementation.viewScreenById(screenId);
		Show show=showServiceImplementation.viewShowById(showId);
		screen.getShowList().remove(show);
		screenRepository.save(screen);
	}
	
}
