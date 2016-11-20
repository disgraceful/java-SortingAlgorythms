/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorter.metering;

import java.util.Arrays;
import sorter.algorythms.SortingAlgorythm;

public class SortTimeMeter {
//Class that actually does time measures

    /**
     *
     * @param array
     * @param algorythm
     * @return nanoseconds
     */    
    public static long countSortTime(int[] array, SortingAlgorythm algorythm){
        long sumTime = 0;
        int measuresCount = 4; //количество замеров
        for (int i = 0; i < measuresCount; i++) {
            int[]copyArray = Arrays.copyOf(array, array.length);
            long untilTime = System.nanoTime();
            algorythm.sort(copyArray);            
            sumTime +=  System.nanoTime() - untilTime; //Прибавить разницу во времени
        }            
        return  sumTime / measuresCount;               
    }
}
