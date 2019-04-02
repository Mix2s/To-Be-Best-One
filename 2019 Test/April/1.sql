CREATE TABLE students (
id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
sn INT NOT NULL UNIQUE COMMENT '学号',
name VARCHAR(20) NOT NULL,
qq VARCHAR(20)
);
INSERT INTO students VALUES (100, 10000, '唐三藏', NULL);
INSERT INTO students VALUES (101, 10001, '孙悟空', '11111');
SELECT * FROM students;
INSERT INTO students (id, sn, name) VALUES
(102, 20001, '曹孟德'),
(103, 20002, '孙仲谋');
CREATE TABLE exam_result (
id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL COMMENT '同学姓名',
yuwen float DEFAULT 0.0 COMMENT '语文成绩',
shuxue float DEFAULT 0.0 COMMENT '数学成绩',
yingyu float DEFAULT 0.0 COMMENT '英语成绩'
);
INSERT INTO exam_result (name, yuwen, shuxue, yingyu) VALUES
('唐三藏', 67, 98, 56),
('孙悟空', 87, 78, 77),
('猪悟能', 88, 98, 90),
('曹孟德', 82, 84, 67),
('刘玄德', 55, 85, 45),
('孙权', 70, 73, 78),
('宋公明', 75, 65, 30);
SELECT * FROM exam_result;
SELECT id, name, yingyu FROM exam_result;
SELECT idname10 FROM exam_resul
select id,name,yingyu+10 from exam_result;
select id,name,yuwen+shuxue from exam_result;
select id,name,yuwen+shuxue dept from exam_result;
select shuxue from exam_result;
select distinct shuxue from exam_result;
select name,yingyu from exam_result where yingyu>=80 and yingyu <=100;
select name,yingyu from exam_result where yingyu between 80 and 100;
select name,shuxue from exam_result where shuxue=58 or shuxue=98;
select name,shuxue from exam_result where shuxue in(100,98,50);
select name,shuxue from exam_result where shuxue in(100,98,50);
SELECT name FROM exam_result WHERE name LIKE '孙_';\
select name,yuwen yingyu from exam_result where yingyu>yuwen;\
select name,yuwen from exam_result where yuwen>80 and name not like '孙%';
select name,yuwen,shuxue,yingyu,yuwen+yingyu dept
from exam_result
where name like '孙%' or (
yuwen+shuxue+yingyu>200);
select name,qq from students where qq is not null;
select null=null,null=1,null=0;
select name,shuxue from exam_result order by shuxue;
select name qq from students order by qq;
select name,qq from students order by qq desc;
select name,shuxue,yingyu,yuwen from exam_result order by shuxue desc,yingyu,yuwen;
select name,yuwen+yingyu+shuxue from exam_result
order by yuwen+yingyu+shuxue desc;
select name,yuwen+yingyu+shuxue dept from exam_result
order by dept desc;
select name,shuxue from exam_result
where name like '孙%' or name like '曹%'
order by shuxue desc; 
select id,name,shuxue,yingyu,yuwen+shuxue from exam_result 
order by id limit 3 offset 0;
update exam_result set shuxue=80 where name='孙悟空';
update exam_result set shuxue=60,yuwen=70 where name='曹孟德';
update exam_result set shuxue=shuxue+30 order by yuwen+shuxue+yingyu limit 3;
update exam_result set shuxue=shuxue+30 order by 
SELECT name, shuxue, yuwen + shuxue + yingyu dept FROM exam_result
ORDER BY dept LIMIT 3;
update exam_result set yuwen=yuwen*2;
select count(*) from students;
select count(shuxue) from exam_result;
select count(distinct shuxue) from exam_result;
select sum(shuxue) from exam_result;
select sum(shuxue) from exam_result exam_result where shuxue<60;
select avg(yuwen+shuxue+yingyu) avg from exam_result;
select max(yingyu) from exam_result;
