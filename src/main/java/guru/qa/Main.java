package guru.qa;

import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;
import guru.qa.service.ConsoleInterface;
import guru.qa.service.GuiInterface;
import guru.qa.service.Interface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Application result = Application.newInstance();
        result.runInterface();
    }
}

