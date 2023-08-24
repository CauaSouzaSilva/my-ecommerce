CREATE TABLE items (
	id INT UNSIGNED auto_increment NOT NULL,
	product_id INT UNSIGNED NOT NULL,
	amount INT NULL,
	variation varchar(255) NULL,
	CONSTRAINT items_PK PRIMARY KEY (id),
	CONSTRAINT items_FK FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
)