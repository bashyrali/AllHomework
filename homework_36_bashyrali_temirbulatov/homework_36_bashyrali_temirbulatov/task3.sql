SELECT DISTINCT products.product
FROM actions 
    INNER JOIN 
	products ON actions.product_id = products.id
WHERE DATE_PART('YEAR',actions.action_date) = 2017


