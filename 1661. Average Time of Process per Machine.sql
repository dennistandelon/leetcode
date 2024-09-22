# Write your MySQL query statement below
WITH e AS
(
    SELECT * FROM Activity
    WHERE activity_type = 'end'
)  
SELECT s.machine_id, ROUND(SUM((e.timestamp - s.timestamp))/COUNT(s.machine_id),3) AS processing_time FROM (
    SELECT * FROM Activity
    WHERE activity_type = 'start'
) AS s
JOIN e ON s.machine_id = e.machine_id AND s.process_id = e.process_id
GROUP BY s.machine_id
