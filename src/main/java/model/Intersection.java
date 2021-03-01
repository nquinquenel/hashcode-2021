package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Intersection {

    private Integer id;
    private List<Street> inputStreets;
    private List<Street> outputStreets;
    private Street currentLight;

}
