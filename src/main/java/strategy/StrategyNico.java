package strategy;

import model.Schedule;
import util.Input;

import java.util.List;

public class StrategyNico extends AbstractStrategy {

    List<Schedule> results;

    public StrategyNico(Input input) {
        super("StrategyNico", input);
//        strategy();
    }

    @Override
    public List<Schedule> getResult() {
        return results;
    }

//    private void strategy() {
//        this.results = new ArrayList<>();
//        for (Intersection inter : input.getIntersections()) {
//            results.add(new Schedule(inter, new LinkedHashMap<>()));
//        }
//
//        for (int currentTime = 0; currentTime < input.getTotalDuration(); currentTime++) {
//            for (Intersection inter : input.getIntersections()) {
//                Street mostCarStreet;
//                if (inter.getCurrentLight() == null) {
//                    mostCarStreet = inter.getMostPopulatedStreet();
//                } else {
//                    mostCarStreet = inter.getCurrentLight();
//                }
//
//                if (mostCarStreet.getCarsWaiting().size() > 0) {
//                    inter.setCurrentLight(mostCarStreet);
//
//                    Car car = mostCarStreet.getCarsWaiting().get(0);
//                    car.go();
//                } else {
//                    inter.setCurrentLight(null);
//                }
//            }
//        }
//    }

}
