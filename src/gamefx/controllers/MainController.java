package gamefx.controllers;

import gamefx.Controller;
import gamefx.GLOBAL;
import gamefx.Main;
import gamefx.models.*;
import gamefx.models.Dialog;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import gamefx.models.Quest.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

import static gamefx.Main.*;

public class MainController extends Controller {

    @FXML public Slider sliderrel;
    @FXML public Slider sliderarm;
    @FXML public Slider slidersoc;
    @FXML public Label labelrel;
    @FXML public Label labelarm;
    @FXML public Label labelsoc;
    @FXML public Label labelquest;
    @FXML public Label labelname;
    @FXML public Button btnselect1;
    @FXML public Button btnselect2;
    @FXML public Label labday;
    @FXML public Label labmonth;
    @FXML public Label labyear;
    @FXML public Region blackscreen;
    @FXML public Region blackrel;
    @FXML public Region blackarm;
    @FXML public Region blacksoc;
    @FXML public Pane panequest;
    @FXML public Label namerel;
    @FXML public Label namearm;
    @FXML public Label namesoc;
    @FXML public Label kingdomname;
    @FXML public Label dinastyname;
    @FXML public ImageView kingicon;

    public Timer timer;

    public int iner_tutorial = 0;
    enum Mode {
        STORY,
        TUTORIAL,
        NONE,
        SKIP
    }

    public Mode mode = Mode.NONE;

    private String advisor; // советник
    private String description; // описание
    private String select1; // текст выбора 1
    private String select2; // текст выбора 2
    private String param1; // параметр 1
    private String param2; // параметр 2
    private int effect1; // эффект 1
    private int effect2; // эффект 2
    private String uniqkey; // уникальный ключ
    private String selectactiv; // номер выбора, приводящий к следующему диалогу
    private int order; // порядок подачи ивента по одинаковому уникальному ключу
//    public TimerModel timer = new TimerModel();

    private int quests[];

    public void initialize() throws InterruptedException {
        if (!Controller.LOAD) {
            initGame();
        } else System.out.println("UNLOAD");
    }

    public void escape(ActionEvent actionEvent) {
        timerCancel();
        changeView("menu");
    }

    public void setReligion(int arg) {
        int REL = (int) Controller.RELIGION;
        if (arg>0) {
            arg = ((arg + REL) > 100) ? (100 - REL) : arg;
//            Animation.animateTo(REL,REL+arg,sliderrel,labelrel);
//            Controller.RELIGION+=arg;
        } else if (arg<0) {
            arg = ((REL+arg)<0)?REL:arg;
//            Animation.animateTo(REL,REL-arg,sliderrel,labelrel);
//            Controller.RELIGION-=arg;
        }
        Animation.animateTo(REL,REL+arg,sliderrel,labelrel);
        Controller.RELIGION+=arg;
    }


    public void setArmy(int arg) {
        int ARM = (int) Controller.ARMY;
        if (arg>0) {
            arg = ((arg + ARM) > 100) ? (100 - ARM) : arg;
//            Animation.animateTo(ARM, ARM + arg, sliderarm, labelarm);
//            Controller.ARMY += arg;
        } else if (arg<0) {
            arg = ((ARM+arg)<0)?ARM:arg;
//            Animation.animateTo(ARM,ARM-arg,sliderarm,labelarm);
//            Controller.ARMY-=arg;
        }
        Animation.animateTo(ARM, ARM + arg, sliderarm, labelarm);
        Controller.ARMY += arg;
    }


    public void setSociety(int arg) {
        int SOC = (int) Controller.SOCIETY;
        if (arg>0) {
            arg = ((arg + SOC) > 100) ? (100 - SOC) : arg;
//            Animation.animateTo(SOC, SOC + arg, slidersoc, labelsoc);
//            Controller.SOCIETY += arg;
        } else if (arg<0) {
            arg = ((SOC+arg)<0)?SOC:arg;
//            Animation.animateTo(SOC,SOC-arg,slidersoc,labelsoc);
//            Controller.SOCIETY-=arg;
        }
        Animation.animateTo(SOC, SOC + arg, slidersoc, labelsoc);
        Controller.SOCIETY += arg;
    }

    public void initGame() throws InterruptedException {
        Controller.RELIGION = 50;
        Controller.SOCIETY = 50;
        Controller.ARMY = 50;
        Controller.GOLD = 1000;
        Controller.DAY = 30;
        Controller.MONTH = 0;
        Controller.YEAR = 1437;

        sliderrel.setValue(Controller.RELIGION);
        sliderarm.setValue(Controller.ARMY);
        slidersoc.setValue(Controller.SOCIETY);
        labelrel.setText(String.valueOf((int)Controller.RELIGION));
        labelarm.setText(String.valueOf((int)Controller.ARMY));
        labelsoc.setText(String.valueOf((int)Controller.SOCIETY));

        kingdomname.setText(Controller.KINGDOM_NAME);
        dinastyname.setText(Controller.DINASTY);
        if (Controller.AVATAR.equals("ICON_1")) {
            Image image = new Image("gamefx/resources/images/icons/kings_icon_03.png");
            kingicon.setImage(image);
        } else if (Controller.AVATAR.equals("ICON_2")) {
            Image image = new Image("gamefx/resources/images/icons/kings_icon_05.png");
            kingicon.setImage(image);
        } else if (Controller.AVATAR.equals("ICON_3")) {
            Image image = new Image("gamefx/resources/images/icons/kings_icon_07.png");
            kingicon.setImage(image);
        } else if (Controller.AVATAR.equals("ICON_4")) {
            Image image = new Image("gamefx/resources/images/icons/kings_icon_09.png");
            kingicon.setImage(image);
        } else if (Controller.AVATAR.equals("ICON_5")) {
            Image image = new Image("gamefx/resources/images/icons/kings_icon_11.png");
            kingicon.setImage(image);
        } else if (Controller.AVATAR.equals("ICON_6")) {
            Image image = new Image("gamefx/resources/images/icons/kings_icon_13.png");
            kingicon.setImage(image);
        } else if (Controller.AVATAR.equals("ICON_7")) {
            Image image = new Image("gamefx/resources/images/icons/kings_icon_14.png");
            kingicon.setImage(image);
        } else if (Controller.AVATAR.equals("ICON_8")) {
            Image image = new Image("gamefx/resources/images/icons/kings_icon_16.png");
            kingicon.setImage(image);
        } else if (Controller.AVATAR.equals("ICON_9")) {
            Image image = new Image("gamefx/resources/images/icons/kings_icon_18.png");
            kingicon.setImage(image);
        }
        Tooltip kn_tooltip = new Tooltip(Controller.KING_NAME);
//        hackTooltipStartTiming(kn_tooltip);
//        Tooltip.install(kingicon, kn_tooltip);
        bindTooltip(kingicon, kn_tooltip);

//        String masInput[] = Quest.getEvent(2);
//
//
//        if (masInput[0].equals("DEFAULT")) {
//            labelname.setText(Controller.ADVISOR);
//        } else {
//            labelname.setText(masInput[0]);
//        }
//        outTextQuest(masInput[1]);
//        btnselect1.setText(masInput[2]);
//        btnselect2.setText(masInput[3]);

        if (GLOBAL.TUTORIAL) {
            mode = Mode.TUTORIAL;
            tutorialGame();
        } else {
            startGame();
//            Dialog dialog = new Dialog();
//            try {
//                dialog.create();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            HeroesHistory hh = new HeroesHistory();
//            try {
//                hh.create();
//                testlabel.setText(GLOBAL.fg);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            Platform.runLater(() -> {
                Dialog dialog = new Dialog();
                GLOBAL.TEXT_DIALOG = "    Приветствуем вас, "+Controller.KING_NAME+"! Ваше королевство процветает и нуждается в Вас. Помните, каждое Ваше решение влияет на Вас и Ваше королевство. \n\n    Если вы новичок, то рекомендуется пройти обучение, выбрав соответствующий пункт при старте новой игры.";
                try {
                    dialog.create();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                if (GLOBAL.fg.equals("sss")) { // отработка после
//                    try {
//                        startGame();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            });

        }
    }

    public static void hackTooltipStartTiming(Tooltip tooltip) {
        try {
            Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
            fieldBehavior.setAccessible(true);
            Object objBehavior = fieldBehavior.get(tooltip);

            Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
            fieldTimer.setAccessible(true);
            Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

            objTimer.getKeyFrames().clear();
            objTimer.getKeyFrames().add(new KeyFrame(new Duration(100)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bindTooltip(final Node node, final Tooltip tooltip){
        node.setOnMouseMoved(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                // +15 moves the tooltip 15 pixels below the mouse cursor;
                // if you don't change the y coordinate of the tooltip, you
                // will see constant screen flicker
                tooltip.hide();
                tooltip.show(node, event.getScreenX(), event.getScreenY() + 15);

            }
        });
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tooltip.show(node, event.getScreenX(), event.getScreenY() + 15);
            }
        });
        node.setOnMouseExited(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                tooltip.hide();
            }
        });
    }

    public void dayIterationBegin() throws InterruptedException {

        btnselect1.setDisable(true);
        btnselect2.setDisable(true);

        if (Controller.DAY == 30) {
            Controller.MONTH += 1;
            Controller.DAY = 0;
            RandomizeEvent();
        }
        if (Controller.MONTH == 12) {
            Controller.YEAR += 1;
            Controller.MONTH = 1;
        }
        Controller.DAY += 1;
        if (isStoryEvent(Controller.DAY, Controller.MONTH, Controller.YEAR)) {

        }
        else {
            bodyInterface(Quest.getEvent(quests[Controller.DAY]));
//            bodyInterface(Quest.getEvent(1));
        }

    }

    public void dayIterationEnd() {

    }

    public void RandomizeEvent() {

        quests = new int[15];

        boolean flag;
        for (int i=0; i<=quests.length-1; i++) {
            flag = true;
            while (flag) {
                quests[i] = rnd(0, Quest.getAmount() - 1);
                for (int j = 0; j <= i; j++) {
                    if (i==j) { flag = false; continue; }
                    if (quests[j] == quests[i]) {
                        flag = true;
                        break;
                    } else if (toInt(Quest.getEvent(quests[i])[10])>1) {
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
            }
        }

//        for (int i=0; i<=quests.length-1; i++) {
//            System.out.print(quests[i]+" | ");
//        }

    }

    public boolean isStoryEvent(int day, int month, int year) {

        return false;
    }

    public void bodyInterface(String[] masInput) throws InterruptedException {
//        String masInput[] = Quest.getEvent(quests[Controller.DAY]);

        // ДНИ, МЕСЯЦЫ, ГОДА

        labday.setText(String.valueOf(Controller.DAY));
        labmonth.setText(String.valueOf(Controller.MONTH));
        labyear.setText(String.valueOf(Controller.YEAR));

        // СОВЕТНИК

        if (masInput[0].equals("DEFAULT")) {
            advisor = Controller.ADVISOR;
        } else {
            advisor = masInput[0];
        }
        labelname.setText(advisor);

        // ОПИСАНИЕ

//        System.out.println(masInput[1]);
        outTextQuest(masInput[1]);

        // ВЫБОРЫ

        select1 = masInput[2];
        btnselect1.setText(select1);
        select2 = masInput[3];
        btnselect2.setText(select2);

        param1 = masInput[4];
        param2 = masInput[5];

        effect1 = toInt(masInput[6]);
        effect2 = toInt(masInput[7]);

        uniqkey = masInput[8];

        selectactiv = masInput[9];

        order = toInt(masInput[10]);


    }

    public void actionButton(ActionEvent actionEvent) throws InterruptedException {
//        System.out.println(((Control) actionEvent.getSource()).getId());

        if (mode == Mode.TUTORIAL) {

            tutorialGame();
        } else if (mode == Mode.SKIP) {
            mode = Mode.NONE;
            blackscreen.setVisible(false);
            blackrel.setVisible(false);
            blackarm.setVisible(false);
            blacksoc.setVisible(false);
            startGame();
        } else if (mode == Mode.NONE) {
            if (((Control) actionEvent.getSource()).getId().equals("btnselect1")) {
//            System.out.println("Нажата кнопка 1");
                System.out.println(param1 + " " + param2 + " | " + effect1 + " " + effect2);
                if (param1.equals(param2)) {
                    if (param1.equals("SOCIETY")) {
                        setSociety(effect1);
                    } else if (param1.equals("RELIGION")) {
                        setReligion(effect1);
                    } else if (param1.equals("ARMY")) {
                        setArmy(effect1);
                    }
                } else {
                    if (param1.equals("SOCIETY")) {
                        setSociety(effect1);
                    } else if (param1.equals("RELIGION")) {
                        setReligion(effect1);
                    } else if (param1.equals("ARMY")) {
                        setArmy(effect1);
                    }
                    if (param2.equals("SOCIETY")) {
                        setSociety(effect2);
                    } else if (param2.equals("RELIGION")) {
                        setReligion(effect2);
                    } else if (param2.equals("ARMY")) {
                        setArmy(effect2);
                    }
                }
            } else {
//            System.out.println("Нажата кнопка 2");
                System.out.println(param1 + " " + param2 + " | " + effect1 + " " + effect2);
                if (param1.equals(param2)) {
                    if (param1.equals("SOCIETY")) {
                        setSociety(effect2);
                    } else if (param1.equals("RELIGION")) {
                        setReligion(effect2);
                    } else if (param1.equals("ARMY")) {
                        setArmy(effect2);
                    }
                } else {
                    int eff1 = -effect1;
                    int eff2 = -effect2;
                    if (param1.equals("SOCIETY")) {
                        setSociety(eff1);
                    } else if (param1.equals("RELIGION")) {
                        setReligion(eff1);
                    } else if (param1.equals("ARMY")) {
                        setArmy(eff1);
                    }
                    if (param2.equals("SOCIETY")) {
                        setSociety(eff2);
                    } else if (param2.equals("RELIGION")) {
                        setReligion(eff2);
                    } else if (param2.equals("ARMY")) {
                        setArmy(eff2);
                    }
                }
            }

            if (!uniqkey.equals("NULL")) {
                if (!selectactiv.equals("NULL")) {
                    if ((((Control) actionEvent.getSource()).getId().equals("btnselect1")) && (toInt(selectactiv) == 1)) {
                        if (!Quest.getEventUnique(uniqkey, order)[0].equals("NULL")) {
                            bodyInterface(Quest.getEventUnique(uniqkey, order));
                        }
                    } else if ((((Control) actionEvent.getSource()).getId().equals("btnselect2")) && (toInt(selectactiv) == 2)) {
                        if (!Quest.getEventUnique(uniqkey, order)[0].equals("NULL")) {
                            bodyInterface(Quest.getEventUnique(uniqkey, order));
                        }
                    } else {
                        startGame();
                    }
                } else {
                    startGame();
                }
            } else {
                startGame();
            }

        }

    }

    public void startGame() throws InterruptedException {
        dayIterationBegin();
    }

    public void tutorialGame() throws InterruptedException {

        String masInput[] = StoryQuest.getTutorialEvent(iner_tutorial);
        btnselect1.setDisable(true);
        btnselect2.setDisable(true);

        if (iner_tutorial==0) {
            blackscreen.setVisible(true);
            panequest.toFront();
            btnselect1.toFront();
            btnselect2.toFront();
            Animation.blackScreenAnimation(blackscreen);
        } else if (iner_tutorial==3) {
            sliderrel.toFront();
            labelrel.toFront();
            namerel.toFront();
            blackrel.setVisible(true);
            Animation.whiteScreenAnimation(blackrel);
        } else if (iner_tutorial==6) {
            Animation.reverseWhiteScreenAnimation(blackrel);
            sliderrel.toBack();
            labelrel.toBack();
            namerel.toBack();
            sliderarm.toFront();
            labelarm.toFront();
            namearm.toFront();
            blackarm.setVisible(true);
            Animation.whiteScreenAnimation(blackarm);
        } else if (iner_tutorial==8) {
            Animation.reverseWhiteScreenAnimation(blackarm);
            sliderarm.toBack();
            labelarm.toBack();
            namearm.toBack();
            slidersoc.toFront();
            labelsoc.toFront();
            namesoc.toFront();
            blacksoc.setVisible(true);
            Animation.whiteScreenAnimation(blacksoc);
        } else if (iner_tutorial==9) {
            Animation.reverseWhiteScreenAnimation(blacksoc);
            slidersoc.toBack();
            labelsoc.toBack();
            namesoc.toBack();
        }


        // СОВЕТНИК

        if (masInput[0].equals("DEFAULT")) {
            advisor = Controller.ADVISOR;
        } else {
            advisor = masInput[0];
        }
        labelname.setText(advisor);

        // ОПИСАНИЕ

//        System.out.println(masInput[1]);
        outTextQuest(masInput[1]);

        // ВЫБОРЫ

        select1 = masInput[2];
        btnselect1.setText(select1);
        select2 = masInput[3];
        btnselect2.setText(select2);

        iner_tutorial++;
        if (iner_tutorial==12) {
            iner_tutorial=0;
            mode = Mode.SKIP;
        }
    }

    public void outTextQuest(String str) throws InterruptedException {

        while (true) {
            if (str.contains("$KINGDOM")) {
                str = str.replace("$KINGDOM", Controller.KINGDOM_NAME);
            } else break;
        }
        while (true) {
            if (str.contains("$KING")) {
                str = str.replace("$KING", Controller.KING_NAME);
            } else break;
        }
//        labelquest.setText(str);
        description = str;
//        System.out.println("DESCR: "+description);
//        System.out.println("TIMER: "+timer);

        timer = new Timer();
        TimerTask task = new TimerTask()
        {
            String sum = "";
            int i = 0;
            public void run()
            {
//                System.out.println("i: "+i+"  |  sum: "+sum);
                Platform.runLater(() -> {
                    if (description.length()==i) {
                        timerCancel();
                    } else {
                        sum += Character.toString(description.charAt(i));
                        labelquest.setText(sum);
                    }
                    i++;
               });
            }

        };
        timer.schedule(task, 0, 30);

    }

    public void showHistoryWindow() {
        HeroesHistory hh = new HeroesHistory();
            try {
                hh.create();
//                testlabel.setText(GLOBAL.fg);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void timerStart() {
        timer = new Timer();
        TimerTask task = new TimerTask()
        {
            String sum = "";
            int i = 0;
            public void run()
            {
                Platform.runLater(() -> {
                    System.out.println("i: "+i);
                    if (i<10) {
                        i++;
                    } else {
                        timerCancel();
                    }
                });
            }

        };
        System.out.println("STARTT");
        timer.schedule(task, 0, 30);
    }

    public void timerCancel() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            timer = null;
        }
        btnselect1.setDisable(false);
        btnselect2.setDisable(false);
        labelquest.setText(description);
    }
    public void timerSkip() {
        timerCancel();
        labelquest.setText(description);
    }


}
