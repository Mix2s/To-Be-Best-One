create database if not exists mall;
use mall;
create table if not exists goods(
goods_id int primary key auto_increment comment '商品编号',
goods_name varchar(32) not null comment '商品名称',
unitprice int not null default 0 comment '单价',
ctaegory varchar(12),
provider varchar(64) not null
)character set utf8 ;
create table if not exists customer(
customer_id int primary key auto_increment,
name varchar(32) not null,
address varchar(256),
email varchar(64) unique key,
sex enum('男','女') not null,
card_id char(18) unique key
);
create table if not exists purchase(
order_id int primary key auto_increment,
customer_id int,
goods_id int,
nums int default 0,
foreign key (customer_id) references customer(customer_id),
foreign key (goods_id) references goods(goods_id)
);
