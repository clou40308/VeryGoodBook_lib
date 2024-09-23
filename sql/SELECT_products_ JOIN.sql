/*INNER JOIN*/
SELECT id, name, unit_price, products.stock, products.photo_url, category, 
	products.release_date, description, discount,
    product_id, cpu_name, product_cpu.release_date AS cpu_release_date,
    product_cpu.photo_url  AS cpu_photo,
    product_cpu.stock AS cpu_stock
	FROM products 
	INNER JOIN product_cpu ON products.id = product_cpu.product_id; 
    
/*E05: 檢視產品明細，使用LEFT OUTER JOIN*/
SELECT id, name, unit_price, products.stock, products.photo_url, category, 
	products.release_date, description, discount,
    product_id, cpu_name, product_cpu.release_date AS cpu_release_date,
    product_cpu.photo_url  AS cpu_photo,
    product_cpu.stock AS cpu_stock
	FROM products 
	LEFT JOIN product_cpu ON products.id = product_cpu.product_id
    WHERE id="6"; 
    
/*使用RIGHT OUTER JOIN */
SELECT id, name, unit_price, products.stock, products.photo_url, category, 
	products.release_date, description, discount,
    product_id, cpu_name, product_cpu.release_date AS cpu_release_date,
    product_cpu.photo_url  AS cpu_photo,
    product_cpu.stock AS cpu_stock
	FROM products 
	RIGHT JOIN product_cpu ON products.id = product_cpu.product_id
    WHERE id="6"; 
    
SELECT * FROM product_cpu ORDER BY product_cpu.ordinal ;

/*SUM*/
SELECT id, name,  IFNULL(SUM(product_cpu.stock),products.stock) AS total_stock,
				  IFNULL(SUM(product_cpu.release_date),products.release_date) AS release_date,
	product_id , GROUP_CONCAT(cpu_name) , GROUP_CONCAT(product_cpu.stock)
	FROM products 
	LEFT JOIN product_cpu ON products.id = product_cpu.product_id
    WHERE id = 1
    GROUP BY id; 

SELECT @@GLOBAL.sql_mode, @@SESSION.sql_mode; 
SET SESSION sql_mode= 'ONLY_FULL_GROUP_BY, STRICT_TRANS_TABLES, NO_ZERO_IN_DATE, NO_ZERO_DATE , ERROR_FOR_DIVISION_BY_ZERO, NO_AUTO_CREATE_USER, and NO_ENGINE_SUBSTITUTION.';