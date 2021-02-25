package util;

import model.Car;
import model.Street;
import strategy.AbstractStrategy;

import java.io.*;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Parser {

    private final String inputName;

    public Parser(final String inputName) {
        this.inputName = inputName;
    }

    public Input parseInput() throws FileNotFoundException {
        final Scanner in = new Scanner(new File("src/main/resources/input/" + inputName));

        final Integer D = in.nextInt();
        final Integer I = in.nextInt();
        final Integer S = in.nextInt();
        final Integer V = in.nextInt();
        final Integer F = in.nextInt();

        final Map<String, Street> streets = new HashMap<>();
        for (int i = 0; i < S; i++) {
            final Integer B = in.nextInt();
            final Integer E = in.nextInt();
            final String streetName = in.next();
            final Integer L = in.nextInt();
            streets.put(streetName, new Street(B, E, streetName, L));
        }

        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            final Integer P = in.nextInt();
            final List<Street> path = new ArrayList<>();
            for (int j = 0; j < P; j++) {
                path.add(streets.get(in.next()));
            }
            cars.add(new Car(P, path));
        }

        in.close();

        return new Input(inputName, D, I, S, V, F, new ArrayList<>(streets.values()), cars);
    }

    public void writeResult(final AbstractStrategy strategy) {
        //final List<LibraryOutput> result = strategy.getResult();
        final OffsetDateTime now = OffsetDateTime.now(ZoneId.systemDefault());
        final String nowString = now.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        final String outputFileName = strategy.getName() + "_" + inputName + "_" + nowString + ".txt";
        try {
            final File file = new File("src/main/resources/output/" + outputFileName);
            file.createNewFile();
            final FileOutputStream fos = new FileOutputStream(file);
            final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            // TODO writing output to file
//            bw.write(Integer.toString(result.size()));
//            bw.newLine();
//            for (int i = 0; i < result.size(); i++) {
//                final LibraryOutput libraryOutput = result.get(i);
//                bw.write(libraryOutput.getId() + " " + booksOutput.size());
//                bw.newLine();
//                String lineBook = booksOutput.get(0).toString();
//                bw.write(lineBook);
//                bw.newLine();
//            }
            bw.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}