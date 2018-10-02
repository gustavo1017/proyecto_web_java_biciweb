
/* Procedimientos CRUD Estacionamiento */
CREATE PROCEDURE sp_insertar_estacionamiento
     (in nombre_esta VARCHAR(30), in direccion_esta VARCHAR(30),id_encar INT )
     insert into estacionamiento (nombre_estacionamiento,direccion_estacionamiento,id_encargado) values(nombre_esta,nombre_esta,id_encar);

-- eliminacion en estacionamiento
CREATE PROCEDURE sp_eliminar_estacionamiento(in id_esta int)
     delete from estacionamiento where id_estacionamiento=id_esta;

-- actualizacion en estacionamiento
CREATE PROCEDURE sp_actualizar_estacionamiento
     (in id_esta INT,in nombre_esta VARCHAR(30), in direccion_esta VARCHAR(30),id_encar INT )
     update estacionamiento set nombre_estacionamiento=nombre_esta, direccion_estacionamiento=direccion_esta,id_encargado=id_encar  where id_estacionamiento=id_esta;

--listar estacionamiento
CREATE PROCEDURE sp_listar_estacionamiento()
     select * from estacionamiento;

--buscar estacionamiento
CREATE PROCEDURE sp_buscar_estacionamiento(in id_esta INT)
     select * from tarjeta where id_tarjeta=id_esta;

/* Procedimientos CRUD Tarjeta */
CREATE PROCEDURE sp_insertar_tarjeta
     (in numero_tar VARCHAR(30), in nombre_tar VARCHAR(30),in tipo_tar VARCHAR(30),in fecha_venci VARCHAR(30) )
     insert into tarjeta ( numero_tarjeta ,nombre_tarjeta,tipo_tarjeta,fecha_vencimiento) values(numero_tar,nombre_tar,tipo_tar,fecha_venci);

-- eliminacion en tarjeta
CREATE PROCEDURE sp_eliminar_tarjeta(in id_tarje INT)
     delete from tarjeta where id_tarjeta=id_tarje;

-- actualizacion en TARJETA
CREATE PROCEDURE sp_actualizar_tarjeta
     (in id_tarje INT,in numero_tar VARCHAR(30), in nombre_tar VARCHAR(30),in tipo_tar VARCHAR(30),in fecha_venci VARCHAR(30) )
     update tarjeta set numero_tarjeta=numero_tar, nombre_tarjeta=nombre_tar,tipo_tarjeta=tipo_tar, fecha_vencimiento=fecha_venci  where id_tarjeta=id_tarje;

--listar TARJETA
CREATE PROCEDURE sp_listar_tarjeta()
     select * from tarjeta;

--buscar tb_distrito
CREATE PROCEDURE sp_buscar_tarjeta(in id_tarje INT)
     select * from tarjeta where id_tarjeta=id_tarje;

/* Procedimientos CRUD ENCARGADO */
CREATE PROCEDURE sp_insertar_encargado
     (in nombre_encar VARCHAR(30), in apellido_encar VARCHAR(30),in telefono_encar VARCHAR(10),in direccion_encar VARCHAR(25) )
     insert into encargado ( nombre_encargado ,apellido_encargado,telefono_encargado,direccion_encargado) values(nombre_encar,apellido_encar,telefono_encar,direccion_encar);

-- eliminacion en tarjeta
CREATE PROCEDURE sp_eliminar_encargado(in id_encar INT)
     delete from encargado where id_encargado=id_encar;

-- actualizacion en TARJETA
CREATE PROCEDURE sp_actualizar_encargado
     (in id_encar INT,in nombre_encar VARCHAR(30), in apellido_encar VARCHAR(30),in telefono_encar VARCHAR(10),in direccion_encar VARCHAR(25) )
     update encargado set nombre_encargado=nombre_encar, apellido_encargado=apellido_encar,telefono_encargado=telefono_encar ,direccion_encargado=direccion_encar where id_encargado=id_encar;

--listar TARJETA
CREATE PROCEDURE sp_listar_encargado()
     select * from encargado;

--buscar tb_distrito
CREATE PROCEDURE sp_buscar_encargado(in id_encar INT)
     select * from encargado where id_tarjeta=id_encar;



/* Procedimientos CRUD CLIENTE */
CREATE PROCEDURE sp_insertar_cliente
     (in nombre_cli VARCHAR(30), in apellido_cli VARCHAR(30),in dni_cli VARCHAR(10),in nombre_usu VARCHAR(30),in clave_usu VARCHAR(30),in id_tarje INT )
     insert into cliente ( nombre_cliente ,apellido_cliente,dni_cliente,nombre_usuario,clave_usuario,id_tarjeta) values(nombre_cli,apellido_cli,dni_cli,nombre_usu,clave_usu,id_tarje);

-- eliminacion en tarjeta
CREATE PROCEDURE sp_eliminar_cliente(in id_cli INT)
     delete from cliente where id_cliente=id_cli;

-- actualizacion en TARJETA
CREATE PROCEDURE sp_actualizar_cliente
     (in id_cli INT,in nombre_cli VARCHAR(30), in apellido_cli VARCHAR(30),in dni_cli VARCHAR(10),in nombre_usu VARCHAR(30),in clave_usu VARCHAR(30),in id_tarje INT  )
     update cliente set nombre_cliente=nombre_cli, apellido_cliente=apellido_cli,dni_cliente=dni_cli, nombre_usuario=nombre_usu,clave_usuario=clave_usu,id_tarjeta=id_tarje  where id_cliente=id_cli;

--listar TARJETA
CREATE PROCEDURE sp_listar_cliente()
     select * from cliente;

--buscar tb_distrito
CREATE PROCEDURE sp_buscar_cliente(in id_cli INT)
     select * from cliente where id_cliente=id_cli;


/* Procedimientos CRUD BICICLETA */
CREATE PROCEDURE sp_insertar_bicicleta
     (in estado_bici VARCHAR(30),in id_esta INT )
     insert into bicicleta ( estado_bicicleta,id_estacionamiento) values(estado_bici,id_esta);

-- eliminacion en tarjeta
CREATE PROCEDURE sp_eliminar_bicicleta(in id_bici INT)
     delete from bicicleta where id_bicicleta=id_bici;

-- actualizacion en TARJETA
CREATE PROCEDURE sp_actualizar_bicicleta
     (in id_bici INT,in estado_bici VARCHAR(30),in id_esta INT  )
     update bicicleta set estado_bicicleta=estado_bici, id_estacionamiento=id_esta  where id_bicicleta=id_bici;

--listar TARJETA
CREATE PROCEDURE sp_listar_bicicleta()
     select * from bicicleta;

--buscar tb_distrito
CREATE PROCEDURE sp_buscar_bicicleta(in id_bici INT)
     select * from bicicleta where id_bicicleta=id_bici;

/* Procedimientos CRUD Alquilet */
CREATE PROCEDURE sp_insertar_alquiler
     (in id_cli INT,in id_bici INT,in fecha_alqui VARCHAR(30),in precio_alqui decimal(5,2) )
     insert into alquiler  values(id_cli,id_bici,fecha_alqui,precio_alqui);



--listar TARJETA
CREATE PROCEDURE sp_listar_alquiler()
     select * from alquiler;

--buscar tb_distrito
CREATE PROCEDURE sp_buscar_alquiler(in id_cli INT,in id_bici INT)
     select * from alquiler where id_cliente=id_cli and  id_bicicleta=id_bici ;


/* LOGIN */
CREATE PROCEDURE sp_validar_cliente (in usu VARCHAR(30),in pas VARCHAR(30))
     select * from cliente where nombre_usuario=usu and clave_usuario=pas;

