import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * A custom control derived from BorderPane, consisting of a Text control wrapped in a ScrollPane control.
 */
public class Editor extends BorderPane {

    public Text content = null;

    public Editor() {
        final ScrollPane scrollpane = new ScrollPane();
        final Text content = new Text(
                "    /***************************************************************************\n" +
                "     *                                                                         *\n" +
                "     * PLACEHOLDER CONTENT                                                     *\n" +
                "     *                                                                         *\n" +
                "     **************************************************************************/\n\n");
        this.content = content;

        scrollpane.setMinSize(300, 200);
        scrollpane.setPrefSize(400, 400);
        scrollpane.setContent(content);

        setCenter(scrollpane);
        setPrefSize(400, 400);

        setOnKeyPressed(getEventReporter(content, "Editor"));
        setOnKeyTyped(getEventReporter(content, "Editor"));
        setOnMousePressed(getEventReporter(content, "Editor"));
        requestFocus();
    }

    public static EventHandler getEventReporter(final Text output, final String source) {
        return new EventHandler<Event>() {
            public void handle(Event e) {
                output.setText(output.getText() + "\n" + e.getEventType().getName() + " in " + source);
            }
        };
    }

}
