insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());

insert into cliente(id,nombreCliente,tipoCliente,fecha_creacion) values (1, 'test', 10, now());

insert into compra(idCompra, precio,idCliente,fecha_creacion) values(2,20000,1,now());