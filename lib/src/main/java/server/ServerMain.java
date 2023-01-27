package server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ServerMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage prymaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/seamples/serverSeample.fxml"));
		prymaryStage.setScene(new Scene(fxmlLoader.load()));
		prymaryStage.show();
	}

}
