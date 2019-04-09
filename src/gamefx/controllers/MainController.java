package gamefx.controllers;

import gamefx.Controller;
import gamefx.GLOBAL;
import gamefx.Main;
import gamefx.models.Animation;
import gamefx.models.Quest;
import gamefx.models.TimerModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import gamefx.models.Quest.*;
import javafx.util.Duration;

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

    public Timer timer;

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


        startGame();
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

        quests = new int[8];

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
        if (((Control) actionEvent.getSource()).getId().equals("btnselect1")) {
//            System.out.println("Нажата кнопка 1");
            System.out.println(param1+" "+param2+" | "+effect1+" "+effect2);
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
                }
                else if (param1.equals("RELIGION")) {
                    setReligion(effect1);
                }
                else if (param1.equals("ARMY")) {
                    setArmy(effect1);
                }
                if (param2.equals("SOCIETY")) {
                    setSociety(effect2);
                }
                else if (param2.equals("RELIGION")) {
                    setReligion(effect2);
                }
                else if (param2.equals("ARMY")) {
                    setArmy(effect2);
                }
            }
        } else {
//            System.out.println("Нажата кнопка 2");
            System.out.println(param1+" "+param2+" | "+effect1+" "+effect2);
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
                }
                else if (param1.equals("RELIGION")) {
                    setReligion(eff1);
                }
                else if (param1.equals("ARMY")) {
                    setArmy(eff1);
                }
                if (param2.equals("SOCIETY")) {
                    setSociety(eff2);
                }
                else if (param2.equals("RELIGION")) {
                    setReligion(eff2);
                }
                else if (param2.equals("ARMY")) {
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
                }
            } else {
                startGame();
            }
        } else {
            startGame();
        }

    }

    public void startGame() throws InterruptedException {
        dayIterationBegin();

    }

    public void outTextQuest(String str) throws InterruptedException {
        while (true) {
            if (str.contains("$KING")) {
               str = str.replace("$KING", Controller.KING_NAME);
            } else break;
        }
        while (true) {
            if (str.contains("$KINGDOM")) {
                str = str.replace("$KINGDOM", Controller.KINGDOM_NAME);
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
    }
    public void timerSkip() {
        timerCancel();
        labelquest.setText(description);
    }


}
