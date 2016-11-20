package sorter.array_generators;

public class RandomArray extends ArrayGenerator {

    @Override
    public int[] generateSingle(int length, int maxValue) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * maxValue);
        }
        return array;
    }

    @Override
    public String toString() {
        return "shuffled";
    }
}
