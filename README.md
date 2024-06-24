# SCRIPT BASE DE DATOS

## CREATE SCHEMA
CREATE SCHEMA alkawallet;

USE alkawallet;

## Creacion BD tabla usuario
CREATE TABLE usuario (
user_id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(100) NULL,
correo_electronico VARCHAR(100) NULL,
contrasenia VARCHAR(500) NULL,
saldo INT NULL,
PRIMARY KEY (user_id));

## Creacion Moneda
CREATE TABLE moneda (
currency_id INT NOT NULL AUTO_INCREMENT,
currency_name VARCHAR(100) NULL,
currency_symbol VARCHAR(3) NULL,
PRIMARY KEY (currency_id));

## Creacion BD Transaccion
CREATE TABLE transaccion (
transaction_id INT NOT NULL AUTO_INCREMENT,
sender_user_id INT NULL,
receiver_user_id INT NULL,
transaction_date DATE NULL,
origin_currency_id INT NULL,
PRIMARY KEY (transaction_id),
INDEX user_sender_idx (sender_user_id ASC) VISIBLE,
INDEX user_receiver_idx (receiver_user_id ASC) VISIBLE,
INDEX origen_currency_idx (origin_currency_id ASC) VISIBLE,
FOREIGN KEY (sender_user_id)
REFERENCES usuario (user_id),
FOREIGN KEY (receiver_user_id)
REFERENCES usuario (user_id),
FOREIGN KEY (origin_currency_id)
REFERENCES moneda (currency_id));

## Poblacion de tablas Usuario
INSERT INTO usuario (nombre, correo_electronico, contrasenia, saldo)
VALUES ('sofia', 'sofia@gmail.com', '$2a$10$ZceeNXNtFHtlDHYfl3Nchu0519FqPMnv8czXeSNPj5uJyFpW821vG', '5000000'),
('andres', 'andres@gmail.com', '$2a$10$ZceeNXNtFHtlDHYfl3Nchu0519FqPMnv8czXeSNPj5uJyFpW821vG', '2000000'),
('pedro', 'pedro@gmail.com', '$2a$10$ZceeNXNtFHtlDHYfl3Nchu0519FqPMnv8czXeSNPj5uJyFpW821vG', '1000000'),
('ines', 'ines@gmail.com', '$2a$10$ZceeNXNtFHtlDHYfl3Nchu0519FqPMnv8czXeSNPj5uJyFpW821vG', '500000'),
('olga', 'olga@gmail.com', '$2a$10$ZceeNXNtFHtlDHYfl3Nchu0519FqPMnv8czXeSNPj5uJyFpW821vG', '3040000'),
('noelia', 'noelia@gmail.com', '$2a$10$ZceeNXNtFHtlDHYfl3Nchu0519FqPMnv8czXeSNPj5uJyFpW821vG', '2840000'),
('miguel', 'miguel@gmail.com', '$2a$10$ZceeNXNtFHtlDHYfl3Nchu0519FqPMnv8czXeSNPj5uJyFpW821vG', '290000'),
('paz', 'paz@gmail.com', '$2a$10$ZceeNXNtFHtlDHYfl3Nchu0519FqPMnv8czXeSNPj5uJyFpW821vG', '390000'),
('ruben', 'ruben@gmail.com', '$2a$10$ZceeNXNtFHtlDHYfl3Nchu0519FqPMnv8czXeSNPj5uJyFpW821vG', '700000'),
( 'ester', 'ester@gmail.com', '$2a$10$ZceeNXNtFHtlDHYfl3Nchu0519FqPMnv8czXeSNPj5uJyFpW821vG', '290000');

## Poblacion Moneda		
INSERT INTO moneda (currency_name, currency_symbol)
VALUES ('peso chileno', '$'),
('euro', '€'),
('dolar americano', '$'),
('libra esterlina', '£'),
('dolar australiano', 'AUD'),
('dolar canadiense', 'CAD'),
('corona sueca', 'SEK'),
('peso mexicano', 'MXN'),
('real brasileño', 'BRL'),
( 'corona noruega', 'NOK');

## Poblacion Transacciones
INSERT INTO transaccion (sender_user_id, receiver_user_id, transaction_date, origin_currency_id)
VALUES ('1', '2', '2024-03-01', '1'),
('3', '1', '2024-03-15', '1'),
('1', '2', '2024-03-18', '1'),
('2', '3', '2024-03-18', '2'),
('3', '1', '2024-03-20', '2'),
('1', '2', '2024-03-20', '3'),
('2', '3', '2024-03-25', '4'),
('3', '1', '2024-03-26', '5'),
('1', '2', '2024-03-29', '10'),
( '2', '3', '2024-03-30', '6');

## Verificacion de tablas y datos creados
### SELECT * FROM usuario;
### SELECT * FROM moneda;
### SELECT * FROM transaccion;