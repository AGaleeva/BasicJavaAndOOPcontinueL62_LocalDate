package homework61_OV;

import java.text.ParseException;
import java.util.List;

public class PersonBD_Appl {
     /*
    Создайте класс Person, c полями имя(стринг) и дата рождения(Date), которому при создании передавайте имя
    и дату рождения в виде строки в формате "ДД.ММ.ГГГГ".

    Реализуйте в классе интерфейс Comparable<Person>, в котором "меньше" будет значить "младше".

    Подсказка: не обязательно вычислять возраст, этому мы так и не научились. Но можно сравнивать даты рождения!
    */

    public static void main(String[] args) throws ParseException {

        List<Person> persons = List.of(
                new Person("John Watts", "22.05.1914"),
                new Person("Ann Freud", "22.06.1902"),
                new Person("John Booth", "22.05.1917"),
                new Person("Will Weathers", "22.05.1976")
        );


        List<Person> ordered = persons.stream().sorted().toList();
        System.out.println(ordered);

    }
}
