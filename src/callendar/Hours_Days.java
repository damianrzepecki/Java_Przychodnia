package callendar;

import java.util.HashMap;
import java.util.Map;

public class Hours_Days {

    private Map<Integer, String> hoursAday = new HashMap<>();

    public Map<Integer, String> getHoursAday() {
        return hoursAday;
    }

    private void definehoursAday() {
        hoursAday.put(1, "8:00");
        hoursAday.put(2, "8:30");
        hoursAday.put(3, "9:00");
        hoursAday.put(4, "9:30");
        hoursAday.put(5, "10:00");
        hoursAday.put(6, "10:30");
        hoursAday.put(7, "11:00");
        hoursAday.put(8, "11:30");
        hoursAday.put(9, "12:00");
        hoursAday.put(10, "12:30");
        hoursAday.put(11, "13:00");
        hoursAday.put(12, "13:30");
        hoursAday.put(13, "14:00");
        hoursAday.put(14, "14:30");
        hoursAday.put(15, "15:00");
        hoursAday.put(16, "15:30");
        hoursAday.put(17, "16:00");
    }

    public String getHoursAday(int x) {
        definehoursAday();
        if (hoursAday.containsKey(x)) {
            return hoursAday.get(x);
        }
        return null;
    }

    public String theDay(int Day) {
        switch (Day) {
            case 1:
                return "Niedziela";
            case 2:
                return "Poniedzialek";
            case 3:
                return "Wtorek";
            case 4:
                return "Sroda";
            case 5:
                return "Czwartek";
            case 6:
                return "Piątek";
            case 7:
                return "Sobota";
        }
        return null;
    }
}