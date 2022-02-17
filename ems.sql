create table user_registration(
 u_id varchar(255) not null, 
 u_name varchar(255) default null, 
 u_address varchar(255) default null, 
 u_phone varchar(255)default null, 
 u_adhar varchar(255)default null,
 u_email varchar(255)default null, 
 u_password varchar(255)default null, 
 u_date varchar(255)default null, 
 u_time varchar(255)default null, 
 u_active tinyint(1) default 0, 
 isActive tinyint(1) default 0,
  PRIMARY KEY (u_id) 
);

drop table user_registration ;

create table category(
category_id varchar(255) not null, 
category_name varchar(255) default null, 
category_date varchar(255) default null, 
category_time varchar(255) default null, 
isActive tinyint(1) default 0,
PRIMARY KEY (category_id)
);

create table city(
city_id varchar(255) not null, 
city_name varchar(255) default null,
isActive tinyint(1) default 0,
PRIMARY KEY (city_id)
);

create table hall(
hall_id varchar(255) not null, 
hall_name varchar(255) default null, 
hall_place varchar(255) default null, 
hall_seat varchar(255) default null, 
hall_date varchar(255) default null, 
hall_time varchar(255) default null, 
hall_price varchar(255) default null, 
hall_availability varchar(255) default null, 
hall_image varchar(255) default null, 
category_id varchar(255) default null, 
city_id varchar(255) default null, 
isActive tinyint(1) default 0,
PRIMARY KEY (hall_id),
key(category_id),
key(city_id),
CONSTRAINT ibfk_category FOREIGN KEY (category_id) REFERENCES category(category_id),
CONSTRAINT ibfk1_city FOREIGN KEY (city_id) REFERENCES city(city_id)
);

drop table hall ;


create table paymentmethod(
payment_id varchar(255) not null, 
payment_name varchar(255) default null, 
payment_date varchar(255) default null, 
payment_time varchar(255) default null, 
isActive tinyint(1) default 0,
PRIMARY KEY (payment_id)
);

create table reservationhall(
reserv_id varchar(255) not null, 
order_no varchar(255) default null, 
arrival_date varchar(255) default null, 
departure_date varchar(255) default null, 
booked_date varchar(255) default null, 
booked_time varchar(255) default null, 
u_id varchar(255) default null, 
hall_id varchar(255) default null, 
category_id varchar(255) default null, 
city_id varchar(255) default null, 
payment_id varchar(255) default null, 
isActive tinyint(1) default 0,
PRIMARY KEY (reserv_id),
KEY `category_id` (`category_id`),
KEY `city_id` (`city_id`),
KEY `payment_id` (`payment_id`),
KEY `hall_id` (`hall_id`),
KEY `u_id` (`u_id`),
CONSTRAINT `reservationhall_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category`(`category_id`),
CONSTRAINT `reservationhall_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `city`(`city_id`),
CONSTRAINT `reservationhall_ibfk_3` FOREIGN KEY (`u_id`) REFERENCES `user_registration`(`u_id`),
CONSTRAINT `reservationhall_ibfk_4` FOREIGN KEY (`hall_id`) REFERENCES `hall`(`hall_id`),
CONSTRAINT `reservationhall_ibfk_5` FOREIGN KEY (`payment_id`) REFERENCES `paymentmethod`(`payment_id`)
);


create table admin_login(
a_id varchar(255) not null, 
a_username varchar(255) default null, 
a_password varchar(255) default null,
isActive tinyint(1) default 0,
PRIMARY KEY (a_id)
);

