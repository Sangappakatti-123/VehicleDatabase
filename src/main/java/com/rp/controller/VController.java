package com.rp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rp.model.Vehicle;
import com.rp.service.VehhicleService;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

@RestController
public class VController {
	
	@Autowired
	VehhicleService vser;
	
	@PostMapping("/addVehicle")
	ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v){
		return new ResponseEntity<Vehicle>(vser.addVehicle(v),HttpStatus.CREATED);
	}
	
	@GetMapping("/findById")
	ResponseEntity<Vehicle> findById(@RequestParam Integer id){
		return new ResponseEntity<Vehicle>(vser.getById(id),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteById")
	ResponseEntity<Vehicle> deleteById(@RequestParam Integer id){
		return new ResponseEntity<Vehicle>(vser.deleteBy(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	ResponseEntity<List<Vehicle>> getAll(){
		return new ResponseEntity<List<Vehicle>>(vser.getAll(),HttpStatus.FOUND);
	}
	
	@GetMapping("/getByColor")
	ResponseEntity<List<Vehicle>> findByColor(@RequestParam String color){
		return new ResponseEntity<List<Vehicle>>(vser.getByColor(color),HttpStatus.FOUND);
	}
	
	@GetMapping("/sortByPrice")
	ResponseEntity<List<Vehicle>> sortByPrice(){
		return new ResponseEntity<List<Vehicle>>(vser.sortByPrice(),HttpStatus.FOUND);
	}
	
	@GetMapping("/sortByPriceColor")
	ResponseEntity<List<Vehicle>> sortByPriceColor(){
		return new ResponseEntity<List<Vehicle>>(vser.sortByPriceColor(),HttpStatus.FOUND);
	}
	
	@PutMapping("/updateVehicle")
	ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle v){
		return new ResponseEntity<Vehicle>(vser.updateVehicle(v),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getLuxury")
	ResponseEntity<List<Vehicle>> getLuxury(){
		return new ResponseEntity<List<Vehicle>>(vser.getLuxury(),HttpStatus.FOUND);
	}
}
