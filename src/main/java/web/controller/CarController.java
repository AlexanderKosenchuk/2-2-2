package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Optional;

import static web.service.CarService.carList;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Optional<Integer> count, ModelMap model) {
        //carList = carService.getCarsCount(count);
        model.addAttribute("carList", carService.getCarsCount(count.orElse(0))); // метод класса Optional что бы обработать null (будет, как при count == 0)
        return "cars";
    }

}