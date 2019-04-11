package gamefx.models;

import gamefx.GLOBAL;
import gamefx.controllers.MenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static gamefx.Main.setCSS;

public class Dialog {

    public Label dialoglabel;
    public Button btn;
    public Region reg;
    public String sr;
    public double xOffset;
    public double yOffset;
    public Stage stage;

    public void initialize() throws Exception {
        System.out.println("INIT DIALOG");
        dialoglabel.setText(GLOBAL.TEXT_DIALOG);
    }


    public void create() throws Exception {
        System.out.println("CREATE DIALOG");
        Stage form2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../views/dialog.fxml"));
        root.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        form2.setTitle("Диалоговое окно");
        Scene scene = new Scene(root, 529, 216);
        scene.setFill(Color.TRANSPARENT);
        form2.setScene(scene);
        setCSS(form2, "dialogs/dialog/styles.css");
        form2.setResizable(false);
        form2.initStyle(StageStyle.TRANSPARENT);
        form2.initModality(Modality.APPLICATION_MODAL);
        form2.show();
//        com.sun.glass.ui.Window.getWindows().get(1).setUndecoratedMoveRectangle(22);
        System.out.println("DONE DIALOG");
//        scene.addEventFilter(MouseEvent.ANY, event ->{ // перемещение окна за что угодно
//            if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
//                xOffset = form2.getX() - event.getScreenX();
//                yOffset = form2.getY() - event.getScreenY();
//            }
//            if(event.getEventType() == MouseEvent.MOUSE_DRAGGED){
//                form2.setX(event.getScreenX() + xOffset);
//                form2.setY(event.getScreenY() + yOffset);
//            }
//        });

//        scene.addEventHandler(MouseEvent.ANY, event ->{ // перемещение окна за все, кроме кнопочных и некоторых компонентов
//            if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
//                xOffset = form2.getX() - event.getScreenX();
//                yOffset = form2.getY() - event.getScreenY();
//            }
//            if(event.getEventType() == MouseEvent.MOUSE_DRAGGED){
//                form2.setX(event.getScreenX() + xOffset);
//                form2.setY(event.getScreenY() + yOffset);
//                event.consume();
//            }
//        });
    }


    public void exit() {
        Stage Form = (Stage) btn.getScene().getWindow();
        Form.close();
    }

    public void paneOnMouseDragged(final MouseEvent event) {
        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }

    public void paneOnMousePressed(final MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }

}
