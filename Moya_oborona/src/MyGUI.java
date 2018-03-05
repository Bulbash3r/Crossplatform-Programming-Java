import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

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
            String[] a = {"Солнечный", "Гречневый", "Памятный", "Масляный", "Траурный", "Плюшевый","Бешеный", "Трепетный", "Базовый",
                    "Скошенный", "Преданный", "Ласковый", "Пойманный", "Радужный", "Огненный", "Радостный"
                    , "Тензорный", "Шёлковый", "Пепельный", "Ламповый", "Жареный", "Загнанный"};
            String[] b = {"зайчик", "котик", "фильтр", "шарик", "Верник", "глобус", "ветер", "щавель", "пёсик", "копчик",
                     "ландыш", "стольник", "мальчик", "дольщик", "Игорь", "невод", "егерь", "пончик"
                    , "лобстер", "жемчуг", "кольщик", "йогурт", "овод"};
            String[] c = {"стеклянного", "ванильного", "резонного", "широкого", "дешёвого", "горбатого"
                    , "собачьего", "исконного", "волшебного", "картонного", "лохматого", "арбузного"
                    , "огромного", "запойного", "великого", "бараньего", "вандального", "едрёного", "парадного", "укромного"};
            String[] d = {"глаза", "плова", "Пельша", "мира", "деда", "жира", "мема", "ада", "бура", "жала"
                    , "нёба", "гунна", "хлама", "шума", "воза", "сала", "фена","зала", "рака"};
            String result = "";
            Random random = new Random();
            int i = random.nextInt(a.length);
            result+=a[i];
            result+=" ";

            i = random.nextInt(b.length);
            result+=b[i];
            result+=" ";

            i = random.nextInt(c.length);
            result+=c[i];
            result+=" ";

            i = random.nextInt(d.length);
            result+=d[i];
            label.setText (result);
        }
    }
}
