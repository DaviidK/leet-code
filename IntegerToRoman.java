/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, two is written as II in Roman numeral, just two one's added together.
Twelve is written as, XII, which is simply X + II. The number twenty seven is
written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII. Instead, the number four is written
as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX. There are
six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral. Input is guaranteed to be 
within the range from 1 to 3999.

Example 1:
Input: 3
Output: "III"

Example 2:
Input: 4
Output: "IV"

Example 3:
Input: 9
Output: "IX"

Example 4:
Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.

Example 5:
Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println("Roman: I, Integer: 1, intToRoman(): " + intToRoman(1));
        System.out.println("Roman: XLIX, Integer: 49, intToRoman(): " + intToRoman(49));
        System.out.println("Roman: CMLIX, Integer: 959, intToRoman(): " + intToRoman(959));
        System.out.println("Roman: MMMCMXCIX, Integer: 3999, intToRoman(): " + intToRoman(3999));
    }

    // O(n) solution - Iterate through each possible combination of roman 
    // numerals, adding them into a result from largest to smallest
    public static String intToRoman(int num) {
        // Create array for all the possible numerical values that can be 
        // expressed by roman numerals
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        // Create array with all the corresponding roman numeral strings
        String[] romanLetters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        // Instantiate result
        StringBuilder result = new StringBuilder();

        // Iterate until the entire number has been represented by roman numerals
        for (int i = 0; i < values.length; i++) {
            // As long as the number is larger than the roman numeral, subtract
            // that value from the passed number and append the corresponding
            // numeral to the result
            while (num >= values[i]) {
                num -= values[i];
                result.append(romanLetters[i]);
            }
        }

        return result.toString();
    }
}