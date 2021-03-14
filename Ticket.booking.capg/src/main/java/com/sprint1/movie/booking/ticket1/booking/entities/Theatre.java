package com.sprint1.movie.booking.ticket1.booking.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel("Theatres")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
	@Column(nullable = false)
	private String theatreName;
	@Column(nullable = false)
	private String theatreCity;
	@OneToMany(targetEntity = Movie.class,cascade = CascadeType.MERGE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Movie> listOfMovies;
	@OneToMany(targetEntity = Screen.class,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Screen> listOfScreens;
	@Column(nullable = false)
	private String managerName;
	@Column(nullable = false)
	private String managerContact;

	public Theatre() {
		super();
	}

	public Theatre(String theatreName, String theatreCity, List<Movie> listOfMovies, List<Screen> listOfScreens,
			String managerName, String managerContact) {
		super();
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.listOfMovies = listOfMovies;
		this.listOfScreens = listOfScreens;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public Theatre(int theatreId, String theatreName, String theatreCity, List<Movie> listOfMovies,
			List<Screen> listOfScreens, String managerName, String managerContact) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.listOfMovies = listOfMovies;
		this.listOfScreens = listOfScreens;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public List<Movie> getListOfMovies() {
		return listOfMovies;
	}

	public void setListOfMovies(List<Movie> listOfMovies) {
		this.listOfMovies = listOfMovies;
	}

	public List<Screen> getListOfScreens() {
		
		return listOfScreens;
	}

	public void setListOfScreens(List<Screen> listOfScreens) {
		this.listOfScreens=listOfScreens;
		
		
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreCity=" + theatreCity
				+ ", listOfMovies=" + listOfMovies + ", listOfScreens=" + listOfScreens + ", managerName=" + managerName
				+ ", managerContact=" + managerContact + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listOfMovies == null) ? 0 : listOfMovies.hashCode());
		result = prime * result + ((listOfScreens == null) ? 0 : listOfScreens.hashCode());
		result = prime * result + ((managerContact == null) ? 0 : managerContact.hashCode());
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
		result = prime * result + ((theatreCity == null) ? 0 : theatreCity.hashCode());
		result = prime * result + ((theatreName == null) ? 0 : theatreName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		if (listOfMovies == null) {
			if (other.listOfMovies != null)
				return false;
		} else if (!listOfMovies.equals(other.listOfMovies))
			return false;
		if (listOfScreens == null) {
			if (other.listOfScreens != null)
				return false;
		} else if (!listOfScreens.equals(other.listOfScreens))
			return false;
		if (managerContact == null) {
			if (other.managerContact != null)
				return false;
		} else if (!managerContact.equals(other.managerContact))
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		if (theatreCity == null) {
			if (other.theatreCity != null)
				return false;
		} else if (!theatreCity.equals(other.theatreCity))
			return false;
		if (theatreName == null) {
			if (other.theatreName != null)
				return false;
		} else if (!theatreName.equals(other.theatreName))
			return false;
		return true;
	}
	
	

}
