-- Active: 1782279402261@@127.0.0.1@3306@ecommerce
show tables;

select * from customer; -- 1

select * from address; -- 2

select * from orders; -- 3

SELECT * from payment;

SELECT * from shipment;

select first_name, last_name, email from customer; -- 4

select * from address where city = "hyderabad" ; -- 5

select * from address where state = "telangana" ; --6

select * from orders where order_status = "pending"; --7

select * from shipment where shipment_status = "delivered";

select * from customer where cust_id >101;

select * from customer where first_name != "ravi" ;


SELECT * FROM customer 
ORDER BY first_name;

SELECT * FROM orders ORDER BY total_amount DESC;

SELECT * FROM orders ORDER BY total_amount DESC LIMIT 2;


select COUNT (*) from customer;

select COUNT (*) from orders;

select SUM(total_amount)  from  orders;

select avg(total_amount) from orders;

select max(total_amount) from orders;

select min(total_amount) from orders;

SELECT * FROM orders;


select order_status, count(*) from orders GROUP BY order_status;

select shipment_status, count(*) from shipment GROUP BY shipment_status;

SELECT cust_id, SUM(total_amount) FROM orders GROUP BY cust_id;

select cust_id, sum(total_amount) from orders group by cust_id having sum(total_amount)>5000;


SELECT cust_id FROM orders GROUP BY cust_id HAVING COUNT(*) > 3;

SELECT orders.*, customer.first_name        
FROM orders 
INNER JOIN customer ON orders.cust_id = customer.cust_id;    