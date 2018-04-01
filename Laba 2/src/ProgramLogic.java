import java.lang.String;
import java.util.ArrayList;

public class ProgramLogic
{
    private Programmer programmer = new Programmer("Юрий Луцик");
    private Cook cook = new Cook("Тамара Васильевна");
    private ArrayList<Food> foodList=new ArrayList();

    public void cook(){
        cook.cook(foodList);
    }
    public String coding() {
        return programmer.coding();
    }
    public Taste eat() {
        return programmer.eat(foodList);
    }
}
