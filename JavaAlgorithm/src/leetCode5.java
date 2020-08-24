public class leetCode5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babadada"));
    }
    public static String longestPalindrome(String s) {
        String ans = s.substring(0, s.length() >= 1 ? 1 : 0);
        for (int i = 0; i < s.length(); i++) {
            char targetCharacter = s.charAt(i);
            for (int j = s.length() - 1; j >= 0; j--) {
                if (targetCharacter == s.charAt(j)) {
                    String subStr = s.substring(i, j + 1);
                    if (isPalindrome(subStr)) {
                        if (ans.length() < subStr.length())
                            ans = subStr;
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public static boolean isPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return str.equals(stringBuilder.reverse().toString());
    }
}
