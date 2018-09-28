CREATE TABLE CLIENTE(
	id_cliente int not null AUTO_INCREMENT,
	nombre_cliente varchar(30) not null,
	apellido_cliente varchar(30) not null,
	dni_cliente varchar(10) not null,
        nombre_usuario varchar(30) not null,
	clave_usuario varchar(30) not null,
	id_tarjeta int not null,
	primary key(id_cliente)
)

CREATE TABLE TARJETA(
	id_tarjeta int not null AUTO_INCREMENT,
	numero_tarjeta varchar(30) not null,
	nombre_tarjeta varchar(30) not null,
	tipo_tarjeta varchar(10) not null,
	fecha_vencimiento datetime not null,
	primary key(id_tarjeta)
)
CREATE TABLE ALQUILER(
	id_cliente int not null,
	id_bicicleta int not null,
	fecha_alquiler datetime not null,
	precio_alquiler decimal(5,2) not null,
	primary key(id_cliente,id_bicicleta)
)
CREATE TABLE BICICLETA(
	id_bicicleta int not null AUTO_INCREMENT,
	estado_bicicleta varchar(30) not null,
	id_estacionamiento int not null,	
	primary key(id_bicicleta)
)
CREATE TABLE ESTACIONAMIENTO(
	id_estacionamiento int not null AUTO_INCREMENT,
	nombre_estacionamiento varchar(30)  null,
	direccion_estacionamiento varchar(30) not null,
	id_encargado int not null,
	primary key(id_estacionamiento)
)
CREATE TABLE ENCARGADO(
	id_encargado int not null AUTO_INCREMENT,
	nombre_encargado varchar(30) not null,
	apellido_encargado varchar(30) not null,
	telefono_encargado varchar(10) not null,
	direccion_encargado varchar(25) null,
	primary key(id_encargado)
)

alter table CLIENTE add foreign key(id_cliente) references TARJETA(id_tarjeta);


alter table ALQUILER add foreign key(id_cliente) references CLIENTE(id_cliente);
alter table ALQUILER add foreign key(id_bicicleta) references BICICLETA(id_bicicleta);

alter table BICICLETA add foreign key(id_estacionamiento) references ESTACIONAMIENTO(id_estacionamiento);
alter table ESTACIONAMIENTO add foreign key(id_encargado) references ENCARGADO(id_encargado);




