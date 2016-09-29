package sorter.array.generators;


public class SortedWithLastRandom implements ArrayGenerator {
      @Override public int[] generate(int length,int maxValue){
        int [] array = new int[length];
        for(int i=0;i<array.length;i++){
            array[i]= (int)(Math.random() * maxValue);
        }
        int random = (int)(Math.random()*maxValue);
        array[array.length-1] = random;
        return array;
    }
      
       @Override public String toString(){
            return "last radnom";
        }
}
