package cpp.model.project;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import cpp.Constants;

public class Deadline {

    private LocalDate date;

    public Deadline(String stringDate) {
        if (Constants.DAYS_OF_THE_WEEK.contains(stringDate.toUpperCase())) {
            DayOfWeek dateEnum = DayOfWeek.valueOf(stringDate.toUpperCase());
            LocalDate today = LocalDate.now();
            DayOfWeek todayEnum = today.getDayOfWeek();
            int daysApart = dateEnum.getValue() - todayEnum.getValue();
            daysApart = daysApart <= 0 ? Constants.DAYS_OF_THE_WEEK.size() - daysApart : daysApart;
            today.plusDays(daysApart);
            date = today;
        } else {
            try {
                date = LocalDate.parse(stringDate);
            } catch (DateTimeParseException e) {
                throw e;
            }
        }
    }

    @Override
    public String toString() {
        return date.toString();
    }
}