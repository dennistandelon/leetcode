# Write your MySQL query statement below
SELECT project_id, ROUND(AVG(experience_years),2) AS average_years FROM Project p
JOIN Employee e ON e.employee_id = p.employee_id
WHERE experience_years IS NOT NULL
GROUP BY project_id