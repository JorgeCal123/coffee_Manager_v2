package application;
	
import java.io.IOException;

import controller.home_controller;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		// carga todos los recursos de un archivo FXML
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/home.fxml"));
			
			//Parent cargara lo que tiene la vista
			Parent root = loader.load();
			Scene scene = new Scene(root);
			// primary stage hace referencia a la ventana completa
			primaryStage.setScene(scene);
		
			// home_control  == window1controller
			home_controller home_control = loader.getController();
			home_control.setStage(primaryStage);

			primaryStage.setTitle("Coffee Manager JC");
			primaryStage.show();
		
		
	/*	original
	 * try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("coffe_M.fxml"));
			
			Scene scene = new Scene(root,root.getPrefWidth(),root.getPrefHeight());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Coffee Manager JC");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
*/	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
