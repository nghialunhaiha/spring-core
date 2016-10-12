drop table if  exists user;
create table if not exists user (
	id int primary key auto_increment,
	address varchar(128),
	email varchar(128),
	name varchar(128),
	created datetime,
	updated datetime
);