package console;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Project: RucksackProblem
 * Class name: ${CLASS_NAME}
 * Created by kevin on 27.05.2017.
 */
public class ConsoleOptions {

    private final Options options;

    public  ConsoleOptions() {
        options = new Options();

        Option quit = new Option("q", "quit", false, "Quit the program.");
        options.addOption(quit);

        Option help = new Option("h", "help", false, "Shows the help page.");
        options.addOption(help);

        Option getRucksack = new Option("g", "get-weight", false, "Get the rucksack weight.");
        options.addOption(getRucksack);

        Option setRucksack = new Option("w", "set-weight", false, "Set the rucksack weight.");
        options.addOption(setRucksack);

        Option listAllItems = new Option("l", "list", false, "List all items.");
        options.addOption(listAllItems);

        Option addItem = new Option("a", "add", false, "Add a new item to the possible items.");
        options.addOption(addItem);

        Option removeItem = new Option("r", "remove", false, "Remove a defined item.");
        options.addOption(removeItem);

        Option clearItems = new Option("c", "clear", false, "Removes all defined items.");
        options.addOption(clearItems);

        Option solver = new Option("s", "solver", true, "Start the selected solver " +
                "[f (first fit)| g (greedy) | b (backtracking) | w (weight)].");
        options.addOption(solver);
    }

    public Options getOptions() {
        return options;
    }

}
