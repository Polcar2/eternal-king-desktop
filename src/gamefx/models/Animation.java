package gamefx.models;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.*;

public class Animation {

    public static void animateTo(int begin, int end, Slider slider, Label label) {

        label.setText(String.valueOf(end));

        if (begin < end) {

            Duration animationDuration = new Duration(1000);

            Timeline timeline = new Timeline(

                    new KeyFrame(Duration.ZERO, new KeyValue(slider.valueProperty(), begin), new KeyValue(label.textFillProperty(), Color.web("#00ee33"))),

                    new KeyFrame(animationDuration, new KeyValue(slider.valueProperty(), end), new KeyValue(label.textFillProperty(), Color.web("#000")))
            );

            timeline.play();

        } else if(begin > end) {

            Duration animationDuration = new Duration(1000);

            Timeline timeline = new Timeline(

                    new KeyFrame(Duration.ZERO, new KeyValue(slider.valueProperty(), begin), new KeyValue(label.textFillProperty(), Color.web("#ee0033"))),

                    new KeyFrame(animationDuration, new KeyValue(slider.valueProperty(), end), new KeyValue(label.textFillProperty(), Color.web("#000")))
            );

            timeline.play();

        }
    }

    public static void logoAnimation(Label label) {
        Duration animationDuration = new Duration(8000);

        double scX = label.getScaleX();
        double scY = label.getScaleY();

        Timeline timeline = new Timeline(

                new KeyFrame(Duration.ZERO, new KeyValue(label.rotateProperty(), 0), new KeyValue(label.scaleXProperty(), scX), new KeyValue(label.scaleYProperty(), scY)),

                new KeyFrame(Duration.millis(2000), new KeyValue(label.rotateProperty(), 2)),

                new KeyFrame(Duration.millis(4000), new KeyValue(label.scaleXProperty(), scX+0.1), new KeyValue(label.scaleYProperty(), scY+0.1)),

                new KeyFrame(Duration.millis(6000), new KeyValue(label.rotateProperty(), -2)),

                new KeyFrame(animationDuration, new KeyValue(label.rotateProperty(), 0), new KeyValue(label.scaleXProperty(), scX), new KeyValue(label.scaleYProperty(), scY))
        );
        timeline.play();
    }

    public static void validateAnimation(Label label) {
        Duration animationDuration = new Duration(1000);

        Timeline timeline = new Timeline(

                new KeyFrame(Duration.ZERO, new KeyValue(label.textFillProperty(), Color.web("#ee0033"))),

                new KeyFrame(animationDuration, new KeyValue(label.textFillProperty(), Color.web("#000")))
        );

        timeline.play();
    }

    public static void blackScreenAnimation(Region region) {
        Duration animationDuration = new Duration(1000);

        Timeline timeline = new Timeline(

                new KeyFrame(Duration.ZERO, new KeyValue(region.opacityProperty(), 0)),

                new KeyFrame(animationDuration, new KeyValue(region.opacityProperty(), 0.5))
        );

        timeline.play();
    }

    public static void whiteScreenAnimation(Region region) {
        Duration animationDuration = new Duration(2000);

        Timeline timeline = new Timeline(

                new KeyFrame(Duration.ZERO, new KeyValue(region.opacityProperty(), 0)),

                new KeyFrame(animationDuration, new KeyValue(region.opacityProperty(), 1))
        );

        timeline.play();
    }

    public static void reverseWhiteScreenAnimation(Region region) {
        Duration animationDuration = new Duration(2000);

        Timeline timeline = new Timeline(

                new KeyFrame(Duration.ZERO, new KeyValue(region.opacityProperty(), 1)),

                new KeyFrame(animationDuration, new KeyValue(region.opacityProperty(), 0))
        );

        timeline.play();
        timeline.setOnFinished(event -> {
            //
        });
    }

}
