package com.bd.mysql.reportes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.bd.mysql.modelo.ClassCliente;
import com.bd.mysql.repositorio.ICliente;
import com.bd.mysql.servicio.IClienteServicio;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.*;

@Service
public class ClassClienteReportesServicios implements IReporteCliente{

	//aplicamos la inyeccion de dependencia
		@Autowired
		//private IClienteServicio iclienteservicio;
		private ICliente iclienterepository;
		//creamos un metodo para reportes
	/*	public void exportJapertReport(HttpServletResponse response) throws JRException, IOException {
		List<ClassCliente> listar=(List<ClassCliente>) iclienterepository.findAll();
		File file=ResourceUtils.getFile("classpath:/Reportes/ReportesClientes.jrxml");
		JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource datasource=new JRBeanCollectionDataSource(listar);
		Map<String,Object> parametros=new HashMap();
		parametros.put("createBy","Simplifying Tech");
		JasperPrint jasperprint=JasperFillManager.fillReport(jasperReport, parametros,datasource);
		JasperExportManager.exportReportToPdfStream(jasperprint,response.getOutputStream());
		
		}  /
		/fin del metodo
*/

		@Override
		public void exportJapertReport(HttpServletResponse response) throws JRException,IOException{
			List<ClassCliente> listar=(List<ClassCliente>) iclienterepository.findAll();
			File file=ResourceUtils.getFile("classpath:Reportes/ReportesClientes.jrxml");
			JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource datasource=new JRBeanCollectionDataSource(listar);
			//para ingresar parametros..desde una bd ,etc.
			Map<String,Object> parametros=new HashMap();
			parametros.put("createBy","Simplifying Tech");
			JasperPrint jasperprint=JasperFillManager.fillReport(jasperReport,parametros,datasource);
		    //JasperExportManager.exportReportToPdfStream(jasperprint,response.getOutputStream());
			
			//*******Para visualizar el pdf directamente desde java
		    String titleTransactionBy = "Reportes de Clientes";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		    var dateTimeNow = LocalDateTime.now().format(formatter);
			var fileName = titleTransactionBy.replace(" ", "") + dateTimeNow;
			  JRPdfExporter exporter = new JRPdfExporter();
		      exporter.setExporterInput(new SimpleExporterInput(jasperprint));
		      exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
		      response.setContentType("application/pdf");
		      response.setHeader(
		      HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".pdf;");
		      exporter.exportReport();
			
			
			
			
			// JasperViewer.viewReport(jasperprint,false);
	        //if (!GraphicsEnvironment.isHeadless()) {
		    // JasperViewer viewer = new JasperViewer(jasperprint,false);
		     //viewer.setTitle("REPORTE DE CLIENTES");
		     //viewer.setVisible(true);
	        	 //Para visualizar el pdf directamente desde java
			    //JasperViewer.viewReport(jasperprint,false);
	        //}

			
		}

		
	
	
}  //fin de la clase.....
