package Humans;
import Items.Food;
import javafx.scene.control.Alert;
import java.util.ArrayList;
import java.util.Random;

public class Proger extends Human {
    private static final int RAND_SIZE = 150;
    private final int MIN_RAND = 50;
    private final String alphabet = ("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890(){}[]<>=!,");

    public Proger() {
        super();
    }

    public Proger (String name) {
        super (name);
    }

    public String coding() {
        int size = new Random().nextInt(RAND_SIZE) + MIN_RAND;
        String code = "";
        for (int i=0; i<size; i++) {
            char next_symbol = alphabet.charAt (new Random().nextInt(alphabet.length()));
            code += next_symbol;
        }
        return code;
    }

    public void eat(ArrayList<Food> foodList) {
        Food f = foodList.get (foodList.size()-1);
        foodList.remove(foodList.size()-1);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("Вкуснота-то какая!");
        alert.setHeaderText(null);
        alert.setContentText("Кажется, вкус этого блюда: " + f.tasteToString().toLowerCase()+"\n"+
                "Было вкусно, но чистая сишка всё равно вкуснее");
        alert.showAndWait();
    }
}
