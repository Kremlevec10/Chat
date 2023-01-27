package chatapplication.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.SessionFactory;

import chatapplication.ApplicationRun;
import database.InstanceSessionFactory;
import database.ListRegistrationUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class EnterController {

	private Stage enterStage;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField eMailField;

	@FXML
	private Label emailLabel;

	@FXML
	private Label passwordLabel;

	@FXML
	private Button enterButton;

	@FXML
	private PasswordField passwordField;

	@FXML
	void initialize() {
		enterText();
		pressEnterButton();
	}

	private void pressEnterButton() {
		enterButton.setOnAction(event -> {
			if (checkUser() && checkPasswords()) {
				enterStage = ApplicationRun.gateStage();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/seamples/chatSeample.fxml"));
				try {
					enterStage.setScene(new Scene(fxmlLoader.load()));
				} catch (IOException e) {
					throw new RuntimeException("Не удалось загрузить чат", e);
				}
				enterStage.show();
			}
		});
	}

	private boolean checkUser() {
		List<String> eMails = ListRegistrationUser.getEmails();
		for (String eMail : eMails) {
			if (eMail.equalsIgnoreCase(eMailField.getText())) {
				return true;
			}
		}
		return false;
	}

	private boolean checkPasswords() {
		List<String> passwords = ListRegistrationUser.getPasswords();
		for (String password : passwords) {
			if (password.equals(passwordField.getText())) {
				return true;
			}
		}
		return false;
	}

	private void enterText() {
		eMailField.setOnAction(event -> {
			if (!checkUser()) {
				emailLabel.setText("Такого пользователя нет");
				emailLabel.setTextFill(Color.SADDLEBROWN);
			} else {
				emailLabel.setText("Такой пользователь существует");
				emailLabel.setTextFill(Color.GREEN);
			}
		});
	}

}
