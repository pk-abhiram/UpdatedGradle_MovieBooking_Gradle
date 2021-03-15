package com.sprint1.movie.booking.ticket1.booking.servicesimplementation;

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
import com.sprint1.movie.booking.ticket1.booking.exceptions.TheatreNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.repository.ShowRepository;
import com.sprint1.movie.booking.ticket1.booking.repository.TheatreRepository;
import com.sprint1.movie.booking.ticket1.booking.service.TheatreService;

@Service
public class TheatreServiceImplementation implements TheatreService{
	@Autowired
	TheatreRepository theatreRepository;

	@Autowired
	ShowRepository showRepository;

	@Autowired
	MovieServiceImplementation movieServiceImplementation;

	@Autowired
	ScreenServiceImplementation screenServiceImplementation;

	@Autowired
	TheatreServiceImplementation theatreServiceImplementation;

	public Theatre addTheatre(Theatre theatre) {
		if(theatre.getListOfMovies()!=null) {
			List<Movie>movies=new ArrayList<>();
			movies.addAll(theatre.getListOfMovies());
			theatre.getListOfMovies().clear();
			for(Movie movie:movies) {
				Movie getMovie=movieServiceImplementation.findMovie(movie);
				theatre.getListOfMovies().add(getMovie);
			}
		}
		Theatre getTheatre=theatreRepository.save(theatre);
		if(getTheatre.getListOfScreens()!=null)
		{
			for(Screen s:getTheatre.getListOfScreens()) {

				s.setTheatreId(getTheatre.getTheatreId());
				if(s.getShowList()!=null) {
					for(Show show:s.getShowList()) {
						show.setScreenid(s.getScreenId());
						show.setTheatreId(getTheatre.getTheatreId());
					}
				}

			}
		}
		return theatreRepository.save(theatre);



	}

	@Transactional()
	public void updateTheatre(Theatre theatre) {

		Optional<Theatre> findTheatre = theatreRepository.findById(theatre.getTheatreId());

		if(findTheatre.isPresent()) {


			Theatre updateTheatre=findTheatre.get();
			if(theatre.getListOfMovies()!=null && !theatre.getListOfMovies().isEmpty())
			{updateTheatre.setListOfMovies(theatre.getListOfMovies());}
			if(theatre.getListOfScreens()!=null && !theatre.getListOfScreens().isEmpty())
			{
				for(Screen screen:theatre.getListOfScreens()) {
					screen.setTheatreId(theatre.getTheatreId());
					for(Show show:screen.getShowList()) {
						show.setTheatreId(theatre.getTheatreId());

					}
				}
				updateTheatre.setListOfScreens(theatre.getListOfScreens());
			}
			if(theatre.getManagerContact()!=null)
			{updateTheatre.setManagerContact(theatre.getManagerContact());}
			if(theatre.getManagerName()!=null)
			{updateTheatre.setManagerName(theatre.getManagerName());}
			if(theatre.getTheatreCity()!=null)
			{updateTheatre.setTheatreCity(theatre.getTheatreCity());}
			if(theatre.getTheatreCity()!=null)
			{updateTheatre.setTheatreName(theatre.getTheatreName());}

		}
		else {
			throw new TheatreNotExistsException("Theatre not exist with Id ");
		}
	}

	public void removeTheatre(int theatreId) {
		Optional<Theatre> findRemoveTheatre=theatreRepository.findById(theatreId);

		if(findRemoveTheatre.isPresent()) {
			theatreRepository.delete(findRemoveTheatre.get());
		}
		else {
			throw new TheatreNotExistsException("Theatre not exist with Id ");
		}
	}

	public Theatre viewTheatreById(int theatreId) {
		Optional<Theatre> findTheatre=theatreRepository.findById(theatreId);
		if(findTheatre.isPresent()) {
			return findTheatre.get();
		}
		else {
			throw new TheatreNotExistsException("Theatre not exist with Id ");
		}

	}
	public List<Theatre>viewTheatreList(){
		List<Theatre>theatres=theatreRepository.findAll();
		return theatres;
	}

	public List<Theatre>viewTheatreListByCity(String City){
		List<Theatre>theatres=theatreRepository.findTheatreWithCity(City);

		return theatres;
	}



	public Theatre theatreAddMovie(int theatreId,Movie movie) {
		Theatre theatre=theatreServiceImplementation.viewTheatreById(theatreId);

		theatre.getListOfMovies().add(movie);
		return theatreRepository.save(theatre);
	}

	public Theatre theatreRemoveMovie(int theatreId,int movieid) {
		Theatre theatre=theatreServiceImplementation.viewTheatreById(theatreId);
		Movie movie=movieServiceImplementation.viewMovie(movieid);
		theatre.getListOfMovies().remove(movie);
		return theatreRepository.save(theatre);

	}

	@Transactional
	public Theatre theatreAddScreen(int theatreId,Screen screen) {
		Theatre theatre=theatreServiceImplementation.viewTheatreById(theatreId);
		theatre.getListOfScreens().add(screen);
		return theatreRepository.save(theatre);

	}

	public Theatre theatreRemoveScreen(int theatreId,int screenId) {
		Theatre theatre=theatreServiceImplementation.viewTheatreById(theatreId);


		Screen screen=screenServiceImplementation.viewScreenById(screenId);

		theatre.getListOfScreens().remove(screen);
		return theatreRepository.save(theatre);
	}
}
