public class Main {

    public static void main(final String[] args) {
        final String input = "a_example";

        final Parser parser = new Parser("a_example");
        final Strategy strategy_naive = new Strategy("naive") {
        };

        parser.writeResult(input, strategy_naive);
    }

}