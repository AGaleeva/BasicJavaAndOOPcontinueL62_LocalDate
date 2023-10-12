package homework61_OV;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Comparable<Person> {
    private String name;
    private Date birthDay;

    public Person(String name, String dob) throws ParseException {
        this.name = name;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        this.birthDay = sdf.parse(dob);
//        this.birthDay = stringToDate(dob);
    }

    /*private Date stringToDate(String dob) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.parse(dob);
    }*/

    public String getName() {
        return name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    @Override
    public String toString() {
        SimpleDateFormat sfd = new SimpleDateFormat("dd.MM.yyyy");
        return "Person{" + "name='" + name + '\'' + ", birthDay=" + sfd.format(birthDay) + '}';
    }

    @Override
    public int compareTo(Person o) {
        return o.birthDay.compareTo(this.birthDay);
    }
}
