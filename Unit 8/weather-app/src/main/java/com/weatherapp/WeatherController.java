package com.weatherapp;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeatherController {
    private final WeatherService weatherService;
    private final VBox view;
    private final TextField cityInput;
    private final Label temperatureLabel;
    private final Label humidityLabel;
    private final Label windSpeedLabel;
    private final ImageView weatherIcon;
    private final ToggleButton unitToggle;
    private final ListView<String> searchHistory;
    private final ObservableList<String> searchHistoryData;
    private boolean isCelsius = true;
    private double currentTemp;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;

        view = new VBox(10);
        view.setPadding(new Insets(10));

        // Create UI components
        cityInput = new TextField();
        cityInput.setPromptText("Enter city name");
        Button searchButton = new Button("Search");

        temperatureLabel = new Label("Temperature: --");
        humidityLabel = new Label("Humidity: --");
        windSpeedLabel = new Label("Wind Speed: --");

        weatherIcon = new ImageView();
        weatherIcon.setFitHeight(100);
        weatherIcon.setFitWidth(100);

        unitToggle = new ToggleButton("°C/°F");

        searchHistoryData = FXCollections.observableArrayList();
        searchHistory = new ListView<>(searchHistoryData);
        searchHistory.setPrefHeight(150);

        // Layout setup
        HBox searchBox = new HBox(10, cityInput, searchButton);
        view.getChildren().addAll(
                searchBox,
                temperatureLabel,
                humidityLabel,
                windSpeedLabel,
                weatherIcon,
                unitToggle,
                new Label("Search History:"),
                searchHistory
        );

        // Event handlers
        searchButton.setOnAction(e -> searchWeather());
        unitToggle.setOnAction(e -> updateTemperatureUnit());
    }

    public VBox getView() {
        return view;
    }

    private void searchWeather() {
        String city = cityInput.getText().trim();
        if (city.isEmpty()) {
            showError("Please enter a city name");
            return;
        }

        try {
            WeatherData data = weatherService.getWeatherData(city);
            updateDisplay(data);
            addToSearchHistory(city);
        } catch (WeatherException e) {
            showError(e.getMessage());
        }
    }

    private void updateDisplay(WeatherData data) {
        currentTemp = data.getTemperature();
        updateTemperatureLabel();
        humidityLabel.setText(String.format("Humidity: %.1f%%", data.getHumidity()));
        windSpeedLabel.setText(String.format("Wind Speed: %.1f m/s", data.getWindSpeed()));
        updateWeatherIcon(data.getIcon());
    }

    private void updateTemperatureLabel() {
        double displayTemp = isCelsius ? currentTemp : (currentTemp * 9/5) + 32;
        String unit = isCelsius ? "°C" : "°F";
        temperatureLabel.setText(String.format("Temperature: %.1f%s", displayTemp, unit));
    }

    private void updateTemperatureUnit() {
        isCelsius = !isCelsius;
        updateTemperatureLabel();
    }

    private void updateWeatherIcon(String iconUrl) {
        weatherIcon.setImage(new Image(iconUrl));
    }

    private void addToSearchHistory(String city) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        searchHistoryData.add(0, String.format("%s - %s", timestamp, city));

        // Keep only last 10 searches
        if (searchHistoryData.size() > 10) {
            searchHistoryData.remove(10, searchHistoryData.size());
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
