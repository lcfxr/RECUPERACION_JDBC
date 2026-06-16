DROP TABLE IF EXISTS reservas;
DROP TABLE IF EXISTS habitaciones;

CREATE TABLE habitaciones (
    id INTEGER PRIMARY KEY,
    numero TEXT NOT NULL,
    tipo TEXT NOT NULL,
    precio_noche REAL NOT NULL,
    ocupada INTEGER NOT NULL
);

CREATE TABLE reservas (
    id INTEGER PRIMARY KEY,
    id_habitacion INTEGER NOT NULL,
    cliente TEXT NOT NULL,
    fecha_entrada TEXT NOT NULL,
    noches INTEGER NOT NULL,
    importe_total REAL NOT NULL,
    FOREIGN KEY (id_habitacion) REFERENCES habitaciones(id)
);

