package LoginWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Scene LoginScene;
    public static Stage LoginStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        LoginStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        LoginScene = new Scene(root, 500, 300);
        LoginStage.setTitle("User Login");
        LoginStage.setScene(LoginScene);
        LoginStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
