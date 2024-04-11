-- Active: 1707625446905@@127.0.0.1@3306@ong
DROP DATABASE ong;

CREATE DATABASE IF NOT EXISTS ONG;

USE ong;

INSERT into roles ( nombre, descripcion) values 
(1, "permiso en todo"),
(2, "permisos gestión: socios, voluntarios, envíos"),
(3, "consultar reportes");

INSERT INTO directores (cedula, p_nombre, s_nombre, p_apellido, s_apellido, email, pass_word, rol_id)
VALUES (123456789, "admin", NULL, "admin", NULL, "admin@mail.com", "admin", 1),
('1234567890', 'Carlos', 'Andrés', 'González', 'Pérez', 'director1@example.com', 'password123', 2),
('2345678901', 'María', 'Isabel', 'López', 'Martínez', 'director2@example.com', 'securepass', 2),
('3456789012', 'José', 'Luis', 'Hernández', 'García', 'director3@example.com', 'mysecret', 2),
('4567890123', 'Ana', 'María', 'Díaz', 'Rodríguez', 'director4@example.com', 'abc123', 2),
('5678901234', 'Pedro', 'Pablo', 'Martínez', 'Sánchez', 'director5@example.com', 'password321', 2);

INSERT INTO ciudades (nombre)
VALUES
('Bogotá'),
('Medellín'),
('Cali'),
('Barranquilla'),
('Cartagena'),
('Bucaramanga'),
('Pereira'),
('Santa Marta'),
('Manizales'),
('Ibagué');

INSERT INTO sedes (direccion, nombre, ciudad_id, director_id)
VALUES
('Calle 1 Carrera 1', 'sede A', 1, NULL),
('Calle 2 Carrera 2', 'sede B', 2, NULL),
('Calle 3 Carrera 3', 'sede C', 3, NULL),
('Calle 4 Carrera 4', 'sede D', 4, NULL),
('Calle 5 Carrera 5', 'sede E', 5, NULL),
('Calle 6 Carrera 6', 'sede F', 6, NULL),
('Calle 7 Carrera 7', 'sede G', 7, NULL),
('Calle 8 Carrera 8', 'sede H', 8, NULL),
('Calle 9 Carrera 9', 'sede I', 9, NULL),
('Calle 0 Carrera 0', 'sede J', 10, NULL);

INSERT INTO refugios (direccion, nombre, ciudad_id)
VALUES
('Calle 1 Carrera 1', 'sede A', 1),
('Calle 2 Carrera 2', 'sede B', 2),
('Calle 3 Carrera 3', 'sede C', 3),
('Calle 4 Carrera 4', 'sede D', 4),
('Calle 5 Carrera 5', 'sede E', 5),
('Calle 6 Carrera 6', 'sede F', 6),
('Calle 7 Carrera 7', 'sede G', 7),
('Calle 8 Carrera 8', 'sede H', 8),
('Calle 9 Carrera 9', 'sede I', 9),
('Calle 0 Carrera 0', 'sede J', 10);

INSERT INTO profesiones (nombre) 
VALUES 
('Médico'),
('Enfermero/a'),
('Fisioterapeuta'),
('Farmacéutico/a'),
('Nutricionista'),
('Psicólogo/a'),
('Técnico/a de laboratorio'),
('Terapeuta ocupacional'),
('Dentista'),
('Optometrista');

INSERT INTO articulos (nombre, tipo)
VALUES 
('Arroz', 1),
('Leche', 1),
('Pan', 1),
('Manzanas', 1),
('Pollo', 1),
('Pescado', 1),
('Huevos', 1),
('Pasta', 1),
('Cereal', 1),
('Yogur', 1),
('Paracetamol', 2),
('Ibuprofeno', 2),
('Aspirina', 2),
('Vitaminas', 2),
('Antibiótico', 2),
('Jarabe para la tos', 2),
('Antiinflamatorio', 2),
('Analgésico', 2),
('Gotas para los ojos', 2),
('Pastillas para dormir', 2);

INSERT INTO socios (cedula, cuenta_bancaria, email, p_nombre, s_nombre, p_apellido, s_apellido, pass_word, rol_id, sede_id) VALUES
('1234567890', '1234567890123456', 'usuario1@example.com', 'Juan', 'Carlos', 'González', 'Pérez', 'password123', 3, 1),
('2345678901', '2345678901234567', 'usuario2@example.com', 'María', 'Isabel', 'López', 'Martínez', 'securepass', 3, 2),
('3456789012', '3456789012345678', 'usuario3@example.com', 'José', 'Luis', 'Hernández', 'García', 'mysecret', 3, 3),
('4567890123', '4567890123456789', 'usuario4@example.com', 'Ana', 'María', 'Díaz', 'Rodríguez', 'abc123', 3, 4),
('5678901234', '5678901234567890', 'usuario5@example.com', 'Pedro', 'Pablo', 'Martínez', 'Sánchez', 'password321', 3, 5),
('6789012345', '6789012345678901', 'usuario6@example.com', 'Laura', 'Beatriz', 'Gómez', 'Pérez', 'letmein', 3, 6),
('7890123456', '7890123456789012', 'usuario7@example.com', 'Diego', 'Fernando', 'Alvarez', 'Fernández', 'qwerty', 3, 7),
('8901234567', '8901234567890123', 'usuario8@example.com', 'Sofía', 'Gabriela', 'Torres', 'González', 'hello123', 3, 8),
('9012345678', '9012345678901234', 'usuario9@example.com', 'Daniel', 'Alejandro', 'Ramírez', 'Sánchez', 'iloveyou', 3, 9),
('0123456789', '0123456789012345', 'usuario10@example.com', 'Carolina', 'Mariana', 'Rojas', 'Martínez', '123456', 3, 10),
('1234509876', '1234509876543210', 'usuario11@example.com', 'Fernando', 'Javier', 'Gutiérrez', 'López', 'password', 3, 1),
('2345098765', '2345098765432109', 'usuario12@example.com', 'Andrea', 'Gabriela', 'Sánchez', 'García', 'secure123', 3, 2),
('3450987654', '3450987654321098', 'usuario13@example.com', 'Ricardo', 'Alberto', 'Fernández', 'Gómez', 'letmeout', 3, 3),
('4509876543', '4509876543210987', 'usuario14@example.com', 'Verónica', 'Marcela', 'Martínez', 'Hernández', 'admin123', 3, 4),
('5098765432', '5098765432109876', 'usuario15@example.com', 'Gonzalo', 'Sebastián', 'Pérez', 'Alvarez', 'changeme', 3, 5);

INSERT INTO ingresos (codigo, cuota, fecha_pago, socio_id, tipo_cuenta) VALUES
("202312345678901" ,10, '2023-02-05', 1, 1),
("202323456789012" ,20, '2023-04-12', 2, 2),
("202334567890123" ,10, '2023-06-21', 3, 1),
("202345678901234" ,30, '2023-08-17', 4, 3),
("202356789012345" ,20, '2023-10-03', 5, 2),
("202367890123456" ,10, '2023-11-28', 6, 1),
("202378901234567" ,20, '2023-01-09', 7, 2),
("202389012345678" ,10, '2023-03-15', 8, 1),
("202390123456789" ,30, '2023-05-22', 9, 3),
("2023012345678910" ,20, '2023-07-19', 10, 2),
("2023123450987611" ,10, '2023-09-25', 11, 1),
("2023234509876512" ,20, '2023-11-10', 12, 2),
("2023345098765413" ,10, '2023-01-27', 13, 1),
("2023450987654314" ,30, '2023-04-03', 14, 3),
("2023509876543215" ,20, '2023-06-08', 15, 2);

INSERT INTO voluntarios (cedula, email, pass_word, p_nombre, s_nombre, p_apellido, s_apellido, tipo, disponibilidad, cant_participacion, profesion_id, rol_id, sede_id) VALUES
('1234567890', 'voluntario1@example.com', 'password123', 'Juan', 'Carlos', 'González', 'Pérez', 1, 1, 3, 1, 3, 1),
('2345678901', 'voluntario2@example.com', 'securepass', 'María', 'Isabel', 'López', 'Martínez', 2, 2, 2, 2, 3, 2),
('3456789012', 'voluntario3@example.com', 'mysecret', 'José', 'Luis', 'Hernández', 'García', 1, 1, 4, 3, 3, 3),
('4567890123', 'voluntario4@example.com', 'abc123', 'Ana', 'María', 'Díaz', 'Rodríguez', 2, 2, 1, 4, 3, 4),
('5678901234', 'voluntario5@example.com', 'password321', 'Pedro', 'Pablo', 'Martínez', 'Sánchez', 1, 1, 5, 5, 3, 5),
('6789012345', 'voluntario6@example.com', 'letmein', 'Laura', 'Beatriz', 'Gómez', 'Pérez', 2, 2, 0, 6, 3, 6),
('7890123456', 'voluntario7@example.com', 'qwerty', 'Diego', 'Fernando', 'Alvarez', 'Fernández', 1, 1, 6, 7, 3, 7),
('8901234567', 'voluntario8@example.com', 'hello123', 'Sofía', 'Gabriela', 'Torres', 'González', 2, 2, 4, 8, 3, 8),
('9012345678', 'voluntario9@example.com', 'iloveyou', 'Daniel', 'Alejandro', 'Ramírez', 'Sánchez', 1, 1, 2, 9, 3, 9),
('0123456789', 'voluntario10@example.com', '123456', 'Carolina', 'Mariana', 'Rojas', 'Martínez', 2, 2, 5, 10, 3, 10),
('1234509876', 'voluntario11@example.com', 'password', 'Fernando', 'Javier', 'Gutiérrez', 'López', 1, 1, 1, 1, 3, 1),
('2345098765', 'voluntario12@example.com', 'secure123', 'Andrea', 'Gabriela', 'Sánchez', 'García', 2, 2, 3, 2, 3, 2),
('3450987654', 'voluntario13@example.com', 'letmeout', 'Ricardo', 'Alberto', 'Fernández', 'Gómez', 1, 1, 6, 3, 3, 3),
('4509876543', 'voluntario14@example.com', 'admin123', 'Verónica', 'Marcela', 'Martínez', 'Hernández', 2, 2, 0, 4, 3, 4),
('5098765432', 'voluntario15@example.com', 'changeme', 'Gonzalo', 'Sebastián', 'Pérez', 'Alvarez', 1, 1, 4, 5, 3, 5);