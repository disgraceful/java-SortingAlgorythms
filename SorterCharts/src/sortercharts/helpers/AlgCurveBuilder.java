package sortercharts.helpers;

import com.sun.javafx.collections.ElementObservableListDecorator;
import com.sun.javafx.collections.ObservableListWrapper;
import java.util.Arrays;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import sorter.algorythms.SortingAlgorythm;
import sorter.metering.SortTimeMeter;

//prev AlgSortSeries
//Class is respisible of filling Point of chart
public class AlgCurveBuilder {

    private final SortingAlgorythm _sortAlg;
    private final XYChart.Series _algSeries;
    public boolean isAdded = false;

    public AlgCurveBuilder(SortingAlgorythm sortAlg, String seriesName) {
        this._sortAlg = sortAlg;
        _algSeries = new XYChart.Series();
        _algSeries.setName(seriesName);
    }

    public XYChart.Series getSeries() {
        return _algSeries;
    }
    
    public void clearSeries(){
        _algSeries.getData().clear();
    }

    public SortingAlgorythm getAlgorythm() {
        return _sortAlg;
    }    
    
    public void doExperiments(List<int[]> arrays){  
        clearSeries();
        arrays.forEach(array -> { 
            long time = SortTimeMeter.countSortTime(array, _sortAlg);
            getSeries().getData().add(new XYChart.Data(array.length, time / 1_000_000_000.0));
        });
    }    
}
