package PagesObjets;

import java.io.File;
import java.util.Properties;

import MapsObjet.MapsObjeMercadoLibre;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetMercadoLibre extends MapsObjeMercadoLibre{
	
	
	
	public PagsObjetMercadoLibre(AppiumDriver<MobileElement> driver) {
		super (driver);
		this.driver = driver;
	}

	public void PaginaGoogle(ReadExcelFile leer, Properties propiedades, File rutaCarpeta, String nomTest) throws Exception {
		
		
			//CLIC EN BUSQUEDA DEL NAVEGADOR
			click(txtBuscar,rutaCarpeta);
			//ESCRIBE LA PAGINA DE MERCADO LIBRE DE MEXICO 
			sendkey(leer.getCellValue(propiedades.getProperty("buscarexcel"),"mercadolibre",1,3),txtBuscar,rutaCarpeta);
			tocarPantalla(997,2123);
			// CLIC EN EL PRIMER PRODUCTO SELECCIONADO
			click(txtProducto,rutaCarpeta);
			//TIEMPO DE ESPERA 
			tiempoEspera(2000);
			//ESCRIBE EL NOMBRE DEL PRODUCTO
			sendkey(leer.getCellValue(propiedades.getProperty("buscarexcel"),"mercadolibre",1,4),txtProducto,rutaCarpeta);
			//CLIC EN LA BUSCAR EL PRODUCTO
			click(btnLupa,rutaCarpeta);
			//TIEMPO DE ESPERA
			tiempoEspera(2000);
			//CLIC EN SELECCIONAR EL PRIMER PRODUCTO DE LA LISTA
			click(btnSeleccionar,rutaCarpeta);
			//TIEMPO DE ESPERA
			tiempoEspera(2000);
			//BAJAR LA PANTALLA PARA QUE SE VISUALICE EL BOTON DEL CARRITO
			scrollVertical(rutaCarpeta,602,1923,602,1);
			//CLIC EN EL BOTON DEL CARRITO
			click(btnCarrito,rutaCarpeta);
			//TIEMPO DE ESPERA
			tiempoEspera(2000);
		
	}
		

}
