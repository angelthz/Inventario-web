-- Alura database
DROP DATABASE IF EXISTS inventario_alura;
CREATE DATABASE inventario_alura;
USE inventario_alura;

CREATE TABLE categorias(
	pk_categoria INT UNSIGNED AUTO_INCREMENT,
	nombre VARCHAR(30),
	PRIMARY KEY(pk_categoria)
)Engine=InnoDB DEFAULT CHARSET = utf8mb4;

CREATE TABLE productos( 
	pk_producto INT UNSIGNED AUTO_INCREMENT,
	fk_categoria INT UNSIGNED,
	nombre VARCHAR(30),
	precio DECIMAL(8,2),
	cantidad INT UNSIGNED,
	PRIMARY KEY(pk_producto),
	FOREIGN KEY(fk_categoria) REFERENCES categorias(pk_categoria)
		ON UPDATE CASCADE
		ON DELETE RESTRICT
)Engine=InnoDB DEFAULT CHARSET = utf8mb4;

-- tabla de usuarios para acceso a la db
CREATE TABLE usuarios(
	id_usuario INT NOT NULL AUTO_INCREMENT,
	usuario VARCHAR(15) NOT NULL UNIQUE,
	pass VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_usuario)
)Engine=InnoDB DEFAULT CHARSET = utf8mb4;


-- INSERT CATEGORIAS

INSERT INTO categorias (nombre) VALUES
	("Audio y Video"),
	("Computo"),
	("Papeleria"),
	("Impresion"),
	("Smartphones"),
	("Entretimiento"),
	("Videojuegos");
	
insert into categorias (nombre) values("Arte y diseño");
-- INSERRT productos

INSERT INTO productos (nombre, precio,cantidad,fk_categoria) VALUES
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


-- INSERT usuarioos

INSERT INTO usuarios (usuario, pass) VALUES 
("angelthz","123456789"),
("ana","2011"),
("juan","1234");


-- some selects
