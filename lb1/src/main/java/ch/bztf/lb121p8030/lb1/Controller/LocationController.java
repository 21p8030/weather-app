package ch.bztf.lb121p8030.lb1.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import ch.bztf.lb121p8030.lb1.Location;

import org.springframework.ui.Model;

@Controller
public class LocationController {
    private static final Logger logger = LogManager.getLogger(LocationController.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/location")
    public String getLocation(@RequestParam(value = "ort", required = false) String ort, Model model) {
        // Hier werden anhand der per Get übergebenen Variable allle Locations welche
        // den übergebenen String im Namen enthalten von der
        // RestAPI abgerufen in ein Java Objekt umgeformt und an die View weitergegeben

        String url = "https://www.metaweather.com/api/location/search/?query=" + ort;
        if (ort == "") {
            // Hier der Fallback falls die Variable leer war
            logger.warn("Location wurde mit leerem Parameter aufgerufen Fallsback Ort Zurich");
            url = "https://www.metaweather.com/api/location/search/?query=Zurich";
        } else {
            logger.info("Location wurde mit folgendem Parameter aufgerufen: " + ort);
            // Dieser Logger wird aufgerufen wenn die Variable nicht leer war
        }

        // Hier wird die Antwort der RestAPI im JSON Format in das Objekt location
        // umgewandelt damit wir die Daten mit Java auslesen können
        ResponseEntity<List<Location>> locationResponse = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Location>>() {
                });
        List<Location> location = locationResponse.getBody();
        model.addAttribute("titel", location);
        // Mittels model.addAttribute werden die Variablen an mittels Thymeleaf
        // generierte Views geliefert damit die entsprechenden Daten auf der
        // Weboberfläche angezeigt werden können.
        return "location";
    }
}