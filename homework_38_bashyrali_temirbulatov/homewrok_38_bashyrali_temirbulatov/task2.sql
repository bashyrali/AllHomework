SELECT suppliers.supplier as s, '' as year, '' as category, SUM(actions.price * actions.qty)
from actions
	INNER JOIN
	suppliers ON actions.supplier_id = suppliers.id
GROUP BY s

UNION ALL

SELECT suppliers.supplier as s, CAST(EXTRACT(YEAR FROM action_date)as text) as year, '' as category, SUM(actions.price * actions.qty)
FROM actions
	INNER JOIN 
	suppliers ON suppliers.id = actions.supplier_id
GROUP BY  year,s

UNION ALL

SELECT suppliers.supplier as s, CAST(date_part('year', action_date)as text) as year, categories.category, SUM(actions.price * actions.qty)
FROM actions

	INNER JOIN
	suppliers ON actions.supplier_id = suppliers.id
	INNER JOIN
	products on actions.product_id = products.id
 	INNER JOIN
	categories ON products.category_id = categories.id
GROUP BY  EXTRACT(YEAR FROM action_date), s, categories.category
ORDER BY  s, year;

