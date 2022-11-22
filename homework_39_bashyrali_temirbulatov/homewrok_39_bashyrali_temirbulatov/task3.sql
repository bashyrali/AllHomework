SELECT 
categories.category, actions.action_date
FROM actions
	INNER JOIN
products on actions.product_id = products.id
	INNER JOIN
categories ON products.category_id = categories.id
WHERE  supplier_id  =  (SELECT id FROM suppliers 
						WHERE supplier ='IDT')
						AND action_date between '2016-06-01' and '2016-08-31'
ORDER BY action_date;