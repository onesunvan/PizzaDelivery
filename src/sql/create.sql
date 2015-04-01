CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 6
  CACHE 1;

CREATE TABLE pizzas (id INT PRIMARY KEY, name VARCHAR, price DOUBLE PRECISION, type VARCHAR);

CREATE TABLE addresses (id INT PRIMARY KEY, country VARCHAR,
    city VARCHAR, street VARCHAR, number INT);

CREATE TABLE customers (id INT PRIMARY KEY REFERENCES addresses(id), first_name VARCHAR, last_name VARCHAR);

CREATE TABLE orders (id INT PRIMARY KEY, date DATE, name VARCHAR, status VARCHAR,
    price DOUBLE PRECISION, customer_id INT REFERENCES customers(id));

CREATE TABLE pizza_orders (
    id INT PRIMARY KEY, pizza_id INT REFERENCES pizzas(id),
    order_id INT REFERENCES orders(id), amount INT);