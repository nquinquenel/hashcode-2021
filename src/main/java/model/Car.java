package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Car {

    // P
    private Integer streetsNumber;
    private List<Street> path;
    private Street currentStreet;
    private Integer currentTimeOnStreet;
    private Integer currentIndexPath;

}
