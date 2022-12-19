package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.DogOrCatUserInterface;

public class DogOrCatQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(DogOrCatUserInterface.TXT_ASERCION).answeredBy(actor).toString();
    }
    public static DogOrCatQuestion dogOrCatQuestion(){
        return new DogOrCatQuestion();
    }
}
