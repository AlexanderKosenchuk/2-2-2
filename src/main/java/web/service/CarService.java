package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    public static List<Car> carList = new ArrayList<>();

    static { // без этого блока не смог положить машинки в лсит ( add не работал )
        carList.add(new Car("Ford", "red", 10000));
        carList.add(new Car("Mercedes", "black", 100000));
        carList.add(new Car("Ferrari", "yellow", 200000));
        carList.add(new Car("Lamborgini", "orange", 250000));
        carList.add(new Car("Buggati", "blue", 1000000));
    }

    public List<Car> getCarsCount(int count) {
        if (count == 0 || count >= 5) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
