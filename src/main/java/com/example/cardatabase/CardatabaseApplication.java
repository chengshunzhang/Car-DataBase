package com.example.cardatabase;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.CarRepository;
import com.example.cardatabase.domain.Owner;
import com.example.cardatabase.domain.OwnerRepository;
import com.example.cardatabase.domain.User;
import com.example.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication {
//	private static final Logger logger =
//			LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private UserRepository urepository;
	
	public static void main(String[] args) {
		
		SpringApplication.run(CardatabaseApplication.class, args);
		//logger.info("Hello Spring Boot");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// add owner objects and save them to database
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			
			// add car objects with link to owners and save them to db
			Car car = new Car("Ford", "Mustang", "Red",
					"ADF-1121", 2017, 59000, owner1);
			repository.save(car);
			car = new Car("Nissan", "Leaf", "White",
					"SSJ-3002", 2014, 29000, owner2);
			repository.save(car);
			car = new Car("Toyota", "Prius", "Silver",
					"KKO-0212", 2018, 39000, owner2);
			repository.save(car);
			
			// add user objects and save them to database
			// username: user; password: user
			// encoded password is obtained by BCrypt calculator
			urepository.save(new User("user", 
				"                                                            $2a$04$jrFVBOHH4rvJk1YbX1b/aevj/iPcGqcvAH.1M5gih48OYIFz0mEYK",
				"USER"));
			
			// username: admin; password: admin
			urepository.save(new User("admin", 
					"                                                            $2a$04$joKPfyKMaBDCyO654KVupeaB4Rb.0WzVKt1cz5lqCNze2mzcwi6hq",
					"ADMIN"));
		};
	}
}

