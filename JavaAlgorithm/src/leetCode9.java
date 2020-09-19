public class leetCode9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1212));
    }

    public static boolean isPalindrome(int x) {
        String strX = String.valueOf(x);
        StringBuilder sb = new StringBuilder(strX);
        return sb.reverse().toString().equals(strX);
    }

}
