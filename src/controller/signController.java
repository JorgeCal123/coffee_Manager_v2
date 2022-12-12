package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signController {


    @FXML
    private Button registrarse;
    @FXML
    private TextField cedula;
    @FXML
    private PasswordField contra;
    @FXML
    private Label error_cedula;
    @FXML
    private Label error_contra;

    private static final String CEDULA_REGEX =
            "{4,8}$";

    private static final Pattern CEDULA_PATTERN =
            Pattern.compile(CEDULA_REGEX);


    private static final String PASSWORD_REGEX =
            "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(PASSWORD_REGEX);
    
    @FXML
    private home_controller home_controller;
    @FXML
    private Stage stage_sign;
    /**
     * @param event
     */
    @FXML
    
    void back_home(ActionEvent event) {
    	
    	if(validationPassword() == true) {
    		home_controller.show_home();
        	stage_sign.close();

    	}
    }
   /* void back_home(ActionEvent event) {
    	String pass = null;
    	try {
        	 ced = cedula.getText();
        	 pass = contra.getText();
		
     		if (PASSWORD_PATTERN.matcher(pass).matches()) {
     			
     		}
        	//home_controller.show_home();
        	//stage_sign.close();

		} catch (Exception e) {
			// TODO: handle exception
    	
    	if(ced == null || ced.equals("")) {
    	    /*Alert alert = new Alert(Alert.AlertType.WARNING);
    	    alert.setTitle("Error cedula");
    	    alert.setContentText("Debes escribir tu cedula");
    	    alert.showAndWait();
    	}
    	if(pass == null || pass.equals("")) {
    		error_contra.setVisible(false);

    	    /*Alert alert = new Alert(Alert.AlertType.WARNING);
    	    alert.setTitle("Error cedula");
    	    alert.setContentText("Debes escribir tu cedula");
    	    alert.showAndWait();
    	}
		}
    }
    */
    public boolean validationCedula() {
    	boolean validacion = false;
    	String ced = null;
    	
       	ced = cedula.getText();
    	if (ced == null || ced.equals("") || CEDULA_PATTERN.matcher(ced).matches()) {
        	error_cedula.setVisible(true);
    	}
    	else {
    		validacion = true;
    	}
    	return validacion;
    }
    public boolean validationPassword() {
    	error_contra.setVisible(true);

    	boolean validacion = false;
    	String password = null;
    	
    	password = contra.getText();		
    	if (password == null || password.equals("") || PASSWORD_PATTERN.matcher(password).matches()) {
        	error_contra.setVisible(true);
    	}
    	else {
        	validacion = true;
        }

        return validacion;
    	
    }
    
    public void writeCedula() {
    	error_cedula.setVisible(false);

    }

    public void writepassword() {
    	error_contra.setVisible(false);

    }


	public void init_Sign(Stage stage_sign, home_controller home_controller) {
		this.home_controller = home_controller;
		this.stage_sign = stage_sign;
		
	}
    

}
