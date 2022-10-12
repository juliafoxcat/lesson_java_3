package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import java.util.Scanner;

public class ConsoleInterface {
    private final CarStore carStore;
    private final TrackStore trackStore;
    private final Scanner sc = new Scanner(System.in);

    public ConsoleInterface(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }

    public Car choiceCarConsole() {
        System.out.println("Выберите автомобиль:");
        carStore.carList();
        String chosenCar = sc.next();
        return carStore.lookup(chosenCar);
    }

    public Track choiceTrackConsole() {
        System.out.println("Выберите трассу:");
        trackStore.trackList();
        String chosenTack = sc.next();
        return trackStore.lookup(chosenTack);
    }

    public void showResult(Car car, Track track) {
        if (car.isPitstopNeeded(track)) {
            System.out.println("Pit-stop needed in " + car.maxLapsForTrack());
        } else {
            System.out.println("Pit-stop not needed");
        }
    }
}