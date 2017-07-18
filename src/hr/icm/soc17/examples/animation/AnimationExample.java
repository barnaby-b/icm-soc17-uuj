package hr.icm.soc17.examples.animation;

import javafx.animation.FillTransition; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle; 
import javafx.stage.Stage; 
import javafx.animation.Timeline; 
import javafx.animation.ParallelTransition; 
import javafx.animation.RotateTransition; 
import javafx.animation.ScaleTransition; 
import javafx.animation.TranslateTransition; 
import javafx.util.Duration; 
 
public class AnimationExample extends Application { 
 
    @Override 
    public void start(Stage stage) { 
        Group root = new Group(); 
        Scene scene = new Scene(root, 500, 500, Color.BLACK); 
        Rectangle r = new Rectangle(0, 0, 250, 250); 
        r.setFill(Color.BLUE); 
        root.getChildren().add(r); 
        
        
 
        TranslateTransition translate = 
        new TranslateTransition(Duration.millis(2000)); 
        translate.setToX(360); 
        translate.setToY(360); 
 
        FillTransition fill = new FillTransition(Duration.millis(2000)); 
        fill.setToValue(Color.RED); 
 
        RotateTransition rotate = new RotateTransition(Duration.millis(2000)); 
        rotate.setToAngle(360); 
 
        ScaleTransition scale = new ScaleTransition(Duration.millis(750)); 
        scale.setToX(0.5); 
        scale.setToY(0.1); 
 
        ParallelTransition transition = new ParallelTransition(r, translate, fill, rotate, scale); 
        
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true); 
        transition.play(); 
 
        stage.setTitle("ICM SoC - Animacija"); 
        stage.setScene(scene); 
        stage.show(); 
    } 
 
    public static void main(String[] args) { 
        launch(args); 
    } 
}