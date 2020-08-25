public class leetCode7 {
    public static void main(String[] args) {
        System.out.println(reverse(-120));
    }
    public static int reverse(int x) {
        long ans = 0;
        while (x != 0 ) {
            int pop = x % 10;
            x = x / 10;
            ans = ans * 10 + pop;
            if (ans > Integer.MAX_VALUE)
                return 0;
            if (ans < Integer.MIN_VALUE)
                return 0;
        }
        return (int)ans;
    }
}
