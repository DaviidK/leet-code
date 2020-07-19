/*
Problem sourced from: leetcode.com

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to
first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the
ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If 
it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should
have finished course 0. So the correct course order is [0,1] .

Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should
             have finished both courses 1 and 2. Both courses 1 and 2 should be
             taken after you finished course 0. So one correct course order is
             [0,1,2,3]. Another correct ordering is [0,2,1,3] .

Note:
The input prerequisites is a adjacencyList represented by a list of edges, not adjacency
matrices. Read more about how a adjacencyList is represented.

You may assume that there are no duplicate edges in the input prerequisites.
*/

#include <iostream>   // For printing
#include <vector>     // For vectors
#include <algorithm>  // For std::find()
#include <stack>      // For stack

using namespace std;
// // Attempt at a viable solution that avoids topological sort - DOESN'T WORK
// vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
//     vector<vector<int>> orderedPrereqs;

//     for (int i = 0; i < numCourses; i++) {
//         orderedPrereqs.push_back({i});
//     }

//     // Iterate through all courses
//     for (int i = 0; i < prerequisites.size(); i++) {
//         int course = prerequisites[i][0];
//         int prereq = prerequisites[i][1];
//         // If the prereq is in the results but the course isn't
//         orderedPrereqs[prereq].push_back(course);
//     }

//     vector<int> results;
//     for (vector<int> edges : orderedPrereqs) {
//         for (int course : edges) {
//             if (find(results.begin(), results.end(), course) == results.end()) {
//                 results.push_back(course);
//             }
//         }
//     }

//     results.push_back(orderedPrereqs[0][0]);
//     int i = results[0];
//     while (results.size() != numCourses) {
//         int tempJump = i;
//         for (int course : orderedPrereqs[tempJump]) {
//             if (find(results.begin(), results.end(), course) == results.end()) {
//                 results.push_back(course);
//                 tempJump = course;
//             }
//         }
//         i++;
//     }

//     return results;
// }

// Solution that actually works using topological sort
vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
    // Create all data structures that will be used
    // Adjacency list
    vector<vector<int>> adjacencyList(numCourses);
    // inDegree of all nodes in the adjacencyList -> use size of numCourses and default value of zero
    vector<int> inDegree(numCourses, 0);
    // All nodes with an inDegree of 0
    stack<int> zeroDegree;
    // Final order, to be returned
    vector<int> result;

    // Iterate through all nodes and add them to the correct locatoin in the
    // adjacency list
    // Update the indegree for each course as it is encountered
    for(int i = 0; i < prerequisites.size(); i++){
        // Add the prerequisite to the adjacency list next to the course
        adjacencyList[prerequisites[i][1]].push_back(prerequisites[i][0]);
        inDegree[prerequisites[i][0]]++;
    }

    // Iterate through all the inDegrees, adding any courses with a value of 0
    // into the zeroDegree array and the result array
    for(int i = 0; i < inDegree.size(); i++){
        if(inDegree[i] == 0){
            zeroDegree.push(i);
            result.push_back(i);
        }
    }

    // Continue iterating
    while(!zeroDegree.empty()){
        // Pop off the top of the stack
        int node = zeroDegree.top();
        zeroDegree.pop();

        // Iterate through the adjacency list for the popped node
        for(int i = 0; i < adjacencyList[node].size(); i++){
            // Pull each adjacent node
            int connectedNode = adjacencyList[node][i];
            // Update the degree of the adjacent node
            inDegree[connectedNode]--;
            // If the new degree is 0, we can now add it to our zeroDegree array
            if(inDegree[connectedNode] == 0){
                zeroDegree.push(connectedNode);
                // And we can add it to the result
                result.push_back(connectedNode);
            }
        }
    }

    // If the resulting array doesn't contain all courses, the input cannot be
    // solved
    if(result.size() != numCourses){
        return vector<int>();
    }

    // Return the resulting array
    return result;
}