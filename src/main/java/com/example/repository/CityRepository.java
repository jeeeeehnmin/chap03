package com.example.repository;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.City;

public interface CityRepository extends CrudRepository<City, BigDecimal>{

}
