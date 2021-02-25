import strategy.AbstractStrategy;
import strategy.StrategyNicoCount;
import util.Parser;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException {
        final List<String> inputName = Arrays.asList("b.txt", "c.txt", "d.txt", "e.txt", "f.txt");

        for (String s : inputName) {
            final Parser parser = new Parser(s);
            final AbstractStrategy strategy_naive = new StrategyNicoCount(parser.parseInput());

            parser.writeResult(strategy_naive);
        }
    }

}