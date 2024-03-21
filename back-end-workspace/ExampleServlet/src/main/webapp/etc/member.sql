select * from gisa;
create table member(
	userId varchar(20) primary key,
	userPwd varchar(20) not null,
	userName varchar(20) not null,
	registDate datetime null
);
select * from member;