package sorter.array.utils;

public class ArrayConverter {

    //converts int[] to Integer[] (primitive array to object array)
    public static Integer[] toObject(int[] intArray) {
        Integer[] result = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            result[i] = Integer.valueOf(intArray[i]);
        }
        return result;
    }

    //convert Intger[] to int[] (object array to primitive array)
    public static int[] toPrimitive(Integer[] integerArray) {
        int[] result = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            result[i] = integerArray[i].intValue();
        }
        return result;
    }
}
