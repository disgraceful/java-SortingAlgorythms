package sorter.algorythms;

import sorter.strategy.SortingAlgorythm;

public class RecursiveSort implements SortingAlgorythm {
    
    @Override
    public void sort(int[] arrayToSort) {
        quickSort(arrayToSort);
    }

    /**
     * public method exposed to client, sorts given array using QuickSort
     * Algorithm in Java
     *
     * @param array
     */
    public static void quickSort(int[] array) {
        recursiveQuickSort(array, 0, array.length - 1);
    }

    /**
     * Recursive quick sort logic
     *
     * @param array input array
     * @param startIdx start index of the array
     * @param endIdx end index of the array
     */
    public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {
        
        int idx = partition(array, startIdx, endIdx);

        // Recursively call quicksort with left part of the partitioned array
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx);
        }
    }

    /**
     * Divides array from pivot, left side contains elements less than Pivot
     * while right side contains elements greater than pivot.
     *
     * @param array array to partitioned
     * @param left lower bound of the array
     * @param right upper bound of the array
     * @return the partition index
     */
    public static int partition(int[] array, int left, int right) {
        int pivot = array[left]; // taking first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // swap the values
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }
}

//    static void InsertionSortRecursion(int[] a, int unsortedIndex, int key, int sortedIndex) {
//
//        if (unsortedIndex <= a.length) {
//
//            if (sortedIndex == -1 && key == 0) {
//                if (unsortedIndex != a.length) {
//                    InsertionSortRecursion(a, unsortedIndex + 1, a[unsortedIndex], unsortedIndex - 1);
//                }
//            } else {
//                if (sortedIndex == -1 || a[sortedIndex] < key) {
//                    a[sortedIndex + 1] = key;
//                    sortedIndex = 0;
//                    key = 0;
//                } else {
//                    //slide
//                    a[sortedIndex + 1] = a[sortedIndex];
//                }
//                InsertionSortRecursion(a, unsortedIndex, key, sortedIndex - 1);
//            }
//        }
//    }
//
//    // wrapper
//    static void InsertionSortRecursive(int[] a) {
//        InsertionSortRecursion(a, 1, 0, -1);
//    }
//


