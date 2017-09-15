package com.example.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

	public enum Gender {
		M, F;
	}

	@Id
	@Column(precision = 4)
	private BigInteger empno;
	@Column(length = 10, nullable = false)
	private String ename;
	@Column(length = 1)
	@Enumerated(EnumType.STRING) // enum을 활용해서 데이터베이스에 정확도를 높이기
	private Gender gender;
	@Column(length = 9)
	private String job;
	@Column(precision = 4)
	private Integer mgr;
	@Temporal(TemporalType.DATE) // java의 date와 db의 date 타입 일치
	private Date hiredate;
//	@Column(precision = 7, scale = 2)
	private BigDecimal sal;
//	@Column(precision = 7, scale = 2)
	private BigDecimal comm;
//	@Column(precision = 2)
	private Integer deptno;

}
