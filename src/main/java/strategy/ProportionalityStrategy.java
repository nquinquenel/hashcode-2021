package strategy;

import model.Car;
import model.Intersection;
import model.Schedule;
import model.Street;
import util.Input;

import java.util.*;

public class ProportionalityStrategy extends AbstractStrategy {

    private final static int DEFAULT_TIME = 1;

    private List<Schedule> results;

    public ProportionalityStrategy(Input input) {
        super("StrategyNicoCount", input);
        strategy();
    }

    @Override
    public List<Schedule> getResult() {
        return results;
    }

    private void strategy() {
        results = new ArrayList<>();

        final Map<Street, Integer> nbPassage = new HashMap<>();
        for (Street street : input.getStreets()) {
            nbPassage.put(street, 0);
        }

        for (final Car car : input.getCars()) {
            for (final Street street : car.getPath()) {
                nbPassage.put(street, nbPassage.get(street) + 1);
            }
        }

        for (final Intersection intersection : input.getIntersections()) {
            final Schedule schedule = new Schedule(intersection, new LinkedHashMap<>());
            final List<Street> streetWithPassage = new ArrayList<>();
            int totalPassage = 0;

            for (Street street : intersection.getInputStreets()) {
                totalPassage += nbPassage.get(street);
                if (nbPassage.get(street) > 0) {
                    streetWithPassage.add(street);
                }
            }

            for (Street street : streetWithPassage) {
                final double percentage = (double) nbPassage.get(street) / totalPassage;
                final double tempsVert = DEFAULT_TIME * percentage;
                schedule.getStreetGreenLightDuration().put(street, (int) (tempsVert + 1));
            }

            if (schedule.getStreetGreenLightDuration().size() > 0) {
                results.add(schedule);
            }
        }
    }

}
