USE [EducacionAmbiental]
GO

-- ========================================
-- DIM_ACTIVIDAD
-- ========================================

CREATE PROCEDURE sp_InsertarActividad
    @Titulo VARCHAR(100),
    @Descripcion TEXT,
    @Recurso VARCHAR(200),
    @Numero INT,
    @ProgresoInicial INT = 0,
    @ProgresoMeta INT = 0
AS
BEGIN
    INSERT INTO DIM_ACTIVIDAD (Titulo, Descripcion, Recurso, Numero, ProgresoInicial, ProgresoMeta)
    VALUES (@Titulo, @Descripcion, @Recurso, @Numero, @ProgresoInicial, @ProgresoMeta)
END
GO

CREATE PROCEDURE sp_ActualizarActividad
    @ID INT,
    @Titulo VARCHAR(100),
    @Descripcion TEXT,
    @Recurso VARCHAR(200),
    @Numero INT,
    @ProgresoInicial INT,
    @ProgresoMeta INT
AS
BEGIN
    UPDATE DIM_ACTIVIDAD
    SET Titulo = @Titulo, Descripcion = @Descripcion, Recurso = @Recurso,
        Numero = @Numero, ProgresoInicial = @ProgresoInicial, ProgresoMeta = @ProgresoMeta
    WHERE ID_Actividad = @ID
END
GO

CREATE PROCEDURE sp_EliminarActividad
    @ID INT
AS
BEGIN
    DELETE FROM DIM_ACTIVIDAD WHERE ID_Actividad = @ID
END
GO

CREATE PROCEDURE sp_SeleccionarActividades
AS
BEGIN
    SELECT * FROM DIM_ACTIVIDAD
END
GO

-- ========================================
-- DIM_CATEGORIA
-- ========================================

CREATE PROCEDURE sp_InsertarCategoria
    @Nombre VARCHAR(50),
    @Descripcion TEXT
AS
BEGIN
    INSERT INTO DIM_CATEGORIA (Nombre, Descripcion) VALUES (@Nombre, @Descripcion)
END
GO

CREATE PROCEDURE sp_ActualizarCategoria
    @ID INT,
    @Nombre VARCHAR(50),
    @Descripcion TEXT
AS
BEGIN
    UPDATE DIM_CATEGORIA SET Nombre = @Nombre, Descripcion = @Descripcion WHERE ID_Categoria = @ID
END
GO

CREATE PROCEDURE sp_EliminarCategoria
    @ID INT
AS
BEGIN
    DELETE FROM DIM_CATEGORIA WHERE ID_Categoria = @ID
END
GO

CREATE PROCEDURE sp_SeleccionarCategorias
AS
BEGIN
    SELECT * FROM DIM_CATEGORIA
END
GO

-- ========================================
-- DIMENSION_DOCENTE
-- ========================================

CREATE PROCEDURE sp_InsertarDocente
    @Nombre VARCHAR(50),
    @Apellidos VARCHAR(50),
    @Correo VARCHAR(100),
    @Contrasena VARCHAR(100),
    @Curso VARCHAR(100)
AS
BEGIN
    INSERT INTO DIMENSION_DOCENTE (Nombre, Apellidos, Correo, Contraseña, Curso)
    VALUES (@Nombre, @Apellidos, @Correo, @Contrasena, @Curso)
END
GO

CREATE PROCEDURE sp_ActualizarDocente
    @ID INT,
    @Nombre VARCHAR(50),
    @Apellidos VARCHAR(50),
    @Correo VARCHAR(100),
    @Contrasena VARCHAR(100),
    @Curso VARCHAR(100)
AS
BEGIN
    UPDATE DIMENSION_DOCENTE
    SET Nombre = @Nombre, Apellidos = @Apellidos, Correo = @Correo, Contraseña = @Contrasena, Curso = @Curso
    WHERE ID_Docente = @ID
END
GO

CREATE PROCEDURE sp_EliminarDocente
    @ID INT
AS
BEGIN
    DELETE FROM DIMENSION_DOCENTE WHERE ID_Docente = @ID
END
GO

CREATE PROCEDURE sp_SeleccionarDocentes
AS
BEGIN
    SELECT * FROM DIMENSION_DOCENTE
END
GO

-- ========================================
-- DIMENSION_MODULO
-- ========================================

CREATE PROCEDURE sp_InsertarModulo
    @Titulo VARCHAR(100),
    @Descripcion TEXT,
    @Nivel VARCHAR(50),
    @ID_Docente INT,
    @ID_Categoria INT,
    @ID_Actividad INT
AS
BEGIN
    INSERT INTO DIMENSION_MODULO (Titulo, Descripcion, Nivel, ID_Docente, ID_Categoria, ID_Actividad)
    VALUES (@Titulo, @Descripcion, @Nivel, @ID_Docente, @ID_Categoria, @ID_Actividad)
END
GO

CREATE PROCEDURE sp_ActualizarModulo
    @ID INT,
    @Titulo VARCHAR(100),
    @Descripcion TEXT,
    @Nivel VARCHAR(50),
    @ID_Docente INT,
    @ID_Categoria INT,
    @ID_Actividad INT
AS
BEGIN
    UPDATE DIMENSION_MODULO
    SET Titulo = @Titulo, Descripcion = @Descripcion, Nivel = @Nivel,
        ID_Docente = @ID_Docente, ID_Categoria = @ID_Categoria, ID_Actividad = @ID_Actividad
    WHERE ID_Modulo = @ID
END
GO

CREATE PROCEDURE sp_EliminarModulo
    @ID INT
AS
BEGIN
    DELETE FROM DIMENSION_MODULO WHERE ID_Modulo = @ID
END
GO

CREATE PROCEDURE sp_SeleccionarModulos
AS
BEGIN
    SELECT * FROM DIMENSION_MODULO
END
GO

-- ========================================
-- DIMENSION_PROGRESO
-- ========================================

CREATE PROCEDURE sp_InsertarProgreso
    @Porcentaje DECIMAL(5,2),
    @FechaInicio DATE,
    @FechaActualizada DATE,
    @Titulo VARCHAR(100),
    @Subtitulo VARCHAR(100),
    @Descripcion VARCHAR(255),
    @ID_Docente INT
AS
BEGIN
    INSERT INTO DIMENSION_PROGRESO (Porcentaje, FechaInicio, FechaActualizada, Titulo, Subtitulo, Descripcion, ID_Docente)
    VALUES (@Porcentaje, @FechaInicio, @FechaActualizada, @Titulo, @Subtitulo, @Descripcion, @ID_Docente)
END
GO

CREATE PROCEDURE sp_ActualizarProgreso
    @ID INT,
    @Porcentaje DECIMAL(5,2),
    @FechaInicio DATE,
    @FechaActualizada DATE,
    @Titulo VARCHAR(100),
    @Subtitulo VARCHAR(100),
    @Descripcion VARCHAR(255),
    @ID_Docente INT
AS
BEGIN
    UPDATE DIMENSION_PROGRESO
    SET Porcentaje = @Porcentaje, FechaInicio = @FechaInicio, FechaActualizada = @FechaActualizada,
        Titulo = @Titulo, Subtitulo = @Subtitulo, Descripcion = @Descripcion, ID_Docente = @ID_Docente
    WHERE ID_Progreso = @ID
END
GO

CREATE PROCEDURE sp_EliminarProgreso
    @ID INT
AS
BEGIN
    DELETE FROM DIMENSION_PROGRESO WHERE ID_Progreso = @ID
END
GO

CREATE PROCEDURE sp_SeleccionarProgresos
AS
BEGIN
    SELECT * FROM DIMENSION_PROGRESO
END
GO

-- ========================================
-- DIMENSION_USUARIO
-- ========================================

CREATE PROCEDURE sp_InsertarUsuario
    @Nombre VARCHAR(50),
    @Apellidos VARCHAR(50),
    @Correo VARCHAR(100),
    @Contrasena VARCHAR(100)
AS
BEGIN
    INSERT INTO DIMENSION_USUARIO (Nombre, Apellidos, Correo, Contraseña)
    VALUES (@Nombre, @Apellidos, @Correo, @Contrasena)
END
GO

CREATE PROCEDURE sp_ActualizarUsuario
    @ID INT,
    @Nombre VARCHAR(50),
    @Apellidos VARCHAR(50),
    @Correo VARCHAR(100),
    @Contrasena VARCHAR(100)
AS
BEGIN
    UPDATE DIMENSION_USUARIO
    SET Nombre = @Nombre, Apellidos = @Apellidos, Correo = @Correo, Contraseña = @Contrasena
    WHERE ID_Usuario = @ID
END
GO

CREATE PROCEDURE sp_EliminarUsuario
    @ID INT
AS
BEGIN
    DELETE FROM DIMENSION_USUARIO WHERE ID_Usuario = @ID
END
GO

CREATE PROCEDURE sp_SeleccionarUsuarios
AS
BEGIN
    SELECT * FROM DIMENSION_USUARIO
END
GO

-- ========================================
-- HECHOS_RENDIMIENTO
-- ========================================

CREATE PROCEDURE sp_InsertarRendimiento
    @NivelAcademico VARCHAR(50),
    @PorcentajePasar DECIMAL(5,2),
    @PorcentajeQuedarse DECIMAL(5,2),
    @FechaEvaluada DATE,
    @ProgresoGlobal DECIMAL(5,2),
    @ID_Usuario INT,
    @ID_Progreso INT,
    @ID_Modulo INT,
    @ID_Actividad INT
AS
BEGIN
    INSERT INTO HECHOS_RENDIMIENTO (
        NivelAcademico, Porcentaje_de_Pasar, Porcentaje_de_Quedarse, FechaEvaluada,
        ProgresoGlobal, ID_Usuario, ID_Progreso, ID_Modulo, ID_Actividad)
    VALUES (
        @NivelAcademico, @PorcentajePasar, @PorcentajeQuedarse, @FechaEvaluada,
        @ProgresoGlobal, @ID_Usuario, @ID_Progreso, @ID_Modulo, @ID_Actividad)
END
GO

CREATE PROCEDURE sp_ActualizarRendimiento
    @ID INT,
    @NivelAcademico VARCHAR(50),
    @PorcentajePasar DECIMAL(5,2),
    @PorcentajeQuedarse DECIMAL(5,2),
    @FechaEvaluada DATE,
    @ProgresoGlobal DECIMAL(5,2),
    @ID_Usuario INT,
    @ID_Progreso INT,
    @ID_Modulo INT,
    @ID_Actividad INT
AS
BEGIN
    UPDATE HECHOS_RENDIMIENTO
    SET NivelAcademico = @NivelAcademico, Porcentaje_de_Pasar = @PorcentajePasar,
        Porcentaje_de_Quedarse = @PorcentajeQuedarse, FechaEvaluada = @FechaEvaluada,
        ProgresoGlobal = @ProgresoGlobal, ID_Usuario = @ID_Usuario, ID_Progreso = @ID_Progreso,
        ID_Modulo = @ID_Modulo, ID_Actividad = @ID_Actividad
    WHERE ID_Rendimiento = @ID
END
GO

CREATE PROCEDURE sp_EliminarRendimiento
    @ID INT
AS
BEGIN
    DELETE FROM HECHOS_RENDIMIENTO WHERE ID_Rendimiento = @ID
END
GO

CREATE PROCEDURE sp_SeleccionarRendimientos
AS
BEGIN
    SELECT * FROM HECHOS_RENDIMIENTO
END
GO
