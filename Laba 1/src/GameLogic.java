import java.util.Random;

/**
 * This class realize a logical component of program.
 */
class GameLogic {
    private Random random = new Random();
    private int userNumber;
    private int border;
    private int computerNumber = -1;
    private int counter;

    /**
     * This method is used to initialize
     * border of random.
     * @param n This is the border of randomize
     */
    GameLogic(int n) {
        border = n;
    }

    /**
     * This method sets number, which makes randomly.
     */
    public void setRandomNumber() {
        computerNumber = random.nextInt(border)+1;
    }

    /**
     * This is method of assignment number, which write user.
     * @param fieldString This is the number from TextField in string format.
     */
    public void setUserNumber(String fieldString){
        userNumber=0;
        if (fieldString.length()==0) {
            userNumber=-2;
            return;
        }
        else userNumber = Integer.parseInt (fieldString);
    }

    /**
     * This method set the game in state NON_STARTED.
     */
    public void setNegativeComputerNumber() {computerNumber = -1;}

    /**
     * This method check relations of user number and random number.
     * @return Result of compare.
     */
    public CompareEnum.compareResult compareOfNumbers(){
        if (computerNumber == -1) return CompareEnum.compareResult.NOT_STARTED;
        else if (userNumber == -2) return CompareEnum.compareResult.NOT_ENTERED;
        else if (userNumber > computerNumber) return CompareEnum.compareResult.MORE;
        else if (userNumber < computerNumber) return CompareEnum.compareResult.LESS;
        else return CompareEnum.compareResult.WIN;

    }

    /**
     * This method sets counter on zero
     */
    public void setCounterToZero() {counter = 0;}

    /**
     * This method increments counter
     */
    public void incCounter() {counter++;}

    /**
     * This method returns count of try
     * @return Count of try
     */
    public int getCounter() {return counter;}

    /**
     * This method return value of random number.
     * @return int Value of random number.
     */
    public int getComputerNumber(){return computerNumber;}

    /**
     * This method return value of user number.
     * @return int Value of user number
     */
    public int getUserNumber(){return userNumber;}
}