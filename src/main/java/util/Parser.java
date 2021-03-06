package util;

import model.Car;
import model.Intersection;
import model.Schedule;
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
        final List<Integer> idIntersections = new ArrayList<>();
        final Map<Integer, Intersection> intersections = new HashMap<>();
        for (int i = 0; i < S; i++) {
            // Streets
            final Integer B = in.nextInt();
            final Integer E = in.nextInt();
            final String streetName = in.next();
            final Integer L = in.nextInt();
            final Street street = new Street(B, E, streetName, L, 0);
            streets.put(streetName, street);

            // Intersections
            if (!idIntersections.contains(B)) {
                intersections.put(B, new Intersection(B, new ArrayList<>(), new ArrayList<>(), null));
                idIntersections.add(B);
            }
            intersections.get(B).getOutputStreets().add(street);

            if (!idIntersections.contains(E)) {
                intersections.put(E, new Intersection(E, new ArrayList<>(), new ArrayList<>(), null));
                idIntersections.add(E);
            }
            intersections.get(E).getInputStreets().add(street);
        }

        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            final Integer P = in.nextInt();
            final List<Street> path = new ArrayList<>();
            for (int j = 0; j < P; j++) {
                final String streetName = in.next();
                path.add(streets.get(streetName));
            }
            Car car = new Car(P, path, path.get(0), 0, 0);
            cars.add(car);
        }

        in.close();

        return new Input(inputName, D, I, S, V, F, new ArrayList<>(streets.values()), cars, new ArrayList<>(intersections.values()));
    }

    public void writeResult(final AbstractStrategy strategy) {
        final OffsetDateTime now = OffsetDateTime.now(ZoneId.systemDefault());
        final String nowString = now.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        final String outputFileName = strategy.getName() + "_" + inputName + "_" + nowString + ".txt";
        try {
            final File file = new File("src/main/resources/output/" + outputFileName);
            file.createNewFile();
            final FileOutputStream fos = new FileOutputStream(file);
            final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            final Integer numberIntersections = strategy.getResult().size();
            bw.write(String.valueOf(numberIntersections));
            bw.newLine();
            for (int i = 0; i < numberIntersections; i++) {
                final Schedule schedule = strategy.getResult().get(i);
                bw.write(String.valueOf(schedule.getIntersection().getId()));
                bw.newLine();

                bw.write(String.valueOf(schedule.getStreetGreenLightDuration().size()));
                bw.newLine();

                for (Map.Entry<Street, Integer> entry : schedule.getStreetGreenLightDuration().entrySet()) {
                    bw.write(entry.getKey().getName() + " " + entry.getValue());
                    bw.newLine();
                }
            }
            bw.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}