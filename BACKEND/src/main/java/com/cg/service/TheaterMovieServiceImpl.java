//package com.cg.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cg.entity.Theater;
//import com.cg.entity.TheaterMovie;
//import com.cg.exception.ResourceNotFoundException;
//import com.cg.repository.TheaterMovieRepository;
//
//@Service
//public class TheaterMovieServiceImpl  implements TheaterMovieService {
//
//	@Autowired
//	private TheaterMovieRepository theaterMovieRepository;
//	
//	@Override
//	public TheaterMovie fetchTheaterMovie(int movieId, int theaterId, int showId) {		
//		
//		TheaterMovie theaterMovie = theaterMovieRepository.getTheaterMovie(movieId, theaterId, showId);
//		return theaterMovie;
//	}
//
//	@Override
//	public List<TheaterMovie> getAllTheaterMovie() {
//		
//		return theaterMovieRepository.findAll();
//	}
//
//	@Override
//	public TheaterMovie addTheaterMovie(TheaterMovie theaterMovie) {
//		
//		return theaterMovieRepository.save(theaterMovie);
//	}
//
//	@Override
//	public TheaterMovie viewTheaterMovie(int theaterId) {
//		
//		Optional<TheaterMovie> optionalTheaterMovie = theaterMovieRepository.findById(theaterId);
//		if (optionalTheaterMovie.isEmpty()) {
//			throw new ResourceNotFoundException("TheaterMovie is not existing with id: " + theaterId);
//		}
//		TheaterMovie theaterMovie = optionalTheaterMovie.get();
//		return theaterMovie;
//	}
//
//}

//
//
//package com.cg.service;
//
//import java.util.List;
//import javax.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.cg.entity.TheaterMovie;
//import com.cg.repository.TheaterMovieRepository;
//
//@Service
//public class TheaterMovieServiceImpl implements TheaterMovieService {
//
//	@Autowired
//	TheaterMovieRepository TheaterMovieRepository;
//	
//	@Override
//	@Transactional
//	public TheaterMovie addTheaterMovie(TheaterMovie theatermovie) {
//		return TheaterMovieRepository.save(theatermovie);
//	}
//
//	@Override
//	public TheaterMovie getTheaterMovieById(int id) {
//		return TheaterMovieRepository.getById(id);
//	}
//
//	@Override
//	public TheaterMovie getTheaterMovieByMovieId(int movieId) {
//		return TheaterMovieRepository.getByMovieId(movieId);
//	}
//
//	@Override
//	public TheaterMovie getTheaterMovieByShowId(int showId) {
//		return TheaterMovieRepository.getByShowId(showId);
//	}
//
//	@Override
//	public TheaterMovie getTheaterMovieByTheaterId(int theaterId) {
//		return TheaterMovieRepository.getByTheaterId(theaterId);
//	}
//
//	@Override
//	public TheaterMovie geTheaterMovieByCostPerTicket(float costPerTicket) {
//		return TheaterMovieRepository.getByCostPerTicket(costPerTicket);
//	}
//
//	@Override
//	public TheaterMovie updateTheaterMovie(TheaterMovie theatermovie) {
//		return TheaterMovieRepository.save(theatermovie);
//	}
//
//	@Override
//	public void deleteTheaterMovieById(int Id) {
//		TheaterMovieRepository.deleteById(Id);
//		
//	}
//	@Override
//	public List<TheaterMovie> getAllTheaterMovies() {
//		return TheaterMovieRepository.findAll();
//	}
//
//	@Override
//	public TheaterMovie viewTheaterMovie(int id) {
//		return TheaterMovieRepository.getById(id);
//	}
//
//}

package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Theater;
import com.cg.entity.TheaterMovie;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.TheaterMovieRepository;

@Service
public class TheaterMovieServiceImpl implements TheaterMovieService {

	@Autowired
	private TheaterMovieRepository theaterMovieRepository;

	@Override
	public TheaterMovie fetchTheaterMovie(int movieId, int theaterId, int showId) {

		TheaterMovie theaterMovie = theaterMovieRepository.getTheaterMovie(movieId, theaterId, showId);
		return theaterMovie;
	}

	@Override
	public List<TheaterMovie> getAllTheaterMovie() {

		return theaterMovieRepository.findAll();
	}

	@Override
	public TheaterMovie addTheaterMovie(TheaterMovie theaterMovie) {

		return theaterMovieRepository.save(theaterMovie);
	}

	@Override
	public TheaterMovie viewTheaterMovie(int theaterId) {

		Optional<TheaterMovie> optionalTheaterMovie = theaterMovieRepository.findById(theaterId);
		if (optionalTheaterMovie.isEmpty()) {
			throw new ResourceNotFoundException("TheaterMovie is not existing with id: " + theaterId);
		}
		TheaterMovie theaterMovie = optionalTheaterMovie.get();
		return theaterMovie;
	}

}