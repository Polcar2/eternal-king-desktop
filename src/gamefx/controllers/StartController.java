package gamefx.controllers;

import gamefx.models.Names;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import gamefx.models.Names.*;

import static gamefx.Main.changeView;

public class StartController {

    public Button startbtn;
    public TextField editking;
    public TextField editdinasty;
    public TextField editkingdom;

    public void startGame() {
        changeView("main", "main/styles.css");
    }

    public void setGenerateKing() {
        editking.setText(Names.getKing());
    }

    public void setGenerateDinasty() {
        editdinasty.setText(Names.getDinasty());
    }

    public void setGenerateKingdom() {
        editkingdom.setText(Names.getKingdom());
    }

}
