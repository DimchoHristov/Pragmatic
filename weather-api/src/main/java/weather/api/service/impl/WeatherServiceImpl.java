package weather.api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import weather.api.models.WeatherData;
import weather.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

  private final RestTemplate restTemplate;

  private final static String API_KEY = "f92ceb0c7deb150dc2c39e6db51061c2";
  private final static String URL = "http://api.openweathermap.org/data/2.5";
  private final static String CURRENT_WEATHER_PATH = "/weather";
  private final static String FORECAST_WEATHER_PATH = "/forecast";

  public WeatherServiceImpl(final RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public WeatherData getCurrentWeatherData(final String city) {
    return restTemplate.getForObject(buildUrl(CURRENT_WEATHER_PATH, city), WeatherData.class);
  }

  @Override
  public String getForecastWeatherData(String city) {
    return restTemplate.getForObject(buildUrl(FORECAST_WEATHER_PATH, city), String.class);
  }

  private String buildUrl(final String api, final String city) {
    return UriComponentsBuilder.fromHttpUrl(URL + api)
        .queryParam("q", city)
        .queryParam("appid", API_KEY)
        .build()
        .toUriString();
  }
}
