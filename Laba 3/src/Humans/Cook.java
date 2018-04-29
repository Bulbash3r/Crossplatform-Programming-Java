package Humans;

import Enums.Taste;
import Items.Food;
import Items.Veget;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Random;

public class Cook extends Human {
    public Cook() {
        super();
    }

    public Cook (String name) {
        super (name);
    }

    public void cook (ArrayList<Food> fl, String name, Veget veget) {
        int rand = new Random().nextInt(4);
        Food f = new Food(name);
        switch (rand) {
            case 0: f.setTaste(Taste.SWEET); break;
            case 1: f.setTaste(Taste.SOUR); break;
            case 2: f.setTaste(Taste.SALTY); break;
            case 3: f.setTaste(Taste.BITTER); break;
        }
        f.setVeget(veget);
        fl.add (fl.size(), f);
    }

    public void eat(ArrayList<Food> foodList) {
        if (!foodList.isEmpty()) {
            Food f = foodList.get (foodList.size()-1);
            foodList.remove(foodList.size()-1);
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle ("Вкуснота-то какая!");
            alert.setHeaderText(null);
            alert.setContentText("Кажется, вкус этого блюда: " + f.tasteToString().toLowerCase()+"\n"+
                    "Овощ: "+ f.getVeget().vegetableToString().toLowerCase() +", цвет блюда: " + f.getVeget().colorToString().toLowerCase()+"\n"+
                    "В следующий раз добавлю больше перца и лавровый листик");
            alert.showAndWait();
        }
    }
}
