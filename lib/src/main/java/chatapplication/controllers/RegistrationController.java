package chatapplication.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

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
        assert eMailField != null : "fx:id=\"eMailField\" was not injected: check your FXML file 'registrationSeample.fxml'.";
        assert loginField != null : "fx:id=\"loginField\" was not injected: check your FXML file 'registrationSeample.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'registrationSeample.fxml'.";
        assert registrationButton != null : "fx:id=\"registrationButton\" was not injected: check your FXML file 'registrationSeample.fxml'.";

    }

}
