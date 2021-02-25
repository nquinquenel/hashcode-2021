package strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import model.Schedule;
import util.Input;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public abstract class AbstractStrategy {
    String name;
    Input input;

    public abstract List<Schedule> getResult();
}
