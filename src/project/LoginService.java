package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class LoginService extends Application {
	DatabaseModel databaseModel;

	
	public static void main(String[] args) {

		launch(args);
	}
	
	public void start(Stage primaryStage) {
		databaseModel = new DatabaseModel();
		databaseModel.connect();
		
		primaryStage.setTitle("Instructor Home page");
        TextField username = new TextField();
        TextField password = new TextField();
        // set title for the stage
        
        Button btn = new Button();
        btn.setText("Log In");
        
        Button btn2 = new Button();
        btn2.setText("One Time Code");
 
        // set preferred column count
        username.setPrefColumnCount(7);
        
        User user = new User();
        
        
        btn.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	
	            	user.username = username.getText();
	            	user.password = password.getText();	
	            	
//	            	if(database.user)
	            	
                } 
            });
        
        btn2.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				OneTimePassPage create = new OneTimePassPage(primaryStage, user, databaseModel);
			}
        	
        });
 
        // create a tile pane
        TilePane r = new TilePane();
 
        // create a label
        Label l = new Label("Enter Username: ");
        Label l2 = new Label("Enter Password: ");

        
        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        root.getChildren().add(username);
//        root.getChildren().add(password);
        r.getChildren().add(l);
        r.getChildren().add(username);
        r.getChildren().add(l2);
        r.getChildren().add(password);
        r.getChildren().add(btn);
        r.getChildren().add(btn2);
        
        primaryStage.setScene(new Scene(r, 350, 250));
        primaryStage.show();
	}

}
