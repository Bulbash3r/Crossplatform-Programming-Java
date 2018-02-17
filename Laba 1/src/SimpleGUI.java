import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUI {
    private JButton randomizeButton;
    private JButton guessButton;
    private JTextField textField;
    private JLabel label;
    private GameLogic gameLogic = new GameLogic();

    public void runGUI(){
        JFrame frame = new JFrame("Guess the random");
        label = new JLabel("Начните игру");
        textField = new JTextField("");
        randomizeButton = new JButton ("Начать игру");
        guessButton = new JButton ("Угадать!");

        randomizeButton.addActionListener(new RandomListener());
        guessButton.addActionListener(new GuessListener());

        frame.getContentPane().add(BorderLayout.CENTER,label);
        frame.getContentPane().add(BorderLayout.NORTH, textField);
        frame.getContentPane().add(BorderLayout.EAST,randomizeButton);
        frame.getContentPane().add(BorderLayout.WEST,guessButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);
    }

    class GuessListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            gameLogic.setUserNumber(textField.getText());
            byte resultOfCompare = gameLogic.compareOfNumbers();
            if (resultOfCompare == 0) label.setText("Начните игру заново");
            else if (resultOfCompare == 1) label.setText("Ваше число больше загаданного");
            else if (resultOfCompare == -1) label.setText("Ваше число меньше загаданного");
            else {
                label.setText("Поздравляю!");
                gameLogic.setNegativeComputerNumber();
            }
        }
    }

    class RandomListener implements ActionListener{
        public void actionPerformed (ActionEvent event) {
            gameLogic.setComputerNumber();
            label.setText("Новое число сгенерировано");
        }
    }
}