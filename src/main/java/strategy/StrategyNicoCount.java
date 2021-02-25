package strategy;

import model.Car;
import model.Intersection;
import model.Schedule;
import model.Street;
import util.Input;

import java.util.*;

public class StrategyNicoCount extends AbstractStrategy {

    List<Schedule> results;

    public StrategyNicoCount(Input input) {
        super("StrategyNicoCount", input);
        strategy();
    }

    @Override
    public List<Schedule> getResult() {
        return results;
    }

    private void strategy() {
        results = new ArrayList<>();

        Map<Street, Integer> nbPassage = new HashMap<>();
        for (Street street : input.getStreets()) {
            nbPassage.put(street, 0);
        }

        for (Car car : input.getCars()) {
            for (Street street : car.getPath()) {
                nbPassage.put(street, nbPassage.get(street) + 1);
            }
        }

        for (Intersection intersection : input.getIntersections()) {
            Schedule schedule = new Schedule(intersection, new LinkedHashMap<>());
            int totalPassage = 0;
            List<Street> streetWithPassage = new ArrayList<>();

            for (Street street : intersection.getInputStreets()) {
                totalPassage += nbPassage.get(street);
                if (nbPassage.get(street) > 0) {
                    streetWithPassage.add(street);
                }
            }

            for (Street street : streetWithPassage) {
                Double pourcentage = (double) nbPassage.get(street) / totalPassage;
                Double tempsVert = 4 * pourcentage;
                schedule.getStreetGreenLightDuration().put(street, (int) (tempsVert + 1));
            }
            if (schedule.getStreetGreenLightDuration().size() > 0) {
                results.add(schedule);
            }
        }
        System.out.println("toto");
    }

}
