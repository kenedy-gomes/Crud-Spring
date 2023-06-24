CREATE TABLE product(
  id serial PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(100),
  preco FLOAT NOT NULL
)