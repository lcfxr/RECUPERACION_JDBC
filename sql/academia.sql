DROP TABLE IF EXISTS alumnos;

CREATE TABLE alumnos (
    id INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    nota REAL NOT NULL
);

INSERT INTO alumnos (id, nombre, nota) VALUES
(1, 'Laura', 8.5),
(2, 'Mario', 6.75),
(3, 'Carmen', 9.2);
