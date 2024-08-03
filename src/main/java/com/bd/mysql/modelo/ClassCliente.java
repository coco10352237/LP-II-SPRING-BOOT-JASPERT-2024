package com.bd.mysql.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="tbl_cliente")
public class ClassCliente {
	//declaramos sus atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcliente;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String telf;
	private String sexo;
	private String nacionalidad;
	
	
	//constructores..
	public ClassCliente() {
			
	}  //fin del constructor vacio..
	
	
	public ClassCliente(int idcliente, String nombre, String apellido, String dni, String email, String telf,
			String sexo, String nacionalidad) {
		//super();
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.telf = telf;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
	}


	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	
	
	/*
	@Override
	public String toString() {
		return "ClassCliente [idcliente=" + idcliente + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo="
				+ sexo + ", dni=" + dni + ", email=" + email + ", nacionalidad=" + nacionalidad + "]";
	}*/
	

	@Override
	public String toString() {
		return "ClassCliente [idcliente=" + idcliente + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", email=" + email + ", telf=" + telf + ", sexo=" + sexo + ", nacionalidad=" + nacionalidad + "]";
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}
	
	
	
	

}   //fin de la clase cliente...
