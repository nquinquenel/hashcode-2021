package util;

import lombok.Value;
import model.Car;
import model.Street;

import java.util.List;

@Value
public class Input {

    String name;

    // D
    Integer totalDuration;
    // I
    Integer numberIntersections;
    // S
    Integer numberStreets;
    // V
    Integer numberCars;
    // F
    Integer bonusPoints;

    List<Street> streets;
    List<Car> cars;

}
