create database testmd3;

use `testmd3`;

create table category(
id_category int auto_increment primary key,
name_category varchar(50)
);

create table product(
id_product int auto_increment primary key,
name_product varchar(50),
price double,
quantity int,
color varchar(200),
description varchar(50),
id_category int,
foreign key (id_category) references category(id_category)
);


INSERT INTO `testmd3`.`category` (`name_category`) VALUES ('phone');
INSERT INTO `testmd3`.`category` (`name_category`) VALUES ('television');

INSERT INTO `testmd3`.`product` (`name_product`, `price`, `quantity`, `color`, `description`, `id_category`) VALUES ('Iphone 11', '799', '12', 'Purple, Yellow, Green', 'new', '1');
INSERT INTO `testmd3`.`product` (`name_product`, `price`, `quantity`, `color`, `description`, `id_category`) VALUES ('Iphone 11 Pro', '1100', '12', 'Green, Black, White', 'new', '1');
INSERT INTO `testmd3`.`product` (`name_product`, `price`, `quantity`, `color`, `description`, `id_category`) VALUES ('Iphone X', '749', '13', 'Coral, Black, Blue', 'new', '1');
INSERT INTO `testmd3`.`product` (`name_product`, `price`, `quantity`, `color`, `description`, `id_category`) VALUES ('Smart TV man hinh cong 4K UHD 49 inch RU730', '1000000', '5', 'black', 'new', '2');
INSERT INTO `testmd3`.`product` (`name_product`, `price`, `quantity`, `color`, `description`, `id_category`) VALUES ('SAMSUNG GALAXY S10 E', '420', '10', 'Prism Blue', 'new', '1');
