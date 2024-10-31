package com.weatherapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class WeatherApp extends Application {
    private WeatherService weatherService;
    private WeatherController controller;

    @Override
    public void start(Stage primaryStage) {
        try {
            weatherService = new WeatherService("125d41d8c051439cffac132bc2477915");
            controller = new WeatherController(weatherService);

            BorderPane root = new BorderPane();
            root.setCenter(controller.getView());

            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("/styles/weather.css").toExternalForm());

            primaryStage.setTitle("Weather Information App");
            primaryStage.setScene(scene);

            // Add proper window closing handler
            primaryStage.setOnCloseRequest(event -> {
                Platform.exit();
                System.exit(0);
            });

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    @Override
    public void stop() {
        // Cleanup code here
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
