SELECT products.product,actions.action_date ,suppliers.supplier,actions.price, qty 
FROM actions 
    INNER JOIN 
	products ON actions.product_id = products.id
	INNER JOIN 
	suppliers ON actions.supplier_id = suppliers.id
WHERE action_date BETWEEN '2016-01-01' AND '2016-01-31'
ORDER BY action_date DESC 

