package util;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Car;
import model.Intersection;
import model.Street;

import java.util.List;

@Data
@AllArgsConstructor
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
    List<Intersection> intersections;

}
