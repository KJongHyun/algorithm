import java.util.*;

public class pg17678 {

    public static void main(String[] args) {
        String[] timeTable = {"09:10", "09:09", "08:00"};
        System.out.println(solution(2, 10, 2, timeTable));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int startTime = 540;
        int lastTime = startTime + (n - 1) * t;
        List<Integer> minuteList = new ArrayList<>();

        for (String strTime : timetable) {
            minuteList.add(convertStringTimeToMinutes(strTime));
        }

        Collections.sort(minuteList);

        Stack<Integer> bus = null;
        startTime -= t;
        for (int i = 0; i < n; i++) {
            startTime += t;
            bus = new Stack<>();
            int index = 0;
            int count = 0;
            while(index < minuteList.size() && count < m) {
                Integer crewTime = minuteList.get(index);
                if (crewTime <= startTime) {
                    bus.push(crewTime);
                    index++;
                    count++;
                } else
                    break;
            }
            minuteList = minuteList.subList(index, minuteList.size());
        }

        // 자리가 빈경우
        if (bus.size() < m)
            answer = convertMinutesStringTime(lastTime);
        else {
            Integer lastCrewTime = bus.pop();
            answer = convertMinutesStringTime(lastCrewTime - 1);
        }

        return answer;
    }


    public static int convertStringTimeToMinutes(String time) {
        String[] timeArr = time.split(":");
        int minutes = 0;
        minutes += Integer.parseInt(timeArr[0]) * 60;
        minutes += Integer.parseInt(timeArr[1]);

        return minutes;
    }

    public static String convertMinutesStringTime(Integer minutes) {
        String strHour = Integer.toString(minutes / 60);
        String strMinutes = Integer.toString(minutes % 60);
        if (strHour.length() == 1)
            strHour = "0" + strHour;
        if (strMinutes.length() == 1)
            strMinutes = "0" + strMinutes;
        return strHour + ":" + strMinutes;
    }

}
