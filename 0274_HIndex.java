/*
Problem sourced from: leetcode.com

Given an array of citations (each citation is a non-negative integer) of a 
researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if
h of his/her N papers have at least h citations each, and the other N − h papers 
have no more than h citations each."

Example:
Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of 
             them had received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each 
             and the remaining two with no more than 3 citations each, her 
             h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as 
the h-index.

*/

import java.util.*;     // For map of TrieNode children

// Java doesn't allow underscores in file names, so it's necessary to rename the 
// file before compiling. I chose to keep the underscore for easy organization
// within my git repo, given that these files are often never compiled after being 
// committed
public class HIndex {
  public int hIndex(int[] citations) {
    // Array to the contain the counts for number of papers 
    // with x citations, where counts[x] will be the number of 
    // papers with x citations.  Because the h value cannot be 
    // larger than the number of papers, the last used count in 
    // this array, count[citations.length], is a count of the 
    // number of papers with citations.length or more citations.
    int[] counts = new int[citations.length + 2];
    
    // Build the counts of how many papers have x citations.  
    // If a paper has more than citations.length citations, then 
    // count it as citations.length citations.
    for (int i = citations.length - 1; i >= 0; i--)  
        counts[Math.min(citations[i], citations.length)]++;
    
    // Go through the count[] array from last index down to 0, trying 
    // successively smaller values for h.  Looping from high to low 
    // possible values for h, will find the highest valid value for 
    // h.  While descending through the count array, add the count 
    // from the next higher index in the count array, which will 
    // convert the current counts[h] value to become a count of 
    // papers with h or more citations.  This is slightly confusing 
    // because h is used as both an index and a value to compare to 
    // the array value at that index.  The "units" for h feel 
    // inconsistent.
    int h;
    for (h = citations.length; h > 0; h--) {
        counts[h] += counts[h + 1];
        if (counts[h] >= h)  break;
    }
    return h;
}
}