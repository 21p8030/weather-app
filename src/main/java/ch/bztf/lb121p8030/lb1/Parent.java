package ch.bztf.lb121p8030.lb1;

public class Parent {
    private String title;
    private String location_type;
    private String latt_long;
    private int woeid;

    public Parent() {

    }

    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }

    public String getLatt_long() {
        return latt_long;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setWoeid(int woeid) {
        this.woeid = woeid;
    }

    public int getWoeid() {
        return woeid;
    }
}