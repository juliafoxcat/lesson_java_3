package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.domain.Track;

public interface Interface {
    Car choiceCar();
    Track choiceTrack();
    void showResult(Car car, Track track);
}