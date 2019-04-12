create table rules (
	id serial primary key,
	name varchar(100), 
	description varchar(255)
);

create table roles (
	id serial primary key,
	name varchar(100), 
	description varchar(255)
);

create table rules_of_roles (
	rule_id serial references rules(id),
	role_id serial references roles(id),
	constraint id primary key (rule_id, role_id)
);
	
create table users (
	id serial primary key,
	role_id serial references roles(id),
	login varchar(20),
	password varchar(20),
	name varchar(100)
);	

create table state (
	id serial primary key,
	name varchar(100),
	description varchar(255)	
);	

create table category (
	id serial primary key,
	name varchar(100),
	description varchar(255)	
);	

create table items (
	id serial primary key,
	category_id serial references category(id),
	state_id serial references state(id),
	user_id serial references users(id), 
	description varchar(2000)	
);	

create table comments (
	id serial primary key,
	item_id serial references items(id),
	user_id serial references users(id), 
	comment varchar(2000)	
);	

create table attachs (
	id serial primary key,
	item_id serial references items(id),
	user_id serial references users(id), 
	file bytea,
	description varchar(255)	
);	

insert into roles (name, description) 
values ('administrator', 'Administrator of system'), 
		('user', 'User of system');

insert into rules (name) 
values ('create item'), 
		('delete item');

insert into rules_of_roles (rule_id, role_id) 
values (1, 1), 
		(2, 1),
		(1, 2);

insert into users (role_id, login, password, name)
values (1, 'admin', 'admin_pwd', ''),
	(2, 'pas', 'pas_pwd', 'Pavlov Aleksey Sergeevich'),
	(2, 'ial', 'ial_pwd', 'Ivanov Andrey Leonidovich');
	
		
insert into state (name, description)
values ('create', ''),
		('handle',''),
		('complete', ''),
		('delete', '');
		
insert into category (name, description)
values('offer', ''),
		('contract', ''),
		('tech support', '');

insert into items (category_id, state_id, user_id, description)
values (3, 1, 2, 'Please repair my computer' ),
		(3, 2, 3, 'You need to set up a printer in our room');

insert into comments (item_id, user_id, comment)
values (1,1,'Bring your computer to the tech center'),
		(2,1,'The printer you have installed, turn it on');