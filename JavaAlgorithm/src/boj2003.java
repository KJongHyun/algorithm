import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int first = 0;
        int second = -1;

        int count = 0;
        int sum = 0;

        while(true) {
            if (sum < m) {
                second++;
                if (second == n)
                    break;
                sum += arr[second];
            } else if (sum >= m) {
                sum -= arr[first];
                first++;
            } else {
                count++;
            }
        }

        System.out.println(count);

    }

}
