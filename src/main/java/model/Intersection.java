package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Intersection {

    Integer id;
    List<Street> inputStreets;
    List<Street> outputStreets;
    Street currentLight;

//    public Street getMostPopulatedStreet() {
//        return outputStreets.stream().max(Comparator.comparing(s -> s.getCarsWaiting().size())).get();
//    }

}
