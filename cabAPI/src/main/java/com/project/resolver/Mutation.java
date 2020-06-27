package com.project.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.project.model.Bookings;
import com.project.model.Cab;
import com.project.model.User;
import com.project.repository.BookingsRepository;
import com.project.repository.CabRepository;
import com.project.repository.UserRepository;

@Component
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private BookingsRepository bookingsRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CabRepository cabRepository;

	public Mutation(BookingsRepository bookingsRepository) {

		this.bookingsRepository = bookingsRepository;
	}

	public Bookings newBooking(String carType, String source, String destination, String userName) {
		Bookings bookings = new Bookings();
		Cab cab = cabRepository.findByDistance(source, carType);
		cab.setStatus("Booked");

		bookings.setCarType(carType);
		bookings.setSource(source);
		bookings.setDestination(destination);

		User user = userRepository.findByName(userName);

		if (user == null) {
			user = new User(userName);
			userRepository.save(user);
		}

		bookings.setUser(user);
		cabRepository.save(cab);
		bookings.setCab(cab);

		bookingsRepository.save(bookings);

		return bookings;
	}
}
