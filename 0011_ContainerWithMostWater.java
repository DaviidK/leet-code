/*
Problem sourced from: leetcode.com

Given n non-negative integers a1, a2, ..., an , where each represents a point at
coordinate (i, ai). n vertical lines are drawn such that the two endpoints of 
line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/

import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] points = {1, 1, 2, 3, 8, 8, 1, 4, 1}; 
        System.out.println("Data used: " + Arrays.toString(points));
        System.out.println("Via brute force algorithm, maxarea = " 
                           + maxAreaBruteForce(points));
        System.out.println("Via optimized algorithm, maxarea = " + maxArea(points));
    }

    // Brute force solution, not optimal. Instead used to verify correct answers
    public static int maxAreaBruteForce(int[] data) {
        // Track largest volume found so far
        int maxVolume = 0;
        // Iterate through every point in the matrix
        for (int i = 0; i < data.length; i++) {
            // For every point, iterate through every other point to find the 
            // maximum volume created by each pair
            for (int j = i + 1; j < data.length; j++) {
                // The volume can be calculated as the width (j - i) * the
                // data (which will be the lower of the two points)
                maxVolume = Math.max(maxVolume, Math.min(data[i], data[j]) * (j - i));
            }
        }
        return maxVolume;
    }

    
    public static int maxArea(int[] data) {
        // Track largest volume found so far
        int maxVolume = 0;

        // Create index variables to track left and right points
        int start = 0;
        int end = data.length - 1;

        // Iterate through all points
        while (start < end) {
            // Check to see if the current points produce a larger max volume
            maxVolume = Math.max(maxVolume, Math.min(data[start], data[end]) * (end - start));

            // Move the smaller point towards the center
            if (data[start] < data[end]) {
                start++;
            }
            else {
                end--;
            }
        }

        return maxVolume;
    }
}