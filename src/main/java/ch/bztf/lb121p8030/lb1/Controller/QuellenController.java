package ch.bztf.lb121p8030.lb1.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import ch.bztf.lb121p8030.lb1.Wetter_daten;

import org.springframework.ui.Model;

@Controller
public class QuellenController {
    private static final Logger logger = LogManager.getLogger(QuellenController.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/quellen")
    public String getSource(Model model) {
        // Hier wird die Seite Quellen geladen
        // Im prinzip nimmt man einfach ein Ort und fragt die Wetterdaten von diesem ab
        // da in diesen die Quellen enthalten sind aber da diese bei allen Orten die
        // selben sind nehme ich hier einfsch einen Ort und lade daraus die Quellen
        // sowie deren URL's
        String url = "https://www.metaweather.com/api/location/784794/";
        logger.info("Quellen wurden aufgerufen");
        Wetter_daten quellen_daten = restTemplate.getForObject(url, Wetter_daten.class);
        model.addAttribute("quellen", quellen_daten.getSources());
        // Mittels model.addAttribute werden die Variablen an mittels Thymeleaf
        // generierte Views geliefert damit die entsprechenden Daten auf der
        // Weboberfläche angezeigt werden können.
        return "quellen";
    }
}