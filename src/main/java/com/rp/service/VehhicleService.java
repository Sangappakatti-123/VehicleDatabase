package com.rp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rp.model.Vehicle;

public interface VehhicleService {
	
	 Vehicle addVehicle(Vehicle v);
	 
	 Vehicle getById(Integer id);
	 
	 Vehicle deleteBy(Integer id);
	 
	 List<Vehicle> getAll();
	 
	 List<Vehicle> getByColor(String color);
	 
	 List<Vehicle> sortByPriceColor();
	 
	 List<Vehicle> sortByPrice();
	 
	 Vehicle updateVehicle(Vehicle v);
	 
	 List<Vehicle> getLuxury();
}
