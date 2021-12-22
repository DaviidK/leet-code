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