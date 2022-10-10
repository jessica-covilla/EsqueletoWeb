package PagesObjets;

import java.io.File;
import java.util.Properties;

import MapsObjet.MapsObjetCrearCuenta;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetCrearCuenta extends MapsObjetCrearCuenta{
	
	public PagsObjetCrearCuenta (AppiumDriver<MobileElement> driver) {
		super (driver);
		this.driver = driver;
	}

	public void CrearCuenta(ReadExcelFile leer, Properties propiedades, File rutaCarpeta, String nomTest) throws Exception {
		
		//CLIC EN EL BOTON DE CRAR CUENTE
		click(btnCuenta,rutaCarpeta);
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		//ACTIVAR EL CHECK 
		click(btnCheck,rutaCarpeta);
		//CLIC EN EL BOTON CONTINUAR
		click(btnContinuar,rutaCarpeta);
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		//CLIC EN EL BOTON DE VALIDAR 
		click(btnValidar,rutaCarpeta);
		// CLIC EN EL CAMPO DONDE SE INGRESA EL CORREO
		click(txtCorreo,rutaCarpeta);
		//SE ESCRIBE EL CORREO 
		sendkey(leer.getCellValue(propiedades.getProperty("buscarexcel"),"mercadolibre",1,6),txtCorreo,rutaCarpeta);
		
	}

}
