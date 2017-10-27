package seedu.address.model.task;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Birthday;

import static java.util.Objects.requireNonNull;

public class StartTime {

    public static final String MESSAGE_TIME_CONSTRAINTS =
            "StartTime must be in the format of HH/MM";

    public static final String TIME_VALIDATION_REGEX =
            "\\d{2}:\\d{2}";
    public final String value;

    //Validates given Birthday.
    public StartTime(String startTime) throws IllegalValueException {
        requireNonNull(startTime);
        String trimmedTime = startTime.trim();
        if (!isValidTime(trimmedTime)) {
            throw new IllegalValueException(MESSAGE_TIME_CONSTRAINTS);
        }
        this.value = trimmedTime;
    }

    /**
     * Returns true if a given String is a valid Birthday.
     */
    public static boolean isValidTime(String test) {
        return test.matches(TIME_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this //short circuit if same object
                || (other instanceof StartTime
                && this.value.equals(((StartTime) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
