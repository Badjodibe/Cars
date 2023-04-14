package com.carsdatabase.carsdatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="cars")
public interface CarRepository extends CrudRepository<Car, Long>{

	// Fetch cars by brand
	List<Car> findByBrand(String brand);
	// Fetch cars by color
	List<Car> findByColor(String color);
	// Fetch cars by year
	List<Car> findByYear(int year);
	
	List<Car> findByBrandAndModel(String brand, String model);
			// Fetch cars by brand or color
			
	List<Car> findByBrandOrColor(String brand, String color);
	
	// Fetch cars by brand and sort by year
	List<Car> findByBrandOrderByYearAsc(String brand);
	
	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrandn(String brand);
}
