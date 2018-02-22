/**
 * The program "Guess of number" implements the algorithm
 * of making a random number by the computer
 * and guessing it by the user.
 *
 * Implemented graphical user interface (GUI)
 * using the library to create a graphical
 * interface Swing, and logical component.
 *
 * @author  Yurevich Anton
 * @version 1.1
 * @since   16.02.2018
 */

class Main{
    /**
     * This is the main method which run the game
     * @param args Border of randomizing.
     */
    public static void main (String[] args) {
        int border = Integer.parseInt(args[0]);
        new MyGUI().runGUI(border);
    }
}