package solvers;

import domain.Item;
import domain.Rucksack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 27.05.2017.
 */
public class FirstFitSolver implements ISolver {

    @Override
    public List<Item> solve(Rucksack rucksack, List<Item> allItems) {
        List<Item> solution = new ArrayList<>();

        int weight = 0;
        for (Item item : SolverUtils.filterItems(rucksack, allItems)) {
            if (weight + item.getWeight() <= rucksack.getWeight()) {
                solution.add(item);
                weight += item.getWeight();
            }
        }

        return solution;
    }
}
