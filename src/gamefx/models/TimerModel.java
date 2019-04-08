package gamefx.models;

import gamefx.GLOBAL;
import gamefx.controllers.MainController;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class TimerModel {

    public int ui = 0;
    public String str;
    public Label label;

    public Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            Platform.runLater(() -> {
                timerBody();
            });
        }

    };

    public void startTimer(int sec) {
        timer.schedule(task, 0, sec);
    }

    public void timerBody() {

    }

    public void timerStop() {
        timer.cancel();
    }

    public void inputLabel(Label label) {
        this.label = label;
    }

    public void inputStr(String str) {
        this.str = str;
    }

}
