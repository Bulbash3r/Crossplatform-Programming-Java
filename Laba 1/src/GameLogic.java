import java.util.Random;
class GameLogic {
    private Random random = new Random();
    private int userNumber;
    private int computerNumber = -1;

    public void setComputerNumber() {
        computerNumber = random.nextInt(100)+1;
    }

    public void setUserNumber(String fieldString){
        userNumber=0;
        for (int i=0; i<fieldString.length(); i++){
            userNumber = userNumber*10 + fieldString.charAt(i) -'0';
        }
    }

    public void setNegativeComputerNumber() {computerNumber = -1;}

    public byte compareOfNumbers(){
        if (computerNumber == -1) return 0;
        else if (userNumber > computerNumber) return 1;
        else if (userNumber < computerNumber) return -1;
        else return 2;

    }
    public int getComputerNumber(){return computerNumber;}
    public int getUserNumber(){return userNumber;}
}