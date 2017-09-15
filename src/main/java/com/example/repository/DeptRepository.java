package com.example.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Dept;

public interface DeptRepository extends JpaRepository<Dept, BigInteger>{
	
	
	/*
	 * query method
	 * --> naming rule : findBy뒤에 컬럼 이름
	 */
	Dept findByLoc(String loc);
	List<Dept> findByDnameOrLoc(String dname, String loc);
	List<Dept> findByDeptnoGreaterThanOrderByDnameDesc(BigInteger gt);
	List<Dept> findByDeptnoBetween(BigInteger left, BigInteger right);

}
