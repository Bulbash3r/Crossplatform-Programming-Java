import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SimpleGui {
    private JButton randomizeButton;
    private JButton guessButton;
    private JTextField textField;
    private JLabel label;
    private Random random = new Random();
    int randNumber = -1;

    public void go(){
        JFrame frame = new JFrame("Guess the random");
        randomizeButton = new JButton ("Новое число");
        guessButton = new JButton ("Угадать!");
        label = new JLabel("Для начала игры нажмите кнопку начала игры");
        textField = new JTextField("");

        randomizeButton.addActionListener(new RandomListener());
        guessButton.addActionListener(new GuessListener());

        frame.getContentPane().add(BorderLayout.EAST,randomizeButton);
        frame.getContentPane().add(BorderLayout.WEST,guessButton);
        frame.getContentPane().add(BorderLayout.CENTER,label);
        frame.getContentPane().add(BorderLayout.NORTH, textField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setVisible(true);
    }

    class GuessListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            String tempString = textField.getText();
            int result=0;
            for (int i=0; i<tempString.length(); i++){
                result = result*10 + tempString.charAt(i) -'0';
            }
            if (randNumber == -1) label.setText("Загадайте число заново");
            else if (result >randNumber) label.setText("Ваше число больше загаданного");
            else if (result < randNumber) label.setText("Ваше число меньше загаданного");
            else {
                label.setText("Угадал!");
                randNumber = -1;
            }
        }
    }

    class RandomListener implements ActionListener{
        public void actionPerformed (ActionEvent event) {
        randNumber = random.nextInt(100)+1;
        label.setText("Новое число загадано");
        }
    }
}