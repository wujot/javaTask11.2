public class WeatherInfo {
    private String city;
    private String description;
    //private int temperature;

    public WeatherInfo() {}

    public WeatherInfo(String city, String description) {
        this.city = city;
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "The weather in the city " +
                city +
                " is: " + description;
    }
}
