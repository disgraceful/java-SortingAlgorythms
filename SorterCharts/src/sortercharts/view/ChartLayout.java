package sortercharts.view;

import com.sun.org.apache.xerces.internal.util.FeatureState;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sortercharts.helpers.ChartBuilder;
import sorter.array_generators.ArrayGenerator;
import sorter.array_generators.AscSortedArray;
import sorter.array_generators.DescSortedArray;
import sorter.array_generators.RandomArray;
import sorter.array_generators.SortedWithLastRandom;

public class ChartLayout extends Application {

    private static final BorderPane root = new BorderPane();
    private static Stage window;
    private static Scene displayScene;    

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        displayScene = initDisplayScene();
        window.setTitle("Sorter Charts");
        window.setScene(displayScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    private static boolean isSet = false;
    private static Scene initDisplayScene() {
        final GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(15);

        final Label arrayLabel = new Label("Array type:");
        ObservableList<ArrayGenerator> variants = FXCollections.observableArrayList(                
                new AscSortedArray(),
                new SortedWithLastRandom(),
                new DescSortedArray(),
                new RandomArray()
        );

        final ComboBox arrayCB = new ComboBox(variants);
        //arrayCB.setVisibleRowCount(4);
        arrayCB.setValue(new RandomArray());
        
        final Label stepLabel = new Label("Step");
        final Spinner stepSpinner = new Spinner(1, 1000, 100, 1);
        stepSpinner.setMaxWidth(120);
        stepSpinner.setEditable(true);
        
        
        final Label minLengthLabel = new Label("Min array length");
        final Spinner minLengthSpinner = new Spinner(1, 1000, 100, 1);
        minLengthSpinner.setMaxWidth(120);
        minLengthSpinner.setEditable(true);
        
        final Label maxLengthLabel = new Label("Max array length");
        final Spinner maxLengthSpinner = new Spinner(1, 50000, 2000, 1);
        maxLengthSpinner.setMaxWidth(120);
        maxLengthSpinner.setEditable(true);
                
        final Button displayButton = new Button();
        displayButton.setText("Measure sort speed");        
        
        displayButton.setOnAction((ActionEvent e) -> {
            //show new time measures
            ChartBuilder.getInstance().rebuildChart((ArrayGenerator) arrayCB.getValue(),
                    (int) minLengthSpinner.getValue(),(int) maxLengthSpinner.getValue(),
                    (int) stepSpinner.getValue());            
        });

        GridPane.setConstraints(arrayLabel, 0, 0);
        GridPane.setConstraints(arrayCB, 1, 0);
        
        GridPane.setConstraints(stepLabel, 0, 2);
        GridPane.setConstraints(stepSpinner, 1, 2);
        
        GridPane.setConstraints(minLengthSpinner, 1, 3);
        GridPane.setConstraints(minLengthLabel, 0, 3);
        
        GridPane.setConstraints(maxLengthLabel, 0, 4);
        GridPane.setConstraints(maxLengthSpinner, 1, 4);
        GridPane.setConstraints(displayButton, 1, 6);

        grid.getChildren().addAll(arrayLabel, arrayCB,
                stepLabel,stepSpinner, displayButton,minLengthLabel,minLengthSpinner,
                maxLengthLabel,maxLengthSpinner);
        
        root.setLeft(grid);
        root.setCenter(ChartBuilder.getInstance().getChart());         
        
        Scene scene = new Scene(root, 1000, 700);
        return scene;
    }
}
