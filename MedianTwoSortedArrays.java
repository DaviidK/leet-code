import java.util.Arrays;

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

    public static int median(int[] nums1, int[] nums2) {
        int combinedSize = nums1.length + nums2.length;

        // If combined array has even number of elements, we must find the average
        // of the middle index and the one after
        if (combinedSize % 2 == 0) {
            int middleValue = find_kth(combinedSize / 2, nums1, nums2);
            int middlePlusOneValue = find_kth((combinedSize / 2) + 1, nums1, nums2);
            return (middleValue + middlePlusOneValue) / 2.0;
        }

        // If combined array has odd number of elements, we can return the middle
        // element itself
        return find_kth(combinedSize / 2, nums1, nums2);
    }

    // Find kth value in two arrays
    public static int find_kth(int k, int[] nums1, int[] nums2) {
        // If array 1 is empty, return the kth value in array 2
        if (nums1.length == 0) {
            return nums2[k];
        }
        // If array 2 is empty, return the kth value in array 1
        if (nums2.length == 0) {
            return nums1[k];
        }

        // Find midpoints of both arrays
        int mid1 = nums1.length / 2;
        int mid2 = nums2.length / 2;

        // If k is larger than sum of both midpoints, then k is to the right 
        // of both indices
        if (k > mid1 + mid2) {
            // If the middle element of nums1 is larger than nums2, we can 
            // eliminate the left half of nums2
            if (nums1[mid1] > nums2[mid2]) {
                // We update k by subtracting the number of elements we have removed
                // from the left
                return find_kth(k - mid2 - 1, nums1, Arrays.copyOfRange(nums2, mid2 + 1, nums2.length));
            }
            // If the middle element of nums2 is larger than nums1, we can 
            // eliminate the left half of nums1
            else {
                return find_kth(k - mid1 - 1, Arrays.copyOfRange(nums1, mid1 + 1, nums1.length), nums2);
            }
        }
        
        // If k is smaller than sum of both midpoints, than k is to the left 
        // of both indices
        else {
            // If the middle element of nums1 is larger than nums2, we can 
            // eliminate the right half of nums1
            if (nums1[mid1] > nums2[mid2]) {
                // We don't update k because we are removing from the end of the
                // array
                return find_kth(k, Arrays.copyOfRange(nums1, 0, mid1), nums2);
                
            }
            // If the middle element of nums2 is larger than nums1, we can 
            // eliminate the right half of nums2
            else {
                return find_kth(k, nums1, Arrays.copyOfRange(nums2, 0, mid2));
            }
        }
    }
    
}


/*

111111

111999

*/