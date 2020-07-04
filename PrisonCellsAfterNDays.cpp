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
vector<int> prisonAfterNDaysBruteForce(vector<int>& cells, int N) {
  // Loop through the passed number of days, calling the helper to update the
  // array's state for each day
  for (int i = 0; i < N; i++) {
    cells = bruteForceHelper(cells);
  }

  return cells;
}

// Optimized solution - this is based on the knowledge that the possible 
// combinations of vacant/occupied cells is limited, and that eventually these
// combinations will begin to repeat in a cycle. We know there are only 2^8 (or 512)
// possible combinations for an array of size 8, with 2 possible choices in each 
// position. Thus, if we have an n value larger than than this, we only need
// to find out all the solutions until we encounter a repitition. Then, we can
// find what combination the result will be by finding the size of the cycle and
// using N % size to specify the exact combination

vector<int> prisonAfterNDays(vector<int>& cells, int N) {
  // Create a 2D vector to store all the combinations seen
  vector<vector<int>> knownStates;
  // Use a temp vector to find each following state
  vector<int> current(8);

  // Iterate through all days
  while (N > 0) {
    N--;
    // Only need to iterate from 1 to 7, as the first & last cells cannot be occupied
    for (int i = 1; i < cells.size() - 1; i++) {
      current[i] = (cells[i - 1] == cells [i + 1]) ? 1 : 0;
    }

    // Check if the newly formed combination has been seen before
    if (knownStates.size() && knownStates.front() == current) {
      // Return the resulting combination by using modulo
      return knownStates[N % knownStates.size()];
    } 
    // If the current combination has not yet been seen, add it to the known states
    else {
      knownStates.push_back(current);
    }

    // Update the cells vector with the new state
    cells = current;
  }

  return cells;
}

int main() {
  // Create initial state of vector
  vector<int> testCase{0,1,0,1,1,0,0,1};

  // Calculate resulting vector
  prisonAfterNDays(testCase, 7);

  cout << "For [0, 1, 0, 1, 1, 0, 0, 1], 7:" << endl;
  cout << "Expected: [0, 0, 1, 1, 0, 0, 0, 0]" << endl;
  cout << "Result: = [";

  // Print vector
  for (int i = 0; i < testCase.size() - 1; i++) {
    cout << testCase[i] << ", ";
  }
  cout << testCase[testCase.size() - 1] << "]" << endl;

  return 0;
} 

