import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Лаба 2.
 * Повар может готовить и кушать еду.
 * Программист может писать код и кушать.
 * После трапезы оба возвращают вкус еды, которую они съели.
 * В классе Main создаётся графический интерфейс пользователя.
 * @since 19.04.2018
 * @author Yurevich Anton
 */
public class Main extends Application {

    /**
     * Точка входа в программу
     * @param args аргументы командной строки (не используются)
     */
    public static void main (String[] args) {
        Application.launch(args);
    }

    /**
     * Создание GUI
     * @param primaryStage начальная сцена приложения
     */
    @Override
    public void start (Stage primaryStage) {
        HBox root = new HBox();
        VBox Vcook = new VBox();
        VBox Vproger = new VBox();

        Button cook = new Button("Приготовить!");
        Button eatProger = new Button("Скушать!");
        Button eatCook = new Button("Скушать!");
        Button code = new Button ("Кодить!");
        cook.setMinWidth(150);
        eatProger.setMinWidth(150);
        eatCook.setMinWidth(150);
        code.setMinWidth(150);

        ProgramLogic Logic = new ProgramLogic();

        TextField TfoodName = new TextField("");
        TfoodName.setPrefSize(150, 15);

        TextArea console = new TextArea("Ваш код будет туть");
        console.setMinSize(150, 200);
        console.setFont(new Font("Courier New", 12));
        console.setWrapText(true);

        ListView<String> ListFood = new ListView<String>();
        ListFood.setMinSize(150, 150);
        ObservableList<String> List = FXCollections.observableArrayList();

        Vcook.getChildren().addAll (ListFood, TfoodName, cook, eatCook);
        Vproger.getChildren().addAll(console, code, eatProger);
        root.getChildren().addAll(Vcook, Vproger);

        cook.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (TfoodName.getText().equals("")) {
                    ShowFoodAlert();
                }
                else {
                    Logic.cook(TfoodName.getText());
                    List.add (TfoodName.getText());
                    ListFood.setItems(List);
                    TfoodName.setText("");
                }
            }
        }));
        eatCook.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (!Logic.getArrayList().isEmpty()) {
                    ShowCookTasteAlert(Logic.eatCook());
                    List.remove(List.size()-1);
                    ListFood.setItems(List);
                }
            }
        }));
        eatProger.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (!Logic.getArrayList().isEmpty()) {
                    ShowProgerTasteAlert(Logic.eatProger());
                    List.remove(List.size()-1);
                    ListFood.setItems(List);
                }
            }
        }));
        code.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                console.setText (Logic.coding());
            }
        }));
        TfoodName.setOnKeyPressed((new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode()== KeyCode.ENTER) {
                    if (TfoodName.getText().equals("")) {
                        ShowFoodAlert();
                    }
                    else {
                        Logic.cook(TfoodName.getText());
                        List.add (TfoodName.getText());
                        TfoodName.setText("");
                        ListFood.setItems(List);
                    }
                }
            }
        }));
        Scene scene = new Scene (root, 300, 250);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private void ShowFoodAlert() {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("А-та-та");
        alert.setHeaderText(null);
        alert.setContentText("Тамара Семёновна, негоже подавать безымянное блюдо!");
        alert.showAndWait();
    }

    private void ShowProgerTasteAlert(Food food) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("Вкуснота-то какая!");
        alert.setHeaderText(null);
        alert.setContentText("Кажется, вкус этого блюда: " + food.tasteToString().toLowerCase()+"\n"+
        "Было вкусно, но чистая сишка всё равно вкуснее");
        alert.showAndWait();
    }

    private void ShowCookTasteAlert(Food food) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("Вкуснота-то какая!");
        alert.setHeaderText(null);
        alert.setContentText("Кажется, вкус этого блюда: " + food.tasteToString().toLowerCase()+"\n"+
        "В следующий раз добавлю больше перца и лавровый листик");
        alert.showAndWait();
    }
}