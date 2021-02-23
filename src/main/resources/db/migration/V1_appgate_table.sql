CREATE TABLE appgate (
  id varchar(255) not null,
  ip_front varchar(255) not null,
  ip_to varchar(255) not null,
  country_code varchar(255) not null,
  country varchar(255) not null,
  region varchar(255) not null,
  city varchar(255) not null,
  latitude varchar(255) not null,,
  longitude varchar(255) not null,,
  timezone varchar(255) not null,
  decimal_value varchar(255) not null,
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;