public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = { 13, 15, 30, 48, 49, 73, 80 };
        System.out.println(binarySearch(0, arr.length - 1, 12, arr));
    }

    public static int binarySearch(int start, int end, int target, int[] arr) {
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            int nextEnd = mid - 1;
            if (nextEnd < 0)
                return -1;
            return binarySearch(start, nextEnd, target, arr);
        } else {
            int nextStart = mid + 1;
            if (nextStart > arr.length - 1)
                return -1;
            return binarySearch(nextStart, end, target, arr);
        }
    }
}
