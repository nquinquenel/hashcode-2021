import model.Schedule;
import strategy.AbstractStrategy;
import util.Parser;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException {
        final String inputName = "a.txt";

        final Parser parser = new Parser(inputName);
        final AbstractStrategy strategy_naive = new AbstractStrategy("naive", parser.parseInput()) {
            @Override
            public List<Schedule> getResult() {
                return null;
            }
        };

        parser.writeResult(strategy_naive);
    }

}