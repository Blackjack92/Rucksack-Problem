package solvers;

import domain.Item;
import domain.Rucksack;

import java.util.List;

/**
 * Created by kevin on 27.05.2017.
 */
public interface ISolver {

    public List<Item> solve(Rucksack rucksack, List<Item> allItems);


}
