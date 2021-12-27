/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the
latest version of your product fails the quality check. Since each version is developed based on the
previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes 
all the following ones to be bad.
You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a 
function to find the first bad version. You should minimize the number of calls to the API.

Example 1:
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.

Example 2:
Input: n = 1, bad = 1
Output: 1

Constraints:
  1 <= bad <= n <= 231 - 1
*/
public class FirstBadVersion {
  // No test cases available for this problem, as it relies on a third-party API to determine if a 
  // version is "bad" or not
  public static void main(String[] args) {

  }

  // Solution that uses iterative binary-search algorithm
  public static int firstBad(int versionCount) {
    // Create two pointers for beginning and end of number set
    int start = 1; // This problem assumes starting at version 1
    int end = versionCount; // End of number set will be the passed integer

    // Iterate until the start of the number set is next to or equal to the end
    while (start < end) {
      // Find the middle of the number set
      int middleNumber = start + ((end - start) / 2);

      // If the middle version is bad, begin search again with the middle as the endpoint 
      if (isBadVersion(middleNumber)) {
        end = middleNumber;
      }
      // If the middle version is not bad, begin search again with the middle as the starting point
      else {
        start = middleNumber + 1;
      }
    }

    // Return the starting point, which represents the earliest possible bad version
    return start;
  }
}