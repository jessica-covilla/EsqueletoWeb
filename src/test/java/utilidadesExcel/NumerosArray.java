package utilidadesExcel;

import java.io.File;

import org.openqa.selenium.By;

import ClaseBase.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NumerosArray extends ClasesBase {

	
		
		public NumerosArray(AppiumDriver<MobileElement> driver){
			super ((AppiumDriver<MobileElement>) driver);
		}
		
		
		public void numeroSeparados (String numeros, By locator, File rutaCarpeta ) throws Exception
		{
			String[] num= new String[numeros.length()] ;
		
			for (int i=0; i<numeros.length();i++) {
				 	num[i]=String.valueOf(numeros.charAt(i));
				 	click(localizadorVariable(locator,num[i]),rutaCarpeta);
				}
		

			 
		}
}




