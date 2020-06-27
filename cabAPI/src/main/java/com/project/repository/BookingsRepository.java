package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Bookings;

@Repository
public interface BookingsRepository extends CrudRepository<Bookings, Integer> {

	@Query(value="SELECT * FROM BOOKINGS B WHERE B.USER_NAME=:name", nativeQuery=true)
	public List<Bookings> findByUserName(String name);
}
