package sorter.algorythms;

import sorter.strategy.SortingAlgorythm;


public class MergingSort implements SortingAlgorythm {
    
    private int[] array;
    private int[]tempArray;
    private int length;
          
    @Override
    public void sort(int[]arrayToSort){
        this.array = arrayToSort;
        this.length = arrayToSort.length;
        this.tempArray = new int[length];
        mergeSort(0,length-1);
    }
    
    private void mergeSort(int lowerIndex,int higherIndex){
        if(lowerIndex<higherIndex){
            int midIndex = lowerIndex +(higherIndex-lowerIndex)/2;
            //recursive call for left side of array;
            mergeSort(lowerIndex, midIndex);
            //recursive call for right side of array;
            mergeSort(midIndex+1,higherIndex);
            //merge both sides
            mergeSides(lowerIndex,midIndex,higherIndex);            
        }
    }
    
    private void mergeSides(int lowerIndex,int midIndex,int higherIndex){
        for(int i=lowerIndex;i<=higherIndex;i++){
            tempArray[i]= array[i];
        }
        
        int i= lowerIndex;
        int j= midIndex +1;
        int k = lowerIndex;
        
        while(i<= midIndex && j<=higherIndex){
            if(tempArray[i]<=tempArray[j]){
                array[k]= tempArray[i];
                i++;
            }else{
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        
        while(i <= midIndex){
            array[k] = tempArray[i];
            k++;
            i++;
        }
        
    }
    
    
}
