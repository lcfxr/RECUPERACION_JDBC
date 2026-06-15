DROP TABLE IF EXISTS mascotas;

CREATE TABLE mascotas (
    id INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    especie TEXT NOT NULL,
    edad INTEGER NOT NULL
);

INSERT INTO mascotas (id, nombre, especie, edad) VALUES
(1, 'Luna', 'Gato', 3),
(2, 'Thor', 'Perro', 5),
(3, 'Nala', 'Perro', 2),
(4, 'Kiwi', 'Pájaro', 1);
