package gestion.burger.burger;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;


import gestion.burger.burger.fixture.UserFixture;



@SpringBootApplication
public class BurgerApplication implements CommandLineRunner {

	@Autowired
	private UserFixture userFixture;

	public static void main(String[] args) {
		SpringApplication.run(BurgerApplication.class, args);
				
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 // userFixture.loadDefaultAdmin();
	} 



}
