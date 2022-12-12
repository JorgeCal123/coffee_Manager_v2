package controller;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class home_controller {
 

	@FXML
	private Pane home;

	@FXML
	private ImageView fondo;
	@FXML
	private ImageView slogan;
	@FXML
	private ImageView logo2;
	@FXML
	private Button butSignIn;
	@FXML
	private Button butsignUp;
	@FXML
	private Label textslogan1;
	@FXML
	private Label textslogan2;

	private Stage stage_home;

	public void initialize() {
		init_Home();
	}
	
	public void init_Home() {
		File file = new File("img/fondo1.jpg");
		Image img = new Image(file.toURI().toString());
		fondo.setImage(img);
		
		File file1 = new File("img/title-logo.png");
		Image img1 = new Image(file1.toURI().toString());
		//en base al tamaño de la anchura se va a colocar la altura
		//Evitar que se distorsione la imagen
		slogan.setPreserveRatio(true);
		//Aplicar suavidad y no se vean los pixeles
		slogan.setSmooth(true);
		// Guarda la imagen en la cache
		slogan.setCache(true);
		slogan.setImage(img1);

	}
	
	@FXML
	private void showSignin() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/signIn.fxml"));
			Parent root = loader.load();
			signController sign_control = loader.getController();
			Scene scene = new Scene(root);
			Stage stage_sign = new Stage();
			stage_sign.setScene(scene);
			sign_control.init_Sign(stage_sign, this);
			stage_sign.show();
			stage_home.close();
		
	}
	

	public void setStage(Stage primaryStage) {
		stage_home = primaryStage;
	}
	public void show_home() {
		stage_home.show();
		
	}

}
