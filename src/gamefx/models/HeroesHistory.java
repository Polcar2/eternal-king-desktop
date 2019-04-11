package gamefx.models;

import gamefx.GLOBAL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static gamefx.Main.setCSS;

public class HeroesHistory {


    public Stage stage;
    public Button btn;


    public void initialize() throws Exception {
//        System.out.println("LOAD DIALOG"+" ++ "+sr);
//        create();
//        changeText(sr);
    }


    public void create() throws Exception {
//        System.out.println("CREATE DIALOG"+" ++ "+sr);
        Stage form2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../views/hhistory.fxml"));
        form2.setTitle("Диалоговое окно");
//        root.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        Scene scene = new Scene(root, 549, 283);
//        scene.setFill(Color.TRANSPARENT);
        form2.setScene(scene);
        setCSS(form2, "dialogs/history/styles.css");
        form2.setResizable(false);
        form2.initStyle(StageStyle.TRANSPARENT);
        form2.initModality(Modality.APPLICATION_MODAL);
        form2.showAndWait();
//        form2.show();
//        com.sun.glass.ui.Window.getWindows().get(1).setUndecoratedMoveRectangle(22);
//        System.out.println("DONE DIALOG"+" ++ "+sr);

    }


    public void exit() {
//        GLOBAL.fg = "sss";
        Stage Form = (Stage) btn.getScene().getWindow();
        Form.close();
    }


}
