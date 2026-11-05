-- Insertar configuración inicial del JDK por defecto
INSERT INTO configuracion (id, jdk_path) VALUES (1, 'C:/Program Files/Java/jdk-25');

-- Insertar una lección de prueba
INSERT INTO leccion (id, titulo, contenido_markdown, objetivo)
VALUES (1, 'leccion-01-hola-mundo', '# Hola Mundo\nCopie el codigo...', 'EJECUTAR EXITOSO');