package MapsObjet;

import org.openqa.selenium.By;

import ClaseBase.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjetCrearCuenta extends ClasesBase {

	public MapsObjetCrearCuenta(AppiumDriver<MobileElement> driver) {
		super (driver);
	}
	
	//ELEMENTOS DE LA PAGINA DE MERCADO LIBRE DE CREAR CUENTA
	protected By btnCuenta= By.xpath("//android.widget.TextView[@text='Crear cuenta']");
	protected By btnCheck= By.xpath("//android.widget.CheckBox[@resource-id='terms-and-conds']");
	protected By btnContinuar= By.xpath("//android.widget.TextView[@text='Continuar']");
	protected By btnValidar= By.xpath("//android.view.View/android.widget.Button[@text='Validar']");
	protected By txtCorreo= By.xpath("//android.widget.EditText[@text='']");
}
