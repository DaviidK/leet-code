/*
Problem sourced from: leetcode.com

In a given grid, each cell can have one of three values:
    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten 
orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh 
orange.  If this is impossible, return -1 instead.

 

Example 1 (Image missing from this comment):
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2 (Image missing from this comment):
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3 (Image missing from this comment):
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
*/

#include <iostream>        // For printing to console
#include <vector>          // For vectors

using namespace std;


  // Helper method which will check if a given position in a passed grid has any
  // neighbors with a value of 2
  bool hasRottenNeighbour(vector<vector<int>>& grid, int x, int y) {
    // checking for for rotten neighbours left, up, right and down
    return (x && grid[y][x - 1] == 2) || (y && grid[y - 1][x] == 2) 
           || (x < grid[0].size() - 1 && grid[y][x + 1] == 2) 
           || (y < grid.size() - 1 && grid[y + 1][x] == 2);
  }
  
  int orangesRotting(vector<vector<int>>& grid) {
    int res = 0;
    int freshCount;
    bool hasRotted;
    vector<pair<int, int>> toRot;
    do {
      // resetting tracking variables
      freshCount = 0;
      hasRotted = false;
      toRot.clear();
      // looping through the grid
      for (int y = 0; y <= grid.size() - 1; y++) {
        for (int x = 0; x <= grid[0].size() - 1; x++) {
            if (grid[y][x] == 1) {
              if (hasRottenNeighbour(grid, x, y)) {
                toRot.push_back({x, y});
                hasRotted = true;
              }
              else freshCount++;
          }
        }
      }
      // updating the grid with the oranges that should rot at this tick
      for (auto e: toRot) grid[e.second][e.first] = 2;
      res += hasRotted;
    } while (hasRotted);
    return freshCount ? -1 : res;
  };