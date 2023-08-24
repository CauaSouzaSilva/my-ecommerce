CREATE TABLE orders (
	id INT UNSIGNED auto_increment NOT NULL,
	seller_id INT UNSIGNED NOT NULL,
	created_at DATETIME DEFAULT now() NOT NULL,
	sended_at DATE NULL,
	CONSTRAINT order_PK PRIMARY KEY (id),
	CONSTRAINT orders_FK FOREIGN KEY (seller_id) REFERENCES users(id) ON DELETE CASCADE
)