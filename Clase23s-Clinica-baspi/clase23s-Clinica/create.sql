DROP TABLE IF EXISTS domicilios;
CREATE TABLE domicilios (ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE varchar(200) NOT NULL,
NUMERO INT NOT NULL,
LOCALIDAD varchar(100) NOT NULL,
PROVINCIA varchar(100) NOT NULL);

DROP TABLE IF EXISTS pacientes;
CREATE TABLE pacientes (ID INT AUTO_INCREMENT PRIMARY KEY,
APELLIDO varchar(100) NOT NULL,
NOMBRE varchar(100) NOT NULL,
EMAIL varchar(100) NOT NULL,
DNI INT NOT NULL,
FECHA_INGRESO DATE NOT NULL,
DOMICILIO_ID INT NOT NULL);


INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES ('Calle A', 475, 'Florida', 'Buenos Aires');
INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES ('Calle B', 123, 'Saavedra', 'Capital federal');

INSERT INTO pacientes(apellido, nombre, email, dni, fecha_ingreso, domicilio_id) VALUES('Aguero', 'Kun', 'kun@gmail.com', 35334589, '2022-03-01', 1);
INSERT INTO pacientes(apellido, nombre, email, dni, fecha_ingreso, domicilio_id) VALUES('Rojas', 'Celina', 'celina@gmail.com', 33334549, '2022-10-21', 2);