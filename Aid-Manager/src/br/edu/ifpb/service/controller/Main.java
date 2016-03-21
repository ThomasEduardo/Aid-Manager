package br.edu.ifpb.service.controller;





import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
	
	public static Stage primaryStage;
	public static Object stage;
	public static Scene scene;
	
	public void start(Stage primaryStage) throws Exception{
		try {

			this.primaryStage = primaryStage;
			
			Parent root = FXMLLoader.load(getClass().getResource("ui/forms/TelaInicial.fxml"));
			
			this.scene = new Scene(root);
			
			primaryStage.setTitle("Aid Manager");
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();

		} catch (Exception e) {

		    // generic exception handling
		    e.printStackTrace();
		}
		

	}
	
	public static void main(String[] args){
		launch(args);
	}
}
