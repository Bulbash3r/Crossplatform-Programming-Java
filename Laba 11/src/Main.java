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
 * @link    https://github.com/Bulbash3r/Java-Labs/tree/master/Laba%201
 */

class Main{
    /**
     * This is the main method which run the game
     * @param args Unused.
     * @return Nothing.
     */
    public static void main (String[] args) {
        final int border=10;
        new MyGUI().runGUI(border);
    }
}