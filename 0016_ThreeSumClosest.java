import java.util.Arrays;

public class ThreeSumClosest {
  public static void main(String[] args) {
    // Instantiate arrays for test cases and targets
    int[][] testCases = { {-1,2,1,-4},
                          {0,0,0},
                          {2,5,6,8,-9},
                          {-1, 0, -2, -5, 0, -9, -4} };
    int[] targets = {1, 1, 5, -2};

    System.out.println("closestThreeSum([-1,2,1,-4], 1) = " + closestThreeSum(testCases[0], targets[0]));
    System.out.println("closestThreeSum([0,0,0], 1) = " + closestThreeSum(testCases[1], targets[1]));
    System.out.println("closestThreeSum([2,5,6,8,-9], 5) = " + closestThreeSum(testCases[2], targets[2]));
    System.out.println("closestThreeSum([-1, 0, -2, -5, 0, -9, -4], -2) = " + closestThreeSum(testCases[3], targets[3]));
  }

  public static int closestThreeSum(int[] nums, int target) {
    // Sort array to allow for two-pointer solution
    Arrays.sort(nums);

    // Create temp variable to track the closest difference in three numbers
    int diff = Integer.MAX_VALUE;
    
    // Iterate through all the numbers 
    for (int i = 0; i < nums.length; i++) {
      // Set up two pointers, one for left and one for right of the sorted array
      int left = i + 1; // Left pointer may begin after i to avoid repeating combinations
      int right = nums.length - 1;
      
      // Iterate until the pointers cross, ensuring that all combinations have been considered
      while (left < right) {
        // Find the sum of the three numbers
        int sum  = nums[i] + nums[left] + nums[right];
        
        // If the difference from the newly calculated sum is less than the current difference, save
        // the new value
        if (Math.abs(target - sum) < Math.abs(diff)) {
          diff = target - sum;
        }

        // If the sum is larger than the target, decrement the right pointer to find a smaller sum
        if (sum > target) {
          right--;
        }
        // If the sum is smaller than the target, increment the left pointer to find a larger sum
        else {
          left++;
        }
      }
    }

    // Return the smallest found difference
    return (target-diff);
  }
}