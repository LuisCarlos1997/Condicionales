package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DogOrCatUserInterface {

    public static final Target BTN_GENERATE = Target.the("Dar clic en el boton generar imagen")
            .locatedBy("//*[text()='Generate Image']");

    public static final Target IMG_CAT = Target.the("imagen del gato")
            .locatedBy("//*[contains(@src,'/static/media/cat.e29f2ed2.jpg')]");

    public static final Target BTN_CAT = Target.the("Dar clic en el boton gato")
            .locatedBy("//*[text()='cat']");

    public static final Target BTN_DOG = Target.the("Dar clic en el boton gato")
            .locatedBy("//*[text()='dog']");

    public static final Target TXT_ASERCION = Target.the("asercion")
            .locatedBy("//*[text()='Success!']");

}