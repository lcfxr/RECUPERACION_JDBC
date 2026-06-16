#!/bin/bash

echo "======================================"
echo " Preparación del entorno para UD10_PIP"
echo "======================================"
echo ""

echo "Actualizando paquetes e instalando SQLite..."
sudo apt-get update
sudo apt-get install -y sqlite3

echo ""
echo "Preparando carpeta lib..."
mkdir -p lib

echo ""
echo "Eliminando versión anterior del driver SQLite, si existe..."
rm -f lib/sqlite-jdbc.jar

echo ""
echo "Descargando driver JDBC de SQLite..."
wget -O lib/sqlite-jdbc.jar https://github.com/xerial/sqlite-jdbc/releases/download/3.45.3.0/sqlite-jdbc-3.45.3.0.jar

echo ""
echo "Descargando dependencia SLF4J API..."
wget -O lib/slf4j-api.jar https://repo1.maven.org/maven2/org/slf4j/slf4j-api/2.0.13/slf4j-api-2.0.13.jar

echo ""
echo "Descargando dependencia SLF4J Simple..."
wget -O lib/slf4j-simple.jar https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/2.0.13/slf4j-simple-2.0.13.jar

echo ""
echo "Contenido actual de la carpeta lib:"
ls -lh lib

echo ""
echo "Comprobando versión de SQLite instalada:"
sqlite3 --version

echo ""
echo "Preparando base de datos hotel.db..."
sqlite3 hotel.db < sql/hotel.sql

echo ""
echo "Base de datos hotel.db creada correctamente."
echo "Importante: si ejecutas este script de nuevo, las tablas se reiniciarán porque hotel.sql contiene DROP TABLE IF EXISTS."
echo ""

echo "Preparación finalizada correctamente."
echo ""
echo "Recuerda compilar con:"
echo 'javac -cp "lib/*" -d out src/*.java'
echo ""
echo "Y ejecutar con:"
echo 'java -cp "lib/*:out" ProgramaPrincipal'
