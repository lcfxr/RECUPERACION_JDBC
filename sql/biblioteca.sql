DROP TABLE IF EXISTS libros;

CREATE TABLE libros (
    id INTEGER PRIMARY KEY,
    titulo TEXT NOT NULL,
    autor TEXT NOT NULL,
    precio REAL NOT NULL
);

INSERT INTO libros (id, titulo, autor, precio) VALUES
(1, 'El Quijote', 'Cervantes', 12.5),
(2, 'La isla del tesoro', 'Robert Louis Stevenson', 9.95),
(3, 'Frankenstein', 'Mary Shelley', 14.75),
(4, 'Clean Code', 'Robert C. Martin', 32.90);
