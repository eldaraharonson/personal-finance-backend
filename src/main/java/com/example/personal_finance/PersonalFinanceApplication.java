package com.example.personal_finance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// postgres superuser password: password

@SpringBootApplication
public class PersonalFinanceApplication {

    private static final Logger log = LoggerFactory.getLogger(PersonalFinanceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner() {
//		return args -> {
//			Expense expense = new Expense(1, 10.0, "Brooklyn Pizza", Category.FOOD, LocalDateTime.now());
//			log.info("New expense: " + expense);
//		};
	//}

}
