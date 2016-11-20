package sorter.array_generators;

import java.util.Arrays;

public class AscSortedArray extends ArrayGenerator {

    @Override
    public int[] generateSingle(int length, int maxValue) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * maxValue);
        }
        Arrays.sort(array);
        return array;
    }

    @Override
    public String toString() {
        return "ascending";
    }
}
