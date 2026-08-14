class Thermometer {
    double temperature;
    char unit;

    Thermometer(double temperature, char unit) {
        this.temperature = temperature;
        this.unit = unit;
    }

    double toCelsius() {
        if (unit == 'F') {
            return (temperature - 32) * 5 / 9.0;
        }
        return temperature;
    }

    double toFahrenheit() {
        if (unit == 'C') {
            return temperature * 9 / 5.0 + 32;
        }
        return temperature;
    }

    void printBoth() {
        System.out.println("섭씨: " + this.toCelsius() + "°C / 화씨: " + this.toFahrenheit() + "°F");
    }
}

public class Q23 {
    public static void main(String[] args) {
        Thermometer t1 = new Thermometer(100, 'C');
        Thermometer t2 = new Thermometer(98.6, 'F');
        t1.printBoth();
        t2.printBoth();
    }
}
