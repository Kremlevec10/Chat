package chatapplication.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea chatTextArea;

    @FXML
    private Button sendButton;

    @FXML
    private TextField sendMessegTextField;

    @FXML
    private TextArea usersTextArea;

    @FXML
    void initialize() {

    }

}
