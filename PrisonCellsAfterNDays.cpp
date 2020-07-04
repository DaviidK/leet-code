/*
There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the 
following rules:

    If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
    Otherwise, it becomes vacant. (Note that because the prison is a row, the
    first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1
if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N 
days (and N such changes described above.)
*/


#include <iostream>   // For printing
#include <vector>     // For vectors

using namespace std;

// Helper method for brute force algorithm, will calculate each day 
// individually 
vector<int> bruteForceHelper(vector<int>& cells) {
  // Create new array that will be returned after applying changes for one day
  vector<int> updatedCells(8, 0);
  
  // Iterate through the passed array, changing the state of each cell as 
  // per the given rules
  for (int i = 1; i < cells.size() - 1; i++) {
    updatedCells[i] = (cells[i - 1] == cells [i + 1]) ? 1 : 0; 
  }

  return updatedCells;
}

// Brute force algorithm (terrible efficiency)
vector<int> prisonAfterNDays(vector<int>& cells, int N) {
  // Loop through the passed number of days, calling the helper to update the
  // array's state for each day
  for (int i = 0; i < N; i++) {
    cells = bruteForceHelper(cells);
  }

  return cells;
}

int main() {
  // Create initial state of vector
  vector<int> testCase{0,1,0,1,1,0,0,1};

  // Calculate resulting vector
  prisonAfterNDays(testCase, 7);

  cout << "For [0,1,0,1,1,0,0,1], 7:" << endl;
  cout << "Expected: [0,0,1,1,0,0,0,0]" << endl;
  cout << "prisonAfterNDays() = [";

  // Print vector
  for (int i = 0; i < testCase.size() - 1; i++) {
    cout << testCase[i] << ", ";
  }
  cout << testCase[testCase.size() - 1] << "]" << endl;

  return 0;
} 

