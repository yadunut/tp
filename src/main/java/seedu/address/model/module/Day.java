package seedu.address.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a ModuleTiming's day in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDay(String)}
 */
public class Day {
    public static final String MESSAGE_CONSTRAINTS =
            "Day should be in the format like Mon, Tue, Wed, Thu, Fri, Sat, Sun";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
    private final DayOfWeek day;

    /**
     * Constructs a {@code Timing}.
     *
     * @param day A valid hour in day format.
     */
    public Day(String day) {
        requireNonNull(day);

        checkArgument(isValidDay(day), MESSAGE_CONSTRAINTS);

        this.day = DayOfWeek.from(formatter.parse(day));
    }

    /**
     * Returns true if a given day string is in the valid day format.
     */
    public static boolean isValidDay(String day) {
        try {
            DayOfWeek parsedDay = DayOfWeek.from(formatter.parse(day));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public DayOfWeek getDay() {
        return day;
    }
}
