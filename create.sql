create sequence notes_seq start with 1 increment by 50;
create sequence users_seq start with 1 increment by 50;
create table notes (created timestamp(6) not null, id bigint not null, last_edited timestamp(6) not null, text varchar(255) not null, primary key (id));
create table users (id bigint not null, first_name varchar(255) not null, last_name varchar(255) not null, primary key (id));
