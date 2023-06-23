package com.rp.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rp.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{
	@Query(value="select * from vehicle where vcolor=?1",nativeQuery=true)
	List<Vehicle> getByColor(String color);
	
	@Query(value="select * from vehicle order by vprice,vcolor",nativeQuery=true)
	List<Vehicle> sortByPriceColor();
	
	@Query(value="select * from vehicle order by vprice",nativeQuery=true)
	List<Vehicle> sortByPrice();
	
	@Query(value="select * from vehicle where vprice>=1000000 order by vprice",nativeQuery=true)
	List<Vehicle> getLuxury();
}
