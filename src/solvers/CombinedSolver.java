package solvers;

import domain.Item;
import domain.Rucksack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 27.05.2017.
 */
public class CombinedSolver implements ISolver {

    private final List<ISolver> solvers;

    public CombinedSolver(List<ISolver> solvers) {
        this.solvers = solvers;
    }

    @Override
    public List<Item> solve(Rucksack rucksack, List<Item> allItems) {
        List<Item> bestSolution = new ArrayList<>();

        for (ISolver solver : solvers) {
            List<Item> solution = solver.solve(rucksack, allItems);
            if (SolverUtils.calcValue(solution) > SolverUtils.calcValue(bestSolution)) {
                bestSolution.clear();
                bestSolution.addAll(solution);
            }
        }

        return bestSolution;
    }
}
