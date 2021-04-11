package model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class CarService {
    private static List<Car> cars = new ArrayList<>();

    public void createCars() {
        for (int i = 0; i < 5; i++) {
            cars.add(new Car("" + i, i, i));
        }
    }

    public List<Car> getCars(int count) {
        return cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
