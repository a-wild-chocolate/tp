//@@author paturikarthik
package seedu.lifetrack.ui;

import seedu.lifetrack.calories.calorielist.CalorieList;
import seedu.lifetrack.hydration.hydrationlist.HydrationList;
import seedu.lifetrack.sleep.sleeplist.SleepList;
import seedu.lifetrack.user.User;

import java.util.Scanner;

import static seedu.lifetrack.ui.UserUi.printNoUserYetMessage;

/**
 * Reads user input from the console and processes it.
 * <p>
 * This method continuously reads input from the console until the user
 * inputs "bye". For each input line, it checks if it's empty and prompts
 * the user to enter a non-empty input if it is. If the input line starts
 * with "calories in", it attempts to parse the input as calorie intake
 * information using the calorieIn method from the CalorieList class.
 */
public class Ui {

    private static final String WHITESPACE = "         ";

    private static final String logo =
            "\n" +
                    ".____    .__  _____        ___________                     __\n" +
                    "|    |   |__|/ ____\\____   \\__    ___/___________    ____ |  | __\n" +
                    "|    |   |  \\   __\\/ __ \\    |    |  \\_  __ \\__  \\ _/ ___\\|  |/ /\n" +
                    "|    |___|  ||  | \\  ___/    |    |   |  | \\// __ \\\\  \\___|    <\n" +
                    "|_______ \\__||__|  \\___  >   |____|   |__|  (____  /\\___  >__|_ \\\n" +
                    "        \\/             \\/                        \\/     \\/     \\/\n";

    /**
     * Reads in the input from the user
     *
     * @param calorieList   list containing all entries pertinent to calories
     * @param hydrationList list containing all entries pertinent to liquids
     */
    public static void readUserInput(CalorieList calorieList, HydrationList hydrationList,
                                     User user, SleepList sleepList) {
        String line;
        do {
            line = new Scanner(System.in).nextLine();
            handleUserInput(line, calorieList, hydrationList, user, sleepList);
        } while (!line.equalsIgnoreCase("bye"));
    }

    /**
     * handles input from the user
     *
     * @param line        input from the user
     * @param calorieList list containing all entries pertinent to calories
     */
    public static void handleCaloriesInput(String line, CalorieList calorieList) {
        assert !line.startsWith("bye") : "exit the app";
        if (line.startsWith("calories in ") || line.startsWith("calories out ")) {
            calorieList.addEntry(line);
        } else if (line.equals("calories list")) {
            calorieList.printCalorieList();
        } else if (line.startsWith("calories delete ")) {
            calorieList.deleteEntry(line);
        } else if (line.startsWith("calories find ")) {
            calorieList.findEntries(line);
        } else {
            handleUnknownInput(line);
        }
    }

    public static void handleHydrationInput(String line, HydrationList hydrationList) {
        assert !line.startsWith("bye") : "exit the app";
        if (line.startsWith("hydration in ")) {
            hydrationList.addEntry(line);
        } else if (line.equals("hydration list")) {
            hydrationList.printHydrationList();
        } else if (line.startsWith("hydration delete ")) {
            hydrationList.deleteEntry(line);
        } else if (line.startsWith("hydration find ")){
            hydrationList.findEntries(line);
        } else {
            handleUnknownInput(line);
        }
    }
    //@@author

    //@@author a-wild-chocolate
    public static void handleSleepInput(String line, SleepList sleepList) {
        assert !line.startsWith("bye") : "exit the app";
        if (line.startsWith("sleep add ")) {
            sleepList.addSleep(line);
        } else if (line.equals("sleep list")) {
            sleepList.printSleepList();
        } else if (line.startsWith("sleep delete ")) {
            sleepList.deleteSleep(line);
        } else {
            handleUnknownInput(line);
        }
    }
    //@@author

    //@@author paturikarthik
    public static void handleUserInput(String line, CalorieList calorieList, HydrationList hydrationList,
                                       User user, SleepList sleepList) {
        if (!line.trim().equalsIgnoreCase("bye")) {
            printLine();
            line = line.trim();
            if (line.isEmpty()) {
                printEmptyInputMessage();
            } else if (line.startsWith("calories")) {
                handleCaloriesInput(line.toLowerCase(), calorieList);
            } else if (line.equalsIgnoreCase("help")) {
                showHelp();
            } else if (line.startsWith("hydration")) {
                handleHydrationInput(line.toLowerCase(), hydrationList);
            } else if (line.startsWith("sleep")) {
                handleSleepInput(line.toLowerCase(), sleepList);
            } else if (line.startsWith("user")) {
                handleUserCommands(line, user);
            } else {
                handleUnknownInput(line);
            }
            printLine();
        }
    }

    public static void handleUserCommands(String line, User user) {
        if (line.startsWith("user setup ")) {
            user.setUp(line);
        } else if (line.equals("user progress")) {
            handleUserProgress(user);
        } else if (line.startsWith("user update")) {
            if (user.getName() == null) {
                printNoUserYetMessage();
            } else {
                user.update(line);
            }
        } else if (line.equals("user details")) {
            if (user.getName() == null) {
                printNoUserYetMessage();
            } else {
                user.getUserDetails();
            }
        } else {
            handleUnknownInput(line);
        }
    }

    private static void handleUserProgress(User user) {
        if (user.getName() == null) {
            printNoUserYetMessage();
        } else {
            user.getCaloriesProgressBar();
            user.getHydrationProgressBar();
            user.getSleepProgressBar();
        }
    }

    public static void sayHello() {
        printLine();
        System.out.println(WHITESPACE + "Hello from\n\n" + logo);
        System.out.println(WHITESPACE + "How can I help you today?");
        printLine();
    }

    public static void byeMessage() {
        printLine();
        System.out.println(WHITESPACE + "Bye! See you again soon ^^");
    }

    public static void printEmptyInputMessage() {
        System.out.println("\t Please enter a non-empty input!");
    }

    public static void printLine() {
        System.out.println(WHITESPACE + "-------------------------------------" +
                "----------------------------------------");
    }

    /**
     * Sorts unhandled inputs into incomplete inputs and unknown inputs
     *
     * @param line string input from user
     */
    public static void handleUnknownInput(String line) {
        if (line.startsWith("calories in") || line.startsWith("calories out") || line.startsWith("calories delete") ||
                line.startsWith("hydration in") || line.startsWith("hydration delete") || line.startsWith("sleep add")
                || line.startsWith("sleep delete") || line.startsWith("user setup")
                || line.startsWith("calories find") || line.startsWith("hydration find")) {
            System.out.println("\t Oops! Incomplete command!");
        } else {
            System.out.println("\t Oops! I've never seen this input before...");
        }
        System.out.println("\t If you are unsure of the commands, use the help command for a quick recap :)");

    }

    public static void showHelp() {
        System.out.println("\t LifeTrack Command List:");
        System.out.println("\t - help: Displays a list of available commands and their descriptions.");
        printLine();
        System.out.println("\t - calories in <food> c/<calories> d/<date, format:YYYY-MM-DD> " +
                "m/[carbohydrates, proteins, fats]:\n" + "\t Adds a calorie gaining entry into the calories tracker.");
        System.out.println("\t - calories out <activity> c/<calories> d/<date, format:YYYY-MM-DD>:\n" +
                "\t Adds a calorie burning entry into the calories tracker.");
        System.out.println("\t - calories list: Displays all entries currently stored in the calorie list.");
        System.out.println("\t - calories delete <calorie ID>: Deletes the entry at the specified ID" +
                " from the calorie list.");
        System.out.println("\t - calories find <keyword>: finds and lists all calorie entries " +
                "containing the keyword " + "in their description");
        printLine();
        System.out.println("\t - hydration in <beverage> v/<volume> d/<date, format:YYYY-MM-DD>:\n" +
                "\t Adds a hydration entry into the hydration tracker.");
        System.out.println("\t - hydration list: Displays all entries currently stored in the hydration list.");
        System.out.println("\t - hydration delete <hydration ID>: Deletes the hydration entry at the specified ID " +
                "from the hydration list.");
        System.out.println("\t - hydration find <keyword>: finds and lists all hydration entries containing " +
                "the keyword " + "in their description");
        printLine();
        System.out.println("\t - sleep add <duration> d/<date, format:YYYY-MM-DD>: " +
                "Adds a sleep entry into the sleep tracker.");
        System.out.println("\t - sleep list: Displays all entries currently stored in the sleep list.");
        System.out.println("\t - sleep delete <sleep ID>: Deletes the entry at the specified index " +
                "from the sleep list.");
        printLine();
        System.out.println("\t - user setup <name> h/<height> w/<weight> a/<age> s/<sex> e/<exercise_level> " +
                "g/<body_goal>:\n" + "\t Create a new user, or edit an existing one.");
        System.out.println("\t - user details: prints the details of the user.");
        System.out.println("\t - user update name/height/weight/age/sex/exercise levels/goal <UPDATED VALUE>: "
                + "updates the corresponding field of the user.");
        System.out.println("\t - user progress: Display calories and hydration progress towards the daily " +
                "requirement.");
    }
}
//@@author
