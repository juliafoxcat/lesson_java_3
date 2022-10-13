package guru.qa;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;
import guru.qa.service.ConsoleInterface;
import guru.qa.service.GuiInterface;
import guru.qa.service.Interface;

import javax.swing.*;

public class Application {

//    private final GuiInterface userInterface;
//
//    public Application(GuiInterface userInterface) {
//        this.userInterface = userInterface;
//    }
//
//    void run() {
//        Car car = userInterface.chooseCarInGui();
//        Track track = userInterface.chooseTrackInGui();
//        userInterface.showResult(car, track);
//    }

    private final Interface userInterface;

    public Application(Interface userInterface) {
        this.userInterface = userInterface;
    }

    public void runInterface() {
        Car car = userInterface.choiceCar();
        Track track = userInterface.choiceTrack();
        userInterface.showResult(car, track);
    }

    public static Application newInstance() {
        String[] choices = {"GUI", "CUI"};
        String chosenInterface = (String) JOptionPane.showInputDialog(
                null,
                "Choose Interface",
                "Choice",
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices,
                "");
        Interface userInterface;
        switch (chosenInterface) {
            case "GUI":
                userInterface = new GuiInterface(new CarStore(), new TrackStore());
                break;
            default:
                userInterface = new ConsoleInterface(new CarStore(), new TrackStore());

        }
        return new Application(userInterface);
    }

}
