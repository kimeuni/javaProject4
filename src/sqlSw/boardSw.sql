show tables;

create table boardSw(
	idx int not null auto_increment primary key,
	category varchar(12) not null,
	title varchar(45) not null,
	content varchar(1000) not null,
	displayYN char(1) default 'Y',
	reportYN char(1) default 'N',
	likes int default 0,
	writedate datetime default now(),
	nickName varchar(20) not null,
	viewCnt int default 0,
	image varchar(100),
	number int
);

insert into boardSw (category,title,content,nickName,image) values ('공지사항','테스트용 공지사항','확인용 공지사항','어드민','');
insert into boardSw (category,title,content,nickName,reportYN,image) values ('게임','게임 게시판','신고 리스트 확인용 글','홍길','Y','');
insert into boardSw (category,title,content,nickName,reportYN,image) values ('게임','게임 게시판','신고 리스트 확인용 글','홍길','Y','');

drop table boardSw;

select * from boardSw;

desc boardSw;
