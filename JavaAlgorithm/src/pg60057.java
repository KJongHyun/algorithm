import java.util.ArrayList;
import java.util.List;

public class pg60057 {
    public static void main(String[] args) {
        String s = "a";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int ans = 1001;
        int maxDivideLength = (s.length() / 2) > 0 ? (s.length() / 2) : 1;

        for (int size = 1; size <= maxDivideLength; size++) {
            List<String> tokens = new ArrayList<>();
            for (int start = 0; start < s.length(); start += size) {
                tokens.add(s.substring(start, Math.min(s.length(), start + size)));
            }


            StringBuilder sb = new StringBuilder();
            int sameCount = 0;
            int index = 0;
            String tempToken = "";
            for (String token : tokens) {
                if (tempToken.equals(token)) {
                    sameCount++;
                    if (index == tokens.size() - 1) {
                        if (sameCount > 1)
                            sb.append(sameCount);
                    }
                } else {
                    if (sameCount > 1)
                        sb.append(sameCount);
                    sb.append(token);
                    tempToken = token;
                    sameCount = 1;
                }
                index++;
            }


            ans = Math.min(ans, sb.toString().length());
        }

        return ans;
    }
}
