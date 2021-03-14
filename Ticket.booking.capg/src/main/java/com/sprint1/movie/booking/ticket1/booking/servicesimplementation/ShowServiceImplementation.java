package com.sprint1.movie.booking.ticket1.booking.servicesimplementation;




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.ticket1.booking.entities.Movie;
import com.sprint1.movie.booking.ticket1.booking.entities.Screen;
import com.sprint1.movie.booking.ticket1.booking.entities.Show;
import com.sprint1.movie.booking.ticket1.booking.entities.Theatre;
import com.sprint1.movie.booking.ticket1.booking.exceptions.MovieNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.exceptions.ScreenNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.exceptions.ShowNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.repository.MovieRepository;
import com.sprint1.movie.booking.ticket1.booking.repository.ScreenRepository;
import com.sprint1.movie.booking.ticket1.booking.repository.ShowRepository;
import com.sprint1.movie.booking.ticket1.booking.repository.TheatreRepository;
import com.sprint1.movie.booking.ticket1.booking.service.ShowService;


@Service
public class ShowServiceImplementation implements ShowService {

@Autowired
ShowRepository showRepository; 

@Autowired
ScreenRepository screenRepository;

@Autowired
MovieRepository movieRepository;

@Autowired
MovieServiceImplementation movieServiceImplementation;

@Autowired
TheatreServiceImplementation theatreServiceImplementation ;

@Autowired
ScreenServiceImplementation screenServiceImplementation;
	
@Autowired
TheatreRepository theatreRepository;

	@Transactional
	public Show addShow(Show show) {
		Show getShow;
		try {
			Theatre theatre=theatreServiceImplementation.viewTheatreById(show.getTheatreId());
			Screen screen=screenServiceImplementation.viewScreenById(show.getScreenid());
			if(screen.getTheatreId()!=theatre.getTheatreId()) {
				throw new ScreenNotExistsException("Screen not exist with Id: " +screen.getScreenId()+" in theatre:"+theatre.getTheatreId());
			}
			Movie movie1=movieServiceImplementation.findMovie(show.getMovie());
			show.setMovie(movie1);
			getShow=showRepository.save(show);
			screen.getShowList().add(getShow);
			
			if(theatre.getListOfMovies().contains(movie1)==false) {
				
				theatre.getListOfMovies().add(movie1);
	
			}
			
			screenRepository.save(screen);
			theatreRepository.save(theatre);
			
		}
		catch(MovieNotExistsException e) {
			Theatre theatre=theatreServiceImplementation.viewTheatreById(show.getTheatreId());
			Screen screen=screenServiceImplementation.viewScreenById(show.getScreenid());
			Movie movie=movieRepository.save(show.getMovie());
			show.setMovie(movie);
			getShow=showRepository.save(show);
			screen.getShowList().add(getShow);
			theatre.getListOfMovies().add(movie);
			screenRepository.save(screen);
			theatreRepository.save(theatre);
		}
		return getShow;
	}
	
	@Transactional
	public Show updateShow(Show show) {
		Optional<Show> getUpdateShow=showRepository.findById(show.getShowId());
		Show updateShow=null;
		Optional<Screen> findScreen = screenRepository.findById(show.getScreenid());
		if(getUpdateShow.isPresent()) {
		updateShow=getUpdateShow.get();
			if(!show.getMovie().equals(null))
			{updateShow.setMovie(show.getMovie());}
			if(show.getScreenid()!=0  && findScreen.isPresent())
			{updateShow.setScreenid(show.getScreenid());}
			if(show.getShowEndTime()!=null)
			{updateShow.setShowEndTime(show.getShowEndTime());}
			if(!show.getShowName().equals(null))
			{updateShow.setShowName(show.getShowName());}
			if(show.getShowStartTime()!=null)
			{updateShow.setShowStartTime(show.getShowStartTime());}
			if(show.getTheatreId()!=0 && findScreen.isPresent() && (findScreen.get().getTheatreId()==show.getTheatreId() ))
			{updateShow.setTheatreId(show.getTheatreId());}
		}
		else {
			throw new ShowNotExistsException("Show not exist with Id: " +  show.getShowId());
		}
		return updateShow;
	}
	
	public Show removeShow(Show show) {
		
		if(show!=null) {
			for(Show findShow:showRepository.findAll()) {

				if(findShow.equals(show)) {
					screenServiceImplementation.deleteShowById(show.getScreenid(), show.getShowId());
					showRepository.delete(findShow);
					return show;
				}
			}
			
			
		}
		throw new ShowNotExistsException("Show not exist");
	}
	
	public Show viewShow(Show show) {
		Optional<Show> findShow=showRepository.findById(show.getShowId());
		if(findShow.isPresent()) {
			return findShow.get();
		}
		else {
			throw new ShowNotExistsException("Show not exist with Id: " +  show.getShowId());
		}
	}
	
	public Show viewShowById(int showId) {
		Optional<Show> findRemoveShow=showRepository.findById(showId);
		if(findRemoveShow.isPresent()) {
			return findRemoveShow.get();
		}
		else {
			throw new ShowNotExistsException("Show not exist with Id: " +  showId);
		}
	}
	
	public List<Show> viewShowList(int theatreid){
		List<Show>shows=showRepository.findByTheatreId(theatreid);
		return shows;
	}
	

	public List<Show> viewShowList(LocalDate date){
	
		List<Show>shows=showRepository.findAll();
		List<Show>showDate=new ArrayList<Show>();
		
		for(Show show:shows) {
			if(show.getShowStartTime().toLocalDate().isEqual(date)) {
				showDate.add(show);
			}
		}
		return showDate;
	}
	
	public List<Show> viewAllShows(){
		List<Show>shows=showRepository.findAll();
		return shows;
	}

	public Show deleteShowById(int showId) {
		Optional<Show> findRemoveShow=showRepository.findById(showId);
		if(findRemoveShow.isPresent()) {
			screenServiceImplementation.deleteShowById(findRemoveShow.get().getScreenid(), findRemoveShow.get().getShowId());
			showRepository.delete(findRemoveShow.get());
			return findRemoveShow.get();
		}
		else {
			throw new ShowNotExistsException("Show not exist with Id: " +  showId);
		}
	} 
}
