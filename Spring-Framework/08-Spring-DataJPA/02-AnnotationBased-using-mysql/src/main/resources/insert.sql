insert into category (name) values ('Fruits');
insert into category (name) values ('Drinks');

insert into product (name, price, createdDate, category_id) values ('Orange', 2000, '220211', 1);
insert into product (name, price, createdDate, category_id) values ('Apple', 3000, '220312', 1);
insert into product (name, price, createdDate, category_id) values ('Mango', 2500, '220112', 1);

insert into product (name, price, size, createdDate, category_id) values ('NestCafe', 1500, 'LARGE', '220305', 2);
insert into product (name, price, size, createdDate, category_id) values ('Shark Energy Drink', 1600, 'SMALL', '220603', 2);
insert into product (name, price, size, createdDate, category_id) values (null, 1950, 'SMALL', '220603', 2);