package seedu.lifetrack.calorielist;

import seedu.lifetrack.activity.Activity;
import seedu.lifetrack.calories.Calorie;

public class Entry {

    private Activity activity;
    private Calorie calorie;

    public Entry(Activity activity, Calorie calorie){
        this.calorie = calorie;
        this.activity= activity;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Calorie getCalorie() {
        return calorie;
    }

    public void setCalorie(Calorie calorie) {
        this.calorie = calorie;
    }
}