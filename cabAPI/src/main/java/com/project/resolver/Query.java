package com.project.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.project.exception.NotFoundException;
import com.project.model.Bookings;
import com.project.model.Cab;
import com.project.model.User;
import com.project.repository.BookingsRepository;
import com.project.repository.CabRepository;
import com.project.repository.UserRepository;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private BookingsRepository bookingsRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CabRepository cabRepository;

	public Query(BookingsRepository bookingsRepository, UserRepository userRepository) {

		this.bookingsRepository = bookingsRepository;
		this.userRepository = userRepository;
	}

	public Iterable<Bookings> findAllBookings() {
		return bookingsRepository.findAll();
	}

	public Iterable<Bookings> findBookings(String name) {
		User user = userRepository.findByName(name);
		List<Bookings> bookings = new ArrayList<>();
		if (user == null) {
			throw new NotFoundException("No User Found", name);
		} else {
			bookings.addAll(bookingsRepository.findByUserName(user.getName()));

			return bookings;
		}

	}

	public Cab findCab(String area, String carType) {
		Cab cab = new Cab();
		cab = cabRepository.findByDistance(area, carType);
		if (cab == null) {
			throw new NotFoundException("No Cab Found", area);
		} else {
			return cab;
		}
	}

}
