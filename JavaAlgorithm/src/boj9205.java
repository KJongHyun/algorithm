import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9205 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.valueOf(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int x = Integer.valueOf(st.nextToken());
                int y = Integer.valueOf(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine(), " ");
            int rX = Integer.valueOf(st.nextToken());
            int rY = Integer.valueOf(st.nextToken());
        }
    }

}
