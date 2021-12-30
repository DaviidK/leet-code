/*
Problem sourced from: leetcode.com
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value 
of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image 
starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to 
the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally 
to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned 
pixels with newColor.

Return the modified image after performing the flood fill.


Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all 
pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored
with the new color.

Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]

Constraints:
  m == image.length
  n == image[i].length
  1 <= m, n <= 50
  0 <= image[i][j], newColor < 216
  0 <= sr < m
  0 <= sc < n
*/
import java.util.Stack;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
  public static void main(String[] args) {
    int[][] testCases = { {1, 1, 1},
                          {1,1, 0},
                          {1, 0, 1} };
    int newColor = 2;
    int sr = 1;
    int sc = 1;
    int[][] results = { {2, 2, 2},
                        {2, 2, 0},
                        {2, 0, 1} };

    System.out.println("Starting image: \n" + Arrays.toString(testCases[0]) + "\n" + Arrays.toString(testCases[1]) + "\n" + Arrays.toString(testCases[2]) + "\n");
    floodFill(testCases, sr, sc, newColor);
    System.out.println("Resulting image: \n" + Arrays.toString(testCases[0]) + "\n" + Arrays.toString(testCases[1]) + "\n" + Arrays.toString(testCases[2]) + "\n");

    // for (int i = 0; i < testCases.length; i++) {
    //   System.out.println("Test case: " + Arrays.toString(testCases[i]));
    //   System.out.println("Target: " + targets[i]);
    //   System.out.println("Expected result: " + results[i]);
    //   System.out.println("Output produced: ");
    //   System.out.println();
    // }
  }
  
  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image[sr][sc] != newColor) {
      search(image, image[sr][sc], newColor, sr, sc);
    }
    return image;
  }

  public static void search(int[][] image, int searchColor, int newColor, int row, int col) {
    if (image[row][col] == searchColor) {
      image[row][col] = newColor;
      if (row - 1 >= 0) {
        search(image, searchColor, newColor, row - 1, col);
      }

      if (col - 1 >= 0) {
        search(image, searchColor, newColor, row, col - 1);
      }

      if (row + 1 < image.length) {
        search(image, searchColor, newColor, row + 1, col);
      }

      if (col + 1 < image[row].length) {
        search(image, searchColor, newColor, row, col + 1);
      }
    }
  }

  // public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
  //   Queue<Integer[][]> q = new LinkedList<>();
  //   int startingColor = image[sr][sc];

  //   q.add([1][1]);

  //   while (!q.isEmpty())

  // }
}
