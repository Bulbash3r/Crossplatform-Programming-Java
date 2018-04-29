import java.util.ArrayList;
import java.util.Random;

/**
 * Класс Повар
 */
class Cook extends Human {

    /**
     * Конструктор по умолчанию
     */
    Cook () {
        super();
    }

    /**
     * Конструктор с параметрами
     * @param name имя
     */
    Cook (String name) {
        super (name);
    }

    /**
     * Метод "готовки" Повара, добавляет новый объект типа "Еда" в общий список
     * @param fl список еды
     * @param ItemName название блюда
     */
    void cook(ArrayList<Food> fl, String ItemName) {
        Random rand = new Random();
        int r = rand.nextInt(4);
        Taste t = null;
        switch (r)
        {
            case 0: t = Taste.SWEET; break;
            case 1: t = Taste.SOUR; break;
            case 2: t = Taste.SALTY; break;
            case 3: t = Taste.BITTER; break;
        }
        Food f = new Food(t, ItemName);
        fl.add(fl.size(), f);
    }
}