SELECT
suppliers.supplier, 
categories.category, 
SUM(a.price) AS total
FROM actions as a
  INNER JOIN
suppliers ON a.supplier_id = suppliers.id
  INNER JOIN
products on a.product_id = products.id
  INNER JOIN
categories ON products.category_id = categories.id
WHERE EXTRACT(YEAR FROM a.action_date) = 2016
GROUP BY suppliers.supplier, categories.category;