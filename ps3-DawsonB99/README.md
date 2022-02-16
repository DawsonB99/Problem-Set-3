# ps3
Problem Set 3
Dawson Bridger and Mike Scanlon

Question 1)
O(n^2) - The run time would end up being O(n^2) since 2 for loops are needed. One is needed to fill the array and another is needed to sort it. 

Question 2)
O(n) - Since we don't need to sort the array now, only one for loop is needed to search through the n values to find the k largest values.

Question 3)
We know it's safe to discard the new value because if the value is smaller than the smallest value in the list of k values, then we know that the new value would not be in the k-element array.

Question 4)
If we have found a value that is bigger than one in the list, then we are completely ok with discarding the previous value, since we know now there are k values that are larger than the previous one.

Question 5)
O(n) - In order to fill the list of all k values, we must look at every single n input value, so therefore notation is O(n).

Question 6)
There is no reason to have a remove method in the BestOf class since the only value that would be removed would end up being the smallest value in the list. This is redundant because this is already accomplished by the add method.
