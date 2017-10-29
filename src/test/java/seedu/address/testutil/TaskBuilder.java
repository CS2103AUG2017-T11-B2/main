package seedu.address.testutil;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.mod.Mod;
import seedu.address.model.person.*;
import seedu.address.model.task.*;
import seedu.address.model.util.SampleDataUtil;

import java.util.Set;

/**
 * A utility class to help with building Person objects.
 */
public class TaskBuilder {

    public static final String DEFAULT_APPOINTMENT = "Anniversary";
    public static final String DEFAULT_DATE = "25/11/2017";
    public static final String DEFAULT_STARTTIME = "11:00";

    private Task task;

    public TaskBuilder() {
        try {
            Appointment defaultAppointment = new Appointment(DEFAULT_APPOINTMENT);
            Date defaultDate = new Date(DEFAULT_DATE);
            StartTime defaultStartTime = new StartTime(DEFAULT_STARTTIME);
            this.task = new Task(defaultAppointment, defaultDate, defaultStartTime);
        } catch (IllegalValueException ive) {
            throw new AssertionError("Default task's values are invalid.");
        }
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public TaskBuilder(ReadOnlyTask taskToCopy) {
        this.task = new Task(taskToCopy);
    }

    /**
     * Sets the {@code Appointment} of the {@code Task} that we are building.
     */
    public TaskBuilder withAppointment(String name) {
        this.task.setAppointment(new Appointment(name));
        return this;
    }

    /**
     * Sets the {@code Date} of the {@code Task} that we are building.
     */
    public TaskBuilder withDate(String date) {
        try {
            this.task.setDate(new Date(date));
        } catch (IllegalValueException ive) {
            throw new IllegalArgumentException("date is expected to be unique.");
        }
        return this;
    }

    /**
     * Sets the {@code StartTime} of the {@code StartTime} that we are building.
     */
    public TaskBuilder withStartTime(String startTime) {
        try {
            this.task.setStartTime(new StartTime(startTime));
        } catch (IllegalValueException ive) {
            throw new IllegalArgumentException("startTime is expected to be unique.");
        }
        return this;
    }

    public Task build() {
        return this.task;
    }

}
