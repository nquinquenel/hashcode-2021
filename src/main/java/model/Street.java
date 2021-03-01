package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Street {

    // B
    private Integer startIntersection;
    // E
    private Integer endIntersection;
    private String name;
    // L
    private Integer time;
    private Integer lightOnSince;

}
