import strategy.AbstractStrategy;
import util.Parser;

import java.io.FileNotFoundException;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException {
        final String inputName = "a.txt";

        final Parser parser = new Parser(inputName);
        final AbstractStrategy strategy_naive = new AbstractStrategy("naive", parser.parseInput()) {
        };

        parser.writeResult(strategy_naive);
    }

}