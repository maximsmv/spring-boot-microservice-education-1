DROP TABLE IF EXISTS exchange_value;
CREATE TABLE exchange_value (
  id SERIAL PRIMARY KEY,
  currency_from VARCHAR(255) NOT NULL,
  currency_to VARCHAR(255) NOT NULL,
  conversion_multiple BIGINT,
  port BIGINT
);

INSERT INTO exchange_value (id, currency_from, currency_to, conversion_multiple, port)
VALUES
(1,'USD','INR',65,0),
(2,'EUR','INR',75,0),
(3,'AUD','INR',25,0);