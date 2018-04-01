import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.event.*;
import javafx.scene.text.Text;
import javafx.stage.*;

public class Main extends Application {
    @Override
    public void start (Stage primaryStage) {
        Group root = new Group();
        Button cook = new Button("Приготовить!");
        Button eat = new Button("Скушать!");
        Button code = new Button ("Кодить!");

        ProgramLogic Logic = new ProgramLogic();
        root.getChildren().add(cook);
        root.getChildren().add(eat);
        root.getChildren().add(code);

        cook.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Logic.cook();
            }
        }));
        eat.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Logic.eat();
            }
        }));
        code.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Logic.coding();
            }
        }));




        Scene scene = new Scene (root, 300, 250);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
        Logic.cook();
        System.out.println(Logic.coding());
        System.out.println (Logic.eat());
    }
    public static void main (String[] args) {
        Application.launch(args);
    }
}