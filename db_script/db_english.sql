-- Creation of necessary enums
CREATE TYPE product_type AS ENUM ('Book', 'Disc', 'Magazine');
CREATE TYPE author_artist_type AS ENUM ('Author', 'Artist');
CREATE TYPE transaction_type AS ENUM ('Sale', 'Rental', 'Purchase');
CREATE TYPE vacation_status AS ENUM ('Requested', 'Approved', 'Rejected', 'Finished');
CREATE TYPE rental_status AS ENUM ('Rented','Returned','Late');

-- CUSTOMERS table
CREATE TABLE Customer (
    customer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    address VARCHAR(200),
    registration_date DATE DEFAULT CURRENT_DATE
);

-- EMPLOYEES table
CREATE TABLE Employee (
    employee_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    position VARCHAR(50),
    hire_date DATE DEFAULT CURRENT_DATE
);

-- CATEGORIES table
CREATE TABLE Category (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL
);

-- AUTHORS / ARTISTS table
CREATE TABLE AuthorArtist (
    author_artist_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type author_artist_type NOT NULL
);

-- PRODUCTS table
CREATE TABLE Product (
    product_id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    type product_type NOT NULL,
    category_id INT REFERENCES Category(category_id),
    author_artist_id INT REFERENCES AuthorArtist(author_artist_id),
    price NUMERIC(10,2) NOT NULL,
    cost NUMERIC(10,2) NOT NULL,
    description TEXT,
    publication_date DATE,
    isbn_issn VARCHAR(50)
);

-- INVENTORY table
CREATE TABLE Inventory (
    inventory_id SERIAL PRIMARY KEY,
    product_id INT NOT NULL REFERENCES Product(product_id),
    total_quantity INT NOT NULL DEFAULT 0,
    available_quantity INT NOT NULL DEFAULT 0,
    location VARCHAR(100)
);

-- TRANSACTIONS table
CREATE TABLE Transaction (
    transaction_id SERIAL PRIMARY KEY,
    type transaction_type NOT NULL,
    date DATE NOT NULL,
    customer_id INT REFERENCES Customer(customer_id),
    employee_id INT REFERENCES Employee(employee_id),
    total NUMERIC(10,2) NOT NULL,
    notes TEXT
);

-- TRANSACTION DETAILS table
CREATE TABLE TransactionDetail (
    detail_id SERIAL PRIMARY KEY,
    transaction_id INT NOT NULL REFERENCES Transaction(transaction_id),
    product_id INT NOT NULL REFERENCES Product(product_id),
    quantity INT NOT NULL,
    unit_price NUMERIC(10,2) NOT NULL,
    subtotal NUMERIC(10,2) GENERATED ALWAYS AS (quantity * unit_price) STORED
);

-- RENTALS table: for controlling return dates
CREATE TABLE Rental (
    rental_id SERIAL PRIMARY KEY,
    transaction_id INT NOT NULL REFERENCES Transaction(transaction_id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    return_date DATE,
    status rental_status DEFAULT 'Rented'
);

-- EMPLOYEE ATTENDANCE REGISTRY (Entries and Exits)
CREATE TABLE AttendanceRegistry (
    registry_id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL REFERENCES Employee(employee_id),
    date DATE NOT NULL,
    entry_time TIME,
    exit_time TIME,
    notes VARCHAR(200)
);

-- EMPLOYEE VACATIONS table
CREATE TABLE Vacation (
    vacation_id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL REFERENCES Employee(employee_id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    days_taken INT GENERATED ALWAYS AS ((end_date - start_date) + 1) STORED,
    status vacation_status DEFAULT 'Requested'
);

-- EMPLOYEE ABSENCES table
CREATE TABLE EmployeeAbsence (
    absence_id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL REFERENCES Employee(employee_id),
    date DATE NOT NULL,
    justified BOOLEAN DEFAULT FALSE,
    reason VARCHAR(255)
);

-- Indexes
CREATE INDEX idx_product_type ON Product(type);
CREATE INDEX idx_product_title ON Product(title);





---



-- Insert a category
INSERT INTO Category(name) VALUES ('Fiction');

-- Insert an author
INSERT INTO AuthorArtist(name, type) VALUES ('George Orwell', 'Author');

-- Insert a product
INSERT INTO Product(title, type, category_id, author_artist_id, price, cost, description, publication_date, isbn_issn)
VALUES ('1984', 'Book', 1, 1, 20.99, 10.50, 'Dystopian novel', '1949-06-08', '9780451524935');

-- Insert into inventory
INSERT INTO Inventory(product_id, total_quantity, available_quantity, location)
VALUES (1, 10, 10, 'Aisle 1, Shelf 2');

-- Insert a customer
INSERT INTO Customer(first_name, last_name, phone, email, address)
VALUES ('John', 'Doe', '555-1234', 'johndoe@email.com', '123 Main St');

-- Insert an employee
INSERT INTO Employee(first_name, last_name, phone, email, position)
VALUES ('Jane', 'Smith', '555-5678', 'jsmith@email.com', 'Manager');

-- Insert a transaction (sale)
INSERT INTO Transaction(type, date, customer_id, employee_id, total, notes)
VALUES ('Sale', CURRENT_DATE, 1, 1, 41.98, 'Regular sale');

-- Insert transaction detail
INSERT INTO TransactionDetail(transaction_id, product_id, quantity, unit_price)
VALUES (1, 1, 2, 20.99);

-- Insert an attendance record
INSERT INTO AttendanceRegistry(employee_id, date, entry_time, exit_time, notes)
VALUES (1, CURRENT_DATE, '09:00', '18:00', 'On time');

-- Insert a vacation request
INSERT INTO Vacation(employee_id, start_date, end_date, status)
VALUES (1, '2025-12-01', '2025-12-05', 'Requested');



----


-- Get all products with their category and author/artist
SELECT p.product_id, p.title, p.type, c.name AS category, aa.name AS author_artist, p.price
FROM Product p
LEFT JOIN Category c ON p.category_id = c.category_id
LEFT JOIN AuthorArtist aa ON p.author_artist_id = aa.author_artist_id;

-- Get all sales transactions with customer and employee names
SELECT t.transaction_id, t.date, t.total, c.first_name AS customer, e.first_name AS employee
FROM Transaction t
LEFT JOIN Customer c ON t.customer_id = c.customer_id
LEFT JOIN Employee e ON t.employee_id = e.employee_id
WHERE t.type = 'Sale';

-- Get inventory quantities for all products
SELECT p.title, i.total_quantity, i.available_quantity, i.location
FROM Inventory i
JOIN Product p ON i.product_id = p.product_id;

-- Get all attendance records for an employee
SELECT * FROM AttendanceRegistry
WHERE employee_id = 1;

-- Get pending vacation requests
SELECT v.vacation_id, e.first_name, e.last_name, v.start_date, v.end_date, v.status
FROM Vacation v
JOIN Employee e ON v.employee_id = e.employee_id
WHERE v.status = 'Requested';

-- Get the list of customers
SELECT * FROM Customer;