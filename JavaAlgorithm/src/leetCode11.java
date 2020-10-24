public class leetCode11 {

    public static void main(String[] args) {
        int[] height = {1,2, 1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int nextLeft = left;
        int right = 1;

        int max = Integer.MIN_VALUE;

        while (right < height.length) {
            int heightLength = Math.min(height[left], height[right]);
            int widthLength = right - left;
            int waterAmount = heightLength * widthLength;

            int newHeightLength = Math.min(height[nextLeft], height[right]);
            int newWidthLength = right - nextLeft;
            int newWaterAmount = newHeightLength * newWidthLength;

            if (left == nextLeft) {
                if (max < waterAmount)
                    max = waterAmount;
            } else if (waterAmount < newWaterAmount) {
                left = nextLeft;
                max = newWaterAmount;
            }

            if (height[left] < height[right])
                nextLeft = right;

            right++;
        }

        return max;
    }

}
