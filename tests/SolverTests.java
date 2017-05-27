import domain.Item;
import domain.Rucksack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import solvers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Project: RucksackProblem
 * Class name: ${CLASS_NAME}
 * Created by kevin on 27.05.2017.
 */
class SolverTests {

    private List<Item> items;
    private Rucksack rucksack;

    @BeforeEach
    void setUp() {
        rucksack = new Rucksack(15);
        items = new ArrayList<>();
        items.add(new Item("Item 1", 5, 12));
        items.add(new Item("Item 2", 15, 6));
        items.add(new Item("Item 3", 3, 5));
        items.add(new Item("Item 4", 7, 8));
        items.add(new Item("Item 5", 4, 1));
        items.add(new Item("Item 6", 8, 6));
        items.add(new Item("Item 7", 2, 3));
        items.add(new Item("Item 8", 4, 7));
        items.add(new Item("Item 9", 3, 5));
        items.add(new Item("Item 10", 8, 20));
    }

    @Test
    void rucksackWithoutSpaceTest() {
        rucksack = new Rucksack(0);

        ISolver solver = new FirstFitSolver();
        List<Item> solution = solver.solve(rucksack, items);
        assertTrue(solution.isEmpty());

        solver = new BacktrackingSolver();
        solution = solver.solve(rucksack, items);
        assertTrue(solution.isEmpty());

        solver = new GreedySolver();
        solution = solver.solve(rucksack, items);
        assertTrue(solution.isEmpty());

        solver = new WeightSolver();
        solution = solver.solve(rucksack, items);
        assertTrue(solution.isEmpty());

        List<ISolver> solvers = new ArrayList<>();
        solvers.add(new FirstFitSolver());
        solvers.add(new WeightSolver());
        solvers.add(new BacktrackingSolver());
        solver = new CombinedSolver(solvers);
        solution = solver.solve(rucksack, items);
        assertTrue(solution.isEmpty());
    }

    @Test
    void noItemsTest() {
        items = new ArrayList<>();

        ISolver solver = new FirstFitSolver();
        List<Item> solution = solver.solve(rucksack, items);
        assertTrue(solution.isEmpty());

        solver = new BacktrackingSolver();
        solution = solver.solve(rucksack, items);
        assertTrue(solution.isEmpty());

        solver = new GreedySolver();
        solution = solver.solve(rucksack, items);
        assertTrue(solution.isEmpty());

        solver = new WeightSolver();
        solution = solver.solve(rucksack, items);
        assertTrue(solution.isEmpty());

        List<ISolver> solvers = new ArrayList<>();
        solvers.add(new FirstFitSolver());
        solvers.add(new WeightSolver());
        solvers.add(new BacktrackingSolver());
        solver = new CombinedSolver(solvers);
        solution = solver.solve(rucksack, items);
        assertTrue(solution.isEmpty());
    }

    @Test
    void firstFitTest() {
        ISolver solver = new FirstFitSolver();
        List<Item> solution = solver.solve(rucksack, items);
        assertTrue(solution.size() == 3);
        assertEquals(solution.get(0), items.get(0));
        assertEquals(solution.get(1), items.get(2));
        assertEquals(solution.get(2), items.get(3));
    }

    @Test
    void greedyTest() {
        ISolver solver = new GreedySolver();
        List<Item> solution = solver.solve(rucksack, items);
        assertTrue(solution.size() == 3);
        assertEquals(solution.get(0), items.get(9));
        assertEquals(solution.get(1), items.get(0));
        assertEquals(solution.get(2), items.get(6));
    }

    @Test
    void weightTest() {
        ISolver solver = new WeightSolver();
        List<Item> solution = solver.solve(rucksack, items);
        assertTrue(solution.size() == 4);
        assertEquals(solution.get(0), items.get(6));
        assertEquals(solution.get(1), items.get(2));
        assertEquals(solution.get(2), items.get(8));
        assertEquals(solution.get(3), items.get(4));
    }

    @Test
    void backtrackingTest() {
        ISolver solver = new BacktrackingSolver();
        List<Item> solution = solver.solve(rucksack, items);
        assertTrue(solution.size() == 3);
        assertEquals(solution.get(0), items.get(0));
        assertEquals(solution.get(1), items.get(6));
        assertEquals(solution.get(2), items.get(9));
    }

    @Test
    void combinedTest() {
        List<ISolver> solvers = new ArrayList<>();
        solvers.add(new FirstFitSolver());
        solvers.add(new WeightSolver());
        solvers.add(new BacktrackingSolver());
        solvers.add(new GreedySolver());
        ISolver solver = new CombinedSolver(solvers);
        List<Item> solution = solver.solve(rucksack, items);
        assertTrue(solution.size() == 3);
        assertEquals(solution.get(0), items.get(0));
        assertEquals(solution.get(1), items.get(6));
        assertEquals(solution.get(2), items.get(9));
    }

}
