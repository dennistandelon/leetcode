# Write your MySQL query statement below
SELECT Email FROM (
    SELECT Email, COUNT(Email) AS ct FROM Person
    GROUP BY Email
) a
WHERE ct >= 2