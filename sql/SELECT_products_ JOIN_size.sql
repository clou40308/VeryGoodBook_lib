SELECT * FROM vgb.product_cpu_size ORDER BY ordinal;

/* E05: 用ajax查詢指定productId, colorName對應的spec(s)  */
SELECT product_id, cpu_name, size_name, 
	product_cpu_size.stock,
    product_cpu_size.unit_price,
    product_cpu_size.unit_price * (100-products.discount) / 100 AS price,
    ordinal 
	FROM product_cpu_size 
    JOIN products ON product_cpu_size.product_id = products.id
	WHERE product_id ="8" AND cpu_name="Ultra 7"
	ORDER BY ordinal;

/*E05: 檢視產品明細，使用LEFT OUTER JOIN (解決MySQL不支援FULL OUTER JOIN) */    
SELECT id, name, products.unit_price, products.stock, products.photo_url, category, products.release_date, 
		description, discount,
		product_cpu.product_id, product_cpu.cpu_name, product_cpu.stock AS cpu_stock,
        IFNULL(product_cpu.release_date,products.release_date) AS cpu_release_date,
        product_cpu.photo_url AS cpu_photo,
        COUNT(size_name) AS size_count
        FROM products
			LEFT JOIN product_cpu ON products.id=product_cpu.product_id
            LEFT JOIN product_cpu_size ON products.id = product_cpu_size.product_id
					AND (product_cpu.cpu_name = product_cpu_size.cpu_name
							OR product_cpu.cpu_name IS NULL
                            )
		WHERE id = "9"
        GROUP BY id,product_cpu.cpu_name;
        
SELECT id, name, products.unit_price, products.stock, products.photo_url, category, products.release_date, 
		description, discount,
		product_cpu.product_id, product_cpu.cpu_name, product_cpu.stock AS cpu_stock,
        IFNULL(product_cpu.release_date,products.release_date) AS cpu_release_date,
        product_cpu.photo_url AS cpu_photo,
        COUNT(size_name) AS size_count , GROUP_CONCAT(size_name ORDER BY product_cpu_size.ordinal )
        FROM products
			LEFT JOIN product_cpu ON products.id=product_cpu.product_id
            LEFT JOIN product_cpu_size ON products.id = product_cpu_size.product_id
					AND (product_cpu.cpu_name = product_cpu_size.cpu_name
							OR product_cpu.cpu_name IS NULL
                            )
        GROUP BY id,product_cpu.cpu_name;
        
SELECT id, name, products.unit_price, products.stock, products.photo_url, category, products.release_date, 
		description, discount,
		product_cpu.product_id, product_cpu.cpu_name, product_cpu.stock AS cpu_stock,
        IFNULL(product_cpu.release_date,products.release_date) AS cpu_release_date,
        product_cpu.photo_url AS cpu_photo,
        COUNT(size_name) AS size_count , GROUP_CONCAT(size_name ORDER BY product_cpu_size.ordinal )
        FROM products
			LEFT JOIN product_cpu ON products.id=product_cpu.product_id
            LEFT JOIN product_cpu_size ON products.id = product_cpu_size.product_id
					AND (product_cpu.cpu_name = product_cpu_size.cpu_name
							OR product_cpu.cpu_name IS NULL
                            )
        GROUP BY id,product_cpu.cpu_name
        HAVING size_count > 0 ;
        
/*E05: */
SELECT id, name, products.unit_price, IFNULL(SUM(product_cpu_size.stock),products.stock) AS stock, products.photo_url, category, products.release_date, 
		description, discount,
		product_cpu.product_id, product_cpu.cpu_name,
        product_cpu.release_date AS cpu_release_date,product_cpu.photo_url  AS cpu_photo,
		IFNULL(SUM(product_cpu_size.stock),product_cpu.stock) AS cpu_stock,
        product_cpu.ordinal,
        COUNT(size_name) AS size_count , GROUP_CONCAT(size_name ORDER BY product_cpu_size.ordinal )
        FROM products
			LEFT JOIN product_cpu ON products.id=product_cpu.product_id
            LEFT JOIN product_cpu_size ON products.id = product_cpu_size.product_id
					AND (product_cpu.cpu_name = product_cpu_size.cpu_name
							OR product_cpu.cpu_name IS NULL)
		WHERE id = "9"
        GROUP BY id,product_cpu.cpu_name;