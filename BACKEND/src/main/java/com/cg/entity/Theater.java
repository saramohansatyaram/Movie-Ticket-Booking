//package com.cg.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "theater_tbl")
//public class Theater {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "theater_Id")	
//	private int theaterId;
//	
//	@Column(name = "theater_name")	
//	private String theaterName;
//	
//	private String city;
//	private String address;
//	private String phone;
//	public int getTheaterId() {
//		return theaterId;
//	}
//	public void setTheaterId(int theaterId) {
//		this.theaterId = theaterId;
//	}
//	public String getTheaterName() {
//		return theaterName;
//	}
//	public void setTheaterName(String theaterName) {
//		this.theaterName = theaterName;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	
//}


package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "theater_tbl")
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "theater_Id")	
	private int theaterId;
	@Column(name = "theater_name")	
	private String theaterName;
	private String city;
	private String address;
	private String phone;
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
