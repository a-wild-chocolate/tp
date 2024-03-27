package seedu.lifetrack.sleep.sleeplist;

import seedu.lifetrack.Entry;
import seedu.lifetrack.system.exceptions.ErrorMessages;
import seedu.lifetrack.system.exceptions.InvalidInputException;
import seedu.lifetrack.system.parser.ParserSleep;
import seedu.lifetrack.system.storage.FileHandler;
import seedu.lifetrack.ui.SleepListUi;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import static seedu.lifetrack.system.exceptions.ErrorMessages.getIncorrectSleepInputMessage;

public class SleepList {

    private ArrayList<Entry> sleepList;
    private FileHandler fileHandler;
    
    //constructor for JUnit tests
    public SleepList() {
        sleepList = new ArrayList<>();
        fileHandler = new FileHandler("data/sleepTestData.txt");
    }

    //constructor for usage in terminal
    public SleepList(String filePath) {
        try {
            fileHandler = new FileHandler(filePath);
            sleepList = fileHandler.getSleepEntriesFromFile();
        } catch (FileNotFoundException e) {
            sleepList = new ArrayList<>();
            System.out.println(ErrorMessages.getFileNotFoundMessage());
        }
    }

    public Entry getSleep(int index) {
        assert index >= 0 && index < sleepList.size() : "Index out of bounds";
        return sleepList.get(index);
    }

    public void addSleep(String input) {
        try {
            SleepEntry newSleep = ParserSleep.parseSleepInput(input);
            sleepList.add(newSleep);
            fileHandler.writeEntries(sleepList);
            SleepListUi.addEntryMessage();
        } catch (InvalidInputException e) {
            System.out.println(getIncorrectSleepInputMessage());
        }
    }
    
    public void deleteSleep(String line) {
        try {
            int index = Integer.parseInt(line.split(" ")[2]) ;
            sleepList.remove(index - 1);
            fileHandler.writeEntries(sleepList);
            SleepListUi.deleteMessage();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(SleepListUi.deleteLogIndexMessage());
        } catch (NumberFormatException e) {
            System.out.println(SleepListUi.deleteLogNumberMessage());
        }
    }

    public void printSleepList() {
        if (this.sleepList.isEmpty()) {
            SleepListUi.emptyListMessage();
        } else {
            SleepListUi.sleepListHeader();
            for (int i = 0; i < this.sleepList.size(); i++) {
                System.out.println("\t " + (i + 1)+ ". " + getSleep(i).toString());
            }
        }
    }

    public int getSize() {
        return sleepList.size();
    }
}
