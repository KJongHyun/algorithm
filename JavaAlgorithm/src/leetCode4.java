
public class leetCode4 {
    public static void main(String[] args) {
        int[] nums1 = {100000};
        int[] nums2 = {100001};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0.0;
        int index = 0;
        int targetIndex;
        int point1 = 0;
        int point2 = 0;
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) {
            targetIndex = length / 2;
        } else {
            targetIndex = length / 2 - 1;
        }

        while (index < targetIndex) {
            int numb1 = point1 >= nums1.length ? 1001 : nums1[point1];
            int numb2 = point2 >= nums2.length ? 1001 : nums2[point2];

            if (numb1 > numb2) {
                point2++;
            } else {
                point1++;
            }

            index++;
        }

        int numb1 = point1 >= nums1.length ? 1001 : nums1[point1];
        int numb2 = point2 >= nums2.length ? 1001 : nums2[point2];


        if (length % 2 == 1) {
            if (numb1 > numb2) {
                ans = numb2;
            } else {
                ans = numb1;
            }
        } else {
            int sum = 0;
            if (numb1 > numb2) {
                sum += numb2;
                point2++;
            } else {
                sum += numb1;
                point1++;
            }

            numb1 = point1 >= nums1.length ? Integer.MAX_VALUE : nums1[point1];
            numb2 = point2 >= nums2.length ? Integer.MAX_VALUE : nums2[point2];

            if (numb1 > numb2) {
                sum += numb2;
            } else {
                sum += numb1;
            }

            ans = sum / 2.0;

        }


        return ans;
    }

    class PrePoint {
        int preIndex;
        int prePoint;

        public PrePoint(int preIndex, int prePoint) {
            this.preIndex = preIndex;
            this.prePoint = prePoint;
        }
    }
}
