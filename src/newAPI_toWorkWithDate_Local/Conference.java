package newAPI_toWorkWithDate_Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conference {
    private String title;
    private LocalDateTime time;
    private String invitationLink;

    public Conference(String title, String date, String time, String invitationLink) {
        this.title = title;
        this.time = stringsToDate(date, time);
        this.invitationLink = invitationLink;
    }

    private LocalDateTime stringsToDate(String date, String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy" + "HH-mm");
        return LocalDateTime.parse(date + time, formatter);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getInvitationLink() {
        return invitationLink;
    }

    public void setInvitationLink(String invitationLink) {
        this.invitationLink = invitationLink;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy" + ", " + "HH-mm");
        return "Conference{" + "title='" + title + '\'' + ", time=" + formatter.format(time) + ", invitationLink='" + invitationLink + '\'' + '}';
    }
}
