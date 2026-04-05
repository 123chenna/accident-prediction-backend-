package com.example.demo.model;

import jakarta.persistence.*;

@Entity  
@Table(name = "accident_data")

public class AccidentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer speed;
    private String weather;
    private String roadType;
    private String trafficDensity;
    private String timeOfDay;
    @Column(name = "risk_level")
    private String riskLevel;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getRoadType() {
		return roadType;
	}
	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}
	public String getTrafficDensity() {
		return trafficDensity;
	}
	public void setTrafficDensity(String trafficDensity) {
		this.trafficDensity = trafficDensity;
	}
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

   
    
}