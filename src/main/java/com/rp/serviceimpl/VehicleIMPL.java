package com.rp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.exception.ResourceNotFound;
import com.rp.model.Vehicle;
import com.rp.repo.VehicleRepo;
import com.rp.service.VehhicleService;

@Service
public class VehicleIMPL implements VehhicleService{
	@Autowired
	VehicleRepo repo;

	@Override
	public Vehicle addVehicle(Vehicle v) {
		return repo.save(v);
	}

	@Override
	public Vehicle getById(Integer id) {
		Vehicle v=repo.findById(id).orElse(null);
		if(v!=null) {
			return v;
		}else {
				throw new ResourceNotFound("Vehicle", "id", id);
		}
	}

	@Override
	public Vehicle deleteBy(Integer id) {
		Vehicle v=repo.findById(id).orElse(null);
		if(v!=null) {
			repo.deleteById(id);
			return v;
		}
		else{
			throw new ResourceNotFound("Vehicle", "id", id);
		}
	}

	@Override
	public List<Vehicle> getAll() {
		List<Vehicle> vehicles=repo.findAll();
		if(vehicles.size()>0) {
			return vehicles;
		}else {
			throw new ResourceNotFound("Vehicle", "any id", 0);
		}
	}

	@Override
	public List<Vehicle> getByColor(String color) {
		List<Vehicle> vehicles=repo.getByColor(color);
		if(vehicles.size()>0) {
			return vehicles;
		}else {
			throw new ResourceNotFound("Vehicle", "color", 0);
		}
	}

	@Override
	public List<Vehicle> sortByPriceColor() {
		List<Vehicle> vehicles=repo.sortByPriceColor();
		if(vehicles.size()>0) {
			return vehicles;
		}else {
			throw new ResourceNotFound("Vehicle", "Price", 0);
		}
	}

	@Override
	public List<Vehicle> sortByPrice() {
		List<Vehicle> vehicles=repo.sortByPrice();
		if(vehicles.size()>0) {
			return vehicles;
		}else {
			throw new ResourceNotFound("Vehicle", " Price", 0);
		}
	}

	@Override
	public Vehicle updateVehicle(Vehicle v) {
		Vehicle v1=repo.findById(v.getVid()).orElse(null);
		if(v1!=null) {
			v1.setVcolor(v.getVcolor());
			v1.setVmodel(v.getVmodel());
			v1.setVname(v.getVname());
			v1.setVprice(v.getVprice());
			return repo.save(v1);
		}
		else {
			throw new ResourceNotFound("Vehicle", "ID", v.getVid());
		}
	}

	@Override
	public List<Vehicle> getLuxury() {
		List<Vehicle> vehicles=repo.getLuxury();
		if(vehicles.size()>0) {
			return vehicles;
		}else {
			throw new ResourceNotFound("Vehicle", "Price", 1000000);
		}
		
	}
	
}
