package com.weatherapp;

import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class WeatherService {
    private final String apiKey;
    private final HttpClient client;
    private final ObjectMapper mapper;
    private static final String BASE_URL = "https://api.weatherstack.com/current";

    public WeatherService(String apiKey) {
        this.apiKey = apiKey;
        this.client = HttpClient.newHttpClient();
        this.mapper = new ObjectMapper();
    }

    public WeatherData getWeatherData(String city) throws WeatherException {
        try {
            // URL encode the city name
            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
            String url = String.format("%s?access_key=%s&query=%s", BASE_URL, apiKey, encodedCity);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new WeatherException("Failed to fetch weather data");
            }

            JsonNode root = mapper.readTree(response.body());

            // Check for API errors
            if (root.has("error")) {
                String errorMsg = root.path("error").path("info").asText("Unknown error");
                throw new WeatherException("API Error: " + errorMsg);
            }

            WeatherData data = new WeatherData();
            JsonNode current = root.path("current");

            // Map Weatherstack data to our model
            data.setTemperature(current.path("temperature").asDouble());
            data.setHumidity(current.path("humidity").asDouble());
            data.setWindSpeed(current.path("wind_speed").asDouble());
            data.setCondition(current.path("weather_descriptions")
                    .get(0)
                    .asText("Unknown"));
            data.setIcon(current.path("weather_icons")
                    .get(0)
                    .asText(""));

            return data;
        } catch (Exception e) {
            throw new WeatherException("Error fetching weather data: " + e.getMessage());
        }
    }
}