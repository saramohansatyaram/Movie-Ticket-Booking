//package com.cg.service;
//
//import java.util.List;
//
//import com.cg.entity.TheaterMovie;
//
//public interface TheaterMovieService {
//
//	TheaterMovie fetchTheaterMovie(int movieId, int theaterId,int showId);
//	
//	List<TheaterMovie> getAllTheaterMovie();	
//
//	TheaterMovie addTheaterMovie(TheaterMovie theaterMovie);
//
//	TheaterMovie viewTheaterMovie(int theaterId);
//	
////	Theater updateTheater(Theater theater);
//
////	void deleteTheater(int theaterId);
//}

//package com.cg.service;
//
//import java.util.List;
//import com.cg.entity.TheaterMovie;
//
//public interface TheaterMovieService {
//
//	public TheaterMovie addTheaterMovie(TheaterMovie theatermovie);
//	public TheaterMovie getTheaterMovieById(int id);
//	public TheaterMovie getTheaterMovieByMovieId(int movieId);
//	public TheaterMovie getTheaterMovieByShowId(int showId);
//	public TheaterMovie getTheaterMovieByTheaterId(int theaterId);
//	public TheaterMovie geTheaterMovieByCostPerTicket(float costPerTicket);
//	public TheaterMovie updateTheaterMovie(TheaterMovie theatermovie);
//	public void deleteTheaterMovieById(int Id);
//	public List<TheaterMovie> getAllTheaterMovies();
//	public TheaterMovie viewTheaterMovie(int id);
//}


package com.cg.service;

import java.util.List;

import com.cg.entity.TheaterMovie;

public interface TheaterMovieService {

	TheaterMovie fetchTheaterMovie(int movieId, int theaterId,int showId);
	
	List<TheaterMovie> getAllTheaterMovie();	

	TheaterMovie addTheaterMovie(TheaterMovie theaterMovie);

	TheaterMovie viewTheaterMovie(int theaterId);
	
//	Theater updateTheater(Theater theater);

//	void deleteTheater(int theaterId);
}