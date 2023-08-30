create database qr_code;

use qr_code;

create table users(
  id varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  password varchar(255),
  so_dien_thoai int,
  email varchar(255),
  role varchar(255),
  ten varchar(255),
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp DEFAULT CURRENT_TIMESTAMP,
  create_user varchar(255) DEFAULT CURRENT_TIMESTAMP,
  update_user varchar(255) DEFAULT CURRENT_TIMESTAMP,
  primary key (id)
);

create table check_in(
     id int NOT NULL AUTO_INCREMENT,
     check_in bit,
     username varchar(255),
     date_check_in timestamp DEFAULT CURRENT_TIMESTAMP,
     create_date timestamp DEFAULT CURRENT_TIMESTAMP,
     update_date timestamp DEFAULT CURRENT_TIMESTAMP,
     create_user varchar(255) DEFAULT CURRENT_TIMESTAMP,
     update_user varchar(255) DEFAULT CURRENT_TIMESTAMP,
     primary key (id)
);

create table config(
   id int NOT NULL AUTO_INCREMENT,
   name varchar(255) not null,
   value varchar(255) not null,
   create_date timestamp DEFAULT CURRENT_TIMESTAMP,
   update_date timestamp DEFAULT CURRENT_TIMESTAMP,
   create_user varchar(255) DEFAULT CURRENT_TIMESTAMP,
   update_user varchar(255) DEFAULT CURRENT_TIMESTAMP,
   primary key (id)
)

