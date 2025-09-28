# Assignment 1 
![photo_2025-09-28_21-58-54](https://github.com/user-attachments/assets/cd27b058-7492-4f25-91aa-4ecb1207c3f7)
![photo_2025-09-28_21-59-08](https://github.com/user-attachments/assets/5c47b643-bb86-4ac7-b1a8-1ff142e974fb)
![photo_2025-09-28_21-59-12](https://github.com/user-attachments/assets/592f8057-9aab-41ee-88b6-0c1824e47796)
## About
This project has some classic algorithms:
MergeSort
QuickSort
Deterministic Select
Closest Pair of Points

I also count:
Time (nanoseconds)
Comparisons
Recursion depth
Memory allocations



## How to run
Build the project:
```bash
mvn clean package


Run example:
java -jar target/algorithms-1.0-SNAPSHOT.jar mergesort metrics.csv 1000 64000 2 3

Arguments:
algorithm (mergesort, quicksort, select)
output csv file
min size
max size
step (multiply by)
trials (repeat times)

Results
I ran MergeSort, QuickSort and Select.
The program saved results into CSV.
Here are the plots:

Time
Depth
Comparisons

My notes
MergeSort: works always stable, O(n log n).
QuickSort: usually fastest, but recursion is deeper.
Select: O(n), but slower in practice, not a sorting algorithm.

Tests
All algorithms are covered with simple JUnit 5 tests.
You can run them with the run button inside the test java files (each of them)
It will save the data automatically

GitHub
Link to repo:
https://github.com/Kitondot/Analysis_Of_ALGORITHMS_A1l


