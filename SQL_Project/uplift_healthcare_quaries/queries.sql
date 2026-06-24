-- Active: 1782202923515@@127.0.0.1@3306@uplift_healthcare
select * FROM members
where member_status= "active";

select * from policies where policy_status = "active" and premium_amount>1200;