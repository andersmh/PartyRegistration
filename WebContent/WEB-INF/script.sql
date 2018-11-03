drop table if exists deltakere,deltakerliste;
 create table deltakerliste (
   id INTEGER,
   primary key (id)
 );
create table deltakere (
  kjonn VARCHAR(6),
  navn VARCHAR(20),
  hashpassord VARCHAR,
  mobil VARCHAR(8),
  DELTAKERLISTE_ID INTEGER,
  primary key (mobil),
  constraint fk foreign key (DELTAKERLISTE_ID) references deltakerliste(id)
);

insert into deltakerliste (id) values (1);