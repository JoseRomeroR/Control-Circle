package controlcircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControlCircle extends Application {
    
        //Declaracion e iniciacion
        Scene scene;
        Pane pane = new Pane();
        Button button = new Button("Enlarge");
        Button button2 = new Button("Shrink");
        Circle circle = new Circle();
        Text text = new Text();
    
    @Override
    public void start(Stage stage) {            
        //Modificando propiedades del circulo
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.RED);
        circle.setFill(Color.BLACK);
        circle.setStrokeWidth(5);
        
        //Modificando propiedades de los botones
        button.setLayoutX(140);
        button.setLayoutY(320);       
        button2.setLayoutX(220);
        button2.setLayoutY(320);
        
        //Manejadores de eventos  
        button.setOnAction(new EventPlus());
        button2.setOnAction(new EventMinus());  
        
        //Modificando el texto
        text.setLayoutX(150);
        text.setLayoutY(380);
        text.setFill(Color.RED);
        text.setVisible(false);
               
        // Añadir componentes al pane 
        pane.getChildren().add(text);
        pane.getChildren().add(button);
        pane.getChildren().add(button2);
        pane.getChildren().add(circle);
        
        //Modificadores scene
        scene = new Scene(pane,400,400);
        stage.setTitle("Control Circle");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();      
    }


    public static void main(String[] args) {
        launch(args);
    }
    // Evento para agrandar el circulo
    class EventPlus implements EventHandler<ActionEvent> {       
        @Override
        public void handle(ActionEvent e) {
            if (circle.getRadius()>=100.0) {
                text.setVisible(true);
                text.setText("Circle too large!");
            }else{
                text.setVisible(false);
                RadiusPlus(); 
            } 
        }
    }
    //Evento para disminuir el circulo
    class EventMinus implements EventHandler<ActionEvent> {       
        @Override
        public void handle(ActionEvent e) {
            if (circle.getRadius()<=5.0) {
                text.setVisible(true);
                text.setText("Circle to small!");
            }else{
                
                text.setVisible(false);
                RadiusMinus(); 
            }                     
        }
    }
    //Metodo para aumentar el radio
    public void RadiusPlus(){
        circle.setRadius(circle.getRadius()+5);
    }
    //Metodo para disminuir el radio
    public void RadiusMinus(){
        circle.setRadius(circle.getRadius()-5);
    }
    
}
