package rentcarcompany;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private List<Car> cars;

    private RentCompany() {
        cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            stringBuilder.append(car.getName())
                    .append(" : ")
                    .append((int) car.getChargeQuantity())
                    .append("리터\n");
        }
        return stringBuilder.toString();
    }
}
