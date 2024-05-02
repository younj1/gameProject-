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
        GridPane dirPane1 = new GridPane();
        dirPane1.setHgap(10);
        dirPane1.setVgap(10);
        
        Button btnUp1 = new Button("Up");
        Button btnDown1 = new Button("Down");
        Button btnLeft1 = new Button("Left");
        Button btnRight1 = new Button("Right");

        Game game = new Game();
        game.InitGame();

        dirPane1.add(btnUp1,2,1);
        dirPane1.add(btnLeft1,1,2);
        dirPane1.add(btnDown1,2,3);
        dirPane1.add(btnRight1,3,2);

        GridPane actPane1 = new GridPane();
        Button colTools1 = new Button("Collect Tools");
        actPane1.add(colTools1,1,0);
        Button colParts1 = new Button("Collect Parts");
        actPane1.add(colParts1,2,0);
        Button buildbtn1 = new Button("Build");
        actPane1.add(buildbtn1,3,0);

        GridPane mainPane = new GridPane();
        Label mainlbl1 = new Label("Make your first move");
        mainPane.add(dirPane1,0,0);
        mainPane.add(actPane1,0,1);
        mainPane.add(mainlbl1,0,3);
        mainPane.add(new Label("Player 1"),0,4);

        GridPane dirPane2 = new GridPane();
        dirPane2.setHgap(10);
        dirPane2.setVgap(10);
        
        Button btnUp2 = new Button("Up");
        Button btnDown2 = new Button("Down");
        Button btnLeft2 = new Button("Left");
        Button btnRight2 = new Button("Right");


        dirPane2.add(btnUp2,2,1);
        dirPane2.add(btnLeft2,1,2);
        dirPane2.add(btnDown2,2,3);
        dirPane2.add(btnRight2,3,2);

        GridPane actPane2 = new GridPane();
        Button colTools2 = new Button("Collect Tools");
        actPane2.add(colTools2,1,0);
        Button colParts2 = new Button("Collect Parts");
        actPane2.add(colParts2,2,0);
        Button buildbtn2 = new Button("Build");
        actPane2.add(buildbtn2,3,0);

        Label mainlbl2 = new Label("Make your first move");
        mainPane.add(dirPane2,1,0);
        mainPane.add(actPane2,1,1);
        mainPane.add(mainlbl2,1,3);
        mainPane.add(new Label("Player 2"),1,4);
        
        actPane2.setDisable(true);//important that you u can do this
        //seperate 2 games into their own class, and have a diableandswitch() mmethod
        mainPane.setHgap(50);
        mainPane.setVgap(10);

        Scene scn = new Scene(mainPane,600,600);
        stg.setScene(scn);
        stg.show();



        class colToolsEvent implements EventHandler<ActionEvent> {
            @Override
                public void handle(ActionEvent event) {
                    System.out.println(game.getCurrentPlayer().collectTools());
                    game.switchPlayer();
                }
            }
        colTools1.setOnAction(new colToolsEvent());
        colTools2.setOnAction(new colToolsEvent());
        
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
