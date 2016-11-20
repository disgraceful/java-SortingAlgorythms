package sorter.array_generators;

import java.util.ArrayList;
import java.util.List;

public abstract class ArrayGenerator {

    public abstract int[] generateSingle(int length, int maxValue);

    public List<int[]> generateMultiples(int minLength, int maxLength, int step, int maxValue) {
        List<int[]> arrays = new ArrayList<int[]>();

        for (int len = minLength; len < maxLength; len += step) {
            arrays.add(generateSingle(len, maxValue));
        }

        return arrays;
    }
}
