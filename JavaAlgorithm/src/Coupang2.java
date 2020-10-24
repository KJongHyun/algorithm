import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

public class Coupang2 {
    public static void main(String[] args) {
        int n = 2;
        String[] customers = { "02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01" };
        System.out.println(solution(n, customers));
    }

    public static int solution(int n, String[] customers) {

        PriorityQueue<Kiosk> q = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            q.offer(new Kiosk(i));
        }

        int i = 1;
        for (String customerInfo : customers) {
            String[] split = customerInfo.split(" ");
            String start = "2020-"+ split[0] + "-" + split[1];

            int minutes = Integer.valueOf(split[2]);
            Kiosk kiosk = q.poll();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM/dd-HH:mm:ss");
            LocalDateTime startLocalDateTime = LocalDateTime.parse(start, dateTimeFormatter);

            if (kiosk.complete == null) {
                kiosk.complete = startLocalDateTime;
                kiosk.index = i++;
            }

            if (kiosk.complete.isBefore(startLocalDateTime)) {
                kiosk.complete = startLocalDateTime;
            }
            kiosk.complete = kiosk.complete.plusMinutes(minutes);
            kiosk.count++;
            System.out.println(kiosk.index + " " + kiosk.complete.toString());
            q.offer(kiosk);
        }

        int max = Integer.MIN_VALUE;

        while(!q.isEmpty()) {
            Kiosk kiosk = q.poll();
            if (kiosk.count > max) {
                max = kiosk.count;
            }
        }

        return max;
    }

    static class Kiosk implements Comparable<Kiosk> {
        int index;
        int count = 0;
        LocalDateTime complete;

        public Kiosk(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(Kiosk o) {
            if (this.complete == o.complete)
                return 0;
            if (this.complete == null) {
                return -1;
            } else if (o.complete == null) {
                return 1;
            }

            if (this.complete.isBefore(o.complete))
                return -1;
            else {
                if (this.complete.isEqual(o.complete)) {
                    if (this.count < o.count) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                return 1;
            }
        }
    }
}
