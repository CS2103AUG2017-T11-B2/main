package seedu.address.model.task;

import javafx.beans.property.ObjectProperty;

public interface ReadOnlyTask {

    ObjectProperty<Appointment> appointmentProperty();
    Appointment getAppointment();
    ObjectProperty<Date> dateProperty();
    Date getDate();
    ObjectProperty<StartTime> startTimeProperty();
    StartTime getStartTime();

    /**
     * Returns true if both have the same state. (interfaces cannot override .equals)
     */
    default boolean isSameStateAs(ReadOnlyTask other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getAppointment().equals(this.getAppointment()) // state checks here onwards
                && other.getDate().equals(this.getDate())
                && other.getStartTime().equals(this.getStartTime()));
    }

    /**
     * Formats the person as text, showing all contact details.
     */
    default String getAsText() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getAppointment())
                .append(" Date: ")
                .append(getDate())
                .append(" StartTime: ")
                .append(getStartTime());
        return builder.toString();
    }
}
