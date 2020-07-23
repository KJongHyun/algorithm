


public class pg157449 {

    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static int max = -1;
    static int sK;

    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4));
    }
    public static String solution(String number, int k) {
        char[] chars = number.toCharArray();
        int start = 0;
        StringBuilder sb = new StringBuilder();

        int choiceLength = chars.length - k;
        for (int i = 1; i <= chars.length - k; i++) {
            int maxIndex = start;
            for (int j = start; j < chars.length - choiceLength + i; j++) {
                if (chars[maxIndex] - '0' < chars[j] - '0') {
                    maxIndex = j;
                }
            }
            sb.append(chars[maxIndex]);
            start = maxIndex + 1;
        }

        return sb.toString();
    }


}
