package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Car {

    // P
    Integer streetsNumber;
    List<Street> path;
    Street currentStreet;
    Integer currentTimeOnStreet;
    Integer currentIndexPath;

//    public void go() {
//        if (currentTimeOnStreet < currentStreet.getTime()) {
//            currentTimeOnStreet++;
//            if (currentTimeOnStreet.equals(currentStreet.getTime())) {
//                currentStreet.carsWaiting.add(this);
//            }
//        } else {
//            if (currentStreet.getLightOnSince() > 0) {
//                currentStreet.decreaseCarsWaiting();
//                currentIndexPath++;
//                if (currentIndexPath != path.size()) {
//                    currentStreet = path.get(currentIndexPath);
//                }
//            }
//        }
//    }

}
