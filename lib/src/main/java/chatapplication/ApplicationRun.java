package chatapplication;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationRun extends Application {
	
	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/seamples/headSeample.fxml"));
		primaryStage.setTitle("Chat 'Rusick'");
		primaryStage.setScene(new Scene(fxmlLoader.load()));
		primaryStage.show();
	}
	
	public static Stage gateStage() {
		return stage;
	}

}
