package solvers;

import domain.Item;
import domain.Rucksack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kevin on 27.05.2017.
 */
public class SolverUtils {

    public static List<Item> filterItems(Rucksack rucksack, List<Item> items) {
        return items.stream().filter(i -> i.getWeight() <= rucksack.getWeight()).collect(Collectors.toList());
    }

    public static int calcWeight(List<Item> items) {
        return items.stream().mapToInt(Item::getWeight).sum();
    }

    public static int calcValue(List<Item> items) {
        return items.stream().mapToInt(Item::getValue).sum();
    }
}
