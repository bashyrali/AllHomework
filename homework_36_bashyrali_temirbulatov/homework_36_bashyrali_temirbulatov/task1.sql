SELECT products.product,DATE(actions.action_date) as act_date,actions.price, qty 
FROM actions 
    INNER JOIN 
	products ON actions.product_id = products.id
WHERE DATE(action_date) <= '2017-01-01' AND products.category_id = 2
ORDER BY qty DESC LIMIT 5

