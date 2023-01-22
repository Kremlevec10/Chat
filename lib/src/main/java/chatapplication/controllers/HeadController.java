package chatapplication.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import chatapplication.ApplicationRun;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HeadController {
	
	private Stage headStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterButton;

    @FXML
    private Button registrationButton;

    @FXML
    void initialize() {
    	pressEnterButton();
    	pressRegistrationButton();
    }

	private void pressRegistrationButton() {
		registrationButton.setOnAction(event -> {
			headStage = ApplicationRun.gateStage();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/seamples/registrationSeample.fxml"));
			try {
				headStage.setScene(new Scene(fxmlLoader.load()));
			} catch (Exception e) {
				throw new RuntimeException("Не удалось загрузить окно регистрации",e);
			}
			headStage.show();
		});
		
	}

	private void pressEnterButton() {
		enterButton.setOnAction(event -> {
			headStage = ApplicationRun.gateStage();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/seamples/enterSeample.fxml"));
			try {
				headStage.setScene(new Scene(fxmlLoader.load()));
			} catch (IOException e) {
				throw new RuntimeException("Не удалось загрузить окно входа",e);
			}
			headStage.show();
		});
		
	}

}
