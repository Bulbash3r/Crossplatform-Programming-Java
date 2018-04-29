import java.lang.String;
import java.util.ArrayList;

/**
 * Класс описания логики
 */
public class ProgramLogic
{
    private Programmer programmer = new Programmer("Юрий Луцик");
    private Cook cook = new Cook("Тамара Семёновна");
    private ArrayList<Food> foodList = new ArrayList<Food>();

    public void cook(String ItemName){
        cook.cook(foodList, ItemName);
    }
    public String coding() {
        return programmer.coding();
    }
    public Food eatProger() {
        return programmer.eat(foodList);
    }
    public Food eatCook() {
        return cook.eat(foodList);
    }
    public ArrayList getArrayList() {
        return foodList;
    }
}
