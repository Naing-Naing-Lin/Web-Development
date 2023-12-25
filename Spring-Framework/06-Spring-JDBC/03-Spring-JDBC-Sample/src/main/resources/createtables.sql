Drop table if exists member_tbl;
Create table member_tbl(
	name varchar(45) not null,
	loginId varchar(45) primary key,
	password varchar(45)
);

insert into member_tbl values ('Andrew', 'admin', '123');
insert into member_tbl values ('William Smith', 'officer', '123');
insert into member_tbl values ('Samlew', 'user', '123');