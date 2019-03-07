package callendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Callendar {
    private Date currentTime = new java.util.Date();
    private Calendar calendar = new GregorianCalendar();
    private Hours_Days cControl = new Hours_Days();

    public void getCallendar() {
        System.out.println("Now: " + calendar.get(Calendar.DATE) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR));
    }

    public void getCallendarDayNow() {
        cControl.theDay(calendar.get(Calendar.DAY_OF_WEEK));
    }

    public void setCallenadrDayOfVisit(int day, int month, int year) {
        month--;
        calendar.set(year, month, day);
        System.out.println("Than: " + calendar.get(Calendar.DATE) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR));
        cControl.theDay(calendar.get(Calendar.DAY_OF_WEEK));
        calendar.setTime(currentTime);
    }

    public String getDayThan(int day, int month, int year) {
        calendar.set(year, month, day);
        String dayThan = cControl.theDay(calendar.get(Calendar.DAY_OF_WEEK));
        calendar.setTime(currentTime);
        return dayThan;
    }
}