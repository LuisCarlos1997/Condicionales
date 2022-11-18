package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import java.awt.*;

public class CondicionalUserinterface {

    public static final Target BTN_GENERATE_COLOR = Target.the("Dar clic en el boton generar color")
            .locatedBy("//*[text()='Generate Color']");


    public static final Target TXT_COLOR = Target.the("si el texto sale el color amarillo")
            .locatedBy("//*[@class='color']");


    public static final Target BTN_AMARILLO = Target.the("Dar clic en el boton generar color")
            .locatedBy("//button[text()='yellow']");


    public static final Target BTN_AZUL = Target.the("Dar clic en el boton generar color")
            .locatedBy("//button[text()='blue']");


    public static final Target TXT_ASERCION = Target.the("asercion")
            .locatedBy("//*[text()='Success!']");
}



