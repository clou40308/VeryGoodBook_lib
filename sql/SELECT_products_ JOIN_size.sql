SELECT * FROM vgb.product_cpu_size ORDER BY ordinal;

SELECT product_id, cpu_name, size_name, 
	product_cpu_size.stock,
    product_cpu_size.unit_price,
    product_cpu_size.unit_price * (100-products.discount) / 100 AS price,
    ordinal 
	FROM product_cpu_size 
    JOIN products ON product_cpu_size.product_id = products.id
	WHERE product_id ="8" AND cpu_name="Ultra 7"
	ORDER BY ordinal;


SELECT id, name, products.unit_price, products.stock, products.photo_url, category, products.release_date, 
		description, discount,
		product_cpu.product_id, product_cpu.cpu_name, product_cpu.stock AS cpu_stock,
        IFNULL(product_cpu.release_date,products.release_date) AS cpu_release_date,
        product_cpu.photo_url AS cpu_photo,
        COUNT(size_name)
        FROM products
			LEFT JOIN product_cpu ON products.id=product_cpu.product_id
            LEFT JOIN product_cpu_size ON product_cpu.product_id = product_cpu_size.product_id
					AND product_cpu.cpu_name = product_cpu_size.cpu_name
		WHERE id = "8"
        GROUP BY id,product_cpu.cpu_name;
        
SELECT id, name, products.unit_price, products.stock, products.photo_url, category, products.release_date, 
		description, discount,
		product_cpu.product_id, product_cpu.cpu_name, product_cpu.stock AS cpu_stock,
        IFNULL(product_cpu.release_date,products.release_date) AS cpu_release_date,
        product_cpu.photo_url AS cpu_photo,
        COUNT(size_name) AS size_count
        FROM products
			LEFT JOIN product_cpu ON products.id=product_cpu.product_id
            LEFT JOIN product_cpu_size ON product_cpu.product_id = product_cpu_size.product_id
					AND (product_cpu.cpu_name = product_cpu_size.cpu_name
							OR product_cpu.cpu_name IS NULL
                            )
		WHERE id = "1"
        GROUP BY id,product_cpu.cpu_name;
