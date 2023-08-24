CREATE TABLE products (
	id INT UNSIGNED auto_increment NOT NULL,
	name varchar(150) NOT NULL,
	description TEXT NULL,
	price DECIMAL(6,2) NOT NULL,
	freight_price decimal(6,2) NULL,
	deleted bit(1) DEFAULT 0 NOT NULL,
	seller_id INT UNSIGNED NOT NULL,
	CONSTRAINT products_PK PRIMARY KEY (id),
	CONSTRAINT products_FK FOREIGN KEY (seller_id) REFERENCES users(id) ON DELETE CASCADE
)