drop table tt1;
use test;
drop table tt2;
create table tt4(id int,a bit(8));
insert into tt4 values(10,10);
select * from tt4;
create table tt6(id int,salary float(4,2));
insert into tt6 values(100,-00.00);
insert into tt6 values(101,-00.00);
select * from tt6;
create table tt7(id int,salary float(4,2) unsigned);
insert into tt7 values(100,-0.1);
show warnings;
create table tt8(id int,salary float(10,8),salary2 decimal(10,9));
insert into tt8 values(100,23.12345612, 23.12345612);
select * from tt8;
create table tt9(id int,name char(2));
insert into tt9 values(100,'a');
select * from tt9;
select null;
select 1+null;
create table myclass(
class_name varchar(20) not null,
class_room varchar(10) not null
);
desc myclass;
insert into muclass(class_name) values('class1');
create table tt10(
name varchar(20) not null,
age tinyint unsigned default 0,
sex char(2) default 'na'
);
desc tt10;
insert into tt10(name) values('zhang');
select * from tt10;
create table tt12(
name varchar(20) not null comment '姓名',
age tinyint unsigned default 0 comment '年龄',
sex char(2) default 'na' comment '性别'
);
desc tt12;
show create table tt12;
show create table tt3;
create table tt3(
a int(10) unsigned default null,
b int(10) unsigned default null
)default charset=gbk;
alter table tt3 change a a int(5) unsigned zerofill;
select * from tt3;
create table tt13(
id int unsigned primary key comment'无敌',
name varchar(20) not null
);
desc tt13;
create table tt14(
id int unsigned,
course char(10) comment'代码',
score tinyint unsigned default 80 comment'成绩',
primary key(id,course));
desc tt14;
alter table tt14 drop primary key;
alter table tt14 add primary key(score);
desc tt14;
insert into tt14 values(12,1,123);
create table tt15(
id int unsigned primary key auto_increment,
name varchar(10) not null default ''
);
insert into tt15(name) values('a');
insert into tt15(name) values('b');
select * from tt15;
create table student(
id char(10) unique comment'wudi',
name varchar(10)
);
insert into student(id,name) values ('01','aaaaa');
insert into student(id,name) values ('01','a11');
insert into student(id,name) values (null,'aaaaa');
select * from student;
drop table myclass;
create table myclass(
id int primary key,
name varchar(30) not null comment '无敌'
);
create table stu(
id int primary key,
name varchar(30) not null comment'学生',
class_id int,
foreign key(class_id) references myclass(id)
);
insert into myclass values (10,'C+++'),(20,'java');
insert into stu values(100, 'zhangsan', 10),(101, 'lisi',20);
desc stu;
desc myclass;
select * from myclass;
select * from stu;
insert into stu values(102,'wangwu',30);
insert into stu values(102,'wang',null);
select * from stu;
insert into stu values(1,'1231',null);
