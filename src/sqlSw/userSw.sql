show tables;

create table userSw(
	idx int not null auto_increment primary key,
	id varchar(20) not null,
	pw varchar(20) not null,
	email varchar(40) not null,
	name varchar(15) not null,
	nickName varchar(8) not null,
	age int not null,
	gender char(2) not null,
	address varchar(60),
	adminYN char(1) default 'N'
);

insert into userSw (id,pw,email,name,nickName,age,gender,adminYN) values ('admin','1234','ax1234@naver.com','어드민','어드민',24,'여자','Y');

select * from userSw;

alter table userSw add column number int;
