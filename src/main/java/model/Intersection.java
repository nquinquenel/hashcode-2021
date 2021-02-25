package model;

import lombok.Value;

import java.util.List;

@Value
public class Intersection {

    Integer id;
    List<Street> inputStreets;
    List<Street> outputStreets;

}
