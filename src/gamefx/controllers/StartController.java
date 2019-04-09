package gamefx.controllers;

import gamefx.Controller;
import gamefx.Main;
import gamefx.models.Animation;
import gamefx.models.Names;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import gamefx.models.Names.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.TextAlignment;

import static gamefx.Main.changeView;

public class StartController extends Controller {

    public Button startbtn;
    public TextField editking;
    public TextField editdinasty;
    public TextField editkingdom;
    public MenuButton menu;
    public Label labdinasty;
    public Label labking;
    public Label labkingdom;
    public Label labavatar;


    public void initialize() {
        final MenuItem wizPopup = new MenuItem();
        wizPopup.setGraphic(createPopupContent());

        menu.getItems().setAll(
                wizPopup
        );

    }

    public void startGame() {
        if (validate()) {
            changeView("main", "main/styles.css");
        } else {

        }
    }

    public boolean validate() {
        boolean validate = true;
//        System.out.println("\""+editdinasty.textProperty().getValue()+"\"");
        if ((editdinasty.textProperty().getValue().equals("")) || (validateSpace(editdinasty.textProperty().getValue()))) {
            Animation.validateAnimation(labdinasty);
            validate = false;
        }
        if ((editking.textProperty().getValue().equals("")) || (validateSpace(editking.textProperty().getValue()))) {
            Animation.validateAnimation(labking);
            validate = false;
        }
        if ((editkingdom.textProperty().getValue().equals("")) || (validateSpace(editkingdom.textProperty().getValue()))) {
            Animation.validateAnimation(labkingdom);
            validate = false;
        }
        if ((menu.textProperty().getValue().equals("")) || (validateSpace(menu.textProperty().getValue()))) {
            Animation.validateAnimation(labavatar);
            validate = false;
        }
        if (validate) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateSpace(String str) {
        int i = 0;
        while (true) {
            if (str.contains(" ")) {
                str =  str.replace(" ", "");
            } else {
                break;
            }
        }
//        System.out.println("STR: "+"\""+str+"\""+" LENGTH="+str.length());
        if (str.length()==0) {
            return true;
        }
        else {
            return false;
        }
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

    private Pane createPopupContent() {
        ImageView vied1 = new ImageView("gamefx/resources/images/icons/kings_icon_03.png");
        ImageView vied2 = new ImageView("gamefx/resources/images/icons/kings_icon_05.png");
        ImageView vied3 = new ImageView("gamefx/resources/images/icons/kings_icon_07.png");
        ImageView vied4 = new ImageView("gamefx/resources/images/icons/kings_icon_09.png");
        ImageView vied5 = new ImageView("gamefx/resources/images/icons/kings_icon_11.png");
        ImageView vied6 = new ImageView("gamefx/resources/images/icons/kings_icon_13.png");
        ImageView vied7 = new ImageView("gamefx/resources/images/icons/kings_icon_14.png");
        ImageView vied8 = new ImageView("gamefx/resources/images/icons/kings_icon_16.png");
        ImageView vied9 = new ImageView("gamefx/resources/images/icons/kings_icon_18.png");
        Region vied1r = new Region();
        Region vied2r = new Region();
        Region vied3r = new Region();
        Region vied4r = new Region();
        Region vied5r = new Region();
        Region vied6r = new Region();
        Region vied7r = new Region();
        Region vied8r = new Region();
        Region vied9r = new Region();
        vied1.setFitWidth(100); vied1.setFitHeight(100);
        vied2.setFitWidth(100); vied2.setFitHeight(100);
        vied3.setFitWidth(100); vied3.setFitHeight(100);
        vied4.setFitWidth(100); vied4.setFitHeight(100);
        vied5.setFitWidth(100); vied5.setFitHeight(100);
        vied6.setFitWidth(100); vied6.setFitHeight(100);
        vied7.setFitWidth(100); vied7.setFitHeight(100);
        vied8.setFitWidth(100); vied8.setFitHeight(100);
        vied9.setFitWidth(100); vied9.setFitHeight(100);
        vied1.setX(0); vied1.setY(0);
        vied2.setX(105); vied2.setY(0);
        vied3.setX(210); vied3.setY(0);
        vied4.setX(0); vied4.setY(105);
        vied5.setX(105); vied5.setY(105);
        vied6.setX(210); vied6.setY(105);
        vied7.setX(0); vied7.setY(210);
        vied8.setX(105); vied8.setY(210);
        vied9.setX(210); vied9.setY(210);
        vied1r.setPrefWidth(100); vied1r.setPrefHeight(100);
        vied2r.setPrefWidth(100); vied2r.setPrefHeight(100);
        vied3r.setPrefWidth(100); vied3r.setPrefHeight(100);
        vied4r.setPrefWidth(100); vied4r.setPrefHeight(100);
        vied5r.setPrefWidth(100); vied5r.setPrefHeight(100);
        vied6r.setPrefWidth(100); vied6r.setPrefHeight(100);
        vied7r.setPrefWidth(100); vied7r.setPrefHeight(100);
        vied8r.setPrefWidth(100); vied8r.setPrefHeight(100);
        vied9r.setPrefWidth(100); vied9r.setPrefHeight(100);
        vied1r.setTranslateX(0);vied1r.setTranslateY(0);
        vied2r.setTranslateX(105);vied2r.setTranslateY(0);
        vied3r.setTranslateX(210);vied3r.setTranslateY(0);
        vied4r.setTranslateX(0);vied4r.setTranslateY(105);
        vied5r.setTranslateX(105);vied5r.setTranslateY(105);
        vied6r.setTranslateX(210);vied6r.setTranslateY(105);
        vied7r.setTranslateX(0);vied7r.setTranslateY(210);
        vied8r.setTranslateX(105);vied8r.setTranslateY(210);
        vied9r.setTranslateX(210);vied9r.setTranslateY(210);
//        final Label unfortunateEvent = new Label();
//        unfortunateEvent.setWrapText(true);
//        unfortunateEvent.setTextAlignment(TextAlignment.CENTER);
//        unfortunateEvent.setMaxWidth(wiz.getImage().getWidth());
        final Pane wizBox = new Pane();
//        wizBox.setAlignment(Pos.CENTER);
        wizBox.getChildren().setAll(
                vied1,
                vied2,
                vied3,
                vied4,
                vied5,
                vied6,
                vied7,
                vied8,
                vied9,
                vied1r,
                vied2r,
                vied3r,
                vied4r,
                vied5r,
                vied6r,
                vied7r,
                vied8r,
                vied9r
        );

        vied1r.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                menu.setText("Бесстрашный");
                Controller.AVATAR = "ICON_1";
            }
        });
        vied2r.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                menu.setText("Дружелюбный");
                Controller.AVATAR = "ICON_2";
            }
        });
        vied3r.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                menu.setText("Упрямый");
                Controller.AVATAR = "ICON_3";
            }
        });
        vied4r.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                menu.setText("Страшный");
                Controller.AVATAR = "ICON_4";
            }
        });
        vied5r.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                menu.setText("Добрый");
                Controller.AVATAR = "ICON_5";
            }
        });
        vied6r.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                menu.setText("Бессмертный");
                Controller.AVATAR = "ICON_6";
            }
        });
        vied7r.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                menu.setText("Воинственный");
                Controller.AVATAR = "ICON_7";
            }
        });
        vied8r.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                menu.setText("Ранимый");
                Controller.AVATAR = "ICON_8";
            }
        });
        vied9r.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                menu.setText("Легендарный");
                Controller.AVATAR = "ICON_9";
            }
        });


        return wizBox;
    }

}
