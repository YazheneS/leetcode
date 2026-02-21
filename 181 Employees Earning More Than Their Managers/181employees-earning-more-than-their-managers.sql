/* Write your PL/SQL query statement below */
select e.name as Employee
from employee e
where e.salary>(Select m.salary
from employee m
where e.managerid=m.id);