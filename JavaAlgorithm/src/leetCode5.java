public class leetCode5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babadada"));
    }
    public static String longestPalindrome(String s) {
        String ans = s.substring(0, s.length() >= 1 ? 1 : 0);
        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s.charAt(i));
            char targetCharacter = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                stringBuilder.append(s.charAt(j));
                if (targetCharacter == s.charAt(j)) {
                    if (isPalindrome(stringBuilder)) {
                        if (ans.length() < stringBuilder.length())
                            ans = stringBuilder.toString();
                    }
                }
            }
        }

        return ans;
    }

    public static boolean isPalindrome(StringBuilder str) {
        int i = 0;
        while (i <= str.length() / 2) {
            char a = str.charAt(i);
            char b = str.charAt(str.length() - 1 - i);
            if (a == b) {
                i++;
            } else {
                return false;
            }
        }

        return true;
    }
}
