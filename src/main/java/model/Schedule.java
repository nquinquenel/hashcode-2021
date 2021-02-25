package model;

import lombok.Value;

import java.util.Map;

@Value
public class Schedule {
    Intersection intersection;
    Map<Street, Integer> streetGreenLightDuration;
}
