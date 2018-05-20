import Humans.*;
import Items.Food;


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

import java.util.ArrayList;

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
        Proger proger = new Proger ("Юрий Луцик");
        Cook cook = new Cook ("тамара Семёновна");
        Farmer farmer = new Farmer ("Семён Семёныч");

        ArrayList<Food> foodList = new ArrayList<Food>();

        HBox root = new HBox();
        VBox Vcook = new VBox();
        VBox Vproger = new VBox();
        VBox Vfarmer = new VBox();

        Button Bcook = new Button("Приготовить!");
        Button BeatProger = new Button("Скушать!");
        Button BeatCook = new Button("Скушать!");
        Button Bcode = new Button ("Кодить!");
        Button Bplant = new Button("Посадить");
        Button Bwater = new Button ("Полить");
        Button Bcollect = new Button ("Собрать урожай");
        Button BeatFarmer = new Button ("Скушать");

        Bcook.setMinWidth(150);
        BeatProger.setMinWidth(150);
        BeatCook.setMinWidth(150);
        Bcode.setMinWidth(150);
        Bplant.setMinWidth(150);
        Bwater.setMinWidth(150);
        Bcollect.setMinWidth(150);
        BeatFarmer.setMinWidth(150);

        Label planted = new Label("Посажено овощей: 0");
        Label watered = new Label("Посажено и полито: 0");
        Label collected = new Label ("Собрано урожая: 0");
        TextField TfoodName = new TextField("");
        TfoodName.setPrefSize(150, 15);

        TextArea console = new TextArea("Ваш код будет туть");
        console.setPrefSize(150, 200);
        console.setFont(new Font("Courier New", 12));
        console.setWrapText(true);

        ListView<String> ListFood = new ListView<String>();
        ListFood.setPrefSize(150, 200);
        ObservableList<String> List = FXCollections.observableArrayList();

        Vcook.getChildren().addAll (ListFood, TfoodName, Bcook, BeatCook);
        Vproger.getChildren().addAll(console, Bcode, BeatProger);
        Vfarmer.getChildren().addAll(planted, watered, collected, Bplant, Bwater, Bcollect, BeatFarmer);
        root.getChildren().addAll(Vcook, Vproger, Vfarmer);

        Bcook.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (TfoodName.getText().equals("")||farmer.getVegetSize()==0) {
                    ShowFoodAlert();
                }
                else {
                    cook.cook(foodList, TfoodName.getText(), farmer.getLast());
                    List.add (TfoodName.getText());
                    farmer.deleteVeget();
                    ListFood.setItems(List);
                    TfoodName.setText("");
                    collected.setText("Собрано урожая: "+ farmer.getVegetSize());
                }
            }
        }));
        BeatCook.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (!foodList.isEmpty()) {
                    cook.eat(foodList);
                    List.remove(List.size()-1);
                    ListFood.setItems(List);
                }
            }
        }));
        BeatFarmer.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (!foodList.isEmpty()) {
                    farmer.eat(foodList);
                    List.remove(List.size()-1);
                    ListFood.setItems(List);
                }
            }
        }));
        BeatProger.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (!foodList.isEmpty()) {
                    proger.eat(foodList);
                    List.remove(List.size()-1);
                    ListFood.setItems(List);
                }
            }
        }));
        Bcode.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                console.setText(proger.coding());
            }
        }));
        TfoodName.setOnKeyPressed((new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode()== KeyCode.ENTER) {
                    if (TfoodName.getText().equals("") || farmer.getVegetSize()==0) {
                        ShowFoodAlert();
                    }
                    else {
                        cook.cook(foodList ,TfoodName.getText(), farmer.getLast());
                        List.add (TfoodName.getText());
                        farmer.deleteVeget();
                        TfoodName.setText("");
                        ListFood.setItems(List);
                        collected.setText("Собрано урожая: "+ farmer.getVegetSize());
                    }
                }
            }
        }));
        Bplant.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                farmer.plant();
                planted.setText("Посажено овощей: "+ farmer.getPlanted());
            }
        }));
        Bwater.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                farmer.water();
                watered.setText("Посажено и полито: "+ farmer.getWatered());
                planted.setText("Посажено овощей: "+ farmer.getPlanted());
            }
        }));
        Bcollect.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                farmer.collect();
                watered.setText("Посажено и полито: "+ farmer.getWatered());
                planted.setText("Посажено овощей: "+ farmer.getPlanted());
                collected.setText("Собрано урожая: "+ farmer.getVegetSize());
            }
        }));
        Scene scene = new Scene (root, 450, 250);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private void ShowFoodAlert() {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("А-та-та");
        alert.setHeaderText(null);
        alert.setContentText("Тамара Семёновна, непорядок!");
        alert.showAndWait();
    }

}