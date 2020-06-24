package ch.bztf.lb121p8030.lb1.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import ch.bztf.lb121p8030.lb1.Wetter_daten;

import org.springframework.ui.Model;

@Controller
public class WeatherController {
    private static final Logger logger = LogManager.getLogger(WeatherController.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/wetter")
    public String getWetter(Model model, @RequestParam(required = false) String woeid) {
        // Hier wird das Wetter anhand der per Get übergebenen Variable woeid von der
        // RestAPI abgerufen

        String url = "https://www.metaweather.com/api/location/" + woeid + "/";

        if (woeid == "") {
            // Hier der Fallback falls die Variable leer war
            logger.warn("Wetter wurde mit leerem Parameter aufgerufen Fallsback Ort Zurich");
            url = "https://www.metaweather.com/api/location/784794/";
        } else {
            logger.info(url + " wurde aufgerufen");
            // Dieser Logger wird aufgerufen wenn die Variable nicht leer war
        }

        // Hier wird die Antwort der RestAPI im JSON Format in das Objekt wetter_daten
        // umgewandelt damit wir die Daten mit Java auslesen können
        Wetter_daten wetter_daten = restTemplate.getForObject(url, Wetter_daten.class);
        model.addAttribute("wetter", wetter_daten.getConsolidated_weather());
        model.addAttribute("info", wetter_daten);
        model.addAttribute("infoparent", wetter_daten.getParent());
        // Mittels model.addAttribute werden die Variablen an mittels Thymeleaf
        // generierte Views geliefert damit die entsprechenden Daten auf der
        // Weboberfläche angezeigt werden können.
        return "Wetter_Anzeige";
    }
}