/*
Problem sourced from: leetcode.com
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
*/
import java.util.Arrays;

public class Matrix01 {

  public static void main(String[] args) {
    int[][][] testCases = { {{0, 0, 0},
                            {0, 1, 0},
                            {0, 1, 0}},
                           {{0, 0, 0},
                            {0, 1, 0},
                            {1, 1, 1} } };
    int[][][] results =   {{ {0, 0, 0},
                            {0, 1, 0},
                            {0, 0, 0}},
                           {{0, 0, 0},
                            {0, 1, 0},
                            {1, 2, 1} } };

    for (int i = 0; i < testCases.length; i++) {
      System.out.println("Test case:\n" + Arrays.toString(testCases[i][0]) + "\n"
                                       + Arrays.toString(testCases[i][1]) + "\n"
                                       + Arrays.toString(testCases[i][2]));
      System.out.println("Expected result:\n" + Arrays.toString(results[i][0]) + "\n"
                                              + Arrays.toString(results[i][1]) + "\n"
                                              + Arrays.toString(results[i][2]));
      System.out.print("Output produced:\n");
      int[][] output = updateMatrix(testCases[i]);
      System.out.println(Arrays.toString(output[0]) + "\n"
                         + Arrays.toString(output[1]) + "\n"
                         + Arrays.toString(output[2]));
      System.out.println();
    }
  }

  // Brute Force Solution (Does not work for large inputs)
  // This solution will iterate through each position in the input matrix and act accordingly depending
  // on the number found. If a zero is found, that will be added directly to the resulting matrix.
  // If a 1 is found, this solution will iterate across all other positions in the input to find the
  // nearest 0. At each 0 found, the distance between that index and the current 1 will be calculated,
  // and the minimum distance will be stored in the result.
  public static int[][] updateMatrix(int[][] mat) {
    // This solution will time out for exceedingly long inputs
    if (mat.length > 500000 || mat[0].length > 500000) {
      System.out.println("ERROR: The input matrix was too large for a brute force solution");
      return mat;
    }

    // Create temp variables to reference the total number of rows and columns
    int rows = mat.length;
    int cols = mat[0].length;

    // Do nothing if the input is empty
    if (rows == 0) {
      return mat;
    }

    // Create a result array and fill it with max values
    int[][] result = new int[rows][cols];
    for (int[] row : result) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    // Iterate through the entire input
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        // If a 0 is found, add it to the result
        if (mat[i][j] == 0) {
          result[i][j] = 0;
        } 
        // If a non-zero is found, iterate through the entire input once again
        else {
          for (int k = 0; k < rows; k++) {
            for (int l = 0; l < cols; l++) {
              // Stop at every 0 that is found
              if (mat[k][l] == 0) {
                // For each 0, calculate the distance to the non-zero index
                int distance = Math.abs(i - k) + Math.abs(j - l);
                // If that distance is lower than the current minimum, store it in the result
                if (distance < result[i][j]) {
                  result[i][j] = distance;
                }
              }
            }            
          }
        }
      }
    }

    // Return the result
    return result;
  }
}
