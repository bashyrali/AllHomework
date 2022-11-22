SELECT 
brands.brand,
SUM(actions.price) AS total
FROM actions
INNER JOIN 
products ON actions.product_id = products.id
LEFT JOIN brands ON products.brand_id = brands.id
GROUP BY brands.brand
ORDER BY brands.brand;