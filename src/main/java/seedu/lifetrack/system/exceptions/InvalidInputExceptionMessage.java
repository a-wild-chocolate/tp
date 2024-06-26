//@@author owx0130
package seedu.lifetrack.system.exceptions;

import java.time.LocalDate;

/**
 * Utility class for managing error messages related to invalid input exceptions.
 */
public class InvalidInputExceptionMessage {

    private static final String HEADER = "\t Invalid input!\n";
    private static final String CALORIES_IN_INPUT = "\t Example input: calories in DESCRIPTION " +
            "c/INTEGER_CALORIES d/DATE [m/MACROS]";
    private static final String CALORIES_OUT_INPUT = "\t Example input: calories out DESCRIPTION " +
            "c/INTEGER_CALORIES d/DATE";
    private static final String MACROS_INPUT = "\t Example input: ....... m/CARBS_INT, PROTEIN_INT, FATS_INT";
    private static final String SLEEP_IN_INPUT = "\t Example input: sleep add 7.5 d/2024-03-11" ;
    private static final String HYDRATION_IN_INPUT = "\t Example input: hydration in Milo v/1000 d/2024-04-19" ;
    private static final String USER_SETUP_INPUT = "\t Example input: user setup Tom h/170 w/80 a/25 s/male e/4 g/3";
    private static final String USER_UPDATE_FIELDS = "\t 1) user update name <NAME>\n"+
            "\t 2) user update height <HEIGHT>\n" +
            "\t 3) user update weight <WEIGHT>\n" +
            "\t 4) user update age <AGE>\n" +
            "\t 5) user update sex <SEX>\n" +
            "\t 6) user update exercise levels <EXERCISE LEVELS>\n" +
            "\t 7) user update goal <GOAL>";

    //general error messages
    public static String getInvalidDateMessage() {
        String message = "\t Invalid date! Please enter a valid date in format YYYY-MM-DD.";
        return message;
    }

    public static String getDateLaterThanPresentDateMessage() {
        String message = "\t Invalid date! Please enter a date that is not later than today's date: " + LocalDate.now();
        return message;
    }

    //calories list related messages
    public static String getCaloriesIncorrectOrderMessage() {
        String message = "\t Please ensure that you have keyed the input in the correct order!\n";
        return HEADER + message + CALORIES_IN_INPUT;
    }

    public static String getCaloriesDuplicateKeywordMessage() {
        String message = "\t Please ensure there are no duplicate c/ or d/ or m/ keywords!\n";
        return HEADER + message + CALORIES_IN_INPUT;
    }

    public static String getIncorrectCaloriesInputMessage() {
        return "\t Please input only positive integers into the calories field!";
    }

    public static String getCaloriesOverLimitMessage() {
        return "\t Please ensure that calories is within the limit of 5000 calories per entry!";
    }

    public static String getCaloriesMissingKeywordsMessage() {
        String message = "\t Please ensure that you have entered all keywords!\n";
        return HEADER + message + CALORIES_IN_INPUT;
    }

    public static String getWhitespaceInInputMessage() {
        String message = "\t Please ensure that there is no whitespace in your input!\n";
        return HEADER + message + CALORIES_IN_INPUT;
    }

    public static String getHydrationWhitespaceInInputMessage() {
        String message = "\t Please ensure that there is no whitespace in your input!\n";
        return HEADER + message + HYDRATION_IN_INPUT;
    }

    public static String getEmptyMacrosMessage() {
        String message = "\t Your macronutrients field is empty!\n";
        return HEADER + message + MACROS_INPUT;
    }

    public static String getIncorrectMacrosInputMessage() {
        return "\t Please input only positive integers into the macronutrients field!";
    }

    public static String getMacrosOverLimitMessage() {
        return "\t Please ensure that all macros entered are within the limit of 800g per macro per entry!";
    }

    public static String getIncompleteMacrosMessage() {
        String message = "\t Please ensure that all macronutrients fields are filled up!\n";
        return HEADER + message + MACROS_INPUT;
    }

    public static String getWhitespaceInMacrosInputMessage() {
        String message = "\t Please ensure that there is no whitespace in your macros input!\n";
        return HEADER + message + MACROS_INPUT;
    }

    public static String getMacrosInCaloriesOutMessage() {
        String message = "\t Calorie output entry cannot have macros!\n";
        return HEADER + message + CALORIES_OUT_INPUT;
    }

    //hydration list related messages
    public static String getHydrationMissingKeywordMessage() {
        String message = "\t Please ensure that you have entered all keywords!\n";
        return HEADER + message + HYDRATION_IN_INPUT;
    }

    public static String getHydrationIncorrectOrderMessage() {
        String message = "\t Please ensure that you have keyed the input in the correct order!\n";
        return HEADER + message + HYDRATION_IN_INPUT;
    }

    public static String getHydrationEmptyDescriptionMessage() {
        String message = "\t Please ensure that beverage and volume is not empty!\n";
        return HEADER + message + HYDRATION_IN_INPUT;
    }

    public static String getHydrationNegativeIntegerVolumeMessage() {
        String message = "\t Please ensure that positive integer value is keyed in for volume!\n";
        return HEADER + message + HYDRATION_IN_INPUT;
    }

    public static String getHydrationOverVolumeLimitMessage() {
        String message = "\t Please ensure that volume is not more than 10000!\n";
        return HEADER + message + HYDRATION_IN_INPUT;
    }

    public static String getHydrationDuplicateInputsMessage() {
        String message = "\t Please ensure that there are no duplicate v/ or d/ inputs!\n";
        return HEADER + message + HYDRATION_IN_INPUT;
    }

    public static String getIncorrectVolumeInputMessage() {
        return "\t Please input only positive integers into the volume field!";
    }

    //sleep list related messages
    //@@author a-wild-chocolate
    public static String getSleepMissingKeywordMessage() {
        String message = "\t Please ensure that you have entered all keywords!\n";
        return HEADER + message + SLEEP_IN_INPUT;
    }

    public static String getIncorrectSleepInputMessage() {
        return "\t Please input one positive real number into the sleep duration field!";
    }

    public static String getIncorrectSleepDeleteMessage() {
        return "\t Please input delete command in correct format: sleep delete SLEEPID ";
    }

    public static String getEmptySleepListMessage() {
        return "\t Sorry, there is no sleep record in the sleep list." +
                                        "You cannot delete sleep entry.";
    }

    public static String getTooLongSleepDurationMessage() {
        return "\t Please enter a sleep duration less than 24 hours.";
    }

    public static String getSleepDurationSumTooLongMessage() {
        return "\t Sorry, your sum of sleep duration exceeds 24 hours in this day. This record failed to add " +
                "into the list. Please ensure your sum of duration of a day do not exceed 24 hours.";
    }
    //@@author

    //user related messages
    public static String getOutOfGoalRangeMessage() {
        return "\t Invalid Goal input!\n " +
                "Please key in a number between 1 and 5!\n " +
                "1 being quick fat loss " +
                "and 5 being quick bulking";
    }

    public static String getOutOfExerciseLevelsRangeMessage() {
        return "\t Invalid Exercise Level input!\n" +
                "\t Please key in a number between 1 and 5!\n" +
                " 1 being little exercise done per week and 5 being" +
                " very heavy levels of exercise done per week.";
    }

    public static String getEmptyUserSetupInputMessage() {
        return HEADER + "\t Please key in the relevant user fields!\n" + USER_SETUP_INPUT;
    }

    public static String getInvalidNumberOfSetUpInputs() {
        return "\t Sorry, this command is invalid. Please enter the setup command in the following format " +
                "user setup {NAME} h/{HEIGHT} w/{WEIGHT} a/{AGE} s/{SEX} e/{EXERCISE LEVELS} g/{GOAL}";
    }

    public static String getInvalidGoalNumberMessage() {
        return "\t Invalid input for goal number. Please enter a number between 1 and 5.";
    }

    public static String getInvalidExerciseLevelsNumberMessage() {
        return "\t Invalid input for exercise level. Please enter a number between 1 and 5.";
    }

    public static String getHeightOutOfRangeMessage() {
        return "\t Please enter a valid height!";
    }

    public static String getInvalidHeightNumberMessage(){
        return "\t Please enter your height(in cm) as an integer!";
    }

    public static String getWeightOutOfRangeMessage(){
        return "\t Please enter a valid weight!";
    }

    public static String  getInvalidWeightNumberMessage(){
        return "\t Please enter your weight(in kg) as an integer!";
    }

    public static String getUnderAgeMessage(){
        return "\t You are too young to use this app :(";
    }

    public static String getAgeOutOfRangeMessage(){
        return "\t Please enter a valid age!";
    }

    public static String getInvalidAgeNumberMessage(){
        return "\t Please enter your age as an integer!";
    }
    public static String getEmptyUserUpdateInputMessage() {
        return "\t Please enter your name!";
    }
    public static String getUnknownUpdateMessage() {
        return "\t Oops, I've not seen this command before!\n" +
                "\t Here are a list of possible update commands:\n" + USER_UPDATE_FIELDS;
    }

    public static String getEmptyGenderInputMessage() {
        return "\t Please enter your gender!";
    }

    public static String getInvalidGenderInputMessage() {
        return "\t Please enter either male or female as your gender!";
    }

    public static String getEmptyNameInputMessage() {
        return "\t Please enter a non-empty name!";
    }

    public static String getEmptyUserUpdateFieldMessage(){
        return "\t Please include the value you would like to update the field to as such:\n" + USER_UPDATE_FIELDS;
    }

    public static String getReachedMaximumSleepMessage(){
        return "\t Invalid input! The total duration you have slept on this day exceeds 24 hours!";
    }
}
