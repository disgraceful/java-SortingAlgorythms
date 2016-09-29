package sortercharts.view;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sorter.algorythms.BubbleSortAscending;
import sorter.strategy.SortingAlgorythm;
import sortercharts.chart.ChartBuilder;
import sorter.array.generators.ArrayGenerator;
import sorter.array.generators.AscSortedArray;
import sorter.array.generators.DescSortedArray;
import sorter.array.generators.RandomArray;
import sorter.array.generators.SortedWithLastRandom;


 public class ChartLayout extends Application {

    private static BorderPane root = new BorderPane();
    private static Stage window;
    private static Scene displayScene;
    
    
    @Override public void start(Stage primaryStage) {
        window = primaryStage;
        displayScene = initDisplayScene();
        window.setTitle("Sorter Charts");
        window.setScene(displayScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static Scene initDisplayScene() {
       
        final GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(15);
 
         final Label arrayLabel = new Label("Sorting array:");
        
        ObservableList<ArrayGenerator> variants = FXCollections.observableArrayList(
                new AscSortedArray(),
                new SortedWithLastRandom(),
                new DescSortedArray(),
                new RandomArray()
        );
    
        final ComboBox arrayCB = new ComboBox(variants);
        arrayCB.setVisibleRowCount(3);
        arrayCB.setValue(new AscSortedArray());
        
        final Label startElementLabel = new Label("Elements number:");
        final Spinner elementSpinner = new Spinner(0,1000,1,1);
        elementSpinner.setMaxWidth(120);
        elementSpinner.setEditable(true);
        final Button displayButton = new Button();
        displayButton.setText("drawGraph");
        displayButton.setOnAction(e->{
            if(arrayCB.getValue()!=null){
            root.setCenter(ChartBuilder.displayChart((ArrayGenerator)arrayCB.getValue(), (int)elementSpinner.getValue()));
            }
        });
        
        GridPane.setConstraints(arrayLabel, 0, 0);
        GridPane.setConstraints(arrayCB, 1, 0);
        GridPane.setConstraints(startElementLabel, 0, 1);
        GridPane.setConstraints(elementSpinner, 1, 1);
        GridPane.setConstraints(displayButton, 1, 2);
       
        grid.getChildren().addAll(arrayLabel,arrayCB,startElementLabel,elementSpinner,displayButton);
        
        root.setLeft(grid);
       // root.setCenter(ChartBuilder.displayChart((ArrayGenerator)arrayCB.getValue(), (int)elementSpinner.getValue()));
        Scene scene = new Scene(root, 1000, 700);
        return scene;
    }
}
