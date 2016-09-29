package sorter.algorythms;

import java.util.Arrays;
import sorter.strategy.SortingAlgorythm;

public class JavaSort implements SortingAlgorythm {

    @Override
    public void sort(int[] arrayToSort) {
        Arrays.sort(arrayToSort);
    }
    
}
