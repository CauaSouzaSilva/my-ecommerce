CREATE TABLE orders_items (
	order_id INT UNSIGNED NOT NULL,
	item_id INT UNSIGNED NOT NULL,
	CONSTRAINT orders_items_PK PRIMARY KEY (order_id,item_id),
	CONSTRAINT orders_items_FK FOREIGN KEY (order_id) REFERENCES orders(id),
	CONSTRAINT orders_items_FK_1 FOREIGN KEY (item_id) REFERENCES items(id)
)