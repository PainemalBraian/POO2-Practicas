CREATE DATABASE IF NOT EXISTS poo2_db;
USE poo2_db;

CREATE TABLE inscripciones (
    id_inscripcion INT AUTO_INCREMENT PRIMARY KEY , -- ID único de la inscripción
    fecha_inscripcion DATE NOT NULL, -- Fecha de inscripción
    id_concurso INT NOT NULL, -- ID del concurso
    fecha_limite DATE NOT NULL, -- Fecha límite del concurso
    fecha_apertura DATE NOT NULL -- Fecha de apertura del concurso
);

--SELECT * FROM inscripciones;

--DROP DATABASE poo2_db;