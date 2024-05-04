import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Maze extends Application {

    @Override
    public void start(Stage stg) throws Exception 
    {
        // Creating directional buttons for player 1
        GridPane dirPane1 = new GridPane();
        dirPane1.setHgap(10);
        dirPane1.setVgap(10);
        
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

        // Creating action buttons for player 1
        GridPane actPane1 = new GridPane();
        Button colTools1 = new Button("Collect Tools");
        actPane1.add(colTools1,1,0);
        Button colParts1 = new Button("Collect Parts");
        actPane1.add(colParts1,2,0);
        Button buildbtn1 = new Button("Build");
        actPane1.add(buildbtn1,3,0);

        // Creating main pane to contain player 1 interface
        GridPane mainPane = new GridPane();
        GridPane player1 = new GridPane();
        player1.add(dirPane1,0,0);
        player1.add(actPane1,0,1);
        Button help1 = new Button("Help! I am lost!!");
        player1.add(help1,0,4);
        mainPane.add(player1,0,1);
        mainPane.add(new Label("Player 1"),0,0);

        // Creating directional buttons for player 2
        // (Similar structure for player 1)
        GridPane dirPane2 = new GridPane();
        // ...

        // Disabling player 2 initially
        player2.setDisable(true);
        
        // Setting up the game manager to switch between players
        class GameManager {
            public void switchAndDisable() {
                // Switching players
                game.switchPlayer();
                // Enabling or disabling players based on the current player
                if(player2.isDisabled()){
                    player2.setDisable(false);
                    player1.setDisable(true);
                } else {
                    player2.setDisable(true);
                    player1.setDisable(false);
                }
            }
        }
        GameManager gameManager = new GameManager();

        // Creating the scene and displaying the stage
        Scene scn = new Scene(mainPane,600,600);
        stg.setScene(scn);
        stg.show();

        // Event handlers for player actions
        // (Similar structure for other player actions)
        class colToolsEvent implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                // Handling collect tools event for current player
                String msg = game.getCurrentPlayer().collectTools();
                System.out.println(msg);
                msgField.setText(msg);
                // Switching players
                gameManager.switchAndDisable();
            }
        }
        colTools1.setOnAction(new colToolsEvent());
        colTools2.setOnAction(new colToolsEvent());

        // ...
    }

    public static void main(String[] args) 
    {
        // Launching the application
        launch(args);
    }
}
