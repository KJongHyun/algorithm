public class leetCode10 {

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }

    public static boolean isMatch(String s, String p) {
        return s.matches(p);
    }

}
