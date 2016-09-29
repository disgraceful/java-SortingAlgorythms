package sorter.algorythms;

import sorter.strategy.SortingAlgorythm;

public class RecursiveInsertionSort implements SortingAlgorythm {

    @Override
    public void sort(int[] arrayToSort) {
    
        InsertionSortRecursive(arrayToSort);
    }

    static void InsertionSortRecursion(int[] a, int unsortedIndex, int key, int sortedIndex) {

        if (unsortedIndex <= a.length) {

            if (sortedIndex == -1 && key == 0) {
                if (unsortedIndex != a.length) {
                    InsertionSortRecursion(a, unsortedIndex + 1, a[unsortedIndex], unsortedIndex - 1);
                }
            } else {
                if (sortedIndex == -1 || a[sortedIndex] < key) {
                    a[sortedIndex + 1] = key;
                    sortedIndex = 0;
                    key = 0;
                } else {
                    //slide
                    a[sortedIndex + 1] = a[sortedIndex];
                }
                InsertionSortRecursion(a, unsortedIndex, key, sortedIndex - 1);
            }
        }
    }

    // wrapper
    static void InsertionSortRecursive(int[] a) {
        InsertionSortRecursion(a, 1, 0, -1);
    }


}
