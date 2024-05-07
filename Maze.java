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

// Defining the Maze class that extends Application
public class Maze extends Application {

    // Overriding the start method from the Application class
    @Override
    public void start(Stage stg) throws Exception 
    {
        // Creating the grid pane for player 1's directional buttons
        GridPane dirPane1 = new GridPane();
        dirPane1.setHgap(10);
        dirPane1.setVgap(10);
        
        // Creating directional buttons for player 1
        Button btnUp1 = new Button("Up");
        Button btnDown1 = new Button("Down");
        Button btnLeft1 = new Button("Left");
        Button btnRight1 = new Button("Right");

        // Initializing the game
        Game game = new Game();
        game.InitGame();

        // Adding directional buttons for player 1 to the grid pane
        dirPane1.add(btnUp1,2,1);
        dirPane1.add(btnLeft1,1,2);
        dirPane1.add(btnDown1,2,3);
        dirPane1.add(btnRight1,3,2);

        // Creating the grid pane for player 1's actions
        GridPane actPane1 = new GridPane();
        Button colTools1 = new Button("Collect Tools");
        actPane1.add(colTools1,1,0);
        Button colParts1 = new Button("Collect Parts");
        actPane1.add(colParts1,2,0);
        Button buildbtn1 = new Button("Build");
        actPane1.add(buildbtn1,3,0);

        // Creating the main grid pane
        GridPane mainPane = new GridPane();
        GridPane player1 = new GridPane();
        player1.add(dirPane1,0,0);
        player1.add(actPane1,0,1);
        Button help1 = new Button("Help! I am lost!!");
        player1.add(help1,0,4);
        mainPane.add(player1,0,1);
        mainPane.add(new Label("Player 1"),0,0);

        // Creating the grid pane for player 2's directional buttons
        GridPane dirPane2 = new GridPane();
        dirPane2.setHgap(10);
        dirPane2.setVgap(10);
        
        // Creating directional buttons for player 2
        Button btnUp2 = new Button("Up");
        Button btnDown2 = new Button("Down");
        Button btnLeft2 = new Button("Left");
        Button btnRight2 = new Button("Right");

        // Adding directional buttons for player 2 to the grid pane
        dirPane2.add(btnUp2,2,1);
        dirPane2.add(btnLeft2,1,2);
        dirPane2.add(btnDown2,2,3);
        dirPane2.add(btnRight2,3,2);

        // Creating the grid pane for player 2's actions
        GridPane actPane2 = new GridPane();
        Button colTools2 = new Button("Collect Tools");
        actPane2.add(colTools2,1,0);
        Button colParts2 = new Button("Collect Parts");
        actPane2.add(colParts2,2,0);
        Button buildbtn2 = new Button("Build");
        actPane2.add(buildbtn2,3,0);

        // Creating the grid pane for player 2
        GridPane player2 = new GridPane();
        player2.add(dirPane2,0,0);
        player2.add(actPane2,0,1);
        Button help2 = new Button("Help! I am lost!!");
        player2.add(help2,0,4);
        mainPane.add(player2,1,1);
        mainPane.add(new Label("Player 2"),1,0);
        player2.setDisable(true);
        
        // Setting the horizontal and vertical gaps for the main pane
        mainPane.setHgap(50);
        mainPane.setVgap(10);

        // Creating a text field for displaying messages
        TextField msgField = new TextField();
        mainPane.setColumnSpan(msgField, 2);
        msgField.setEditable(false);
        mainPane.add(msgField,0,5);

        // Defining a GameManager class for managing game state
        class GameManager {
            public void switchAndDisable() {
                game.switchPlayer();
                if(player2.isDisabled()){
                    player2.setDisable(false);
                    player1.setDisable(true);
                }else{
                    player2.setDisable(true);
                    player1.setDisable(false);
                }
            }
        }
        GameManager gameManager = new GameManager();

        // Creating and setting the scene
        Scene scn = new Scene(mainPane,600,600);
        stg.setScene(scn);
        stg.show();


        // Event handler for collecting tools
        class colToolsEvent implements EventHandler<ActionEvent> {
            @Override
                public void handle(ActionEvent event) {
                    String msg = game.getCurrentPlayer().collectTools();
                    System.out.println(msg);
                    msgField.setText(msg);
                    gameManager.switchAndDisable();
                }
            }
        colTools1.setOnAction(new colToolsEvent());
        colTools2.setOnAction(new colToolsEvent());

        // Event handler for collecting parts
        class colPartsEvent implements EventHandler<ActionEvent> {
            @Override
                public void handle(ActionEvent event) {
                    String msg = game.getCurrentPlayer().collectPart();
                    System.out.println(msg);
                    msgField.setText(msg);
                    gameManager.switchAndDisable();
                }
            }
        colParts1.setOnAction(new colPartsEvent());
        colParts2.setOnAction(new colPartsEvent());

        // Event handler for building
        class buildEvent implements EventHandler<ActionEvent> {
            @Override
                public void handle(ActionEvent event) {
                    String msg = game.getCurrentPlayer().build();
                    System.out.println(msg);
                    msgField.setText(msg);
                    if(msg.contains("Won")){
                    player1.setDisable(true);
                    player2.setDisable(true);
                    }
                    else{
                    gameManager.switchAndDisable();
                    }
                }
            }
        buildbtn1.setOnAction(new buildEvent());
        buildbtn2.setOnAction(new buildEvent());

        // Event handler for moving up
        class moveUpEvent implements EventHandler<ActionEvent> {
            @Override
                public void handle(ActionEvent event) {
                    String msg = game.getCurrentPlayer().move(Direction.up);
                    System.out.println(msg);
                    msgField.setText(msg);
                    gameManager.switchAndDisable();
                }
            }
        btnUp1.setOnAction(new moveUpEvent());
        btnUp2.setOnAction(new moveUpEvent());

        // Event handler for moving down
        class moveDownEvent implements EventHandler<ActionEvent> {
            @Override
                public void handle(ActionEvent event) {
                    String msg = game.getCurrentPlayer().move(Direction.down);
                    System.out.println(msg);
                    msgField.setText(msg);
                    gameManager.switchAndDisable();
                }
            }
        btnDown1.setOnAction(new moveDownEvent());
        btnDown2.setOnAction(new moveDownEvent());

        // Event handler for moving left
        class moveLeftEvent implements EventHandler<ActionEvent> {
            @Override
                public void handle(ActionEvent event) {
                    String msg = game.getCurrentPlayer().move(Direction.left);
                    System.out.println(msg);
                    msgField.setText(msg);
                    gameManager.switchAndDisable();
                }
            }
        btnLeft1.setOnAction(new moveLeftEvent());
        btnLeft2.setOnAction(new moveLeftEvent());

        // Event handler for moving right
        class moveRightEvent implements EventHandler<ActionEvent> {
            @Override
                public void handle(ActionEvent event) {
                    String msg = game.getCurrentPlayer().move(Direction.right);
                    System.out.println(msg);
                    msgField.setText(msg);
                    gameManager.switchAndDisable();
                }
            }
        btnRight1.setOnAction(new moveRightEvent());
        btnRight2.setOnAction(new moveRightEvent());

        // Event handler for help button
        class helpEvent implements EventHandler<ActionEvent> {
            @Override
                public void handle(ActionEvent event) {
                    String msg = game.getCurrentPlayer().currentRoom().helpMessage();
                    System.out.println(msg);
                    msgField.setText(msg);
                }
            }
        help1.setOnAction(new helpEvent());
        help2.setOnAction(new helpEvent());

        // Event handler for restart button
        class restartEvent implements EventHandler<ActionEvent> {
            @Override
                public void handle(ActionEvent event) {
                    game.InitGame();
                    if(player2.isDisable() == false){
                        gameManager.switchAndDisable();
                    }
                    if(player1.isDisable() == true){
                        player1.setDisable(false);
                    }
                }
            }
        Button rsrtButton = new Button("Restart");
        mainPane.add(rsrtButton,0,4);
        rsrtButton.setOnAction(new restartEvent());
    }

    // Main method
    public static void main(String[] args) 
    {
        launch(args);
    }
}
