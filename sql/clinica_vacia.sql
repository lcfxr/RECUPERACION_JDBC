DROP TABLE IF EXISTS mascotas;

CREATE TABLE mascotas (
    id INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    especie TEXT NOT NULL,
    edad INTEGER NOT NULL
);
