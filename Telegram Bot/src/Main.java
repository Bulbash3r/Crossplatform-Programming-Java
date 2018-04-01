import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init(); //инициализация api
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new BulbasherBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println ("Bot is ready");
        new BulbasherBot().addToLog("Bot is ready");
    }
}
