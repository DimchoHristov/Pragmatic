package weather;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import weather.api.models.WeatherData;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public RestTemplate restTemplate(final RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public CommandLineRunner run(final RestTemplate restTemplate) {
    return args -> {
      final WeatherData currentWeatherData = restTemplate.getForObject(
          "http://api.openweathermap.org/data/2.5/weather?q=Berlin&appid=f92ceb0c7deb150dc2c39e6db51061c2",
          WeatherData.class);
      System.out.println(currentWeatherData);
      final String forecastWeatherData = restTemplate.getForObject(
          "http://api.openweathermap.org/data/2.5/forecast?q=Berlin&appid=f92ceb0c7deb150dc2c39e6db51061c2",
          String.class);
      System.out.println(forecastWeatherData);
    };
  }
}
