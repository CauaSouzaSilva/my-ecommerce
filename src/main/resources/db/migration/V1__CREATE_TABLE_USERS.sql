CREATE TABLE users (
	id INT UNSIGNED auto_increment NOT NULL,
	user_name varchar(255) NOT NULL,
	cpf varchar(18) NOT NULL,
	email varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	deleted bit(1) DEFAULT 0 NOT NULL,
	CONSTRAINT users_PK PRIMARY KEY (id),
	CONSTRAINT users_UN UNIQUE KEY (user_name,cpf,email)
)
