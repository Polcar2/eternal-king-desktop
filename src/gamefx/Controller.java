package gamefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Optional;

import static gamefx.Main.changeView;

public class Controller {
    public static boolean LOAD = false;


    public static double RELIGION;
    public static double SOCIETY;
    public static double ARMY;

    public static double GOLD;

    public static int DAY;
    public static int MONTH;
    public static int YEAR;

    public static String DINASTY;
    public static String KINGDOM_NAME;
    public static String KINGS[][] = new String[0][3]; //имя, год_начало_правл, год_конец_правл, количество_дней
    public static String KING_NAME = "Polcar";
    public static String ADVISOR = "Советник";
    public static String AVATAR;


    public void showDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public String showCustomDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select");
        alert.setHeaderText("Choose the sport you like:");

        ButtonType football = new ButtonType("Football");
        ButtonType badminton = new ButtonType("Badminton");
        ButtonType volleyball = new ButtonType("Volleyball");



        // Remove default ButtonTypes
        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(football, badminton, volleyball);

        // option != null.
        Optional<ButtonType> option = alert.showAndWait();
        String str = "";
        if (option.get() == null) {
            str = "Ничего не выбрано";
        } else if (option.get() == football) {
            str = "Выбран футбол";
        } else if (option.get() == badminton) {
            str = "Выбран бадминтон";
        } else if (option.get() == volleyball) {
            str = "Выбран волейбол";
        }
        return str;
    }

    public void exit(Button exitbtn) {
        Stage Form = (Stage) exitbtn.getScene().getWindow();
        Form.close();
        System.exit(0);
    }


    public static int rnd(int min, int max) {  // этот метод возращает случайное число в диапозоне
        max+=1;
        max -= min;
        return (int) (Math.random() * +max) + min;
    }

    public static boolean rndproc(double chance) { // этот метод возращает истину с шансом param%
        int random = rnd(0,100);
        if (random > chance) {
            return false;
        }
        else {
            return true;
        }
    }

    public static int toInt(String arg) {
        return Integer.parseInt(arg);
    }
    public static int toInt(char arg) {
        return Character.getNumericValue(arg);
    }
    public static int toInt(double arg) {
        return (int) arg;
    }

}
