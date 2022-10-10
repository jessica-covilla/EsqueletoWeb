package MapsObjet;


import org.openqa.selenium.By;


import ClaseBase.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class MapsObjetCalculadoraOperaciones extends ClasesBase
{
	
	//CONSTRUCTOR DE LA CLASE
	
	public MapsObjetCalculadoraOperaciones(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}	
	

	//ELEMENTOS DE LA CALCULADORA
	protected By btnNumero= By.xpath("//android.widget.TextView[@text='{0}']");
	protected By btnSuma= By.xpath("//android.widget.ImageView[@content-desc=\"{0}\"]");
	protected By btnIgual= By.id("com.miui.calculator:id/btn_equal_s");
	
	
	
	
	

}
