package sorter.algorythms;

public class BubbleSortDescending extends SortingAlgorythm {    
    //bubble sort alg in descending order
    
    @Override
    public void sort(int[]arrayToSort){
        int temp;
        for(int i=0;i<arrayToSort.length-1;i++){
            for(int j=arrayToSort.length-2;j>=i;j--){
                if(arrayToSort[j+1]>arrayToSort[j]){
                    temp = arrayToSort[j+1];
                    arrayToSort[j+1]= arrayToSort[j];
                    arrayToSort[j]=temp;
                }
            }
        }
    }    
}
