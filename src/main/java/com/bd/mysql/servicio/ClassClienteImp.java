package com.bd.mysql.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.mysql.modelo.ClassCliente;
import com.bd.mysql.repositorio.ICliente;

@Service
public class ClassClienteImp implements IClienteServicio {
	//implementamos la inyeccion de dependencia..
	@Autowired
	private ICliente iclienterepository;

	@Override
	public List<ClassCliente> ListadoClientes() {
		//retornamos el listados de clientes...
		return (List<ClassCliente>) iclienterepository.findAll();
	}  //fin del metodo listadol...

	@Override
	public void RegistrarCliente(ClassCliente clien) {
		//registramos datos cliente a la base de datos..
		iclienterepository.save(clien);	
	}  //fin del metodo registrar cliente...

	@Override
	public ClassCliente BuscarCliente(Integer id) {
		//buscar cliente por codigo
		return iclienterepository.findById(id).orElse(null);
	}  //fin del metodo buscarcliente...

	@Override
	public void EliminarCliente(Integer id) {
		//eliminamos registro por id
		iclienterepository.deleteById(id);
		
	}  //fin del metodo eliminar cliente...

}  //fin de la clase imp...
