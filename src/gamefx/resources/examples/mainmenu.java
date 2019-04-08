
import javafx.event.EventDispatchChain;
import javafx.event.EventTarget;
import javafx.scene.input.*;
import javafx.scene.input.MouseEvent.*;
import javafx.scene.control.Button;
import javafx.scene.control.Control;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;

import static java.awt.event.MouseEvent.MOUSE_EXITED;

public class mainmenu {

    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;

    public void opacitibutton(javafx.scene.input.MouseEvent event){
        btn1.setOpacity(1);
    }
    public void opacitibuttonminus (javafx.scene.input.MouseEvent event){
        btn1.setOpacity(0.18);
    }

    public void chenchopacitibutton(javafx.scene.input.MouseEvent event) throws NoSuchFieldException, IllegalAccessException {
        String srt;
        Button btn;
        srt = ((Control)event.getTarget()).getId();
        String t;
        for (int i=1;i<=4;i++) {
            t = String.valueOf(i);
            Field field = this.getClass().getField("btn"+t);
            Object ft = field.get(this);
            btn = (Button) ft;
            btn.setOpacity(0.18);
        }


          Field field = this.getClass().getField(srt);
          Object ft = field.get(this);
        System.out.println(event.getEventType());
        btn = (Button) ft;
        btn.setOpacity(1);
//           if (field.isAccessible()) {
//               if (btn1 != null) {
//                   btn1.setOpacity(1);
//               } else {
//                   btn1.setOpacity(0.18);
//               }
//           }
        t = event.getEventType().toString();
        if (t.equals("MOUSE_EXITED")) {
            System.out.println("proshlo");
            for (int i=1;i<=4;i++) {
                t = String.valueOf(i);
                field = this.getClass().getField("btn"+t);
                ft = field.get(this);
                btn = (Button) ft;
                btn.setOpacity(0.18);
            }
        }
    }




}
