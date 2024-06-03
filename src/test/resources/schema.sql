drop table if exists customer;

create table customer (
  id bigserial not null primary key,
  first_name varchar(255) not null,
  last_name varchar(255) not null
);
