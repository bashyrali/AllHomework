SELECT 
categories.category, EXTRACT(YEAR FROM a.action_date) as data, max(a.price), min(a.price),SUM(a.price)/SUM(a.qty) as avg_price_year
FROM actions as a
INNER JOIN 
products ON a.product_id = products.id
INNER JOIN 
categories ON products.category_id = categories.id
GROUP BY categories.category, data
ORDER BY categories.category, data;