//package com.cg.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cg.entity.TheaterMovie;
//import com.cg.service.TheaterMovieService;
//
//@CrossOrigin(origins="http://localhost:3000/")
//@RestController
//@RequestMapping("/api/theaterMovie")
//
//public class TheaterMovieController {
//
//			@Autowired
//			TheaterMovieService TheaterMovieService;
//			
//			
//			@PostMapping("/add")
//			public ResponseEntity<TheaterMovie> addTheaterMovie(@RequestBody TheaterMovie theatermovie)
//			{	
//					theatermovie = TheaterMovieService.addTheaterMovie(theatermovie);
//					return new ResponseEntity<>(theatermovie, HttpStatus.CREATED);
//			}
//			
//			@PutMapping("/update")
//			public ResponseEntity<TheaterMovie> updateTheaterMovie(@RequestBody TheaterMovie theatermovie)
//			{
//					theatermovie = TheaterMovieService.updateTheaterMovie(theatermovie);
//					return new ResponseEntity<>(theatermovie, HttpStatus.OK);
//			}
//			
//			@GetMapping("/viewTheaterMovie/{Id}")
//			public ResponseEntity<TheaterMovie> viewTheaterMovie(@PathVariable int Id) 
//			{
//					TheaterMovie theatermovie = TheaterMovieService.viewTheaterMovie(Id);
//					return new ResponseEntity<TheaterMovie>(theatermovie,HttpStatus.OK);
//			}
//
//			@GetMapping("/getall")
//			public ResponseEntity<List<TheaterMovie>> viewTheaterMovieList()  
//			{
//					return ResponseEntity.ok(TheaterMovieService.getAllTheaterMovies());
//			}
//
//			@PostMapping("/deleteTheaterMovie/{id}")
//			public ResponseEntity<String> deleteTheaterMovie(@PathVariable("id") int id )
//			{		
//				TheaterMovieService.deleteTheaterMovieById(id);
//				return new ResponseEntity<>("TheaterMovie details are Deleted", HttpStatus.OK);
//			}
//		
//	    }


package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.TheaterMovie;
import com.cg.service.TheaterMovieService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/theatermovie")
public class TheaterMovieController {

	@Autowired
	private TheaterMovieService theaterMovieService;
	
	@PostMapping("/add")
	public ResponseEntity<TheaterMovie> addTheaterMovie(@RequestBody TheaterMovie theaterMovie) {
		TheaterMovie newTheaterMovie = theaterMovieService.addTheaterMovie(theaterMovie);
		return new ResponseEntity<>(newTheaterMovie, HttpStatus.CREATED);
	}

	@GetMapping("/view/{theaterId}")
	public ResponseEntity<TheaterMovie> viewTheaterMovie(@PathVariable int theaterId) {
		TheaterMovie theaterMovie = theaterMovieService.viewTheaterMovie(theaterId);
		return new ResponseEntity<>(theaterMovie, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<TheaterMovie>> viewTheaterMovieList() {
		return ResponseEntity.ok(theaterMovieService.getAllTheaterMovie());
	}

}