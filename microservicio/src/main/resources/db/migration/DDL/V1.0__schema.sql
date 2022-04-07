
create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table cliente(
id int(11) not null auto_increment,
nombreCliente varchar(100) not null,
tipoCliente int(2) not null,
fecha_creacion datetime null,
primary key (id)
);

create table compra (
 idCompra int(11) not null auto_increment,
 precio varchar(100) not null,
 idCliente int(11) not null,
 fecha_creacion datetime null,
 foreign key(idCliente) references cliente(id),
 primary key (idCompra)
);


