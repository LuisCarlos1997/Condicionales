package tasks;

import interactions.Time;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import userinterfaces.DogOrCatUserInterface;

public class DogOrCatTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(DogOrCatUserInterface.BTN_GENERATE));
        actor.attemptsTo(
                Check.whether(DogOrCatUserInterface.IMG_CAT.resolveFor(actor).isVisible())
                        .andIfSo(
                                Click.on(DogOrCatUserInterface.BTN_CAT))
                        .otherwise(Click.on(DogOrCatUserInterface.BTN_DOG)));
        Time.Sleep(1000);

    }

    public static DogOrCatTask dogOrCatTask(){
        return Tasks.instrumented(DogOrCatTask.class);
    }

}
