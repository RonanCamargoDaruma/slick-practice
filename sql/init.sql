create table person(
    id serial NOT NULL primary key,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    identification int not null,
    age int NOT NULL,
    address varchar NOT NULL,
    city varchar not null,
    country int not null,
    creation_datetime timestamp not null
);

create table identification(
    id serial not null primary key,
    identification_number varchar not null,
    identification_type varchar not null
);

alter table person add
constraint fk_p_i foreign key (identification) references identification(id);

alter table identification add
constraint ck_type check (identification_type in ('DNI', 'CI', 'LC'));