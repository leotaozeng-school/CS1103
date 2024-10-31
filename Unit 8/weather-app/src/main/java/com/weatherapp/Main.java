package com.weatherapp;

import javafx.application.Platform;

public class Main {
    public static void main(String[] args) {
        // Set this property before launching the app
        System.setProperty("javafx.macosx.enableDirect2D", "true");

        // Add shutdown hook to ensure clean exit
        Platform.setImplicitExit(true);

        WeatherApp.main(args);
    }
}