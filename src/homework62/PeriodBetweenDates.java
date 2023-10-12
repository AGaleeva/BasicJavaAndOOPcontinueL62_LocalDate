package homework62;

import java.time.LocalDate;
import java.time.Period;

public class PeriodBetweenDates {
    /*
    Задача 2.
    Создайте метод, который принимает две даты LocalDate, а возвращает строку, сколько времени между ними пройдет.

    Например: "10 years, 2 months, 3 days"

    Используйте класс Period
    */

    public static void main(String[] args) {

        LocalDate date1 = LocalDate.of(2022, 05, 12);
        LocalDate date2 = LocalDate.of(2023, 07, 13);

        System.out.println(periodBetweenDatesToString(date1, date2));
    }
    public static String periodBetweenDatesToString(LocalDate date1, LocalDate date2) {
        Period timeSpan = date1.isBefore(date2) ? Period.between(date1, date2) : Period.between(date2, date1);
        return timeSpan.getYears() + " year(s), " + timeSpan.getMonths() + " month(s), " + timeSpan.getDays() + " " +
                "day(s)";
    }
}
