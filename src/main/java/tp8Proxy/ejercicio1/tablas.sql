CREATE DATABASE oopProxy;
USE oopProxy;

CREATE TABLE Personas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR (100)
);

CREATE TABLE Telefonos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR (20),
    idPersona INT,
    foreign key (idPersona) REFERENCES Personas(id)
);

INSERT INTO Personas (nombre) VALUES
('Juan Pérez'),
('María Gómez'),
('Carlos López');

INSERT INTO Telefonos (numero, idPersona) VALUES
('111-1111', 1),
('222-2222', 1),
('333-3333', 1),  -- Juan Pérez tiene 3 teléfonos

('444-4444', 2),
('555-5555', 2),  -- María Gómez tiene 2 teléfonos

('666-6666', 3);  -- Carlos López tiene 1 teléfono


-- SELECT * FROM Peronas;
-- SELECT * FROM Telefonos;

-- DROP DATABASE oopProxy;