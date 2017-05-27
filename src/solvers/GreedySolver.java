package solvers;

import domain.Item;
import domain.Rucksack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kevin on 27.05.2017.
 */
public class GreedySolver implements ISolver {

    @Override
    public List<Item> solve(Rucksack rucksack, List<Item> allItems) {

        List<Item> solution = new ArrayList<>();
        List<Item> itemsClone = SolverUtils.filterItems(rucksack, allItems);
        itemsClone.sort(Comparator.comparingInt(Item::getValue).reversed());

        int weight = 0;
        for (Item item : itemsClone) {
            if (item.getWeight() + weight <= rucksack.getWeight()) {
                solution.add(item);
                weight += item.getWeight();
            }
        }

        return solution;
    }
}
