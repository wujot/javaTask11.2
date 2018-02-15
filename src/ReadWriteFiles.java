import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ReadWriteFiles {

    // method to read text file with names of cities - returns array of cities
    public String[] getCity(String fileName) {
        String line;
        String[] cities = new String[5];
        int increase = 0;

        try {
            FileReader fileReader = new FileReader(fileName);
            File fileDir = new File("C://Users/husar/IdeaProjects/javaTask11.2/cities.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

            while ((line = br.readLine()) != null) {
                cities[increase] = line;
                increase++;
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

    // method to take and WeatherInfo objects as an argument and write them i csv file.
    public void writeFile(ArrayList<WeatherInfo> info) {
        String fileName = "cities.csv";

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("cities.csv", true);

            //Write a new product object to the CSV file
            for (int i = 0; i < info.size(); i++) {
                fileWriter.append(info.get(i).getCity());
                fileWriter.append(";");
                fileWriter.append(info.get(i).getDescription());
                fileWriter.append(";");
                fileWriter.append("\n");
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}
