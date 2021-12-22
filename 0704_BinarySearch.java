public class BinarySearch {
  public static void main(String[] args) {
    int[] numbers = {-1,0,3,5,9,12};
    int targetNum = 9;
    
    System.out.println("recursiveSearch([-1,0,3,5,9,12], 9): " + recursiveSearch(numbers, targetNum));
    System.out.println("iterativeSearch([-1,0,3,5,9,12], 9): " + iterativeSearch(numbers, targetNum));
  }

  public static int recursiveSearch(int[] nums, int target) {
    return recursiveSearchHelper(nums, 0, nums.length - 1, target);
  }

  // Helper method which performs recursive binary search
  public static int recursiveSearchHelper(int[] nums, int start, int end, int target) {
    // Base case: search algorithm cannot split the remaining numbers any further, meaning the target
    // cannot be found
    if (start > end) {
      return -1;
    }

    // Find the middle position of the current number set
    int middleIndex = start + ((end-start) / 2);
    // If the number in the middle position is equal to the target, return that index
    if (target == nums[middleIndex]) {
      return middleIndex;
    } 
    // If the target is smaller than the number in the middle, search through the left half of the 
    // number set
    else if (target < nums[middleIndex]) {
      return recursiveSearchHelper(nums, start, middleIndex - 1, target);
    } 
    // If the target is larger than the number in the middle, search through the right half of the 
    // number set
    else {
      return recursiveSearchHelper(nums, middleIndex+1, end, target);
    }
  }

  public static int iterativeSearch(int[] nums, int target) { 
    // Set pointers to refer to beginning and end of the number set
    int start = 0;
    int end = nums.length - 1;

    // Search until the starting index is larger than the ending index
    while (start <= end) {
      // Find the middle index of the current number set
      int middleIndex = start + ((end - start) / 2);
      // Perform the same checks as in the recursive algorithm, but instead of calling the method, 
      // move the bounds of the current number set by changing either 'start' or 'end'
      if (target == nums[middleIndex]) {
        return middleIndex;
      } else if (nums[middleIndex] < target) {
        start = middleIndex + 1; 
      } else {
        end = middleIndex - 1;
      }
    }

    // If the algorithm exits the while loop, the target has not been found
    return -1;
  }
}