package gamefx.controllers;

import gamefx.Controller;
import gamefx.Main;
import gamefx.models.Animation;
import gamefx.models.Dialog;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import gamefx.models.Animation.*;
import javafx.scene.control.Label;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import static gamefx.Main.*;
import static gamefx.controllers.MainController.*;

public class MenuController extends Controller {

    public Button exitbtn;
    public Label logo;
    public Timer timer = new Timer();

    public void initialize() {
        logoTimer();
    }

    public void showWindow(ActionEvent actionEvent) {
        showDialog("Титул","Тестовое диологовое окно");
    }

    public void newGame(ActionEvent actionEvent) {
        logoTimerCancel();
        Controller.LOAD = false;
        changeView("start", "start/styles.css");
    }
    public void loadGame(ActionEvent actionEvent) throws Exception {
        logoTimerCancel();
        Controller.LOAD = true;
        changeView("main", "main/styles.css");
//        Dialog df = new Dialog();
//        df.create();
    }

    public void exitAction(ActionEvent actionEvent) {
        logoTimerCancel();
        exit(exitbtn);
    }

    public void logoTimer() {
        TimerTask task = new TimerTask()
        {
            public void run()
            {
                Platform.runLater(() -> {
                    Animation.logoAnimation(logo);
                });

            }
        };
        timer.schedule(task, 0, 8000);
    }

    public void logoTimerCancel() {
        timer.cancel();
    }

}
