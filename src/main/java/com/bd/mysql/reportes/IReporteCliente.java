package com.bd.mysql.reportes;

import java.io.FileNotFoundException;
import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

public interface IReporteCliente {

	void exportJapertReport(HttpServletResponse response) throws JRException, IOException;
	
}  //fin de la interface...
