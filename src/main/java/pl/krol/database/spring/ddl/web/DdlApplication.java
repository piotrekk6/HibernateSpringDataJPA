package pl.krol.database.spring.ddl.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.krol.database.spring.ddl.beans.B;
import pl.krol.database.spring.ddl.service.BRepository;

@SpringBootApplication
public class DdlApplication {

	private static final Logger log = LoggerFactory.getLogger(DdlApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DdlApplication.class, args);
	}

//	@Bean
////	public CommandLineRunner demo(BRepository bRepository)
////	{
////		return(args)->{
////			bRepository.save(new B("Andrzej"));
////			bRepository.save(new B("koń Rafał"));
////
////            log.info("Found with findAll():");
////			for(B b: bRepository.findAll())
////            {
////                log.info((b.toString()));
////            }
////		};
//	}

}
