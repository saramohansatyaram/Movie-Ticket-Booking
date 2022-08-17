//package com.cg.service;
//
//import java.time.LocalDate;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Service;
//
//import com.cg.entity.TicketBooking;
//import com.cg.exception.ResourceNotFoundException;
//import com.cg.repository.TicketBookingRepository;
//import com.cg.repository.CustomerRepository;
//import com.cg.repository.MovieRepository;
//import com.cg.repository.MovieShowRepository;
//import com.cg.entity.Customer;
//import com.cg.entity.Movie;
//import com.cg.entity.MovieShow;
//
//@Service
//public class TicketBookingImpl implements TicketBookingService {
//	@Autowired
//	TicketBookingRepository t;
//	@Autowired
//	MovieRepository m;
//	@Autowired
//	MovieShowRepository mr;
//	@Autowired
//	CustomerRepository c;
//	TicketBooking ticketBooking;
//
//	@Override
//	public List<TicketBooking> getAllTicketBooking() {
//		return t.findAll();
//	}
//
//	@Override
//	public TicketBooking getTicketBookingById(int ticketBooking_id) throws ResourceNotFoundException {
//		if (t.findById(ticketBooking_id).isEmpty()) {
//			throw new ResourceNotFoundException("ticket not existing");
//		} else {
//			ticketBooking = t.findById(ticketBooking_id).get();
//		}
//		return ticketBooking;
//	}
//
//	@Override
//	public List<TicketBooking> viewTicketList() throws ResourceNotFoundException {
//		List<TicketBooking> ti = t.findAll();
//		if (ti.size() == 0)
//			throw new ResourceNotFoundException("No tickets are avaliable");
//		return ti;
//	}
//
//	@Override
//	public TicketBooking pushBooking(TicketBooking newBooking) {
//		int movieId = newBooking.getMovieId();
//		Optional<Movie> optionalMovie = m.findById(movieId);
//		if (optionalMovie.isEmpty()) {
//			throw new ResourceNotFoundException("movie not exising with id: " + movieId);
//		}
//
//		Movie movie = optionalMovie.get();
//		int showId = newBooking.getShowId();
//		Optional<MovieShow> optionalMovieShow = mr.findById(showId);
//		if (optionalMovieShow.isEmpty()) {
//			throw new ResourceNotFoundException("movie not exising with id: " + showId);
//		}
//
//		MovieShow movieShow = optionalMovieShow.get();
//		int customer = newBooking.getMovieId();
//		Optional<Customer> optionalCustomer = c.findById(customer);
//		if (optionalCustomer.isEmpty()) {
//			throw new ResourceNotFoundException("movie not exising with id: " + customer);
//		}
//
////		Customer  customer = optionalMovieShow.get();
//		return t.save(newBooking);
//	}
//
//	@Override
//	public TicketBooking updateBooking(TicketBooking updatedBooking, int ticketBooking_id)
//			throws ResourceNotFoundException {
//
//		if (t.existsById(ticketBooking_id))
//			return t.saveAndFlush(updatedBooking);
//		else
//			throw new ResourceNotFoundException("No Booking are avaliable");
//	}
//
//	@Override
//	public void deleteBookingById(int booking_id) {
//
//		t.deleteById(booking_id);
//	}
//
//}


package com.cg.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.TicketBooking;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.TicketBookingRepository;
import com.cg.repository.CustomerRepository;
import com.cg.repository.MovieRepository;
import com.cg.repository.MovieShowRepository;
import com.cg.repository.TheaterMovieRepository;
import com.cg.repository.TheaterRepository;
import com.cg.entity.Customer;
import com.cg.entity.Movie;
import com.cg.entity.MovieShow;
import com.cg.entity.Theater;
import com.cg.entity.TheaterMovie;

@Service
public class TicketBookingImpl implements TicketBookingService {

	@Autowired
	private TicketBookingRepository tktBookingRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	MovieShowRepository movieShowRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	TheaterRepository theaterRepository;
	
	@Autowired
	TheaterMovieRepository theaterMovieRepository;
	
	@Override
	public List<TicketBooking> getAllTicketBooking() {
		return tktBookingRepository.findAll();
	}

	@Override
	public TicketBooking getTicketBookingById(int tktBookingId) throws ResourceNotFoundException {
		
		Optional<TicketBooking> optionalTktBooking = tktBookingRepository.findById(tktBookingId);
		if (optionalTktBooking.isEmpty()) {
			throw new ResourceNotFoundException("Ticket is not existing with id: ");
		} 			
		TicketBooking ticketBooking = optionalTktBooking.get();		
		return ticketBooking;
	}
	
	@Override
	public List<TicketBooking> getAllTicketBookingForCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketBooking pushBooking(TicketBooking ticketBooking) {
		
		int theaterId = ticketBooking.getTheaterId();
		Optional<Theater> optionalTheater = theaterRepository.findById(theaterId);
		if (optionalTheater.isEmpty()) {
			throw new ResourceNotFoundException("Theater not exising with id: " + theaterId);
		}
		//Theater theater = optionalTheater.get();
		
		int movieId = ticketBooking.getMovieId();
		Optional<Movie> optionalMovie = movieRepository.findById(movieId);
		if (optionalMovie.isEmpty()) {
			throw new ResourceNotFoundException("Movie not exising with id: " + movieId);
		}
		//Movie movie = optionalMovie.get();
		
		int showId = ticketBooking.getShowId();
		Optional<MovieShow> optionalMovieShow = movieShowRepository.findById(showId);
		if (optionalMovieShow.isEmpty()) {
			throw new ResourceNotFoundException("MovieShow not exising with id: " + showId);
		}
		//MovieShow movieShow = optionalMovieShow.get();	
		
		TheaterMovie theaterMovie = theaterMovieRepository.getTheaterMovie(movieId, theaterId, showId);
		
		float totalCost = ticketBooking.getNoOfTickets()* theaterMovie.getCostPerTicket();
		
		ticketBooking.setTotalAmount(totalCost);
		ticketBooking.setStatus("Booked");
		
		return tktBookingRepository.save(ticketBooking);
	}

	@Override
	public TicketBooking updateBooking(TicketBooking ticketBooking) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBookingById(int bookingId) {
		// TODO Auto-generated method stub
		
	}

	
}