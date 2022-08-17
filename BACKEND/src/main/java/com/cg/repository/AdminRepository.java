//package com.cg.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.cg.entity.Admin;
//
//@Repository
//public interface AdminRepository extends JpaRepository<Admin, Integer> {
//
//	@Query("Select a from Admin a where a.username=?1 and a.password=?2")
//	Optional<Admin> checkLogin(String userName, String password);
//
//}
//
package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query("Select a from Admin a where a.username=?1 and a.password=?2")
	Optional<Admin> checkLogin(String userName, String password);

}