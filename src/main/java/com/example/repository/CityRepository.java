package com.example.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.City;

public interface CityRepository extends CrudRepository<City, BigDecimal>{
	
	/*
	@Query("select c.name, c.population from city c where c.poplution > 1000000 order by DESC")
	List<Object[]> selectPopulation(); 
	*/
}
