public class MedianTwoSortedArrays {
    public static void main(String[] args) {

    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] addedArr = addArrays(nums1, nums2);
        int medianIndex = nums1.length + nums2.length / 2;

        if (medianIndex % 2 == 0) {
            return (addedArr[medianIndex - 1] + addedArr[medianIndex] / 2.0);
        } else {
            return addedArr[medianIndex];
        }
    }
    
    public int[] addArrays(int[] a1, int[] a2) {
        int size = (a1.length < a2.length) ? a1.length : a2.length;
        int[] result = new int[a1.length + a2.length];
        int cur1 = 0;
        int cur2 = 0;

        while (cur1 < size && cur2 < size) {
            if (a1[cur1] < a2[cur2]) {
                result[cur1 + cur2] = a1[cur1];
                cur1++;
            } else if (a1[cur1] > a2[cur2]) {
                result[cur1 + cur2] = a2[cur2];
                cur2++;
            } else {
                result[cur1 + cur2] = a1[cur1];
                cur1++;
                result[cur1 + cur2] = a2[cur2];
                cur2++;
            }
        }
        
        while (cur1 < size) {
            result[cur1 + cur2] = a1[cur1];
            cur1++;
        }

        while (cur2 < size) {
            result[cur1 + cur2] = a1[cur2];
            cur2++;
        }

        return result;
    }
    
}