DROP DATABASE  IF EXISTS control_de_ventas;

-- CREAR BASE DE DATOS
CREATE DATABASE IF NOT EXISTS control_de_ventas;

USE control_de_ventas;


CREATE TABLE clientes(
	id_cliente INT UNSIGNED AUTO_INCREMENT,
	nombre VARCHAR(30),
	apellido_pat VARCHAR(30),
	apellido_mat VARCHAR(30),
	fecha_nacim DATE,
	genero ENUM("Femenino","Masculino"),
	estado_civil ENUM("Casado","Divorciado","Soltero","Viudo"),
	telefono VARCHAR(10) UNIQUE,
	PRIMARY KEY (id_cliente)
)Engine=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE categorias(
	id_categoria INT UNSIGNED AUTO_INCREMENT,
	categoria VARCHAR(15) UNIQUE,
	PRIMARY KEY (id_categoria)
)Engine=InnoDB DEFAULT CHARSET=utf8mb4;;


CREATE TABLE forma_de_pago(
	id_pago INT UNSIGNED AUTO_INCREMENT,
	pago VARCHAR(20) UNIQUE,
	descripcion VARCHAR(50),
	PRIMARY KEY(id_pago)
)Engine=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE productos(
	id_producto INT UNSIGNED AUTO_INCREMENT,
	nombre VARCHAR(50),
	precio DECIMAL(8,2),
	cantidad INT,
	id_categoria INT UNSIGNED,
	PRIMARY KEY(id_producto),
	FOREIGN KEY(id_categoria) REFERENCES categorias (id_categoria)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE ventas(
	id_venta INT UNSIGNED AUTO_INCREMENT,
	id_cliente INT UNSIGNED,
	id_pago INT UNSIGNED,
	fecha DATE,
	total_articulos INT,
	subtotal DECIMAL(8,2),
	descuento DECIMAL(8,2) DEFAULT 0.00,
	iva DECIMAL(8,2) DEFAULT 16.00,
	total_neto DECIMAL(8,2),
	
	PRIMARY KEY(id_venta),
	FOREIGN KEY(id_cliente) REFERENCES clientes (id_cliente)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	FOREIGN KEY(id_pago) REFERENCES forma_de_pago(id_pago)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE detalle_ventas(
	id_venta INT UNSIGNED,
	id_producto INT UNSIGNED,
	cantidad INT,
	importe DECIMAL(8,2),
	
	FOREIGN KEY(id_venta) REFERENCES ventas(id_venta)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	FOREIGN KEY(id_producto) REFERENCES productos (id_producto)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO 
	clientes (nombre, apellido_pat, apellido_mat, fecha_nacim,genero, estado_civil, telefono)
VALUES
	('Angel', 'Torres', 'Hernandez', '1994-11-20', '2', '3', '5585293776'),
	('Yorgos', 'Bushnell', 'Consterdine', '1976-12-27', '1', '1', '4206636355'),
	('Dacey', 'Peplaw', 'Rodenburg', '1994-04-21', '2', '1', '9528039548'),
	('Blanch', 'Riccetti', 'Reason', '1998-04-27', '2', '1', '1514870683'),
	('Rowena', 'Giovannacc@i', 'Jarmain', '1978-12-25', '2', '4', '8642579890'),
	('Clarence', 'Mackin', 'Battman', '1995-09-03', '1', '3', '7014533387'),
	('Giselle', 'Adnams', 'Kemsley', '1980-03-18', '2', '1', '5781052860'),
	('Perry', 'Joyce', 'Wolledge', '1973-08-30', '2', '4', '5892415596'),
	('Kingsley', 'Bentke', 'Klaffs', '1990-02-07', '2', '4', '9148979230'),
	('Sharl', 'Balbeck', 'Aubray', '1998-03-11', '2', '1', '4476464674'),
	('Royce', 'Henrych', 'Dumbar', '1979-02-19', '2', '1', '2906893515');

INSERT INTO forma_de_pago (pago) VALUES 
	("Efectivo"),
	("Tarjeta de credito"),
	("Tarjeta de Debito");

INSERT INTO categorias (categoria) VALUES
	("Audio y Video"),
	("Computo"),
	("Papeleria"),
	("Impresion"),
	("Smartphones"),
	("Entretimiento"),
	("Videojuegos");
	

INSERT INTO productos (nombre, precio,cantidad,id_categoria) VALUES
	("Microfono Sony",885.50,100,1),
	("Camara Logitech",1250.00,50,1),
	("MacBook Pro",35000.00,20,2),
	("HP Envy",20000.00,30,2),
	("Lapices Stadtler",350.50,50,3),
	("Pluma Bic Negra",7.50,200,3),
	("Pluma Bic Roja",7.50,200,3),
	("Pluma Bic Azul",7.50,200,3),
	("Hojas Blancas 100/P",95.50,50,4),
	("Multifuncional Epson",8999.90,15,4),
	("Copiadora Color/BN",2500.75,15,4),
	("Iphone 14",35000.00,25,5),
	("Pixel ONE 7",18000.00,30,5),
	("Pantalla Sony 50 plg",10000.00,25,6),
	("Teatro en casa Sony",1200.50,27,6),
	("Nintendo Switch OLED",9990.00,33,7),
	("Nintendo Switch Lite",4000.00,10,7),
	("PS5 1TB",9500.00,25,7),
	("Xbox Series X",6500.00,35,7);

INSERT INTO ventas (id_cliente,id_pago,fecha) VALUES
	(1,1,CURRENT_DATE());
INSERT INTO ventas (id_cliente,id_pago,fecha) VALUES
	(2,1,CURRENT_DATE());
INSERT INTO ventas (id_cliente,id_pago,fecha) VALUES
	(3,1,CURRENT_DATE());

-- -------------------------------------------------------------------------------

-- Stored Procedure para agregar productos al detalle venta
DELIMITER $$
CREATE PROCEDURE sp_agregar_productos(
	IN id_ven INT UNSIGNED, 
	IN id_prod INT UNSIGNED, 
	IN cantidad INT UNSIGNED
)
BEGIN
	DECLARE cantidad_disponible INT UNSIGNED;
	SET cantidad_disponible = (SELECT cantidad FROM productos WHERE id_producto = id_prod);
	
	IF cantidad_disponible < cantidad THEN
		SELECT "No hay existencia suficiente";
	ELSEIF cantidad_disponible >= cantidad THEN
		-- insertar productos al detalle venta
		INSERT INTO detalle_ventas (id_venta, id_producto, cantidad, importe)
		VALUES(id_ven, id_prod, cantidad, 0.00);
		
		-- actualizar el stock disponible
		UPDATE productos 
		SET productos.cantidad = (productos.cantidad - cantidad)
		WHERE productos.id_producto = id_prod;
	
		-- actualizar importe
		UPDATE detalle_ventas 
		SET importe = ((SELECT precio FROM productos WHERE id_producto = id_prod ) * cantidad)
		WHERE id_venta = id_ven AND id_producto = id_prod;
		
		SELECT "Productos añadidos correctamente";
	ELSE
		SELECT "No hay Stock";
	END IF;
			
END $$
DELIMITER ;

-- funcion para obtener la suma de articulos por venta
DELIMITER $$
CREATE FUNCTION sf_total_articulos(id_ven INT UNSIGNED)
RETURNS INT UNSIGNED
DETERMINISTIC
	BEGIN
		DECLARE total INT UNSIGNED;
		SET total = (SELECT SUM(cantidad) FROM detalle_ventas WHERE id_venta = id_ven);
		RETURN total;
	END $$
DELIMITER ;


-- funcion para obtener el subtotal
DELIMITER $$
CREATE FUNCTION sf_calcula_subtotal(id_ven INT UNSIGNED)
RETURNS DECIMAL(8,2)
DETERMINISTIC
	BEGIN
		DECLARE sub DECIMAL(8,2);
	
		SET sub = (SELECT SUM(importe) FROM detalle_ventas WHERE id_venta = id_ven);
	
		RETURN sub;
	END $$
DELIMITER ;

-- Funcion para calcular el total neto
DROP FUNCTION IF EXISTS sf_calcula_totalneto;
DELIMITER $$
CREATE FUNCTION sf_calcula_totalneto(id_ven INT UNSIGNED)
RETURNS DECIMAL(8,2)
DETERMINISTIC
	BEGIN	
		DECLARE total DECIMAL(8,2);
		
		SET total = (
			SELECT ( (subtotal + (subtotal * (iva/100))) - (subtotal * (descuento/100)) )
			FROM ventas WHERE id_venta = id_ven
		);
		RETURN total;
	END $$
DELIMITER ;



-- TRIGGER para actualizar la tabla ventas
DROP TRIGGER IF EXISTS tg_actualizar_venta;
DELIMITER $$
CREATE TRIGGER tg_actualizar_venta
	AFTER UPDATE ON detalle_ventas
	FOR EACH ROW 
	BEGIN 
		UPDATE ventas SET total_articulos = sf_total_articulos(NEW.id_venta) WHERE id_venta = NEW.id_venta;
		UPDATE ventas SET subtotal = sf_calcula_subtotal(NEW.id_venta) WHERE id_venta = NEW.id_venta;
		UPDATE ventas set total_neto = sf_calcula_totalneto(NEW.id_venta) WHERE id_venta = NEW.id_venta;
	END $$
DELIMITER ;



