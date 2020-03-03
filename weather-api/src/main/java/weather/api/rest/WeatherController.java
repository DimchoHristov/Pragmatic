package weather.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import weather.api.service.WeatherService;
import weather.api.models.WeatherData;

@RestController
@RequestMapping("/weather")
public class WeatherController {

  private final WeatherService weatherService;

  public WeatherController(final WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping("/current")
  public WeatherData getCurrentWeatherData(@RequestParam final String city) {
    return weatherService.getCurrentWeatherData(city);
  }

  @GetMapping("/forecast")
  public String getForecastWeatherData(@RequestParam final String city){
    return weatherService.getForecastWeatherData(city);
  }

}
