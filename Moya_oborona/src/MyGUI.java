import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;

public class MyGUI {
    JLabel label;

    public void runGUI() {
        JFrame frame = new JFrame("Моя оборона");
        label = new JLabel ("Солнечный зайчик стеклянного глаза");
        JButton button = new JButton ("Сгенерировать");

        //ImageIcon icon = new ImageIcon ("/src/image/icon.png");
        //frame.setIconImage(icon.getImage());

        JPanel panel = new JPanel();
        panel.setLayout(null);
        label.setFont (new Font ("Arial", Font.PLAIN, 14));
        button.setFont (new Font ("Arial", Font.PLAIN, 14));
        button.addActionListener(new GenerateListener());

        label.setBounds(15, 10, 282, 35);
        panel.add(label);

        button.setBounds(15,50, 282,35);
        panel.add(button);
        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330,135);
        frame.setLocation(800,400);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }

    class GenerateListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String[] plastmassovyy = {"Пластмассовый", "Внеклассовый", "Яичневый","Бензиновый", "Неоновый"};
            String[] mir = {"мир","пир","рис","сыр","мост","лист","лось",
                    "тесть","взгляд",};
            String[] pobedil = {"победил","перепил","накормил","покормил",};
            String[] maket = {"Макет", "Пакет","Буфет","Омлет","Паштет",};
            String[] okazalsya = {"оказался","показался","представлялся","поменялся"};
            String[] silney = {"сильней","слабей","умней","тупей","бледней","мрачней",
                    "милей","бедней","наглей","грязней",};
            String[] posledniy = {"Последний", "Соседний","Победный","Наследный"};
            String[] korablik = {"кораблик","рогалик","хрусталик","фонарик","волканик",
                    "гидравлик","кудяблик","динамик","ботаник"};
            String[] ostyl = {"остыл","простыл","застыл","гостил","отмыл","помыл",};
            String[] ustal = {"устал","упал","настал"};
            String[] av = {"А в"};
            String[] gorle = {"горле"};
            String[] sopyat = {"сопят","лежат","сидят","вопят"};
            String[] komya = {"комья"};
            String[] vospominaniy = {"воспоминаний","именований","повествований",
                    "кровопусканий","соревнований","распознаваний","правописаний"};
            String[] ooo = {"О-о-о, моя"};
            String[] oborona = {"оборона","вибриона"};
            String[] solnechnyy = {"Солнечный", "Гречневый", "Памятный", "Масляный", "Траурный", "Плюшевый","Бешеный", "Трепетный", "Базовый",
                    "Скошенный", "Преданный", "Ласковый", "Пойманный", "Радужный", "Огненный", "Радостный"
                    , "Тензорный", "Шёлковый", "Пепельный", "Ламповый", "Жареный", "Загнанный"};
            String[] zaychik = {"зайчик", "котик", "фильтр", "шарик", "Верник", "глобус", "ветер", "щавель", "пёсик", "копчик",
                     "ландыш", "стольник", "мальчик", "дольщик", "Игорь", "невод", "егерь", "пончик"
                    , "лобстер", "жемчуг", "кольщик", "йогурт", "овод"};
            String[] steklyannogo = {"стеклянного", "ванильного", "резонного", "широкого", "дешёвого", "горбатого"
                    , "собачьего", "исконного", "волшебного", "картонного", "лохматого", "арбузного"
                    , "огромного", "запойного", "великого", "бараньего", "вандального", "едрёного", "парадного", "укромного"};
            String[] glaza = {"глаза", "плова", "Пельша", "мира", "деда", "жира", "мема", "ада", "бура", "жала"
                    , "нёба", "гунна", "хлама", "шума", "воза", "сала", "фена","зала", "рака"};
            String result = "";
            Random random = new Random();

            result+="\n\n\n\n\n\n\n\n\n\n\n\n";
            int i = random.nextInt(plastmassovyy.length);
            result+=plastmassovyy[i];
            result+=" ";

            i = random.nextInt(mir.length);
            result+=mir[i];
            result+=" ";

            i = random.nextInt(pobedil.length);
            result+=pobedil[i];
            result+=",\n";

            i = random.nextInt(maket.length);
            result+=maket[i];
            result+=" ";

            i = random.nextInt(okazalsya.length);
            result+=okazalsya[i];
            result+=" ";

            i = random.nextInt(silney.length);
            result+=silney[i];
            result+=",\n";

            int p = i = random.nextInt(posledniy.length);
            result+=posledniy[p];
            result+=" ";

            i = random.nextInt(korablik.length);
            result+=korablik[i];
            result+=" ";

            i = random.nextInt(ostyl.length);
            result+=ostyl[i];
            result+=",\n";

            i = p;
            result+=posledniy[i];
            result+=" ";

            i = random.nextInt(korablik.length);
            result+=korablik[i];
            result+=" ";

            i = random.nextInt(ustal.length);
            result+=ustal[i];
            result+=".\n";

            i = random.nextInt(av.length);
            result+=av[i];
            result+=" ";

            i = random.nextInt(gorle.length);
            result+=gorle[i];
            result+=" ";

            i = random.nextInt(sopyat.length);
            result+=sopyat[i];
            result+=" ";

            i = random.nextInt(komya.length);
            result+=komya[i];
            result+=" ";

            i = random.nextInt(vospominaniy.length);
            result+=vospominaniy[i];
            result+="\n\n";

            i = random.nextInt(ooo.length);
            result+=ooo[i];
            result+=" ";

            i = random.nextInt(oborona.length);
            result+=oborona[i];
            result+=",\n";

            i = random.nextInt(solnechnyy.length);
            result+=solnechnyy[i];
            result+=" ";

            i = random.nextInt(zaychik.length);
            result+=zaychik[i];
            result+=" ";

            i = random.nextInt(steklyannogo.length);
            result+=steklyannogo[i];
            result+=" ";

            i = random.nextInt(glaza.length);
            result+=glaza[i];
            result+=".\n";

            i = random.nextInt(ooo.length);
            result+=ooo[i];
            result+=" ";

            i = random.nextInt(oborona.length);
            result+=oborona[i];
            result+=",\n";

            i = random.nextInt(solnechnyy.length);
            result+=solnechnyy[i];
            result+=" ";

            i = random.nextInt(zaychik.length);
            result+=zaychik[i];
            result+=" ";

            i = random.nextInt(steklyannogo.length);
            result+=steklyannogo[i];
            result+=" ";

            i = random.nextInt(glaza.length);
            result+=glaza[i];
            result+=".\n";

            i = random.nextInt(solnechnyy.length);
            result+=solnechnyy[i];
            result+=" ";

            i = random.nextInt(zaychik.length);
            result+=zaychik[i];
            result+=" ";

            i = random.nextInt(steklyannogo.length);
            result+=steklyannogo[i];
            result+=" ";

            i = random.nextInt(glaza.length);
            result+=glaza[i];
            result+=".\n";



            //label.setText(result);
            System.out.println (result);
        }
    }
}
