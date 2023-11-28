-- Insert categories
INSERT INTO category (name, description) VALUES
('Electronics', 'Electronic devices and accessories'),
('Clothing', 'Fashionable clothing items'),
('Books', 'A variety of books'),
('Home and Kitchen', 'Products for home and kitchen use'),
('Toys', 'Toys for all ages');

-- Insert products
INSERT INTO product (name, description, price, category_id, inventory_stock, created_date, updated_date) VALUES
('Laptop', 'Powerful laptop for all your computing needs', 1200.0, 1, 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Smartphone', 'Latest smartphone with advanced features', 800.0, 1, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('T-shirt', 'Comfortable cotton T-shirt in various colors', 25.0, 2, 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Jeans', 'Classic denim jeans for a stylish look', 50.0, 2, 75, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Java Programming Book', 'Comprehensive guide to Java programming', 40.0, 3, 20, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Cookware Set', 'High-quality cookware set for your kitchen', 150.0, 4, 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Action Figure', 'Collectible action figure for enthusiasts', 15.0, 5, 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Headphones', 'Premium over-ear headphones for immersive audio', 80.0, 1, 15, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Dress Shirt', 'Formal dress shirt for special occasions', 35.0, 2, 40, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Children''s Book', 'Educational and entertaining books for children', 20.0, 3, 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
