package sorter.algorythms;

import sorter.strategy.SortingAlgorythm;

public class BubbleSortAscending implements SortingAlgorythm{

    //bubble sorting alg in ascending order
    @Override
public void sort(int[]arrayToSort){
    int temp;
    for(int i=0; i<arrayToSort.length-1;i++){
        for(int j=1;j<arrayToSort.length-i;j++){
            if(arrayToSort[j-1]>arrayToSort[j]){
                temp = arrayToSort[j-1];
                arrayToSort[j-1]= arrayToSort[j];
                arrayToSort[j]=temp;
            }
        }
        
    }
}    
}
