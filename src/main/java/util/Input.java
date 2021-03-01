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

    private String name;

    // D
    private Integer totalDuration;
    // I
    private Integer numberIntersections;
    // S
    private Integer numberStreets;
    // V
    private Integer numberCars;
    // F
    private Integer bonusPoints;

    private List<Street> streets;
    private List<Car> cars;
    private List<Intersection> intersections;

}
