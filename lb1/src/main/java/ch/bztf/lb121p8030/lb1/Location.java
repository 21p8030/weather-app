package ch.bztf.lb121p8030.lb1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private String title;
    private String location_type;
    private int woeid;

    public Location() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitel() {
        return title;
    }

    public void setWoeid(int woeid) {
        this.woeid = woeid;
    }

    public int getWoeid() {
        return woeid;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public String getLocation_type() {
        return location_type;
    }
}