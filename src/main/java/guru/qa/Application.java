package guru.qa;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.service.GuiInterface;

public class Application {

    private final GuiInterface userInterface;

    public Application(GuiInterface userInterface) {
        this.userInterface = userInterface;
    }

    void run() {
        Car car = userInterface.chooseCarInGui();
        Track track = userInterface.chooseTrackInGui();
        userInterface.showResult(car, track);
    }
}
