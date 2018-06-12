package ch2;

/**
 * Created by yjw on 18-4-17.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidty;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("Current conditions: " + temperature
            + "F degree and " + humidty + "% humidity");
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidty = humidity;
        display();
    }
}
