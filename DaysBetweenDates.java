import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Task 2: Number of days between two dates.
 */
public class DaysBetweenDates {

    /**
     * Returns the number of days from the first date to the second date.
     * The result is positive if the "to" date is later than the "from" date,
     * negative if it is earlier, and 0 if both dates are the same.
     */
    public static long daysBetween(int year_from, int month_from, int day_from,
                                   int year_to, int month_to, int day_to) {
        LocalDate from = LocalDate.of(year_from, month_from, day_from);
        LocalDate to = LocalDate.of(year_to, month_to, day_to);
        return ChronoUnit.DAYS.between(from, to);
    }

    public static void main(String[] args) {
        System.out.println(daysBetween(2024, 1, 1, 2024, 12, 31)); // 365 (leap year)
        System.out.println(daysBetween(2026, 11, 11, 2026, 12, 25)); // 44
        System.out.println(daysBetween(2025, 5, 10, 2025, 5, 10));   // 0
    }
}
