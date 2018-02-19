import java.util.Random;

class GameLogic {
    private Random random = new Random();
    private int userNumber;
    private int border = 0;
    private int computerNumber = -1;

    GameLogic(int n) {
        border = n;
    }

    public void setComputerNumber() {
        computerNumber = random.nextInt(border)+1;
    }

    public void setUserNumber(String fieldString){
        userNumber=0;
        if (fieldString.length()==0) {
            userNumber=-2;
            return;
        }
        else
        for (int i=0; i<fieldString.length(); i++){
            userNumber = userNumber*10 + fieldString.charAt(i) -'0';
        }
    }

    public void setNegativeComputerNumber() {computerNumber = -1;}

    public CompareEnum.compareResult compareOfNumbers(){
        if (computerNumber == -1) return CompareEnum.compareResult.NOT_STARTED;
        else if (userNumber == -2) return CompareEnum.compareResult.NOT_ENTERED;
        else if (userNumber > computerNumber) return CompareEnum.compareResult.MORE;
        else if (userNumber < computerNumber) return CompareEnum.compareResult.LESS;
        else return CompareEnum.compareResult.WIN;

    }
    public int getComputerNumber(){return computerNumber;}
    public int getUserNumber(){return userNumber;}
}