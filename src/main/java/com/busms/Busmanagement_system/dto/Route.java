package com.busms.Busmanagement_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	Bus bus;
	@ManyToOne
	Agency agency;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Station> stations;
	private boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean thursday;
	private boolean friday;
	private boolean saturday;
	private boolean sunday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public List<Station> getStations() {
		return stations;
	}
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	public boolean isMonday() {
		return monday;
	}
	public void setMonday(boolean monday) {
		this.monday = monday;
	}
	public boolean isTuesday() {
		return tuesday;
	}
	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}
	public boolean isWednesday() {
		return wednesday;
	}
	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}
	public boolean isThursday() {
		return thursday;
	}
	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}
	public boolean isFriday() {
		return friday;
	}
	public void setFriday(boolean friday) {
		this.friday = friday;
	}
	public boolean isSaturday() {
		return saturday;
	}
	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}
	public boolean isSunday() {
		return sunday;
	}
	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}
	
}
