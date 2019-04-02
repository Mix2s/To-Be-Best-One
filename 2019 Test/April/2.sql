select emp.ename,emp.sal,dept.dname from emp,dept where emp.deptno=dept.deptno;
select ename,sal,dname from emp,dept where emp.deptno=dept.deptno and dept.deptno;
select ename,sal,grade from emp,salgrade where emp.sal between losal and hisal;
select empno,ename from emp where emp.empno=
(select mgr from emp where ename='ford');
select leader.empno,leader.ename from emp leader,emp worker where leader.empno=
worker.mgr and worker.ename='ford';
select * from emp where deptno=
(select deptno from emp where ename='smith');
select ename,job,sal,empno from emp 
where job in
(select distinct job from emp where deptno=10)
and deptno<>10;
select ename,sal,deptno from emp where
sal>all(select sal from emp where deptno=10);
select ename,sal,deptno from emp
where sal>any(select sal from emp where deptno=30);
select ename from emp where (deptno,job)=
(select deptno,job from emp where ename='smith')
and ename <>'smith';
select ename,deptno,sal,format(asal,2) from emp,
(select avg(sal) asal,deptno dt from emp group by deptno)tmp
where emp.sal>tmp.asal and emp.deptno=tmp.dt;
select emp.ename,emp.sal,emp.deptno,ms from emp,
(select max(sal) ms,deptno from emp gtoup by deptno)tmp
where emp.deptno=tmp.deptno and emp.sal=tmp.ms;
select dept.dname,dept.deptno,dept.loc,count(*)
'bumen' from emp,dept
where emp.deptno=dept.deptno
group by dept.deptno,dept.dname,dept.loc;
select dept.deptno,dname,mycnt,loc from dept,
(select count(*) mycnt,deptno from emp group by deptno)tmp
where dept.deptno=tmp.deptno;
select ename,sal,job from emp where sal>2500 union
select ename,sal,job from emp where job='manager';
select ename,sal,job from emp where sal>2500 union all
select ename,sal,job from emp where job='manager';
select ename,dname from emp,dept where emp.deptno=dept.deptno and ename='smith';
select ename,dname from emp inner join dept on emp.deptno=dept.deptno and ename='smith';
create table stu (
 id int,
 name varchar(30)
 ); 
insert into stu values(1,'jack'),
(2,'tom'),
(3,'kity'),
(4,'nono');
create table exam (
 id int, 
 grade int
 ); 
insert into exam values(1, 56),
(2,76),
(11, 8);
select * from stu left join exam on stu.id=exam.id;
select * from stu right join exam on stu.id=exam.id;
