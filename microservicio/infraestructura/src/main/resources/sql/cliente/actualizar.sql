update cliente
set nombreCliente = :nombreCliente,
	tipoCliente = :tipoCliente,
	fecha_Creacion_Cliente = :fechaCreacionCliente
where idCliente = :idCliente