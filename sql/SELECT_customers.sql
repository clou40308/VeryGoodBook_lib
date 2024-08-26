/* E04-a:查詢全部產品*/
SELECT id, name, unit_price, stock, photo_url, category, release_date, description, discount FROM products;

/* E04-b:用關鍵字查詢產品*/
SELECT id, name, unit_price, stock, photo_url, category, release_date, description, discount FROM products
			WHERE name LIKE "%ACER%";

/* E04-c:用分類查詢產品*/
SELECT id, name, unit_price, stock, photo_url, category, release_date, description, discount FROM products
			WHERE category LIKE "華碩";

/* E04-d:最新上架*/
SELECT id, name, unit_price, stock, photo_url, category, release_date, description, discount FROM products
		ORDER BY release_date DESC
	   limit 5;
       
/* 最近一週內上架*/
SELECT id, name, unit_price, stock, photo_url, category, release_date, description, discount FROM products
				WHERE release_date  BETWEEN date_add(curdate(), INTERVAL -7 DAY) AND curdate();

/* 亂數推薦產品*/
SELECT id, name, unit_price, stock, photo_url, category, release_date, description, discount FROM products
    ORDER BY rand() limit 5;

