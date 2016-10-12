/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorter.array.utils;

import sorter.array_generators.GeneratorContext;
import sorter.array_generators.DescSortedArray;
import sorter.array_generators.SortedWithLastRandom;
import sorter.array_generators.AscSortedArray;
import sorter.array_generators.RandomArray;
import sorter.algorythms.BubbleSortAscending;
import sorter.algorythms.BubbleSortDescending;
import sorter.algorythms.JavaSort;
import sorter.algorythms.MergingSort;
import sorter.algorythms.RecursiveSort;
import sorter.strategy.*;

/**
 *
 * @author Kashapov
 */
public class Test {

//    public static void main(String[] args) {
//        // generatorsTest();
//        algsTest();
//    }

    public static void generatorsTest() {
        GeneratorContext con = new GeneratorContext(new AscSortedArray());

        int[] array = con.generate(10, 100);
        con.setAlgorythm(new DescSortedArray());
        array = con.generate(10, 100);
        con.setAlgorythm(new RandomArray());
        array = con.generate(10, 100);
        con.setAlgorythm(new SortedWithLastRandom());
        array = con.generate(10, 100);
        print(array);
    }

    public static void algsTest() {
        GeneratorContext con = new GeneratorContext(new AscSortedArray());
        int[] array = con.generate(10, 100);
        con.setAlgorythm(new DescSortedArray());
        array = con.generate(10000, Integer.MAX_VALUE);
//        con.setAlgorythm(new RandomArray());
//        array = con.generate(10, 100);
//        con.setAlgorythm(new SortedWithLastRandom());
//        array = con.generate(10000, 100);

        SortingContext sc = new SortingContext(new BubbleSortAscending());
        sc.setAlgorythm(new BubbleSortDescending());
        sc.setAlgorythm(new JavaSort());
        sc.setAlgorythm(new MergingSort());
        sc.setAlgorythm(new RecursiveSort());
        
        System.out.println("before: ");
        //print(array);
        sc.sort(array);
        System.out.println("after: ");
        //print(array);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }
}
