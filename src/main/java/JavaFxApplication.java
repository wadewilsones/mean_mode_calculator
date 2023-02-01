import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.FlowPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class JavaFxApplication extends Application {

    @Override
    public void start(Stage window) {

        HBox buttons = new HBox();
        Button mean = new Button("Get mean");
        Button mode = new Button("Get mode");

        //Add buttons to layout
        buttons.setSpacing(20);
        buttons.getChildren().add(mean);
        buttons.getChildren().add(mode);

        //Layout
        Label headings = new Label ("Calculate mean or mode");
        Label description = new Label ("Type your data set here using commas");
        TextField dataSet = new TextField(); // DataSet input

        FlowPane textHolder = new FlowPane();
        textHolder.getChildren().add(headings);
        textHolder.getChildren().add(description);
        textHolder.getChildren().add(dataSet);

        BorderPane layout = new BorderPane();
        layout.setTop(textHolder);
        layout.setCenter(buttons);

        Label meanResultDisplay = new Label();
        Label modeResultDisplay = new Label();
        //Display Mean and Mode
        textHolder.getChildren().add(meanResultDisplay);
        textHolder.getChildren().add(modeResultDisplay);


        Scene view = new Scene(layout);

        //Add event for buttons
        EventHandler<MouseEvent> calculateMean = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                //dataSet.getText();
                if(dataSet.getText().equals("")){
                    //Create a new element with error
                    Label error = new Label ("Input can't be empty!");
                    textHolder.getChildren().add(error);
                }

                Calculator myCalculator = new Calculator(dataSet.getText());
                Double meanResult = myCalculator.getMean(myCalculator.getDataSet());
                String meanResultFormatted = String.format("%, .2f", meanResult);
                meanResultDisplay.setText("The mean is: " + meanResultFormatted);
            }
        };

        EventHandler<MouseEvent> calculateMode = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                //dataSet.getText();
                if(dataSet.getText().equals("")){
                    //Create a new element with error
                    Label error = new Label ("Input can't be empty!");
                    textHolder.getChildren().add(error);
                }

                Calculator myCalculator = new Calculator(dataSet.getText());
                String modeResult = myCalculator.getMod(myCalculator.getDataSet());
                meanResultDisplay.setText(modeResult);
            }
        };

        mean.addEventFilter(MouseEvent.MOUSE_CLICKED, calculateMean);
        mode.addEventFilter(MouseEvent.MOUSE_CLICKED, calculateMode);


        //Window
        window.setTitle("Calculator");
        window.setMinWidth(400);
        window.setMinHeight(400);
        window.setScene(view);
        window.show();
    }


}