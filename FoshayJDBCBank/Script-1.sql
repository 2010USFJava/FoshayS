drop schema if exists bank cascade;

set search_path to bank;

create table bank.users (
	userid serial not null,
	username varchar(20) not null,
	pass varchar(20) not null,
	primary key(userid)
);

create table bank.accounts (
	acctnum int not null,
	userid int,
	balance numeric, 
	accttype varchar(20),
	primary key(acctnum),
	constraint fk_user
		foreign key(userid)
		references bank.users (userid)
);

create table bank.transactions (
	userid int not null,
	actionid int not null, 
	primary key(actionid),
	constraint fk_user_actions
		foreign key(userid)
		references bank.users (userid)
);

select * from bank.accounts;

select * from bank.users;
