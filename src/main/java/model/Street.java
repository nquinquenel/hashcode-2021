package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Street {

    // B
    Integer startIntersection;
    // E
    Integer endIntersection;
    String name;
    // L
    Integer time;
    Integer lightOnSince;
//    List<Car> carsWaiting;
//
//    public void incrementCarsWaiting(Car car) {
//        carsWaiting.add(car);
//    }
//
//    public void decreaseCarsWaiting() {
//        carsWaiting.remove(0);
//    }

}
