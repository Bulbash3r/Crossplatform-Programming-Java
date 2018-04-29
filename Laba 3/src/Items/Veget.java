package Items;

import Enums.Color;
import Enums.Vegetable;

import java.util.Random;

public class Veget extends Item {
    private Color color;
    private Vegetable vegetable;


    public Veget() {
        super("Enums.Vegetable");
    }

    public Veget(String name) {
        super(name);
    }

    public Veget (String name, Color color, Vegetable vegetable) {
        super (name);
        this.color = color;
        this.vegetable = vegetable;
    }

    public void setColor (Color color) {
        this.color = color;
    }

    public void setVegetable (Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public Color getColor () {
        return this.color;
    }

    public Vegetable getVegetable() {
        return this.vegetable;
    }

    public void setRandVeget() {
        int rand = new Random().nextInt(9);
        switch (rand) {
            case 0: setColor(Color.RED); break;
            case 1: setColor(Color.GREEN); break;
            case 2: setColor(Color.BLUE); break;
            case 3: setColor(Color.PURPLE); break;
            case 4: setColor(Color.YELLOW); break;
            case 5: setColor(Color.VIOLET); break;
            case 6: setColor(Color.BROWN); break;
            case 7: setColor(Color.CYAN); break;
            case 8: setColor(Color.PINK); break;
        }
        rand = new Random().nextInt(5);
        switch (rand) {
            case 0: setVegetable(Vegetable.CARROT); break;
            case 1: setVegetable(Vegetable.CORN); break;
            case 2: setVegetable(Vegetable.POTATO); break;
            case 3: setVegetable(Vegetable.TOMAT); break;
            case 4: setVegetable(Vegetable.CUCUMBER); break;
        }
    }

    public String colorToString() {
        switch (color) {
            case RED: return "Красный";
            case GREEN: return "Зелёный";
            case BLUE: return "Голубой";
            case PURPLE: return "Фиолетовый";
            case YELLOW: return "Жёлтый";
            case VIOLET: return "Сиреневый";
            case BROWN: return "Коричневый";
            case CYAN: return "Бирюзовый";
            case PINK: return "Розовый";
        }
        return "Бесцветный";
    }

    public String vegetableToString() {
        switch (vegetable) {
            case CARROT: return "Морковь";
            case CORN: return "Кукуруза";
            case POTATO: return "Картофель";
            case TOMAT: return "Помидор";
            case CUCUMBER: return "Огурец";
        }
        return "Овощ";
    }
}