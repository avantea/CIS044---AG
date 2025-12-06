# Phase 1: Requirements & Design
## Project Option: Smart Scheduler (Priority Queue using a Heap)

### 1. Overview
I chose the **Smart Scheduler** project. The program handles tasks with different priority levels. Higher-priority tasks should be handled first.

### 2. Data Structure Choice
I will use a **Max-Heap** because it allows:
- Fast insertion of new tasks
- Fast removal of the highest-priority task

A heap is stored in an ArrayList and always keeps the largest priority at the top.

### 3. UML Diagram

Job
- id
- description
- priority

PriorityQueueScheduler
- heap (ArrayList)
+ addJob()
+ peekNextJob()
+ pollNextJob()
- heapifyUp()
- heapifyDown()

### 4. Big-O Justification
- Adding a job: **O(log n)** because the heap may need to bubble the job up.
- Removing the top job: **O(log n)** because the heap must bubble down.
- Peeking the next job: **O(1)** because it just returns the first element.  

