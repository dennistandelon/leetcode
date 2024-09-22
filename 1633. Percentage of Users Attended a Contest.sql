# Write your MySQL query statement below
SELECT contest_id, ROUND((COUNT(contest_id)/(SELECT COUNT(*) FROM Users)) * 100, 2) AS percentage FROM Users as x
JOIN Register as r ON r.user_id = x.user_id
GROUP BY contest_id
ORDER BY percentage DESC, contest_id ASC