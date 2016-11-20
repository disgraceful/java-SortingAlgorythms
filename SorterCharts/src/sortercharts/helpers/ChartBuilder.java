package sortercharts.helpers;

import java.util.List;
import java.util.ServiceLoader;
import javafx.collections.FXCollections;
import sorter.array_generators.ArrayGenerator;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import sorter.algorythms.*;

public class ChartBuilder {
    
    public static ChartBuilder current;    
    private static List<AlgCurveBuilder> _curvesBuilders;    
    private LineChart lineChart;
       
    private ChartBuilder() { 
        //todo find algorythms with reflection
        _curvesBuilders = FXCollections.observableArrayList(
                new AlgCurveBuilder(new BubbleSortAscending(), "Bubble Sort Asc"),
                new AlgCurveBuilder(new BubbleSortDescending(), "Bubble Sort Desc"),
                new AlgCurveBuilder(new JavaSort(), "Java Sort"),
                new AlgCurveBuilder(new MergingSort(), "Merging Sort"),
                new AlgCurveBuilder(new RecursiveSort(), "Recur Insertion Sort")
        );     
         
        createChart();
    }

    //pattern Singleton - because we declare curvebuilders collection only once
    public static ChartBuilder getInstance() {
        if (current == null) {
            current = new ChartBuilder();
        }
        return current;
    }
    
    public LineChart getChart()
    {
        return lineChart;
    }
    
    public void rebuildChart (ArrayGenerator arrayGen, int minLength, int maxLength, int step){
        //generate arrays with new parameters
        List<int[]> arrays = arrayGen.generateMultiples(minLength, maxLength, step, Integer.MAX_VALUE);  
        //renew curves (provide time measures for new arrays)
        _curvesBuilders.forEach((curveBuilder) -> {             
            curveBuilder.doExperiments(arrays);            
        });
    }
    
    private void createChart()
    {
        //create new line chart
        final NumberAxis axisX = new NumberAxis();
        axisX.setLabel("Elements of array");
        
        final NumberAxis axisY = new NumberAxis();
        axisY.setLabel("Time of execeution (seconds)");
        
        lineChart = new LineChart<>(axisX, axisY);
        lineChart.setTitle("Sorting Algorythm Chart");    
             
        //add empty curves to line chart. Curves will be filled with data(points) later         
        _curvesBuilders.forEach((curveBuilder) -> {        
            lineChart.getData().add(curveBuilder.getSeries());    
        });
    }
    
    //public LineChart buildDisplayChart(ArrayGenerator arrayGen, int minLength, int maxLength, int step) {
    //      System.out.println(arrayGen.getClass().toString());
        
//        //Создание новой диаграммы
//        final NumberAxis axisX = new NumberAxis();
//        axisX.setLabel("Elements of array");
//        
//        final NumberAxis axisY = new NumberAxis();
//        axisY.setLabel("Time of execeution (seconds)");
//        
//        lineChart = new LineChart<>(axisX, axisY);
//        lineChart.setTitle("Sorting Algorythm Chart");
//                              
        //генерация массивов с задаными параметрами
        //List<int[]> arrays = arrayGen.generateMultiples(minLength, maxLength, step, Integer.MAX_VALUE);   
        
//        //генерация кривых времени сортировки для каждого алгоритма
//        _curvesBuilders.forEach((curveBuilder) -> { 
//            //очистить прошлый результат
//            curveBuilder.doExperiments(arrays);
//            //добавить линию (серию испытаний) на диаграму
//            if(!curveBuilder.isAdded){
//                lineChart.getData().add(curveBuilder.getSeries());
//                curveBuilder.isAdded = true;
//            }
//        });
        
    //    return lineChart;
    //}
}
