import console.ConsoleOptions;
import domain.Item;
import domain.Rucksack;
import org.apache.commons.cli.*;
import solvers.*;
import visualizer.ConsoleVisualizer;
import visualizer.IVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Project: RucksackProblem
 * Class name: ${CLASS_NAME}
 * Created by kevin on 27.05.2017.
 */
public class Main {

    public static void main(String[] args) {


        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        Options options = new ConsoleOptions().getOptions();
        Scanner scanner = new Scanner(System.in);

        Rucksack rucksack = new Rucksack(15);
        // Init items with some items
        List<Item> items = new ArrayList<>();
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

        IVisualizer visualizer = new ConsoleVisualizer();

        System.out.println("Rucksack problem solver started...");
        formatter.printHelp("Rucksack problem solver:", options);

        while (true) {
            String test = scanner.nextLine();
            String[] input = test.split(" ");
            try {
                CommandLine cmd = parser.parse(options, input, true);

                if (cmd.hasOption("q")) {
                    scanner.close();
                    System.out.println("Rucksack problem solver quit.");
                    System.exit(0);
                    return;
                } else if (cmd.hasOption("h")) {
                    formatter.printHelp("Rucksack problem solver:", options);
                } else if (cmd.hasOption("g")) {
                    System.out.println("Rucksack weight:" + rucksack.getWeight());
                } else if (cmd.hasOption("w")) {
                    System.out.print("Enter new rucksack weight:");
                    int newWeight = scanner.nextInt();
                    rucksack = new Rucksack(newWeight);
                    System.out.println("Rucksack weight was set to:" + newWeight);
                } else if (cmd.hasOption("l")) {
                    System.out.println("All used items:");
                    visualizer.visualize(items);
                } else if (cmd.hasOption("a")) {
                    System.out.print("Enter new item name:");
                    String name = scanner.nextLine();
                    System.out.print("Enter new item weight:");
                    int weight = scanner.nextInt();
                    System.out.print("Enter new item value:");
                    int value = scanner.nextInt();
                    Item item = new Item(name, weight, value);
                    items.add(item);
                    System.out.println("Item was added. " + item);
                } else if (cmd.hasOption("r")) {
                    System.out.print("Enter index of item to remove:");
                    int index = scanner.nextInt();
                    Item item = items.remove(index);
                    System.out.println("Item was removed. " + item);
                } else if (cmd.hasOption("c")) {
                    items.clear();
                    System.out.println("All items were removed.");
                } else if (cmd.hasOption("s")) {
                    String solverName = cmd.getOptionValue("s");
                    ISolver solver = null;
                    switch (solverName) {
                        case "f":
                            System.out.println("First fit solver selected.");
                            solver = new FirstFitSolver();
                            break;
                        case "g":
                            System.out.println("Greedy solver selected.");
                            solver = new GreedySolver();
                            break;
                        case "b":
                            System.out.println("Backtracking solver selected.");
                            solver = new BacktrackingSolver();
                            break;
                        case "w":
                            System.out.println("Weight solver selected.");
                            solver = new WeightSolver();
                            break;
                        default:
                            System.out.println("Selected solver not supported.");
                    }
                    if (solver != null) {
                        System.out.println("Solver started...");
                        List<Item> solution = solver.solve(rucksack, items);
                        System.out.println("Solution of the solver:");
                        visualizer.visualize(solution);
                    }
                }
            } catch (Exception ex) {
                // ex.printStackTrace();
                System.out.println("Some error occurred, please try again.");
            }
        }
    }
}