package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import userinterfaces.CondicionalUserinterface;

public class CondicionalTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(CondicionalUserinterface.BTN_GENERATE_COLOR));
        actor.attemptsTo(
                Check.whether(CondicionalUserinterface.TXT_COLOR.resolveFor(actor).getText().equals("YELLOW"))
                        .andIfSo(
                                Click.on(CondicionalUserinterface.BTN_AMARILLO))
                        .otherwise(Click.on(CondicionalUserinterface.BTN_AZUL)));
    }
    public static CondicionalTask condicionalTask() {
        return Tasks.instrumented(CondicionalTask.class);
    }
}
