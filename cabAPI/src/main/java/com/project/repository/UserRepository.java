package com.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByName(String name);


	@Query(value="SELECT COUNT(*) FROM USER U WHERE U.phone_number=:phoneNumber", nativeQuery=true)
	public int existsByPhoneNumber(Long phoneNumber);
}
