-- Creación de enums necesarios
CREATE TYPE tipo_producto AS ENUM ('Libro', 'Disco', 'Revista');
CREATE TYPE tipo_autor_artista AS ENUM ('Autor', 'Artista');
CREATE TYPE tipo_transaccion AS ENUM ('Venta', 'Renta', 'Compra');
CREATE TYPE estatus_vacacion AS ENUM ('Solicitado', 'Aprobado', 'Rechazado', 'Finalizado');
CREATE TYPE estado_renta AS ENUM ('Rentado','Devuelto','Retrasado');

-- TABLA DE CLIENTES
CREATE TABLE Cliente (
    id_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    direccion VARCHAR(200),
    fecha_registro DATE DEFAULT CURRENT_DATE
);

-- TABLA DE EMPLEADOS
CREATE TABLE Empleado (
    id_empleado SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    puesto VARCHAR(50),
    fecha_contratacion DATE DEFAULT CURRENT_DATE
);

-- TABLA DE CATEGORÍAS DE PRODUCTO
CREATE TABLE Categoria (
    id_categoria SERIAL PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL
);

-- TABLA DE AUTORES / ARTISTAS
CREATE TABLE AutorArtista (
    id_autor_artista SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo tipo_autor_artista NOT NULL
);

-- TABLA DE PRODUCTOS
CREATE TABLE Producto (
    id_producto SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    tipo tipo_producto NOT NULL,
    id_categoria INT REFERENCES Categoria(id_categoria),
    id_autor_artista INT REFERENCES AutorArtista(id_autor_artista),
    precio NUMERIC(10,2) NOT NULL,
    costo NUMERIC(10,2) NOT NULL,
    descripcion TEXT,
    fecha_publicacion DATE,
    isbn_issn VARCHAR(50)
);

-- TABLA DE INVENTARIO
CREATE TABLE Inventario (
    id_inventario SERIAL PRIMARY KEY,
    id_producto INT NOT NULL REFERENCES Producto(id_producto),
    cantidad_total INT NOT NULL DEFAULT 0,
    cantidad_disponible INT NOT NULL DEFAULT 0,
    ubicacion VARCHAR(100)
);

-- TABLA DE TRANSACCIONES
CREATE TABLE Transaccion (
    id_transaccion SERIAL PRIMARY KEY,
    tipo tipo_transaccion NOT NULL,
    fecha DATE NOT NULL,
    id_cliente INT REFERENCES Cliente(id_cliente),
    id_empleado INT REFERENCES Empleado(id_empleado),
    total NUMERIC(10,2) NOT NULL,
    notas TEXT
);

-- DETALLE DE TRANSACCIONES
CREATE TABLE TransaccionDetalle (
    id_detalle SERIAL PRIMARY KEY,
    id_transaccion INT NOT NULL REFERENCES Transaccion(id_transaccion),
    id_producto INT NOT NULL REFERENCES Producto(id_producto),
    cantidad INT NOT NULL,
    precio_unitario NUMERIC(10,2) NOT NULL,
    subtotal NUMERIC(10,2) GENERATED ALWAYS AS (cantidad * precio_unitario) STORED
);

-- TABLA DE RENTAS: para controlar fechas de devolución
CREATE TABLE Renta (
    id_renta SERIAL PRIMARY KEY,
    id_transaccion INT NOT NULL REFERENCES Transaccion(id_transaccion),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    fecha_devolucion DATE,
    estado estado_renta DEFAULT 'Rentado'
);

-- TABLA DE ASISTENCIA DE EMPLEADOS (Entradas y salidas)
CREATE TABLE RegistroAsistencia (
    id_registro SERIAL PRIMARY KEY,
    id_empleado INT NOT NULL REFERENCES Empleado(id_empleado),
    fecha DATE NOT NULL,
    hora_entrada TIME,
    hora_salida TIME,
    observaciones VARCHAR(200)
);

-- TABLA DE VACACIONES DE EMPLEADOS
CREATE TABLE Vacaciones (
    id_vacacion SERIAL PRIMARY KEY,
    id_empleado INT NOT NULL REFERENCES Empleado(id_empleado),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    dias_disfrutados INT GENERATED ALWAYS AS ((fecha_fin - fecha_inicio) + 1) STORED,
    estatus estatus_vacacion DEFAULT 'Solicitado'
);

-- TABLA DE FALTAS DE EMPLEADOS
CREATE TABLE FaltasEmpleado (
    id_falta SERIAL PRIMARY KEY,
    id_empleado INT NOT NULL REFERENCES Empleado(id_empleado),
    fecha DATE NOT NULL,
    justificado BOOLEAN DEFAULT FALSE,
    motivo VARCHAR(255)
);

-- Índices
CREATE INDEX idx_producto_tipo ON Producto(tipo);
CREATE INDEX idx_producto_titulo ON Producto(titulo);