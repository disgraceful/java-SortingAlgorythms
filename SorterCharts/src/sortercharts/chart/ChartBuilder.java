package sortercharts.chart;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sorter.array.generators.ArrayGenerator;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import sorter.algorythms.BubbleSortAscending;
import sorter.algorythms.BubbleSortDescending;
import sorter.algorythms.JavaSort;
import sorter.algorythms.MergingSort;
import sorter.algorythms.RecursiveInsertionSort;
import sorter.strategy.SortingAlgorythm;
import sorter.strategy.SortingContext;
import sorter.array.generators.GeneratorContext;
import sorter.array.utils.Test;

public class ChartBuilder {

    private static LineChart<Number, Number> lineChart;
    private static int[] sortingArray;
    private static List<SortingAlgSeries> algSeries;
    public static GeneratorContext genContext;
    private static int initialLength;

    static {
        genContext = new GeneratorContext();
    }

    public static LineChart displayChart(ArrayGenerator arrayGen, int initCapacity) {
        System.out.println(arrayGen.getClass().toString());
        final NumberAxis axisX = new NumberAxis();
        final NumberAxis axisY = new NumberAxis();

        lineChart = new LineChart<Number, Number>(axisX, axisY);
        axisX.setLabel("Elements of array");
        axisY.setLabel("Time of execeution (seconds)");
        lineChart.setTitle("Sorting Algorythm Chart");

        genContext.setAlgorythm(arrayGen);
        initialLength = initCapacity;

        ObservableList<SortingAlgSeries> series = FXCollections.observableArrayList(
                new SortingAlgSeries(new BubbleSortAscending(), "Bubble Sort Asc"),
                new SortingAlgSeries(new BubbleSortDescending(), "Bubble Sort Desc"),
                new SortingAlgSeries(new JavaSort(), "Java Sort"),
                new SortingAlgSeries(new MergingSort(), "Merging Sort"),
                new SortingAlgSeries(new RecursiveInsertionSort(), "Recur Insertion Sort")
        );

        fillData(series);

        series.stream().forEach((e) -> {
            lineChart.getData().add(e.getSeries());
        });
        return lineChart;

    }

    private static void fillData(ObservableList<SortingAlgSeries> series) {
        int temp = initialLength + 5000;
        while (initialLength <= temp) {

            series.stream()
                    .forEach((alg) -> {

                        long sumTime = 0;
                        int count = 10;
                        for (int i = 0; i < count; i++) {
                            sortingArray = genContext.generate(initialLength, Integer.MAX_VALUE);
                            //Test.print(sortingArray);
                            System.out.println(alg.getAlgorythm().getClass().toString());
                            long curTime = System.nanoTime();
                            alg.getAlgorythm().sort(sortingArray);
                            long afterTime = System.nanoTime() - curTime;
                            sumTime += afterTime;

                        }
                        double seconds = sumTime / 1_000_000_000.0 / count;
                        alg.getSeries().getData().add(new XYChart.Data(sortingArray.length, seconds));
                    });
            initialLength += 500;
        }

    }
}
