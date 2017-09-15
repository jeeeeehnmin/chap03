package com.example.repository.jpql;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.EmpRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
public class JPQLEmpRepositoryTest {

	@Inject
	EmpRepository repo;
	
	@Test
	public void test() {
		System.out.println(repo.getClass());
	}

	/*
	 * error 중에 no Session 발생하면
	 * @Transactional 
	 * 여기에서 이루어지는 쿼리들은 하나의 트랜잭션에서 수행된다.
	 * 한꺼번에 여러 개의 트랜잭션이 발생하는 것을 방지
	 */
	
	@Test
	@Transactional							
	public void findAll() {
		repo.findAll().forEach(e -> {
			System.out.println(e.getEmpno() + "," +e.getEname());
		});
	}
	
	@Test
	@Transactional
	public void selectEmpByDeptno(){
		//조인된 채로 조회해 온다.
		repo.selectEmpByDeptno(new BigInteger("10")).forEach(e -> {
//			System.out.println(e);
			System.out.println(e + ". " + e.getDept());
		});
	}

	@Test
	@Transactional
	public void selectEmpByDeptno2(){
		repo.selectEmpByDeptno2(new BigInteger("10")).forEach(e -> {
			System.out.println(e);
//			System.out.println(e + ". " + e.getDept());
		});
	}
	
	@Test
	@Transactional
	public void stat(){
		repo.stat().forEach(e -> {
			System.out.println(Arrays.toString(e));
		});
	}
	
	@Test
	@Transactional
	public void stat2(){
		repo.stat2().forEach(e -> {
//			System.out.println(e);
			System.out.println("avg = " + e.get("avg") + ", min = " + e.get("min") + ", max = " + e.get("max") );
		});
	}
	
	@Test
	@Transactional
	public void stat3(){
		repo.stat3().forEach(e -> {
//			System.out.println(e);
			System.out.println(e.get("deptno") +", "+ e.get("dname")+": " 
										+"avg = " + e.get("avg") +", " 
										+"min = " + e.get("min") +", "
										+"max = " + e.get("max") );
		});
	}
	
}
