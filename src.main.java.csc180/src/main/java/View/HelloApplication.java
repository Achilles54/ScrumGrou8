package View;

import Controller.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/csc180/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Calender Application!");
        stage.setScene(scene);
        stage.show();

        //HelloController controller = fxmlLoader.getController();
        //controller.setStage(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}