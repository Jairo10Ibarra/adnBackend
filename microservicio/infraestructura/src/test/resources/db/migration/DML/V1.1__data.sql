insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());

insert into cliente(idCliente,nombreCliente,tipoCliente,fecha_creacion) values (10, 'jairo', 10, now());

insert into compra(idCompra, precio,idCliente,fecha_creacion) values(1,20000,10,now());