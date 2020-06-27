package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cab {
	public Cab(int cabId, String carType, long distance, String status, String area) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.distance = distance;
		this.status = status;
		this.area = area;

	}

	public Cab() {

	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cabId;

	private String carType;

	private long distance;

	private String status;

	private String area;

}
