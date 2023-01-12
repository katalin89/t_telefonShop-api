package ro.mycode.telefonapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.telefonapi.repositpry.TelefonRepo;
//nu insereaza in database
@SpringBootApplication
public class TelefonApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(TelefonApiApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(TelefonRepo telefonRepo){
		return  args->{
//			for(int i=0;i<100;i++){
//				telefonRepo.getAllMarci().forEach((e)->{
//					System.out.println(e);
//
//				});
		};


	}

}


