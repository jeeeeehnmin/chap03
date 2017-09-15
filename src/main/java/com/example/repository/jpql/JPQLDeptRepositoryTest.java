package com.example.repository.jpql;

import static org.junit.Assert.*;

import java.math.BigInteger;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.repository.DeptRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("oracle")
public class JPQLDeptRepositoryTest {

	@Inject
	DeptRepository repo;
	
	@Test
	public void test() {
		System.out.println(repo.getClass());
	}

	@Test
	public void insertRow() {
		Dept d50 = new Dept(new BigInteger("50"), "xxx", "yyy");
		repo.save(d50);
		
		System.out.println(repo.findOne(new BigInteger("50")));
	}

	
}
