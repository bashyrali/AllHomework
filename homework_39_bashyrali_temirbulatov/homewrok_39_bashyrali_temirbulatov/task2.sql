SELECT 
products.product
FROM actions
  INNER JOIN
products on actions.product_id = products.id
INNER JOIN
suppliers ON actions.supplier_id = suppliers.id
WHERE NOT EXISTS(SELECT products.product, suppliers.supplier FROM actions 
				 WHERE actions.product_id = products.id AND
				 actions.supplier_id = (SELECT id FROM suppliers WHERE suppliers.supplier = 'IDT'))
GROUP BY products.product
