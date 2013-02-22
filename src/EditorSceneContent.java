import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

/**
 * Root content of the editor scene. Consists of a TabPane and an Editor control.
 * When the editor is
 */
public class EditorSceneContent extends BorderPane {

    public EditorSceneContent() {
        Editor editor = new Editor();
        Tab tab = new Tab("Editor");
        tab.setContent(editor);

        TabPane tabs = new TabPane();
        tabs.getTabs().add(tab);

        // either
        setCenter(tabs);

        // or
        setCenter(editor);

        editor.requestFocus();

        setOnKeyPressed(Editor.getEventReporter(editor.content, "EditorSceneContent"));
        setOnKeyTyped(Editor.getEventReporter(editor.content, "EditorSceneContent"));
        setOnMousePressed(Editor.getEventReporter(editor.content, "EditorSceneContent"));
    }

    public Editor getEditor() {
        // if the editor is set as the sole content of the border pane
        if (getChildren().get(0) instanceof Editor) return (Editor)getChildren().get(0);

        // if the editor was added as part of the TabPane
        TabPane tabs = (TabPane)getChildren().get(0);
        return (Editor)tabs.getTabs().get(0).getContent();
    }
}
