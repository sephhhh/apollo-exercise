package apollo.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExerciseApplication {

	private static final Logger log = LoggerFactory.getLogger(ExerciseApplication.class);

	public ExerciseApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}

	@Bean
	public CommandLineRunner movieApp() {
		return (args) -> {
			log.info("This is running...");
		};
	}
}
