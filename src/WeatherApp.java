import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class WeatherApp {
    public static void main(String[] args) throws IOException {

        String fileName = "cities.txt";

        ReadWriteFiles rw = new ReadWriteFiles();

        String[] cities = rw.getCity(fileName);

        ArrayList<WeatherInfo> listOfWeatherInfo = new ArrayList<>();

        WeatherApi api = new WeatherApi();

        // loop to create WeatherInfo objects
        for (int i = 0; i < cities.length; i++) {
            listOfWeatherInfo.add(new WeatherInfo(cities[i], api.getDescription(cities[i])));
        }

        // loop prints information about weather in each city
        for (int i = 0; i < listOfWeatherInfo.size(); i++) {
            System.out.println(listOfWeatherInfo.get(i).toString());
        }

        rw.writeFile(listOfWeatherInfo);

    }
}