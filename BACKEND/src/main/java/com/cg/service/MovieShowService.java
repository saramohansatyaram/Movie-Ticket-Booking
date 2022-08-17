//package com.cg.service;
//
//import java.util.List;
//import java.util.function.IntPredicate;
//
//import com.cg.entity.MovieShow;
//
//public interface MovieShowService {
//	
//	
//	List<MovieShow> getAllMovies();
//
//	MovieShow updateMovieShow(MovieShow updatedMovie);
//
//	MovieShow addMovieShow(MovieShow movie);
//
//	MovieShow viewMovieShow(int Id);
//	
//	void deleteMovieShowById(int booking_id);
//
//}


package com.cg.service;

import java.util.List;
import com.cg.entity.MovieShow;

public interface MovieShowService {

	List<MovieShow> getAllMovies();

	MovieShow updateMovieShow(MovieShow show_time);

	MovieShow addMovieShow(MovieShow show_time);

	MovieShow viewMovieShow(int showId);
	
	void deleteMovieShowById(int showId);

}