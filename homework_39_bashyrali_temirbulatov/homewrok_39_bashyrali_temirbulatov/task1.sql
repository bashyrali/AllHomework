SELECT suppliers.supplier, SUM(a.price * a.qty) as total
FROM actions as a
	INNER JOIN 
	suppliers ON a.supplier_id = suppliers.id
WHERE  date_part('year', action_date) = 2016 
GROUP BY suppliers.supplier
HAVING SUM(a.price * a.qty) > (SELECT  SUM(a2.price * a2.qty) as total2 FROM actions as a2 
							   WHERE supplier_id = (SELECT id FROM suppliers WHERE supplier='IDT') 
							   AND date_part('year', action_date) = 2016 
							   GROUP BY suppliers.supplier)
