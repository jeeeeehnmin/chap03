
select * from dept;
select * from emp;

update emp
   set gender = 'F'
 where gender ='f';
 
 update emp
   set gender = 'M'
 where gender ='M';
 
 
-- JPQL의 @Query로 작성한 것을 내장 sql로 바꿔준다.
-- 아래가 내장 sql문

SELECT emp0_.empno AS empno1_2_,
       emp0_.comm AS comm2_2_,
       emp0_.deptno AS deptno9_2_,
       emp0_.ename AS ename3_2_,
       emp0_.gender AS gender4_2_,
       emp0_.hiredate AS hiredate5_2_,
       emp0_.job AS job6_2_,
       emp0_.mgr AS mgr7_2_,
       emp0_.sal AS sal8_2_
  FROM emp emp0_ INNER JOIN dept dept1_ ON emp0_.deptno = dept1_.deptno
 WHERE dept1_.deptno = ?;
 
 
 SELECT emp0_.empno AS empno1_2_,
       emp0_.comm AS comm2_2_,
       emp0_.deptno AS deptno9_2_,
       emp0_.ename AS ename3_2_,
       emp0_.gender AS gender4_2_,
       emp0_.hiredate AS hiredate5_2_,
       emp0_.job AS job6_2_,
       emp0_.mgr AS mgr7_2_,
       emp0_.sal AS sal8_2_
  FROM emp emp0_;