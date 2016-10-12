package sortercharts.chart;

import javafx.scene.chart.XYChart;
import sorter.strategy.SortingAlgorythm;

public class SortingAlgSeries {

    private SortingAlgorythm sortAlg;
    private final XYChart.Series algSeries;

    public SortingAlgSeries(SortingAlgorythm sortAlg, String seriesName) {
        this.sortAlg = sortAlg;
        algSeries = new XYChart.Series();
        algSeries.setName(seriesName);
    }

    public XYChart.Series getSeries() {
        return algSeries;
    }

    public SortingAlgorythm getAlgorythm() {
        return sortAlg;
    }

    public void setAlgorythm(SortingAlgorythm sortAlg) {
        if (sortAlg != null) {
            this.sortAlg = sortAlg;
        }
    }
}
