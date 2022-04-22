
create table cliente(
id int(11) not null auto_increment,
nombreCliente varchar(100) not null,
tipoCliente int(2) not null,
fecha_creacion datetime null,
primary key (id)
);

create table compra (
 id int(11) not null auto_increment,
 precio varchar(100) not null,
 idCliente int(11) not null,
 fecha_creacion datetime null,
 foreign key(idCliente) references cliente(id),
 primary key (id)
);


