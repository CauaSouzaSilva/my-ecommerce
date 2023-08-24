CREATE TABLE orders_items (
	order_id INT UNSIGNED NOT NULL,
	product_id INT UNSIGNED NOT NULL,
	amount INT NOT NULL,
	CONSTRAINT orders_items_PK PRIMARY KEY (order_id,product_id),
	CONSTRAINT orders_items_FK FOREIGN KEY (order_id) REFERENCES orders(id),
	CONSTRAINT orders_items_FK_1 FOREIGN KEY (product_id) REFERENCES products(id)
)