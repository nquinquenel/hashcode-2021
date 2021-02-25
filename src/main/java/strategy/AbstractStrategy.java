package strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import util.Input;

@AllArgsConstructor
@Getter
@ToString
public abstract class AbstractStrategy {
    String name;
    Input input;

//    public abstract List<LibraryOutput> getResult();
}
