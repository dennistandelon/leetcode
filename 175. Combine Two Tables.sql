# Write your MySQL query statement below
SELECT p.firstName, p.LastName, a.city, a.state
FROM Person p
LEFT JOIN Address a ON a.personId = p.personId