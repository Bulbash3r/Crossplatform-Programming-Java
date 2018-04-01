import java.util.ArrayList;
import java.util.Random;

class Cook extends Human {

    Cook () {
        super();
    }
    Cook (String name) {
        super (name);
    }
    void cook(ArrayList<Food> fl) {
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
        Food f = new Food(t);
        fl.add(fl.size(), f);
        System.out.println ("Vsyo ok!");
    }
}