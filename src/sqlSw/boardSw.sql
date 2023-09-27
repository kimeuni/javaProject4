show tables;

create table boardSw(
	idx int not null auto_increment primary key,
	category varchar(12),
	title varchar(45) not null,
	content varchar(1000) not null,
	displayYN char(1) default 'Y',
	reportYN char(1) default 'N',
	likes int default 0,
	writedate datetime default now(),
	nickName varchar(20) not null,
	viewCnt int default 0,
	image varchar(100)
);

desc boardSw;
