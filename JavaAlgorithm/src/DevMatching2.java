import java.time.LocalDate;
import java.util.*;
public class DevMatching2 {
    static final int HOUR_TO_SECOND = 3600;
    static final int MINUTE_TO_SECOND = 60;
    public static void main(String[] args) {
        System.out.println(solution("AM 12:00:59", 10));
    }
    public static String solution(String p, int n) {
        String[] split = p.split(" |:");
        String measure = split[0];
        int rawHours = Integer.valueOf(split[1]);
        int hours;
        if (rawHours == 12) {
            hours = measure.equals("PM") ? rawHours : rawHours - 12;
        } else {
            hours = measure.equals("PM") ? rawHours + 12 : rawHours;
        }

        int minutes = Integer.valueOf(split[2]);
        int seconds = Integer.valueOf(split[3]);

        System.out.println(hours + ":" + minutes + ":" + seconds);

        int amountSeconds = hours * HOUR_TO_SECOND + minutes * MINUTE_TO_SECOND + seconds + n;

        int newHour = (amountSeconds / HOUR_TO_SECOND) % 24;
        amountSeconds %= HOUR_TO_SECOND;

        int newMinutes = amountSeconds / MINUTE_TO_SECOND;
        int newSeconds = amountSeconds % MINUTE_TO_SECOND;

        return String.join(":", addZero(String.valueOf(newHour)), addZero(String.valueOf(newMinutes)), addZero(String.valueOf(newSeconds)));
    }

    public static String addZero(String timeData) {
        return timeData.length() == 1 ? "0" + timeData : timeData;
    }
}
