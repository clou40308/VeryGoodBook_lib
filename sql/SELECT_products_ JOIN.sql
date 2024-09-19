/*INNER JOIN*/
SELECT id, name, unit_price, products.stock, products.photo_url, category, 
	products.release_date, description, discount,
    product_id, cpu_name, product_cpu.release_date AS cpu_release_date,
    product_cpu.photo_url  AS cpu_photo,
    product_cpu.stock AS cpu_stock
	FROM products 
	INNER JOIN product_cpu ON products.id = product_cpu.product_id; 
    
/*E05: 檢視產品明細*/
SELECT id, name, unit_price, products.stock, products.photo_url, category, 
	products.release_date, description, discount,
    product_id, cpu_name, product_cpu.release_date AS cpu_release_date,
    product_cpu.photo_url  AS cpu_photo,
    product_cpu.stock AS cpu_stock
	FROM products 
	LEFT JOIN product_cpu ON products.id = product_cpu.product_id
    WHERE id="6"; 