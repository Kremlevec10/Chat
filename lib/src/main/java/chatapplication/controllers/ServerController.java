package chatapplication.controllers;

import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import server.MyServer;

public class ServerController {
	
	private Socket socket;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea serverField;

    @FXML
    private Button serverOffButton;

    @FXML
    private Button serverOnButton;

    @FXML
    void initialize() {
    	pressServerOnButton();
//    	pressServerButtonOff();
    }
    
    private void pressServerOnButton() {
    	serverOnButton.setOnAction(event -> {
    		setTextServerField("Server wait in conection");
    		new MyServer().startServer();
    	});
	}
    
    private void pressServerButtonOff() {
		serverOffButton.setOnAction(event -> {
			serverField.setText("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		});
	}
    
    public void setTextServerField(String messege) {
    		serverField.setText(messege);
	}

}
