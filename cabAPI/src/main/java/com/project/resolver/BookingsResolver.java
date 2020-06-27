package com.project.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.project.model.Bookings;
import com.project.model.User;
import com.project.repository.UserRepository;

@Component
public class BookingsResolver implements GraphQLResolver<Bookings> {

	@Autowired
	private UserRepository userRepository;

	public BookingsResolver(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUser(Bookings bookings) {
		return userRepository.findByName(bookings.getUser().getName());
	}
}
