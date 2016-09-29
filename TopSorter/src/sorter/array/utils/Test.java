/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorter.array.utils;

import sorter.algorythms.BubbleSortAscending;
import sorter.algorythms.BubbleSortDescending;
import sorter.algorythms.JavaSort;
import sorter.algorythms.MergingSort;
import sorter.algorythms.RecursiveInsertionSort;
import sorter.array.generators.AscSortedArray;
import sorter.array.generators.DescSortedArray;
import sorter.array.generators.RandomArray;

/**
 *
 * @author Kashapov
 */
public class Test {
    public static void main(String[]args){
        int []array = new DescSortedArray().generate(10,100);
        int[]array1 = array.clone();
        int[]array2 = array.clone();
        int[]array3 = array.clone();
        int[]array4 = array.clone();
//        print(array);
//        new RecursiveInsertionSort().sort(array);
//        print(array);
//        print(array1);
//        new MergingSort().sort(array1);
//        print(array1);
//        print(array2);
//        new JavaSort().sort(array2);
//        print(array2);
//        print(array3);
//        new BubbleSortAscending().sort(array3);
//        print(array3);
        print(array4);
        new BubbleSortDescending().sort(array4);
        print(array4);        
        
        
    }
    
    
    public static void print(int []array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
            
            
        }
        System.out.println(" ");
    }
}
