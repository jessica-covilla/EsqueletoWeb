package PagesObjets;

import java.io.File;
import java.io.IOException;
import java.util.Properties;



import MapsObjet.MapsObjetCalculadoraOperaciones;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetCalculadoraOperaciones extends MapsObjetCalculadoraOperaciones
{

	//CREAR EL CONSTRUCTOR DE LA CLASE
	public PagsObjetCalculadoraOperaciones(AppiumDriver<MobileElement> driver)
	{
		super (driver);
		this.driver =(AppiumDriver<MobileElement>) driver;
	}

	





	public void Operaciones(ReadExcelFile leer, Properties propiedades, File rutaCarpeta, String nomTest) throws IOException, Exception {
		//CLIC AL PRIMER NUMERO
		numeroSeparados(leer.getCellValue(propiedades.getProperty("buscarexcel"),"calculadora", 1, 1),btnNumero,rutaCarpeta);
		
		// CLICK EN EL OPERADOR SELECCIONADO
		click(localizadorVariable(btnSuma,leer.getCellValue(propiedades.getProperty("buscarexcel"),"calculadora", 1, 0)),rutaCarpeta);
		//CLIC AL SEGUNDO NUMERO
		numeroSeparados(leer.getCellValue(propiedades.getProperty("buscarexcel"),"calculadora", 1, 2),btnNumero,rutaCarpeta);
		//CLIC EN EL SIGNO IGUAL
		click(btnIgual,rutaCarpeta);
		
	}







	
	
	
	
	
 	

		
	
		
	

		


}
