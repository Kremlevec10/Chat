package chatapplication.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;

import chatapplication.ApplicationRun;
import chatapplication.database.pojo.User;
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

public class RegistrationController {

	private User user;
	
	private Stage stage;

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
    private Label eMailLabel;
	
	@FXML
    private Label loginLabel;

	@FXML
	private Button registrationButton;

	@FXML
	void initialize() {
		pressRegistrationButton();
		enterTextLoginField();
		enterTextEmailField();
	}

	private void pressRegistrationButton() {
		registrationButton.setOnAction(event -> {
			user = new User();
			user.saveIntoUser(loginField.getText(), eMailField.getText(), passwordField.getText(), false);
			saveToDataBase(user);
			try {
				moveToNewScene();
			} catch (IOException e) {
				throw new RuntimeException("Не удалось загрузить чат", e);
			}
		});
	}

	private void saveToDataBase(User registryUser) {
		Session session = InstanceSessionFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.save(registryUser);
		session.getTransaction().commit();
		session.close();
	}
	
	private void moveToNewScene() throws IOException {
		stage = ApplicationRun.gateStage();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/seamples/chatSeample.fxml"));
		stage.setScene(new Scene(fxmlLoader.load()));
		stage.show();
	}
	
	private void enterTextEmailField() {
		eMailField.setOnAction(event -> {
			if (checkEmail()) {
				eMailLabel.setText("Такой пользователь уже существует");
				eMailLabel.setTextFill(Color.SADDLEBROWN);
			} else if (eMailLabel.getText().length() < 1) {
				eMailLabel.setText("Введите вашу почту");
				eMailLabel.setTextFill(Color.SADDLEBROWN);
			} else {
				eMailLabel.setText("Такого пользователя еще нет");
				eMailLabel.setTextFill(Color.GREEN);
			}
		});
	}
	
	private void enterTextLoginField() {
		loginField.setOnAction(event -> {
			if (checkLogin()) {
				loginLabel.setText("Такой логин уже существует");
				loginLabel.setTextFill(Color.SADDLEBROWN);
			} else {
				loginLabel.setText("Этот логин свободен");
				loginLabel.setTextFill(Color.GREEN);
			}
		});
	}
	
	private boolean checkLogin() {
		List<String> logins = ListRegistrationUser.getLogins();
		for (String login : logins) {
			if (loginField.getText().equals(login)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkEmail() {
		List<String> eMails = ListRegistrationUser.getEmails();
		for (String eMail : eMails) {
			if (eMailField.getText().equalsIgnoreCase(eMail)) {
				return true;
			}
		}
		return false;
	}

}
