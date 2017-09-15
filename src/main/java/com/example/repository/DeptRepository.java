package com.example.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

	/*
	 * JPQL(JPA SQL)
	 * 객체 조회 --> 리턴도 객체 d
	 * d.dname의 dname은 객체의 프로퍼티
	 */
	@Query("select d from Dept d where d.dname=?1")
	List<Dept> selectDept1(String name);

	@Query("select d from Dept d where d.dname=:dname or d.loc=:loc")
	List<Dept> selectDept(@Param("dname") String name, @Param("loc") String loc);

	/*
	 * 일부 컬럼만 조회하기
	 */
	
	@Query("select d.dname, d.loc from Dept d order by d.loc asc")
	List<Object[]> selectDnameLoc();	
}
