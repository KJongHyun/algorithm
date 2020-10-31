public class Mobility1 {
    public static void main(String[] args) {
        System.out.println(solution(1));
    }

    public static int solution(int num) {
        int ans = 0;


        for (int i = 1; i <= num; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != '0' && (s.charAt(j) - '0') % 3 == 0) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}
