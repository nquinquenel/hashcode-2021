package model;

import lombok.Value;

import java.util.List;

@Value
public class Car {

    // P
    Integer streetsNumber;
    List<Street> path;

}
