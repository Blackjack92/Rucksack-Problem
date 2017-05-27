package visualizer;

import domain.Item;

import java.util.List;

/**
 * Created by kevin on 27.05.2017.
 */
public class ConsoleVisualizer implements IVisualizer {

    @Override
    public void visualize(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("Items are empty.");
            return;
        }

        int sumWeight = 0;
        int sumValue = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            sumWeight += item.getWeight();
            sumValue += item.getValue();

            System.out.println((i + 1) + ". " + item);
        }

        System.out.println("Sum weight:" + sumWeight + " Sum value:" + sumValue);
    }
}
