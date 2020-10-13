DROP TABLE IF EXISTS person;

create table person (
  id serial primary key,
  creation_date timestamp with time zone default(CURRENT_TIMESTAMP),
  email varchar(255) not null,
  name varchar(30) null);
