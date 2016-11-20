package sorter.array_generators;

import java.util.Arrays;
import java.util.Collections;
import sorter.array.utils.ArrayConverter;

public class DescSortedArray extends ArrayGenerator {

    @Override
    public int[] generateSingle(int length, int maxValue) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * maxValue);
        }
        Integer[] x = ArrayConverter.toObject(array);
        Arrays.sort(x, Collections.reverseOrder());

        return ArrayConverter.toPrimitive(x);
    }

    @Override
    public String toString() {
        return "descending";
    }

}
