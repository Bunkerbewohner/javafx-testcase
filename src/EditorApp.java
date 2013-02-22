import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class EditorApp extends Application {

    Scene createScene() {

        EditorSceneContent content = new EditorSceneContent();
        Scene scene = new Scene(content);
        content.setPrefSize(800, 600);
        content.getEditor().requestFocus();

        return scene;
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("edit");
        stage.setScene(createScene());
        stage.show();
    }

    public static void main(String[] args) {
        EditorApp.launch(args);
    }
}
