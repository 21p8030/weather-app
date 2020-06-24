package ch.bztf.lb121p8030.lb1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RequestMapping("/")
public class Wetter {
	private static final Logger logger = LogManager.getLogger(Wetter.class);

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Wetter.class, args);
	}

	// Um die index Seite anzuzeigen
	@GetMapping("index")
	public String showIndex() {
		logger.info("Index wurde aufgerufen");
		return "index";
	}

	// Um die index Seite anzuzeigen und um einen logger einzubinden wenn die URL
	// localhost:8080/ aufgerufen wird
	@GetMapping("/")
	public String showIndex2() {
		logger.info("Index wurde aufgerufen");
		return "index";
	}

	// Um allfällige Fehlermeldungen sowie Leute die sich im URL Jungle verlaufen
	// abzufangen und auf eine dafür vorgesehene Seite weiterzuleiten
	@GetMapping("/error")
	public String Errorhandler() {
		logger.info("Ein Error ist aufgetreten");
		return "error";
	}

}