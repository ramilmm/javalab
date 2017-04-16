package ru.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ru.domain.WeatherData;

/**
 * The type Application.
 */
@SpringBootApplication
public class Application {

    @Value("${weather.apiKey}")
    private String apiKey;
    @Value("${weather.city}")
    private String city;



    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            WeatherData weather = restTemplate.getForObject("http://api.apixu.com/v1/current.json?key=" + apiKey +"&q=" + city, WeatherData.class);
            StringBuilder header = new StringBuilder().append(weather.getLocation().getCountry()).append(",")
                    .append(weather.getLocation().getRegion()).append(",")
                    .append(weather.getLocation().getName());
            StringBuilder data = new StringBuilder().append("Date of reading: ").append(weather.getCurrent().getLast_updated_epoch()).append("\n")
                    .append("Temp: ").append(weather.getCurrent().getTemp_c()).append("\n")
                    .append("Feels like: ").append(weather.getCurrent().getFeelslike_c()).append("\n")
                    .append("Wind: ").append(weather.getCurrent().getWind_kph()).append(weather.getCurrent().getWind_dir()).append("\n")
                    .append("Pressure: ").append(weather.getCurrent().getPressure_in()).append("\n")
                    .append("Humidity: ").append(weather.getCurrent().getHumidity()).append("\n")
                    .append("Cloud: ").append(weather.getCurrent().getCloud());
            System.out.println("------------------------------------");
            System.out.println(header);
            System.out.println(data);
            System.out.println("------------------------------------");
        };
    }
}