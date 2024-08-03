package com.bd.mysql.servicio;

import java.util.List;

import com.bd.mysql.modelo.ClassCliente;

public interface IClienteServicio {
	//declaramos los metodos
	public List<ClassCliente> ListadoClientes();
	public void RegistrarCliente(ClassCliente clien);
	public ClassCliente BuscarCliente(Integer id);
	public void EliminarCliente(Integer id);

}  //fin de la interface...
