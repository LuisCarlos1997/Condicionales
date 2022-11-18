package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.CondicionalUserinterface;

public class CondicionalQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(CondicionalUserinterface.TXT_ASERCION).answeredBy(actor).toString();
    }
    public static CondicionalQuestion condicionalQuestion(){
        return new CondicionalQuestion();
    }
}
