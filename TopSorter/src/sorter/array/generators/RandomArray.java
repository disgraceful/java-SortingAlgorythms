package sorter.array.generators;

public class RandomArray implements ArrayGenerator {

    @Override public int[] generate(int length,int maxValue ){
        int [] array = new int[length];
        for(int i=0;i<array.length;i++){
            array[i]= (int)(Math.random() * maxValue);
        }
        return array;
    }
    
     @Override public String toString(){
            return "shuffled";
        }
}
