CREATE TABLE IF NOT EXISTS category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price DOUBLE,
    category_id BIGINT,
    inventory_stock INT,
    created_date TIMESTAMP,
    updated_date TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES category(id)
);