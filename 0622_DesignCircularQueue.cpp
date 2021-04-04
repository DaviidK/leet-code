/*
Problem sourced from: leetcode.com

Design your implementation of the circular queue. The circular queue is a 
linear data structure in which the operations are performed based on FIFO 
(First In First Out) principle and the tail position is connected back to 
the head position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces 
in front of the queue. In a normal queue, once the queue becomes full, we cannot 
insert the next element even if there is a space in front of the queue. 
But using the circular queue, we can use the space to store new values.

Implementation the MyCircularQueue class:

  MyCircularQueue(k) Initializes the object with the size of the queue to be k.
  int Front() Gets the front item from the queue. If the queue is empty, return -1.
  int Rear() Gets the tail item from the queue. If the queue is empty, return -1.
  boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
  boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
  boolean isEmpty() Checks whether the circular queue is empty or not.
  boolean isFull() Checks whether the circular queue is full or not.

Example:
Input
  ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
  [[3], [1], [2], [3], [4], [], [], [], [4], []]
  Output
  [null, true, true, true, false, 3, true, true, true, 4]

Explanation
  MyCircularQueue myCircularQueue = new MyCircularQueue(3);
  myCircularQueue.enQueue(1); // return True
  myCircularQueue.enQueue(2); // return True
  myCircularQueue.enQueue(3); // return True
  myCircularQueue.enQueue(4); // return False
  myCircularQueue.Rear();     // return 3
  myCircularQueue.isFull();   // return True
  myCircularQueue.deQueue();  // return True
  myCircularQueue.enQueue(4); // return True
  myCircularQueue.Rear();     // return 4

Constraints:

  1 <= k <= 1000
  0 <= value <= 1000
  At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.

Follow up: Could you solve the problem without using the built-in queue? 
*/

#include <vector> // For storing data

using namespace std;

class MyCircularQueue {
public:
  //--------------------------------------------------Public member fields
  int length; // Total number of possible elements in the queue
  int size;   // Current count of elements in the queue
  int head;   // Front of the queue
  int tail;   // Back of the queue
  vector<int> data;  // Elements in the queue

  //-------------------------------------------------Public member methods
  // Initializes the object with the size of the queue to be k.
  MyCircularQueue(int k) {
    length = k;
    size = 0;
    data = vector<int>(k);
    head = 0;
    tail = -1;
  }

  // Checks whether the circular queue is empty or not. 
  bool isEmpty() {
    return size == 0;
  }
  
  // Checks whether the circular queue is full or not.
  bool isFull() {
    return length == size;
  }

  // Get the front item from the queue.
  int Front() {
    // Return -1 if the queue is empty
    if (isEmpty()) {
      return -1;
    }
    return data[head];
  }
  
  // Get the tail item from the queue.
  int Rear() {
    // Return -1 if the queue is empty
    if (isEmpty()) {
      return -1;
    }
    return data[tail];
  }

  // Insert an element into the circular queue. Return true if the operation is successful.
  bool enQueue(int value) {
    if(!isFull()) {
      // If the end of the queue is immediately before index 0, need
      // to add to the beginning
      if (tail == length - 1) {
        tail = 0;
      }
      // Otherwise, increment tail location
      else {
        tail++;
      }
      // Add new value into tail location and increment size
      data[tail] = value;
      size++;
      return true;
    }
    // Return false if queue was full
    return false;
  }
  
  // Delete an element from the circular queue. Return true if the operation is successful.
  bool deQueue() {
    if(!isEmpty()) {
      // If the beginning of the queue is immediately before index 0, need
      // to reset the head to index 0
      if (head == length-1) {
        head = 0;
      }
      // Otherwise increment head position, effectively removing data at
      // the previous location
      else {
        head++;
      }
      // Decrement size
      size--;
      return true;
    }
    // Return false if queue was empty
    return false;
  }
};