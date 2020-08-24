import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class pg17676 {
    static int durationSecond = 999 * 1000000;

    public static void main(String[] args) {
        String[] lines = {
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };

        String[] lines2 = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };
        System.out.println(solution(lines2));
    }

    public static int solution(String[] lines) {

        List<TimeData> timeDataList = convertTimeData(lines);


        int max = 0;
        for(TimeData timeData : timeDataList) {
            int include = 0;
            TimeData duration = new TimeData(timeData.startDateTime, timeData.startDateTime.plusNanos(durationSecond));
            for (TimeData timeData1 : timeDataList) {
                if (isIncludeTime(duration, timeData1.startDateTime) || isIncludeTime(duration, timeData1.endDateTime))
                    include++;
            }
            if (max < include)
                max = include;
            include = 0;
            duration = new TimeData(timeData.endDateTime, timeData.endDateTime.plusNanos(durationSecond));
            for (TimeData timeData2 : timeDataList) {
                if (isIncludeTime(duration, timeData2.startDateTime) || isIncludeTime(duration, timeData2.endDateTime))
                    include++;
            }
            if (max < include)
                max = include;
        }

        return max;
    }

    public static boolean isIncludeTime(TimeData duration, LocalDateTime target) {
        return target.isEqual(duration.startDateTime) || target.isEqual(duration.endDateTime) || (target.isAfter(duration.startDateTime) && target.isBefore(duration.endDateTime));
    }

    public static List<TimeData> convertTimeData(String[] lines) {
        List<TimeData> timeDataList = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(" ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime currentLocalDateTime = LocalDateTime.parse(split[0] + " " + split[1], formatter);
            LocalDateTime startLocalDateTime = currentLocalDateTime;
            LocalDateTime endLocalDateTime = currentLocalDateTime;
            int amountNanoSeconds = (int)(Double.parseDouble(split[2].replace("s", "")) * 1000.0 - 1.0);
            int seconds = amountNanoSeconds / 1000;
            int nanoSeconds = amountNanoSeconds % 1000;
            startLocalDateTime = startLocalDateTime.minusSeconds(seconds);
            startLocalDateTime = startLocalDateTime.minusNanos(nanoSeconds * 1000000);

            timeDataList.add(new TimeData(startLocalDateTime, endLocalDateTime));
        }

        return timeDataList;
    }

    static class TimeData {

        LocalDateTime startDateTime;
        LocalDateTime endDateTime;

        TimeData(LocalDateTime startDateTime, LocalDateTime endDateTime) {
            this.startDateTime = startDateTime;
            this.endDateTime = endDateTime;
        }

    }

}
