/*
Problem sourced from: leetcode.com

You have a total of n coins that you want to form in a staircase shape, where
every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed. n is
a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:
n = 5
The coins can form the following rows:
¤
¤ ¤
¤ ¤
Because the 3rd row is incomplete, we return 2.

Example 2:
n = 8
The coins can form the following rows:
¤       
¤ ¤   
¤ ¤ ¤
¤ ¤
Because the 4th row is incomplete, we return 3.

Example 3:
n = 16
¤
¤ ¤
¤ ¤ ¤
¤ ¤ ¤ ¤
¤ ¤ ¤ ¤ ¤
¤
Because the 6th row is incomplete, we return 5.

Example 4:
n = 37
¤                 = 1
¤ ¤               = 3
¤ ¤ ¤             = 6
¤ ¤ ¤ ¤           = 10
¤ ¤ ¤ ¤ ¤         = 15
¤ ¤ ¤ ¤ ¤ ¤       = 21
¤ ¤ ¤ ¤ ¤ ¤ ¤     = 28
¤ ¤ ¤ ¤ ¤ ¤ ¤ ¤   = 36
¤
Because the 9th row is incomplete, we return 8.
*/
#include <stdexcept>
#include <iostream>
#include <cmath>
#include <climits>

using namespace std;

class ArrangingCoins {  
  public:
    // First solution: Using a stack to store the 
    int arrangeCoinsBruteForce(int n) {
      if (n == 0) {
        return 0;
      }

      for (int i = 1; i <= n; i++) {
        n -= i;
        if (n < i + 1) {
          return i;
        }
      }

      throw std::invalid_argument("Received invalid input");
    }

    /*
    given n, x is the result

    Solve inequality:

    x(x+1) / 2 < n
    x(x+1) / 2 - n < 0
    x(x+1) - 2n < 0
    x^2 + x - 2n < 0

    Use quadratic formula to solve for both roots (only need positive)
    
    x = (-b +- sqrt(b^2 - 4ac)) / 2a

    a=1
    b=1
    n = some constant

    x = (-1 +- sqrt(1^2 - 4(1)(n)) / 2a
    */
    int arrangeCoins(int n) {
      if (n < 0) {
        throw std::invalid_argument("Received invalid input");
      }
      return floor((-1 + sqrt(1 + ( (long) 8 * n))) / 2);
    }

};

int main() {

  ArrangingCoins obj = ArrangingCoins(); 
  
  cout << "For n = 5, arrangeCoins() = " << obj.arrangeCoins(5) << endl;
  cout << "For n = 8, arrangeCoins() = " << obj.arrangeCoins(8) << endl;
  cout << "For n = 16, arrangeCoins() = " << obj.arrangeCoins(16) << endl;
  cout << "For n = 37, arrangeCoins() = " << obj.arrangeCoins(37) << endl;
  cout << "For n = INT_MAX, arrangeCoins() = " << obj.arrangeCoins(INT_MAX) << endl;

  return 0;
} 