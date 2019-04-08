package gamefx.models;

import gamefx.controllers.MenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Dialog {

    public Label dialoglabel;
    public String sr;

    public void initialize() throws Exception {
        System.out.println("LOAD DIALOG"+" ++ "+sr);
//        create(sr);
        changeText(sr);
    }


    public void create() throws Exception {
        System.out.println("CREATE DIALOG"+" ++ "+sr);
        Stage form2 = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("../views/dialog.fxml"));
        form2.setTitle("Диалоговое окно");
        form2.setScene(new Scene(root, 195, 126));
        form2.setResizable(false);
        form2.show();
        System.out.println("DONE DIALOG"+" ++ "+sr);
    }

    public void changeText(String str) {
        System.out.println(str);
        dialoglabel.setText(str);
    }

}
