create table students(
id int unsigned primary key auto_increment,
sn int not null unique comment'无丢',
name varchar(20) not null,
qq varchar(20)
);
insert into students values(100,10000,'唐三藏',null);
insert into students values (100,10000,'孙悟空',null);
show create database test;
alter database test character set utf8;
insert into students (id,sn,name)values(102,20001,'caocao'),(103,20002,'sunzhongmou');
select * from students;
insert into students(id,sn,name) values(100,10010,'tangdashi');
insert into students(sn,name)values(20001,'caoaman');
insert into students(id,sn,name) values (100,10010,'tangdashi') 
on duplicate key update sn=10010,name='tangdashi';
select row_count();
replace INTO students(sn,name) values (20001,'caocao');
create table exam_result(
id int unsigned primary key auto_increment,
name varchar(20) not null ,
yuwen float default 0.0 not null,
shuwxue float default 0.0 not null,
yingyu float default 0.0
);
INSERT INTO exam_result (name, yuwen, shuwxue, yingyu) VALUES
('tangsanzang', 67, 98, 56),
('sunwukong', 87, 78, 77),
('zhuwuneng', 88, 98, 90),
('caomengde', 82, 84, 67),
('liuxuande', 55, 85, 45),
('sunquan', 70, 73, 78),
('songgongming', 75, 65, 30);
select * from exam_result;
select id,name,yingyu from exam_result;
select id,name,10 from exam_result;
select id,name,yingyu+10 from exam_result;
select id,name,yuwen+shuwxue from exam_result;
select id,name,yuwen+shuwxue 总分 from exam_result;
select shuwxue from exam_result;
select distinct shuwxue from exam_result;
select name,yingyu from exam_result where yingyu<60;
select name,yuwen from exam_result where yuwen>=80 and yuwen<=90;
select name,yuwen from exam_result where yuwen between 80 and 90;
select name,shuwxue from exam_result where shuwxue=59 or shuwxue=59 or shuwxue=00;
select name,shuwxue from exam_result where shuwxue in(58,50,98,99);
select name from exam_result where name like 'sun%';
select name from exam_result where name like 'sun_';
select name,yuwen,yingyu from exam_result where yuwen>yingyu;
select name,yuwen+shuwxue+yingyu 总分 from 
exam_result where yuwen+shuwxue+yingyu<200;
select name,yuwen from exam_result where yuwen>80 and name not like'sun%';
select name,yuwen,shuwxue,yingyu,yuwen+shuwxue+yingyu 总分 from exam_result
where name like 'sun%' or 
(yuwen+shuwxue+yingyu>200 and yuwen<shuwxue and yingyu>80);
select name,qq from students where name is not null;
select null=null,null=1,null=0;
select null<=>null,null<=>1,null<=>0;
select name,shuwxue from exam_result order by shuwxue;
select name,qq from students order by qq;
select name,qq from students order by qq desc;
select name,shuwxue,yingyu,yuwen from exam_result
order by shuwxue desc,yingyu,yuwen;
select name,yuwen+yingyu+shuwxue from exam_result
order by yuwen+yingyu+shuwxue desc;
select name,yuwen+yingyu+shuwxue 总分 from exam_result
order by 总分 desc;
select name,shuwxue from exam_result where name like
'sun%' or name like 'cao' order by shuwxue desc;
select id,name,shuwxue,yingyu,yuwen from exam_result
order by id limit 3 offset 0;
select id,name,shuwxue,yingyu,yuwen from exam_result
order by id limit 3 offset 6;
select name,shuwxue from exam_result where name='sunwukong';
update exam_result set shuwxue=80 where name='suanwukong';
update exam_result set shuwxue=60,yuwen=70 where name='caomengde';
SELECT name, shuxue, yuwen + shuxue + yingyu 总分 FROM exam_result
ORDER BY 总分 LIMIT 3;
update exam_result set shuwxue=shuwxue+30 order by yuwen+shuwxue+yingyu limit 3;
