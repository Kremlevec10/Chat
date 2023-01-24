package chatapplication.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import chatapplication.database.pojo.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {
	
	User user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField eMailField;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registrationButton;

    @FXML
    void initialize() {
    	pressRegistrationButton();
    }

	private void pressRegistrationButton() {
		user = new User();
		user.saveIntoUser(loginField.getText(), eMailField.getText(), passwordField.getText());
		System.out.println(user);
	}
		
}
