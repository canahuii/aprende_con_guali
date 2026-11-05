-- schema.sql

-- Tabla para guardar la ruta del JDK
CREATE TABLE IF NOT EXISTS configuracion (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        jdk_path VARCHAR(255) NOT NULL
    );

-- Tabla para gestionar las lecciones persistidas
CREATE TABLE IF NOT EXISTS leccion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    contenido_markdown TEXT,
    objetivo VARCHAR(100)
    );

-- Tabla para registrar las sesiones del historial
CREATE TABLE IF NOT EXISTS historial (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    leccion_nombre VARCHAR(255) NOT NULL,
    fecha_inicio VARCHAR(100),
    fecha_fin VARCHAR(100),
    resultado VARCHAR(50)
    );