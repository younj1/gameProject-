//Importing stuff that is needed
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Maze extends Application {

    @Override
    public void start(Stage stg) throws Exception 
    {
        // Creating a grid pane for direction buttons
        GridPane dirPane1 = new GridPane();
        dirPane1.setHgap(10);
        dirPane1.setVgap(10);
        
        // Creating buttons for directions
        Button btnUp1 = new Button("Up");
        Button btnDown1 = new Button("Down");
        Button btnLeft1 = new Button("Left");
        Button btnRight1 = new Button("Right");

        // Initializing the game
        Game game = new Game();
        game.InitGame();

        // Adding direction buttons to the grid pane
        dirPane1.add(btnUp1, 2, 1);
        dirPane1.add(btnLeft1, 1, 2);
        dirPane1.add(btnDown1, 2, 3);
        dirPane1.add(btnRight1, 3, 2);

        // Creating a grid pane for action buttons
        GridPane actPane1 = new GridPane();
        Button colTools1 = new Button("Collect Tools");
        actPane1.add(colTools1, 1, 0);
        Button colParts1 = new Button("Collect Parts");
        actPane1.add(colParts1, 2, 0);
        Button buildbtn1 = new Button("Build");
        actPane1.add(buildbtn1, 3, 0);

        // Creating the main grid pane
        GridPane mainPane = new GridPane();
        Label mainlbl1 = new Label("Make your first move");
        mainPane.add(dirPane1, 0, 0);
        mainPane.add(actPane1, 0, 1);
        mainPane.add(mainlbl1, 0, 3);
        mainPane.add(new Label("Player 1"), 0, 4);

        // Similar setup for Player 2
        // Omitted for brevity

        // Disabling the action pane for Player 2
        actPane2.setDisable(true);

        // Setting the horizontal and vertical gaps for the main pane
        mainPane.setHgap(50);
        mainPane.setVgap(10);

        // Creating the scene and setting it to the stage
        Scene scn = new Scene(mainPane, 600, 600);
        stg.setScene(scn);
        stg.show();

        // Handling event for clicking on the "Collect Tools" button
        class colToolsEvent implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                // Add your event handling code here
            }
        }
    }
}
