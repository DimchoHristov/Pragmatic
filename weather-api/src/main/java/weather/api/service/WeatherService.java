package weather.api.service;

import weather.api.models.WeatherData;

public interface WeatherService {

  WeatherData getCurrentWeatherData(String city);

  String getForecastWeatherData(String city);
}

