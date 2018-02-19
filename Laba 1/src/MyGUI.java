import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class realize graphical user interface (GUI) of labushka.
 */
public class MyGUI {
    private JButton startButton;
    private JButton guessButton;
    private JTextField textField;
    private JLabel label;
    private JMenuBar menuBar;
    private JFrame frame;
    private JMenu mainMenu;
    private GameLogic gameLogic;

    /**
     * Method of initialize and running GUI.
     * @param border This is the border of randomize.
     */
    public void runGUI(int border){
        constructFrame (border);
        setIcon();
        makeMenu();
        addComponentsToFrame();
        finalSettingOfFrame();
    }

    /**
     * This method initialize main components of GUI.
     * @param border This is the border of randomize.
     */
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

    /**
     * This method sets icon of app.
     */
    void setIcon() {
        ImageIcon icon = new ImageIcon("src/image/games-icon.png");
        frame.setIconImage(icon.getImage());
    }

    /**
     * This method makes menu.
     */
    void makeMenu() {
        mainMenu = new JMenu("Меню");

        JMenuItem newGameItem = new JMenuItem("Новая игра");
        mainMenu.add(newGameItem);
        newGameItem.addActionListener(new RandomListener());

        JMenuItem aboutItem = new JMenuItem("О программе");
        mainMenu.add(aboutItem);
        aboutItem.addActionListener(new AboutListener());

        JMenuItem catItem = new JMenuItem("Не жмякай, подумой");
        mainMenu.add(catItem);
        catItem.addActionListener(new CatListener());

        mainMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Выход");
        mainMenu.add(exitItem);
        exitItem.addActionListener(new ExitListener());

        menuBar.add(mainMenu);
        frame.setJMenuBar(menuBar);
    }

    /**
     * This method adds components on frame.
     */
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

    /**
     * This method sets principal settings of frame.
     */
    void finalSettingOfFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,165);
        frame.setLocation(800,400);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }

    /**
     * Event handler of menu item "exitItem".
     * When clicked, exits the app.
     */
    class ExitListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            System.exit(0);
        }
    }

    /**
     * Event handler of menu item "aboutItem".
     * Open the window with information about program and creator.
     */
    class AboutListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            JOptionPane.showMessageDialog(null,
                    "Автор: Юревич Антон, группа 650503\n20!8\n\nНаписал HelloWorld - напишу и первую лабу", "О программе",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    class CatListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            JOptionPane.showMessageDialog(null,
                    "..........................／＞　　フ\n" +
                            ".........................| 　_　 _ l   \n" +
                            "......................／` ミ＿xノ\n" +
                            "...................../　　　　 | \n" +
                            "..................../　 ヽ　　 ﾉ \n" +
                            "............. ..│　　|　|　| \n" +
                            "..........／￣|　　 |　|　| \n" +
                            "..........| (￣ヽ＿_ヽ_)__) \n" +
                            "...........＼二つ\n", "Це кіт",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Event handler of button "guessButton".
     * Realize the interface of reading and guessing number.
     */
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

    /**
     * Event handler of button "startButton".
     * Realize the starting of a new game.
     */
    class RandomListener implements ActionListener{
        public void actionPerformed (ActionEvent event) {
            gameLogic.setRandomNumber();
            label.setText("Новое число сгенерировано");
            textField.setText("");
        }
    }
}