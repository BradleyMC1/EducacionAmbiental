USE [EducacionAmbiental]
GO

-- ===============================
-- DIM_CATEGORIA
-- ===============================
INSERT INTO DIM_CATEGORIA (Nombre, Descripcion) VALUES
('Reciclaje', 'Actividades para clasificar y reutilizar residuos'),
('Energía', 'Ahorro y eficiencia energética'),
('Agua', 'Uso responsable del agua'),
('Contaminación', 'Reducción de emisiones y residuos'),
('Bosques', 'Cuidado de áreas verdes'),
('Animales', 'Protección de fauna'),
('Cambio climático', 'Acciones contra el calentamiento global');

-- ===============================
-- DIM_ACTIVIDAD
-- ===============================
INSERT INTO DIM_ACTIVIDAD (Titulo, Descripcion, Recurso, Numero, ProgresoInicial, ProgresoMeta) VALUES
('Separar Plásticos', 'Clasificación de plásticos por tipo', 'https://recurso1.com', 1, 0, 100),
('Ahorrar Luz', 'Reducir consumo eléctrico en casa', 'https://recurso2.com', 2, 0, 100),
('Cuidar Agua', 'Cerrar el caño al cepillarse', 'https://recurso3.com', 3, 0, 100),
('Plantar Árboles', 'Reforestación comunitaria', 'https://recurso4.com', 4, 0, 100),
('Recoger Residuos', 'Limpieza de espacios públicos', 'https://recurso5.com', 5, 0, 100),
('Evitar Aerosoles', 'Uso de productos ecoamigables', 'https://recurso6.com', 6, 0, 100),
('Usar Bicicleta', 'Transporte sostenible', 'https://recurso7.com', 7, 0, 100);

-- ===============================
-- DIMENSION_DOCENTE
-- ===============================
INSERT INTO DIMENSION_DOCENTE (Nombre, Apellidos, Correo, Contraseña, Curso) VALUES
('Lucía', 'Pérez', 'lucia@edu.com', '1234', 'Ciencias'),
('Carlos', 'Ramos', 'carlos@edu.com', 'abcd', 'Ecología'),
('Sofía', 'Gómez', 'sofia@edu.com', 'pass123', 'Biología'),
('Luis', 'Núñez', 'luis@edu.com', '9876', 'Química'),
('Ana', 'Salas', 'ana@edu.com', 'as2023', 'Educación Ambiental'),
('Diego', 'Vega', 'diego@edu.com', 'dv456', 'Geografía'),
('María', 'López', 'maria@edu.com', 'ml789', 'Física');

-- ===============================
-- DIMENSION_USUARIO
-- ===============================
INSERT INTO DIMENSION_USUARIO (Nombre, Apellidos, Correo, Contraseña) VALUES
('Juan', 'García', 'juan@correo.com', 'jg123'),
('Elena', 'Torres', 'elena@correo.com', 'et456'),
('Marco', 'Reyes', 'marco@correo.com', 'mr789'),
('Valeria', 'Díaz', 'valeria@correo.com', 'vd321'),
('Pedro', 'Mendoza', 'pedro@correo.com', 'pm654'),
('Lucía', 'Ramírez', 'lucia@correo.com', 'lr987'),
('Andrés', 'Chávez', 'andres@correo.com', 'ac000');

-- ===============================
-- DIMENSION_MODULO
-- ===============================
INSERT INTO DIMENSION_MODULO (Titulo, Descripcion, Nivel, ID_Docente, ID_Categoria, ID_Actividad) VALUES
('Módulo Reciclaje', 'Enseñanza sobre reciclaje básico', 'Inicial', 1, 1, 1),
('Energía Renovable', 'Ahorro energético en el hogar', 'Intermedio', 2, 2, 2),
('Cuidado del Agua', 'Gestión del agua doméstica', 'Inicial', 3, 3, 3),
('Vida Verde', 'Fomento de áreas verdes', 'Avanzado', 4, 5, 4),
('Limpieza Comunitaria', 'Participación en limpieza urbana', 'Inicial', 5, 4, 5),
('Productos Eco', 'Uso de productos sostenibles', 'Intermedio', 6, 4, 6),
('Movilidad Sostenible', 'Transporte alternativo', 'Avanzado', 7, 6, 7);

-- ===============================
-- DIMENSION_PROGRESO
-- ===============================
INSERT INTO DIMENSION_PROGRESO (Porcentaje, FechaInicio, FechaActualizada, Titulo, Subtitulo, Descripcion, ID_Docente) VALUES
(10.5, '2025-06-01', '2025-06-15', 'Inicio reciclaje', 'Etapa 1', 'Primeros pasos en reciclaje', 1),
(20.0, '2025-06-01', '2025-06-16', 'Energía', 'Etapa 1', 'Ahorro eléctrico básico', 2),
(35.0, '2025-06-01', '2025-06-17', 'Agua', 'Etapa 2', 'Uso consciente del agua', 3),
(50.0, '2025-06-01', '2025-06-18', 'Verde', 'Etapa 2', 'Plantación de árboles', 4),
(65.0, '2025-06-01', '2025-06-19', 'Residuos', 'Etapa 3', 'Limpieza pública', 5),
(80.0, '2025-06-01', '2025-06-20', 'Eco productos', 'Etapa 3', 'Uso sin contaminantes', 6),
(95.0, '2025-06-01', '2025-06-21', 'Movilidad', 'Etapa 4', 'Uso de bicicleta', 7);

-- ===============================
-- HECHOS_RENDIMIENTO
-- ===============================
INSERT INTO HECHOS_RENDIMIENTO (NivelAcademico, Porcentaje_de_Pasar, Porcentaje_de_Quedarse, FechaEvaluada, ProgresoGlobal, ID_Usuario, ID_Progreso, ID_Modulo, ID_Actividad) VALUES
('Secundaria', 85.5, 14.5, '2025-06-15', 10.5, 1, 1, 1, 1),
('Primaria', 90.0, 10.0, '2025-06-16', 20.0, 2, 2, 2, 2),
('Universitario', 75.5, 24.5, '2025-06-17', 35.0, 3, 3, 3, 3),
('Secundaria', 88.0, 12.0, '2025-06-18', 50.0, 4, 4, 4, 4),
('Primaria', 92.0, 8.0, '2025-06-19', 65.0, 5, 5, 5, 5),
('Universitario', 80.0, 20.0, '2025-06-20', 80.0, 6, 6, 6, 6),
('Secundaria', 97.0, 3.0, '2025-06-21', 95.0, 7, 7, 7, 7);
