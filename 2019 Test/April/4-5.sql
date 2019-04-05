有一个商店的数据，记录客户及购物情况，有以下三个表组成：
要求：
- 每个表的主外键
- 客户的姓名不能为空值
- 邮箱不能重复
- 客户的性别(男，女)

create database if not exists shops charset=utf8 collate utf8_bin;
use shops;
- 商品goods(商品编号goods_id，商品名goods_name, 
单价unitprice, 商品类别category,  

create table if not exists goods(
goods_id int primary key auto_increment comment'商品编号',
goods_name varchar(20) not null comment'商品名称',
unitprice  float(6,2) not null default 0 comment '商品单价',
category  varchar(10) not null comment'商品类别'
); 

客户customer(客户号customer_id,姓名name,
住址address,邮箱email,性别sex，身份证card_id)

create table if not exists customer(
customer_id  int primary key auto_increment comment'客户编号',
name   varchar(10)  not null comment'客户姓名',
email  varchar(30) unique comment '客户邮箱',
sex    enum('男','女')  default '男' comment'客户性别',
card_id char(18) unique comment'客户身份证'
);

- 购买purchase(购买订单号order_id,客户号customer_id,
商品号goods_ id,购买数量nums)

create table if not exists purchase(
order_id int primary key auto_increment comment'购买订单号',
customer_id int comment '客户编号',
goods_id  int comment '商品编号',
nums   int  not null comment '购买数量',
foreign key (goods_id) references goods(goods_id),
foreign key (customer_id) references customer(customer_id)
);

查询工资高于500或岗位为MANAGER的雇员，同时还要满足他们的姓名首字母为大写的J
select ename,sal,job 
from emp
where (sal>500 or job='MANAGER')
and ename like 'J%';
按照部门号升序而雇员的工资降序排序
select * from emp order by deptno,sal desc;
使用年薪进行降序排序

select ename,sal*12+ifnull(comm,0)  total from emp order by total desc; 
显示工资最高的员工的名字和工作岗位
select ename,job from emp where sal=(select max(sal) from emp);
显示工资高于平均工资的员工信息
select ename,sal from emp where sal>(select avg(sal) from emp);
显示每个部门的平均工资和最高工资
select deptno,format(avg(sal),2),max(sal) from emp group by deptno;
显示平均工资低于2000的部门号和它的平均工资
select deptno,avg(sal) from emp group by deptno having avg(sal)<2000;

显示每种岗位的雇员总数，平均工资
select avg(sal),count(*),job from emp group by job;
显示雇员名、雇员工资以及所在部门的名字因为上面的数据来自EMP和DEPT表，

select emp.ename,emp.sal,dept.dname 
from emp,dept 
where emp.deptno=dept.deptno;
显示部门号为10的部门名，员工名和工资
select dept.deptno,dname,ename,sal 
from emp,dept
where emp.deptno=dept.deptno
and dept.deptno=10;
显示各个员工的姓名，工资，及工资级别
select emp.ename,emp.sal,s.grade 
from emp,salgrade s
where emp.sal between s.losal and s.hisal;
显示员工FORD的上级领导的编号和姓名（mgr是员工领导的编号--empno）

select empno,ename 
from emp 
where empno=(select mgr from emp where ename='FORD');

select l.empno,l.ename 
from emp w,emp l
where  w.mgr=l.empno
and w.ename='FORD';

显示SMITH同一部门的员工
select ename,deptno,job,sal 
from emp 
where deptno=(select deptno from emp where ename='SMITH');

查询和10号部门的工作岗位相同的雇员的名字，岗位，工资，部门号，
但是不包含10自己的
select ename,job,sal,deptno
from emp 
where job in (select job from emp where deptno=10);

显示工资比部门30的所有员工的工资高的员工的姓名、工资和部门号
select ename,sal,deptno
from emp
where sal>(select max(sal) from emp where deptno=30);


select ename,sal,deptno
from emp
where sal> all (select sal from emp where deptno=30);

显示工资比部门30的任意员工的工资高的员工的姓名、
工资和部门号（包含自己部门的员工）

select ename,sal,deptno
from emp
where sal>(select min(sal) from emp where deptno=30);


select ename,sal,deptno
from emp
where sal> any(select sal from emp where deptno=30);

查询和SMITH的部门和岗位完全相同的所有雇员，不含SMITH本人

select ename,deptno,job,sal 
from emp 
where (deptno,job)=(select deptno,job from emp where ename='SMITH');


select ename,deptno,job,sal 
from emp 
where deptno=(select deptno from emp where ename='SMITH')
and job=(select job from emp where ename='SMITH');

显示高于自己部门平均工资的员工的姓名、部门、工资、平均工资

select emp.ename,emp.deptno,emp.sal,tmp.bsal 
from emp,(select avg(sal) bsal, deptno ds  from emp group by deptno ) tmp
where emp.deptno=tmp.ds and emp.sal>tmp.bsal;

查找每个部门工资最高的人的姓名、工资、部门、最高工资

select emp.ename,emp.sal,emp.deptno,tmp.msal
from emp,(select max(sal) msal,deptno ds from emp group by deptno) tmp
where emp.deptno=tmp.ds and emp.sal=tmp.msal;

显示每个部门的信息（部门名，编号，地址）和人员数量
select dept.dname,dept.deptno,dept.loc,tmp.stotal
from dept,(select count(*) stotal,deptno ds from emp group by deptno) tmp
where dept.deptno=tmp.ds;

select dept.dname,dept.deptno,dept.loc,count(*)
from emp,dept
where emp.deptno=dept.deptno
group by dept.dname,dept.deptno,dept.loc;

将工资大于2500或职位是MANAGER的人找出来

select ename,deptno,sal
from emp
where sal>2500 or job='MANAGER';

select ename,deptno,sal 
from emp 
where sal>2500
union all
select ename,deptno,sal 
from emp 
where job='MANAGER';

显示SMITH的名字和部门名称

select emp.ename,dept.dname
from emp,dept
where emp.deptno=dept.deptno
and emp.ename='SMITH';

select emp.ename,dept.dname
from emp
inner join dept
on emp.deptno=dept.deptno
and emp.ename='SMITH';

查询所有学生的成绩，如果这个学生没有成绩，也要将学生的个人信息显示出来

select * from stu left join exam on stu.id=exam.id;

列出部门名称和这些部门的员工信息，同时列出没有员工的部门

select dept.dname,emp.ename,emp.sal,emp.job,emp.deptno
from emp
left join dept
on emp.deptno=dept.deptno;

便签应用数据库项目
create database if not exists memo charset=utf8 collate utf8_general_ci;
use memo;
便签组--1

- 编号  - 组名称  - 创建时间  - 修改时间  - 删除时间
create table if not exists notes_group(
id int primary key auto_increment comment'便签组编号',
group_name varchar(30) unique comment'便签名称',
create_date datetime comment'创建时间',
modify_date timestamp comment'修改时间',
delete_date datetime comment'删除时间'
);

便签表--2

- 编号  - 标题 - 内容 - 是否私密 - 背景颜色 - 是否提醒  - 是否删除
- 提醒时间 - 创建时间 - 修改时间 - 删除时间 - 便签组编号

create table if not exists notes(
id int primary key auto_increment comment'便签编号',
title varchar(30) unique comment'便签标题',
content varchar(1000) comment'便签内容',
is_display char(1) default '0' comment'是否私密',
backup enum('黄色','红色','蓝色','绿色') comment'背景颜色',
is_call char(1) default '1' comment'是否提醒 ',
is_delete bit(1) comment'是否删除',
call_date datetime comment'提醒时间',
create_date datetime comment'创建时间',
modify_date timestamp comment'修改时间',
delete_date datetime comment'删除时间',
group_id int comment'便签组编号',
foreign key (group_id) references notes_group(id)
);

便签分享--3

- 编号   - 标签编号  - 分享备注 - 分享时间 - 删除时间
create table if not exists notes_share(
id int primary key auto_increment comment'分享编号',
notes_id int not null comment'便签编号',
share_mark varchar(100) comment'分享备注',
share_date datetime comment'分享时间 ',
delete_date datetime comment'删除时间',
foreign key (notes_id) references notes(id)
);






