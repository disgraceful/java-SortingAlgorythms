package sorter.strategy;

public class SortingContext {

private SortingAlgorythm _sortingStrategy;

    public SortingContext(SortingAlgorythm sortingStrategy) throws NullPointerException{
        if(sortingStrategy==null) {
            throw new NullPointerException("Sorting Algortytm is null");
        }
        else{
            _sortingStrategy = sortingStrategy;
        }
    }
    public void setAlgorythm(SortingAlgorythm sortingStrategy)throws NullPointerException{
        if(sortingStrategy==null) {
            throw new NullPointerException("Sorting Algortytm is null");
        }
        else{
            _sortingStrategy = sortingStrategy;
        }        
     }
    public void sort(int[]arrayToSort){
        _sortingStrategy.sort(arrayToSort);
    }
}
    



