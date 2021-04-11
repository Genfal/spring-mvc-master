package web.controller;

import model.Car;
import model.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class CarController {

    private static final CarService carService = new CarService();

    static {
        carService.createCars();
    }

    @GetMapping(value = "/cars")
    public String CreateCars(@RequestParam(value = "count", required = false) Integer count,
                             Model model) {

        StringBuilder stringBuilder = new StringBuilder();
        if (count != null) {
            List<Car> cars = carService.getCars(count);
            for (Car car : cars) {
                stringBuilder.append(car.toString()).append("\n");
            }
            model.addAttribute("cars", stringBuilder.toString());
        }
        return "cars";
    }
}