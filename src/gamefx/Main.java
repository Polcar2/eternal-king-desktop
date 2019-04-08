package gamefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Parent pane;
    private static Stage stage;
    private static Scene scene;
    private static String CSS = "styles.css";

    public static int size_X = 1270;
    public static int size_Y = 710;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("views/menu.fxml"));
        pane = root;
        primaryStage.setTitle("Eternal King v0.1");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, size_X, size_Y));
        setCSS();
        primaryStage.show();
    }


    public static void changeView(String path) {
        path="views/"+path+".fxml";
        try{FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Controller.class.getResource(path));
            pane = loader.load();}
        catch (IOException ex) {System.out.println("SwitchScene Error");}
        if(path.contains("Active")){scene=new Scene(pane,size_X+10,size_Y+10);}
        else{scene=new Scene(pane,size_X+10,size_Y+10);}
        stage.setScene(scene);
        setCSS();
    }

    public static void changeView(String path, String CSSlocal) {
        path="views/"+path+".fxml";
        try{FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Controller.class.getResource(path));
            pane = loader.load();}
        catch (IOException ex) {System.out.println("SwitchScene Error");}
        if(path.contains("Active")){scene=new Scene(pane,size_X+10,size_Y+10);}
        else{scene=new Scene(pane,size_X+10,size_Y+10);}
        stage.setScene(scene);
        setCSS(CSSlocal);
    }

    public static void setCSS() {
        stage.getScene().getStylesheets().add("gamefx/resources/css/"+CSS);
    }
    public static void setCSS(String CSSlocal) {
        stage.getScene().getStylesheets().add("gamefx/resources/css/"+CSSlocal);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
