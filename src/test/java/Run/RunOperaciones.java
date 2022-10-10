package Run;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import org.junit.After;
import org.junit.Before;

import org.junit.Test;

//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;

import ClaseBase.ClasesBase;
import utilidadesExcel.MyScreenRecorder;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;
import PagesObjets.PagsObjetCalculadoraOperaciones;
import PagesObjets.PagsObjetCrearCuenta;
import PagesObjets.PagsObjetMercadoLibre;
import io.appium.java_client.AppiumDriver;


public class RunOperaciones 
{	
	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;
	
	PagsObjetCalculadoraOperaciones pagina;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	ClasesBase clasesBase;
	PagsObjetMercadoLibre paginas;
	PagsObjetCrearCuenta paginas1;
	
@SuppressWarnings("unchecked")	
@Before	
	
	public void setUp() throws IOException
	{
	
		// INSTANCIAR LA CLASE PROPIEDADES DE JAVA 
		propiedades = new Properties();
		
		
		//CREAR LA VARIABLE TIPO INPUTSTREAM
		InputStream entrada = null;
		
		//INSTANCIAR LAS CLASES EXCEL
		
		leer= new ReadExcelFile();
		escribir = new WriteExcelFile();
		
		//VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try 
		{
			entrada = new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		
	}


	@SuppressWarnings("unchecked")
	@Test
	public void Operaciones()throws Exception
	{
		//ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClasesBase.appiumDriverConnetion(propiedades, leer, "calculadora",1,4);
		//SE REALIZA UN CONDICIANAL
		if(leer.getCellValue(propiedades.getProperty("buscarexcel"), "calculadora", 1,3).equals("Si")) 
		{	
			
			//INSTANCIAMOS LA CLASE BASE
			clasesBase = new ClasesBase(driver);
			//ABRIR URL DE ACCESO
			pagina= new PagsObjetCalculadoraOperaciones(driver);
				
			//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();					
			//CREAR CARPETA PARA ALMECENAMIENTO DE IMAGENE
			File rutaCarpeta = clasesBase.crearCarpeta(propiedades,nomTest);
			//INICIA GRABACION DE VIDEO
			MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
			//ACCEDER A LA CALCULADORA
			pagina.Operaciones(leer, propiedades, rutaCarpeta, nomTest);
			//FINALIZA GRABACIÓN DE VIDEO
			MyScreenRecorder.stopRecording();
		
		}else {
		
			System.out.println("La automatización no se ejecutara");
		}

	}
	

	@SuppressWarnings("unchecked")
	@Test		
	public void Google()throws Exception
	{
		//ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClasesBase.appiumDriverConnetion(propiedades, leer, "mercadolibre",1,1);
		//SE REALIZA UN CONDICIANAL
		if(leer.getCellValue(propiedades.getProperty("buscarexcel"), "mercadolibre",1,0).equals("Si")) {
			
		//ABRIR URL DE ACCESO 
		paginas= new PagsObjetMercadoLibre(driver);
		paginas1= new PagsObjetCrearCuenta(driver);
		//INSTANCIAMOS LA CLASE BASE
		clasesBase = new ClasesBase(driver);
				
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();					
		//CREAR CARPETA PARA ALMECENAMIENTO DE IMAGENE
		File rutaCarpeta = clasesBase.crearCarpeta(propiedades,nomTest);
		//INICIA GRABACION DE VIDEO
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		//ACCEDE A LA PAGINA DEL NAVEGADOR 
		paginas.PaginaGoogle(leer, propiedades, rutaCarpeta, nomTest);
		//ACCEDE A LA PAGINA DE MERCADO LIBRE EN CRAE CUENTA
		paginas1.CrearCuenta(leer, propiedades, rutaCarpeta, nomTest);
		//FINALIZA GRABACIÓN DE VIDEO
		MyScreenRecorder.stopRecording();
				
		}else {
			//ENVIAS UN MENSAJE EN CONSOLA 
			System.out.println("La automatización no se ejecutara");
		}
  }
		
	
	
	@After
	public void cerrar()
	{
	// CERRAR PROCESO
	 driver.quit();
	}
	
	
}
