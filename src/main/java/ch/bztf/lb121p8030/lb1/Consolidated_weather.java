package ch.bztf.lb121p8030.lb1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Consolidated_weather {
	private long id;
	private Date applicable_date;
	private String weather_state_name;
	private String weather_state_abbr;
	private float wind_speed;
	private float wind_direction;
	private String wind_direction_compass;
	private int min_temp;
	private int max_temp;
	private int the_temp;
	private float air_pressure;
	private float humidity;
	private float visibility;
	private int predictability;

	public Consolidated_weather() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApplicable_date() {
		// Hier wird die Variable vom Typ Date mittels der Variable format einem
		// SimpleDateFormat Type umgewandelt sodas dieser nacher in der form E ff MMM
		// angezeigt wird
		SimpleDateFormat format = new SimpleDateFormat("E dd MMM");

		return format.format(applicable_date);
	}

	public void setApplicable_date(Date applicable_date) {
		this.applicable_date = applicable_date;
	}

	public String getWeather_state_name() {
		return weather_state_name;
	}

	public void setWeather_state_name(String weather_state_name) {
		this.weather_state_name = weather_state_name;
	}

	public String getWeather_state_abbr() {
		return weather_state_abbr;
	}

	public void setWeather_state_abbr(String weather_state_abbr) {
		this.weather_state_abbr = weather_state_abbr;
	}

	public String getWind_speed() {
		// Da die Daten nicht in kmh ankommne sondern in mph muss hier noch
		// umgerechnet werden
		double rand = wind_speed * 1.60934;
		double speed = Math.floor(rand);
		return speed + " kmh";
	}

	public void setWind_speed(float wind_speed) {
		this.wind_speed = wind_speed;
	}

	public float getWind_direction() {
		return wind_direction;
	}

	public void setWind_direction(float wind_direction) {
		this.wind_direction = wind_direction;
	}

	public String getWind_direction_compass() {
		return "Windrichtung: " + wind_direction_compass;
	}

	public void setWind_direction_compass(String wind_direction_compass) {
		this.wind_direction_compass = wind_direction_compass;
	}

	public String getMin_temp() {
		return "Min: " + min_temp + " °C";
	}

	public void setMin_temp(int min_temp) {
		this.min_temp = min_temp;
	}

	public String getMax_temp() {
		return "Max: " + max_temp + " °C";
	}

	public void setMax_temp(int max_temp) {
		this.max_temp = max_temp;
	}

	public String getThe_temp() {
		return "Effektive Temp " + the_temp + " °C";
	}

	public void setThe_temp(int the_temp) {
		this.the_temp = the_temp;
	}

	public String getAir_pressure() {
		return "Lufdruck " + (int) air_pressure + " mbar";
	}

	public void setAir_pressure(float air_pressure) {
		this.air_pressure = air_pressure;
	}

	public String getHumidity() {
		return "Luftfeuchtigkeit " + (int) humidity + " %";
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public String getVisibility() {
		// Da die Daten nicht in km ankommne sondern in meilen muss hier noch
		// umgerechnet werden
		double rand = visibility * 1.60934;
		double visi = Math.floor(rand);
		return "Sichtweite " + (int) visi + " km";
	}

	public void setVisibility(float visibility) {
		this.visibility = visibility;
	}

	public String getPredictability() {
		return "Wahrscheinlichkeit " + predictability + " %";
	}

	public void setPredictability(int predictability) {
		this.predictability = predictability;
	}
}