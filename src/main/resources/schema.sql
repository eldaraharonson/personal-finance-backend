CREATE TABLE IF NOT EXISTS Expense (
    id INT NOT NULL,
    amount DECIMAL(6, 2) NOT NULL,
    business VARCHAR(250) NOT NULL,
    category VARCHAR(250) NOT NULL,
--    date_time TIMESTAMP NOT NULL,
    version INT,
    PRIMARY KEY (id)
);
