
CREATE TABLE flow_data (
    id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(2048) NOT NULL,
    PRIMARY KEY (id)
);