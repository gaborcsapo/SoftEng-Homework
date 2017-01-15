package impl.ViewTypes;

import api.Controller;
import impl.GameController;
import impl.GameFactory;
import impl.GameTemplate;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GraphicalView extends Application {
	private Circle circle;
	private Scene scene;
	private GameTemplate game;
	private GameFactory factory= new GameFactory();
	private Controller controller;
		
	public void init(){
		game = factory.createGameType(getParameters().getRaw().get(0));
    	controller = new GameController(game);
	}

	public void start(Stage primaryStage) {
		//SETUP
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);
		pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11, 12, 13, 14));
        
        //DISKS
        for (int r = 0; r < game.getRows(); r++){
        	for (int c = 0; c < game.getColumns() ; c++){
        		circle = new Circle(30);
        		circle.fillProperty().bind(game.getBoard()[r][c]);
        		GridPane.setRowIndex(circle, r);
                GridPane.setColumnIndex(circle, c);
                pane.add(circle, c, game.getRows()-r);              
        	}
        }
        
        //CURRENTPLAYER CIRCLE
        circle = new Circle(30);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(7);
		circle.fillProperty().bind(game.getCurrentPlayer());
		pane.add(circle, game.getColumns()+3, game.getRows());
		
		//WINNER CIRCLE
		circle = new Circle(30);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(7);
        game.bindToWinningPlayer(circle.fillProperty());
		pane.add(circle, game.getColumns()+3, game.getRows()-1);       		
		
		//MOUSE CLICK HANDLER I could set onmouseclick events on each circle, but then I can't click inbetween the circles
		pane.setOnMouseClicked(e -> {
			for( Node node: pane.getChildren()) {
				if( node instanceof Circle) {
					if( node.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())) {
						controller.handlePlaceDisk(GridPane.getRowIndex(node), GridPane.getColumnIndex(node));
						break;
					}
				}
			}
		});
				
        scene = new Scene(pane);
		primaryStage.setTitle("ConnectFour V2"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
	}
}
