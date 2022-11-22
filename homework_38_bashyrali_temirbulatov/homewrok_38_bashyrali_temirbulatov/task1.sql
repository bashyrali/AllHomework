SELECT EXTRACT(YEAR FROM actions.action_date) AS year, null as month, '' as day, SUM(actions.price * qty) AS total
FROM actions
GROUP BY year



UNION ALL

SELECT EXTRACT(YEAR FROM actions.action_date) AS year, EXTRACT(MONTH FROM actions.action_date) AS month, '' as day, SUM(actions.price * qty) AS total
FROM actions
GROUP BY year,month


UNION ALL

SELECT EXTRACT(YEAR FROM actions.action_date) AS year, EXTRACT(MONTH FROM actions.action_date) as month, TO_CHAR(actions.action_date, 'dd/mm/yyyy') as day, SUM(actions.price * qty) AS total
FROM actions
GROUP BY year,month, day
ORDER BY year, month, day;
