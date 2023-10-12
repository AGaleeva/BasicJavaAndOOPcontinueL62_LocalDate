package newAPI_toWorkWithDate_Local;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class LocalDemo {
    public static void main(String[] args) {
//        Java 8 - new API to work with date and time
//        LacalDate - day, month, year
//        LocalTime - as at Clock
//        LocalDateTime - all together: day, month, year + current time
//        The standard of the time occurrence is ISO 8601

//        1. How to create an instance
//        of(), now()

        LocalDate today = LocalDate.now();
        System.out.println(today); // 2023-10-12
//      set date manually
        LocalDate tomorrow = LocalDate.of(2023, 10, 13);
        System.out.println(tomorrow); // 2023-10-13

        LocalTime moment = LocalTime.now();
        System.out.println(moment); // 10:51:34.308382300
        LocalTime endOfLesson = LocalTime.of(13, 0, 0);

        LocalDateTime thisPointInTime = LocalDateTime.now();
        System.out.println(thisPointInTime); // 2023-10-12T10:55:40.205482500
        LocalDateTime endOfTomorrowLesson =
                LocalDateTime.of(2023, 10,13, 13, 0, 0);
        LocalDateTime endOfTomorrowClass = LocalDateTime.of(tomorrow, endOfLesson);
        System.out.println(endOfTomorrowLesson); // 2023-10-13T13:00
        System.out.println(endOfTomorrowClass); // 2023-10-13T13:00

//        2. Immutability
//        All Local classes are immutable!!!

        today.plusDays(2); // так изменить нельзя, можно только положить в новую переменную
        LocalDate dayAfterTomorrow = today.plusDays(2);
        System.out.println(today);
        System.out.println(dayAfterTomorrow);

//        Для изменения времени есть методы со словами: plus... , minus...
        LocalDate dayOfNextWeek = today.plusDays(7);
        System.out.println(dayOfNextWeek); // 2023-10-19
        LocalDate dayOfLastWeek = today.minusDays(7);
        System.out.println(dayOfLastWeek); // 2023-10-05

//        .plusDays(), plusMonths(), plusYears()
//        .minusDays(), minusMonths(), minusYears()

        LocalTime consultation = endOfLesson.plusHours(2).plusMinutes(30);
        System.out.println(consultation); // 15:30
        LocalTime consultation2 = LocalTime.of(15, 30);
        System.out.println(consultation2);

//        3. Getting fields values
        int numberOfDayToday = today.getDayOfMonth();
        System.out.println(numberOfDayToday); // 12
        int numberOfDayFromYearBeginn = today.getDayOfYear();
        System.out.println(numberOfDayFromYearBeginn); // 285 - from the beginning of the year
        DayOfWeek todayDayOfWeek = today.getDayOfWeek();
        System.out.println(todayDayOfWeek);
        System.out.println(DayOfWeek.MONDAY); // this is enum !
        String germanDay = DayOfWeek.MONDAY.getDisplayName(TextStyle.FULL, Locale.GERMANY);
        System.out.println(germanDay);

//        так же можно получить LocalTime
        int currentHour = moment.getHour();
        System.out.println(currentHour);

        System.out.println("------------------------------ 4 --------------------------------------");

//        4. Period - time span
        LocalDate unity = LocalDate.of(1990, 10, 3);

//        We can calculate the period between two days
        Period period = Period.between(unity, today);
        System.out.println(period); // P33Y9D
        System.out.println(period.getYears()); // 33 years
        System.out.println(period.getMonths()); // 0
        System.out.println(period.getDays()); //  9 days

//        How else can we create a period?
        Period vacation = Period.of(0, 0, 14);
        System.out.println(vacation); // P14D
        int vacationLength = vacation.getDays();
        System.out.println(vacationLength); // 14

//        Assume that my vacation starts 2024.02.12
//        And my vacation is 14 days
//        We can calculate day of the end of vacation

        LocalDate startOfVacation = LocalDate.of(2024, 02, 12);
        LocalDate endOfVacation = startOfVacation.plus(vacation);
        System.out.println(endOfVacation); // 2024-02-26

//        5. How to parse string? How to format date?
//        Если строка приходит через дефис: 2022-12-12
//        parse
        LocalDate christmas = LocalDate.parse("2023-12-24");
        System.out.println(christmas); // 2023-12-24

//        if the format of coming date is different, we can use formatter: DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate orthodoxChristmas = LocalDate.parse("2024/01/07", formatter);
        System.out.println(orthodoxChristmas);

//        Format date
        String unitySlashStyle = formatter.format(unity);
        System.out.println(unitySlashStyle); // 1990/10/03

        System.out.println("---------------------------------------------------------------------------------");

//        Создайте класс Conference с полями:
//        - тема String
//        - время LocalDateTime
//        - ссылка на приглашение String
//        В конструкторе конференции нужно принимать отдельно две строки
//        date - "dd-MM-yyyy", time "HH-mm" и остальную необходимую информацию
//        Создайте лист конференций и отсортируйте их по возрастанию

        List<Conference> upcomingConferences = List.of(
                new Conference("Meeting 1", "07-11-2023", "15-00", "www.link1"),
                new Conference("Meeting 3", "12-01-2024", "15-00", "www.link3"),
                new Conference("Meeting 2", "08-12-2023", "15-00", "www.link2")
        );
        List<Conference> conferenceOrderesList = upcomingConferences.stream()
                .sorted(Comparator.comparing(Conference::getTime)).toList();
        System.out.println(conferenceOrderesList);

    }
}
