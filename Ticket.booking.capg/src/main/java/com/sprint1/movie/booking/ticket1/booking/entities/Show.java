package com.sprint1.movie.booking.ticket1.booking.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel("Current Shows")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showId;
	@Column(nullable = false)
	private LocalDateTime showStartTime;
	@Column(nullable = false)
	private LocalDateTime showEndTime;
	@Column(nullable = false)
	private String showName;
	@OneToOne(targetEntity = Movie.class,cascade = CascadeType.MERGE)
	private Movie movie;
	@Column(nullable = false)
	private int screenid;
	@Column(nullable = false)
	private int theatreId;
	
	public Show() {
		
	}
	
	
	
	public Show(LocalDateTime showStartTime, LocalDateTime showEndTime, String showName, Movie movie, int screenid,
			int theatreId) {
		super();
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.showName = showName;
		this.movie = movie;
		this.screenid = screenid;
		this.theatreId = theatreId;
	}



	public Show(int showId, LocalDateTime showStartTime, LocalDateTime showEndTime, String showName, Movie movie,
			int screenid, int theatreId) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.showName = showName;
		this.movie = movie;
		this.screenid = screenid;
		this.theatreId = theatreId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getScreenid() {
		return screenid;
	}
	public void setScreenid(int screenid) {
		this.screenid = screenid;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", showName=" + showName + ", movie=" + movie + ", screenid=" + screenid + ", theatreId=" + theatreId
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + screenid;
		result = prime * result + ((showEndTime == null) ? 0 : showEndTime.hashCode());
		result = prime * result + ((showName == null) ? 0 : showName.hashCode());
		result = prime * result + ((showStartTime == null) ? 0 : showStartTime.hashCode());
		result = prime * result + theatreId;
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
		Show other = (Show) obj;
		if (screenid != other.screenid)
			return false;
		if (showEndTime == null) {
			if (other.showEndTime != null)
				return false;
		} else if (!showEndTime.equals(other.showEndTime))
			return false;
		if (showName == null) {
			if (other.showName != null)
				return false;
		} else if (!showName.equals(other.showName))
			return false;
		if (showStartTime == null) {
			if (other.showStartTime != null)
				return false;
		} else if (!showStartTime.equals(other.showStartTime))
			return false;
		if (theatreId != other.theatreId)
			return false;
		return true;
	}




	
	
	
}
