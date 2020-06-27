package com.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Cab;

@Repository
public interface CabRepository extends CrudRepository<Cab, Integer>{

	public Cab findByCarType(String carType);
	
	@Query(value="SELECT * FROM CAB where distance=\r\n" + 
			"(select MIN(distance) from cab WHERE AREA=:area and status=\"Available\"\r\n" + 
			"and car_type=:carType) and AREA=:area and status=\"Available\"\r\n" + 
			"and car_type=:carType ", nativeQuery=true)
	public Cab findByDistance(String area, String carType);
}
