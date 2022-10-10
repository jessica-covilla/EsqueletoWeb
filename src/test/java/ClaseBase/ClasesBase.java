package ClaseBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilidadesExcel.ReadExcelFile;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;







public class ClasesBase 
{
	
	protected AppiumDriver<MobileElement> driver;
	
	// CONSTRUCTOR DE CLASE
	public ClasesBase(AppiumDriver<MobileElement> driver)
	{
		super();
	}
	
	//METODO CONEXION PAGINA WEB EN CROMEDRIVER
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnetion(Properties propiedades, ReadExcelFile leer, String  hoja, int fila, int columna )
	{
		AppiumDriver driver = null;
		try {
			
			//CREAR LAS CAPA BILITIES DEL MOVIL
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName",propiedades.getProperty("platformName"));
			caps.setCapability("deviceName",propiedades.getProperty("deviceName"));
			caps.setCapability("platformVersion",propiedades.getProperty("platformVersion"));
			caps.setCapability("appPackage",leer.getCellValue(propiedades.getProperty("buscarexcel"),""+hoja+"", fila,columna));
			caps.setCapability("appActivity",leer.getCellValue(propiedades.getProperty("buscarexcel"),""+hoja+"", fila,columna+1));
			caps.setCapability("noReset",propiedades.getProperty("noReset"));
			caps.setCapability("autoGrantPermissions",propiedades.getProperty("autoGrantPermissions"));
		
			//INSTANCIAR APPIUM DRIVER
			try {
				printConsola("Cargado Cability de appium, por favor espere...");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps); 
				
			} catch (MalformedURLException e) {
				printConsola(e.getMessage());
			}
			return driver;
			
		} catch (Exception e) {
			printConsola(e.getMessage());
		}
		return driver;
		
	}
	
	public void enter(File rutaCarpeta)throws Exception
    {
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
     //   tiempoEspera(2000);
        captureScreen(rutaCarpeta);
    }
		
	    public By localizadorVariable(By locator, String valor)
	    {
	    	String jj = locator.toString().replace("{0}",valor);
	    	String kk = jj.replace("By.xpath:", "");
	    	By localizador=By.xpath(kk);
			return localizador;
	    	
	    }

	    public void tocarPantalla(int x, int y)
	    {
	        @SuppressWarnings("rawtypes")
	        TouchAction touch = new TouchAction(driver);
	        touch.press(PointOption.point(x,y)).release().perform();
	        
	    }

		private static void printConsola(String texto) {
			System.out.println(texto);
		
	}
		
		public void numeroSeparados (String numeros, By locator, File rutaCarpeta ) throws Exception
		{
			String[] num= new String[numeros.length()] ;
		
			for (int i=0; i<numeros.length();i++) {
				 	num[i]=String.valueOf(numeros.charAt(i));
				 	click(localizadorVariable(locator,num[i]),rutaCarpeta);
				}		 
		}
		
		
		 public void scrollVertical(File rutaFile, int xini,int yini, int yfinal, int iteraciones) throws Exception
		    {
		        
		        for (int i = 1 ;i<=iteraciones;i++)
		        {
		            @SuppressWarnings("rawtypes")
		            TouchAction touch = new TouchAction(driver);
		            touch.press(PointOption.point(xini,yini))
		            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		            .moveTo(PointOption.point(xini,yfinal))
		            .release().perform();
		            captureScreen(rutaFile);
		        }
		    }

		//METODO CLICK
		public void click(By locator, File rutaCarpeta) throws Exception
		{
			try {
			
			driver.findElement(locator).click();
			captureScreen(rutaCarpeta);
			
			
			} catch (Exception e) {
				System.out.println("hola" +e);
			}
			
			
		}
		//METODO BORRAR
		public void borrar(By locator, File rutaCarpeta) throws Exception
		{
			captureScreen(rutaCarpeta);
			driver.findElement(locator).clear();
			//tiempoEspera(2000);
			
		}
		
		//METODO ENVIO
		public void submit(By locator, File rutaCarpeta) throws Exception
		{
			
			driver.findElement(locator).submit();
			captureScreen(rutaCarpeta);
		//	tiempoEspera(2000);
			
		}
		
		//METODO ENVIAR TEXTO
		public void sendkey(String inputText, By locator, File rutaCarpeta) throws Exception
		{
			
			driver.findElement(locator).sendKeys(inputText);
			captureScreen(rutaCarpeta);
			//tiempoEspera(2000);
			
		}
		
		//METODO ESPERA DE TIEMPO
		public void tiempoEspera(long tiempo) throws InterruptedException
		{
			Thread.sleep(tiempo);
		}
		
		//METODO PARA REALIZAR UN SCROLL
		public void scroll(int y)
		{
			//ENVIO DE LOS VALORES DE BUSQUEDA EN EL NAVEGADOR 
			JavascriptExecutor js = (JavascriptExecutor) driver;
	    	// This  will scroll down the page by  1000 pixel vertical        
			js.executeScript("window.scrollBy(0,"+y+")");
		}
		
		public void captureScreen(File rutaCarpeta) throws Exception
		{
			//
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			
		}
		
		public File crearCarpeta(Properties propiedades, String nomTest)
		{
			//LA FECHA DEL SISTEMA
			String fecha = fechaHora();
			//CREAMOS EL NOMBRE DE LA CARPETA
			String nomCarpeta = nomTest+"-"+fecha;
			//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
			File directorio = new File("./output/"+nomCarpeta);
			//CREAMOS LA CARPETA
			directorio.mkdir();
			return directorio;
			
		}
		
		public String fechaHora()
		{
			//TOMAMOS LA FECHA DEL SISTEMA
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
		
		public String HoraSistema()
		{
			//TOMAMOS LA FECHA DEL SISTEMA
			LocalTime horaSistema = LocalTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha =DateTimeFormatter.ofPattern("HHmmss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String hora = fecha.format(horaSistema);
			return hora;
		}
		
		
}


