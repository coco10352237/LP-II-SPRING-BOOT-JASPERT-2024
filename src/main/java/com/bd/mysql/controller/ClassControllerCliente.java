package com.bd.mysql.controller;

import com.bd.mysql.modelo.ClassCliente;
import com.bd.mysql.reportes.IReporteCliente;
import com.bd.mysql.servicio.IClienteServicio;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/vistas")
public class ClassControllerCliente {
	
	@Autowired
	private IClienteServicio iclienteservicio;
	@Autowired
	private IReporteCliente ireportecliente;
	//creamos el metodo listado
	@GetMapping("/ListadoCliente")
	public String ListadoCliente(Model modelo) {
		//recuperamos el listado  de clientes...
		List<ClassCliente>  listado=iclienteservicio.ListadoClientes();
		//para hacer un pequeño testeo
		for(ClassCliente lis:listado) {
			
			System.out.println("codigo "+lis.getIdcliente()+
					" nombre "+lis.getNombre()+
					" apellido "+lis.getApellido()+
					" dni "+lis.getDni()+" email "+lis.getEmail()+
					" telf "+lis.getTelf()+" sexo "+lis.getSexo()+
					" nacio "+lis.getNacionalidad());
		}//fin de bucle
		
		//enviamos la data hacia la vista
		modelo.addAttribute("listado",listado);
		//retornamos
		return "/Vistas/ListadoCliente";
		
	}  //fin del metodo listado
	
	//creamos el metodo registrar
	@GetMapping("/RegistrarCliente")
	public String RegistrarCliente(Model modelo) {
		//realizamos la respectiva instancia de clase..
		ClassCliente cliente=new ClassCliente();
		//enviamos a la vista
		modelo.addAttribute("regiscliente",cliente);
		//retornamos
		return "/Vistas/FrmCrearCliente";
	}  //fin del metodo registrar cliente...
	

		
	//realizamos el mapeo con postmapping(guardar los datos)
	@PostMapping("/GuardarCliente")
	public String GuardarCliente(@ModelAttribute ClassCliente cliente,Model modelo) {
		iclienteservicio.RegistrarCliente(cliente);
		//emitimos un mensaje por consola
		System.out.println("dato registrado en la bd");
		//redireccionamos
	  return "redirect:/vistas/ListadoCliente";	
	}  //fin del metodo guardaauto...
	
	
	
	@GetMapping("/editar/{id}")
	public String Editar(@PathVariable("id") Integer idcliente,Model modelo) {
		ClassCliente cliente=iclienteservicio.BuscarCliente(idcliente);
		//enviamos hacia la vista...
		modelo.addAttribute("regiscliente",cliente);
		//retornamos el frmcrearcliente...
		return "/Vistas/FrmCrearCliente";	
	}  //fin del metodo editar...
	
   //realizamos el metodo eliminar..
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer idcliente,Model modelo) {
		
		//aplicamos la inyeccion de dependencia
		iclienteservicio.EliminarCliente(idcliente);
		//actualizar por el listado
		List<ClassCliente> listado=iclienteservicio.ListadoClientes();
		//enviamos
		modelo.addAttribute("listado",listado);
		//redireccionamos
		return "redirect:/vistas/ListadoCliente";
		
	}  //fin del metodo eliminar...
	
    @GetMapping("/reportes")	
	public void createPdf(HttpServletResponse response) throws JRException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateforma=new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		String currenDateTime=dateforma.format(new Date());
		String headerKey="Content-Disposition";
		String headerValue="attachment;filename=pdf_"+currenDateTime+".pdf";
		response.setHeader(headerKey,headerValue);
	    ireportecliente.exportJapertReport(response);	
	}   //fin del metodo create pdf....
	 
	

}  //fin de la clase controller cliente...
