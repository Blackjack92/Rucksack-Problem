package solvers;

import domain.Item;
import domain.Rucksack;

import java.util.ArrayList;
import java.util.List;

import static solvers.SolverUtils.calcValue;
import static solvers.SolverUtils.calcWeight;
import static solvers.SolverUtils.filterItems;

/**
 * Created by kevin on 27.05.2017.
 */
public class BacktrackingSolver implements ISolver {
    @Override
    public List<Item> solve(Rucksack rucksack, List<Item> allItems) {

        // Call recursive backtrack
        List<Item> bestSolution = new ArrayList<>();
        backtrack(rucksack, new ArrayList<>(), filterItems(rucksack, allItems), bestSolution);
        return bestSolution;
    }

    private boolean backtrack(Rucksack rucksack, List<Item> actualItems, List<Item> unusedItems, List<Item> bestSolution) {
        if (calcWeight(actualItems) >= rucksack.getWeight() || unusedItems.isEmpty()) { return calcWeight(actualItems) <= rucksack.getWeight(); }

        for (Item item : unusedItems) {
            List<Item> newActualItems = new ArrayList<>(actualItems);
            List<Item> newUnusedItems = new ArrayList<>(unusedItems);

            newActualItems.add(item);
            newUnusedItems.remove(item);

            if (backtrack(rucksack, newActualItems, newUnusedItems, bestSolution)) {
                // Update best solution if necessary
                if (calcValue(bestSolution) < calcValue(newActualItems)) {
                    bestSolution.clear();
                    bestSolution.addAll(newActualItems);
                }
            }
        }

        return true;
    }
}
