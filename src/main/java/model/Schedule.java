package model;

import lombok.Value;

import java.util.LinkedHashMap;
import java.util.Map;

@Value
public class Schedule {

    Intersection intersection;
    LinkedHashMap<Street, Integer> streetGreenLightDuration;

}
