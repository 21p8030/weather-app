package ch.bztf.lb121p8030.lb1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Wetter_daten {
    private Consolidated_weather consolidated_weather[];
    private Sources sources[];
    private Parent parent;
    private String title;
    private String location_type;
    private Date time;
    private Date sun_rise;
    private Date sun_set;
    private String timezone_name;

    public Wetter_daten() {

    }

    public void setConsolidated_weather(Consolidated_weather[] consolidated_weather) {
        this.consolidated_weather = consolidated_weather;
    }

    public Consolidated_weather[] getConsolidated_weather() {
        return consolidated_weather;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Parent getParent() {
        return parent;
    }

    public void setSources(Sources[] sources) {
        this.sources = sources;
    }

    public Sources[] getSources() {
        return sources;
    }

    public void setSun_rise(Date sun_rise) {
        this.sun_rise = sun_rise;
    }

    public String getSun_rise() {
        // Hier wird die Variable vom Typ Date mittels der Variable format3 einem
        // SimpleDateFormat Type umgewandelt sodas dieser nacher in der form HH:mm
        // angezeigt wird
        SimpleDateFormat format3 = new SimpleDateFormat("HH:mm");

        return "Sonnenaufgang: " + format3.format(sun_rise);
    }

    public void setSun_set(Date sun_set) {
        this.sun_set = sun_set;
    }

    public String getSun_set() {

        // Hier wird die Variable vom Typ Date mittels der Variable format2 einem
        // SimpleDateFormat Type umgewandelt sodas dieser nacher in der form HH:mm
        // angezeigt wird
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");

        return "Sonnenuntergang: " + format2.format(sun_set);
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTime() {
        // Hier wird die Variable vom Typ Date mittels der Variable format einem
        // SimpleDateFormat Type umgewandelt sodas dieser nacher in der form HH:mm:ss
        // angezeigt wird
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        return "Uhrzeit: " + format.format(time);
    }

    public void setTimezone_name(String timezone_name) {
        this.timezone_name = timezone_name;
    }

    public String getTimezone_name() {
        return timezone_name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}