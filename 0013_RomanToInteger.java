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

Given a roman numeral, convert it to an integer. Input is guaranteed to be
within the range from 1 to 3999.

Example 1:
Input: "III"
Output: 3

Example 2:
Input: "IV"
Output: 4

Example 3:
Input: "IX"
Output: 9

Example 4:
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println("Roman: I, Integer: 1, romanToInt(): " + romanToInt("I"));
        System.out.println("Roman: XLIX, Integer: 49, romanToInt(): " + romanToInt("XLIX"));
        System.out.println("Roman: CMLIX, Integer: 959, romanToInt(): " + romanToInt("CMLIX"));
        System.out.println("Roman: MMMCMXCIX, Integer: 3999, romanToInt(): " + romanToInt("MMMCMXCIX"));
        
    }

    public static int romanToInt(String romanNum) {
        int result = 0;

        //char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        String symbols = "IVXLCDM";

        // Iterate through each character in the string
        for (int i = 0; i < romanNum.length(); i++) {
            // Pull current letter from input
            char romanLetter = romanNum.charAt(i);
            // Create int to determine if this letter will be added or subtracted
            int positiveNum = 1;

            // Only check for subtraction if this character is not the last character
            // in the input
            if (i != romanNum.length() - 1) {
                // Find the index of the current character in the known symbols
                int symbolIndex = symbols.indexOf(romanLetter);
                // Find the index of the next character in the known symbols
                int nextSymbolIndex = symbols.indexOf(romanNum.charAt(i + 1));

                // If the next character can be found within two index positions
                // of the current character, then subtraction must occur
                if (nextSymbolIndex - symbolIndex <= 2 && nextSymbolIndex - symbolIndex > 0) {
                    positiveNum = -1;
                }
            }

            // Add the correct amount to our result, using positiveNum as an 
            // indicator for addition or subtraction
            switch (romanLetter) {
                case 'I':
                    result += (1 * positiveNum);
                    break;
                case 'V':
                    result += (5 * positiveNum);
                    break;
                case 'X':
                    result += (10 * positiveNum);
                    break;
                case 'L':
                    result += (50 * positiveNum);
                    break;
                case 'C':
                    result += (100 * positiveNum);
                    break;
                case 'D':
                    result += (500 * positiveNum);
                    break;
                case 'M':
                    result += (1000 * positiveNum);
                    break;
            }
        }

        return result;
    }
}