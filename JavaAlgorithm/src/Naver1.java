public class Naver1 {

    public static void main(String[] args) {
        int[] p = {5, 4, 7, 2, 0, 6};
        int[] c = {4, 6, 4, 9, 2, 3};
        System.out.println(solution(6, p , c));
    }

    public static String solution(int n, int[] p, int[] c) {

        int stock = 0;
        int orderCancel = 0;
        int sellSum = 0;
        int day;
        for (day = 0; day < n; day++) {

            int productCount = p[day];
            int orderCount = c[day];

            if (productCount + stock >= orderCount) {
                stock = productCount + stock - orderCount;
                int productPrice = getProductPrice(orderCancel);
                sellSum += orderCount * productPrice;
                orderCancel = 0;
            } else {
                orderCancel++;
                stock += productCount;
            }

            if (orderCancel == 3) {
                day++;
                break;
            }
        }

        double avg = sellSum /  (double)day;

        return String.format("%.2f", avg);
    }

    public static int getProductPrice(int orderCancel) {
        if (orderCancel == 0) {
            return 100;
        } else if (orderCancel == 1) {
            return 50;
        } else
            return 25;
    }
}
