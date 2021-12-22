import java.util.Arrays;

public class SquaresOfASortedArray {
  public static void main(String[] args) {
    int[] input = {-7,-3,2,3,11};
    System.out.println("sortedSquares([-7,-3,2,3,11]): " + Arrays.toString(sortedSquares(input)));
  }

  // Solution using two pointer algorithm
  // This solution is based on the knolwedge that in any sorted number set, the left and right most 
  // values represent the largest possible results when squared (as a negative number squared is positive).
  // To create a sorted array of squares, iterate from both the beginning & end of the number set and 
  // square each number. Place the larger number at the end of the resulting array, and update the 
  // bounds of the remaining number set.
  public static int[] sortedSquares(int[] nums) {
    // Instantiate two pointers to refer to the beginning and end of the number set
    int start = 0;
    int end = nums.length - 1;
    
    // Create an array to store the results
    int[] result = new int[nums.length];
    // Create a temp variable to track the index at which to add new numbers to the result
    int currentIndex = end;

    // Iterate through the entire number set
    while (start <= end) {
      // Square the left and right most numbers
      int squaredStart = nums[start] * nums[start];
      int squaredEnd = nums[end] * nums[end];

      // If the left square is larger than the right, add it the the end of the results array
      if (squaredStart > squaredEnd) {
        result[currentIndex] = squaredStart;
        // Increment the left pointer to compare the next number
        start++;
      } 
      // If the right square is larger than the left, or if they are equal, add the right square to 
      // the results array
      else {
        result[currentIndex] = squaredEnd;
        // Decrement the right pointer to compare the next number
        end--;
      } 

      // Decrement the results index to ensure that the next number is added to the correct position
      currentIndex--;
    }

    // Return the resulting sorted array of squares
    return result;
  }
}

/*
class Solution {
  public int[] sortedSquares(int[] nums) {
      int[] result = new int[nums.length];
      int current = nums.length - 1;
      
      int left = 0;
      int right = current;
      
      while (current >= 0) {
          int leftAbs = Math.abs(nums[left]);
          int rightAbs = Math.abs(nums[right]);
          
          if (leftAbs > rightAbs) {
              result[current] = leftAbs * leftAbs;
              left++;
              
          } else {
              result[current] = rightAbs * rightAbs;
              right--;
          }
          
          current--;
          
      }
      
      return result;
  }
}
*/