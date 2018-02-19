import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.*;

public class MyGUI {
    private JButton startButton;
    private JButton guessButton;
    private JTextField textField;
    private JLabel label;
    private JMenuBar menuBar;
    private JFrame frame;
    private JMenu mainMenu;
    private GameLogic gameLogic;

    public void runGUI(){
        constructFrame (100);
        setIcon();
        makeMenu();
        addComponentsToFrame();
        finalSettingOfFrame();
    }

    void constructFrame(int border) {
        frame = new JFrame("Guess the random");
        label = new JLabel("Начните игру");
        textField = new JTextField();
        startButton = new JButton ("Начать игру");
        guessButton = new JButton ("Угадать!");
        menuBar = new JMenuBar();
        gameLogic = new GameLogic(border);

        startButton.addActionListener(new RandomListener());
        guessButton.addActionListener(new GuessListener());
    }

    void setIcon() {
        ImageIcon icon = new ImageIcon("src/games-icon.png");
        frame.setIconImage(icon.getImage());
    }

    void makeMenu() {
        mainMenu = new JMenu("Меню");

        JMenuItem newGameItem = new JMenuItem("Новая игра");
        mainMenu.add(newGameItem);
        newGameItem.addActionListener(new RandomListener());

        JMenuItem aboutItem = new JMenuItem("О программе");
        mainMenu.add(aboutItem);
        aboutItem.addActionListener(new AboutListener());

        mainMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Выход");
        mainMenu.add(exitItem);
        exitItem.addActionListener(new ExitListener());

        menuBar.add(mainMenu);
        frame.setJMenuBar(menuBar);
    }

    void addComponentsToFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        textField.setBounds(20,15,150,20);
        panel.add (textField);

        label.setBounds(20,35, 200, 20);
        panel.add(label);

        guessButton.setBounds (20, 60, 90,30);
        panel.add(guessButton);

        startButton.setBounds (120, 60, 150, 30);
        panel.add(startButton);

        frame.getContentPane().add(panel);
    }

    void finalSettingOfFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,165);
        frame.setLocation(800,400);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    class ExitListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            System.exit(0);
        }
    }

    class AboutListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            JOptionPane.showMessageDialog(null,
                    "Автор: Юревич Антон\n20!8\n\nНаписал HelloWorld - напишу и первую лабу", "О программе",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    class GuessListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            gameLogic.setUserNumber(textField.getText());
            switch (gameLogic.compareOfNumbers()) {
                case NOT_STARTED: label.setText("Начните игру"); break;
                case NOT_ENTERED: label.setText("Число не введено"); break;
                case MORE: label.setText("Ваше число больше загаданного"); break;
                case LESS: label.setText("Ваше число меньше загаданного"); break;
                case WIN: {
                    JOptionPane.showMessageDialog(null,
                            "Вы угадали число!", "Победа!",
                            JOptionPane.PLAIN_MESSAGE);
                    gameLogic.setNegativeComputerNumber();
                    label.setText("Начните игру заново");
                    textField.setText("");
                    break;
                }
            }
        }
    }

    class RandomListener implements ActionListener{
        public void actionPerformed (ActionEvent event) {
            gameLogic.setComputerNumber();
            label.setText("Новое число сгенерировано");
            textField.setText("");
        }
    }
}