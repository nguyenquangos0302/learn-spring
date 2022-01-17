DROP TABLE IF EXISTS Item;

CREATE TABLE Item
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255),
    price    INT,
    quantity INT
);