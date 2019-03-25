
select null;
select 1+null;
 create table myclass(
class_name varchar(20) not null,
class_room varchar(10) not null
);
> create table tt10 (
name varchar(20) not null,
age tinyint unsigned default 0,
 sex char(2) default '男'
);
desc tt10;
insert into tt10(name) values('zhangsan');
select * from tt10;

create table tt12 (
name varchar(20) not null comment '姓名',
age tinyint unsigned default 0 comment '年龄',
sex char(2) default '男' comment '性别'
 );
 desc tt12;
 show create table tt12;
 create table tt12(
 name varchar(20) not null,
 age tiny
  show create table tt3\G
select * from tt3;
alter table tt3 change a a int(5) unsigned zerofill;
 select * from tt3;
 select a, hex(a) from tt3;
