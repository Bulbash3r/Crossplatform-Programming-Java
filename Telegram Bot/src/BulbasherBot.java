import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.telegram.telegrambots.*;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.objects.*;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;

/**
 * Небольшой бот для Телеграма, взаимодействие с которым происходит при помощи /команд.
 */
public class BulbasherBot extends TelegramLongPollingBot {
    private static final String BOT_TOKEN = "522275875:AAFNsGlbSzvioBRT3e3uRIxrwj03H5YzcCk"; //Токен бота
    private static final String BOT_USERNAME = "Bulbash3r Bot"; //Имя бота
    private static final int ERROR_CONST = 3;
    private static final String[] STICKER = {
            "CAADAgADAQADqCIbEo_tyLxW-GDrAg",
            "CAADAgADAgADqCIbEhZIzEOaArMbAg",
            "CAADAgADAwADqCIbEgorrzElmtpiAg",
            "CAADAgADBAADqCIbEjaKOICKdjVOAg",
            "CAADAgADBQADqCIbEjn7O7Ry7M5-Ag",
            "CAADAgADBwADqCIbErum2jHga5g-Ag",
            "CAADAgADCAADqCIbEg8C29F_fzVAAg",
            "CAADAgADCQADqCIbEnFjZ92OisebAg",
            "CAADAgADDAADqCIbEv5phAABnJDVhQI",
            "CAADAgADDQADqCIbEl--ewMVon3kAg",
            "CAADAgADDgADqCIbEnkAAaUciwrDbAI",
            "CAADAgADIwADqCIbEsx1mIYnyRURAg"};
    private static final String[] HELLO = {"Дороу", "Привет", "Хаюшки"}; //Массив приветствий
    private static final String[] QUOTE = {"Дибилы", "звучит как угроза","Знает кто как заходить на iis БГУИР?",
    "ты сравниваешь машину и скейтборд", "В каждом есть дерьмо. Его ещё принято называть личностью или персональностью",
    "лучше го пивка потом выпьем","Не знаю, ни одного по-настоящему хорошего человека",
    "смешной такой", "+\\","харе стебаться","а вообще, все нужно делать в прикол",
    "я Злата брат",
            "Писка",
            "программируй на своем питоне",
            "теперь я знаю, что делать, когда до меня доебался Педрушкевич",
            "го дискуссию",
            "книги бесполезная трата времени",
            "что годного по линухе почитать?",
            "Сергей Шемпелевич",
            "Console.log('как дела');",
            "кодь под грушу",
            "бляяяяяяяяяяять",
            "Не сказал бы что умение прогать == знанию С",
            "короче, есть массив 2d (не тян), нужно взять колво строк",
            "вот коболь жопа",
            "хотел порешать ctf и пописать метру -> смотрю 7-ую серию подряд)",
            "я так и не разобрался \n" +
                    "забил",
            "ну если ты можешь посмотреть уроки видео и сразу кодить, то респект тебе\n" +
                    "я так не могу",
            "привет, человек",
            "так что такое аилофт",
            "(если кому смешно, это тру)",
            "существует мнение, что возможно в X-боксах присутствуют слабости",
            "Бывалый",
            "это как-то кхм.",
            "Интересно ты свои комплексы скрываешь, Юрэвич",
            "глупый вопрос",
            "Хм, человек-клещ прыгал бы метров на 50-100",
            "выборы, выборы\n" +
                    "кандидаты в старосты",
            "а может мне попробовать версию старньше 16.04",
            "жизнь воообще боль",
            "бля, все бы сча отдал за линукс",
            "Меня под 4 машинкой стригли",
            "завтра праздник еще буде?",
            "У кого есть список литературы по аокт?",
            "умирать совершеннее чем жить",
            "делфи говно",
            "ясненько, людей мы не уважаем",
            "кто ещё кроме Оношко действительно что-то добился",
            "почему ты так рьяно защищаешь поит",
            "Поит и вмсис братья почти",
            "но в мыслях он мне постоянно ебало начищает",
            "ПЛИСКАСОСИСКА",
            "Я че еблан?",
            "огурчик, попрошу",
            "вмсис ведь не тупой читать вики?",
            "Звёзд в void должно быть столько же скока их во вселенной",
            "сидел кто на тарифах семья лайф",
            "(заткните АНТОСЯ мне рил плевать)",
            "на пересдачу",
            "вроде все логично",
            "так, это сстеб Азарова, или рил так",
            "Хули он такой агрессивенвй",
            "Вы че ебланы?",
            "что юзаете чтобы взбродрится?",
            "вообще js классная штука",
            "Я один такой\n" +
                    "Других таких как я нет\n" +
                    "Я личность",
            "бля, голова уже не работает",
            "я понял процентов 60 слов",
            "скоро должно отпустить",
            "Придумал супералгоритм",
            "туса без расширенных жоп"};
    private static final String[] MEMES = {"https://pp.userapi.com/c846322/v846322926/52aa/U0upTVS2_OU.jpg",
            "https://pp.userapi.com/c847219/v847219419/8aab/5eij9gNUCQQ.jpg",
            "https://pp.userapi.com/c639425/v639425192/36b27/c2mGbIGaqEs.jpg",
            "https://sun9-3.userapi.com/c831209/v831209872/52bfb/dtE4JKp3NkE.jpg",
            "https://sun9-5.userapi.com/c840727/v840727938/66fad/c82Si8kLmyM.jpg",
            "https://pp.userapi.com/c7002/v7002111/4421e/caw8TQl7lBo.jpg",
            "https://sun9-2.userapi.com/c840728/v840728121/5abe1/YhTjAPqj2ao.jpg",
            "https://sun9-4.userapi.com/c840534/v840534452/2bcdb/FN5aRjKo0ps.jpg",
            "https://pp.userapi.com/c639123/v639123170/e743/KYR40PKpIR4.jpg",
            };
    private int error_count = ERROR_CONST;
    private int log_count = 0;
    private boolean random = false;

    /**
     * @return Имя бота
     */
    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    /**
     * Обработка полученного сообщения и совершение какого-либо действия
     * @param e для получения текста сообщения
     */
    @Override
    public void onUpdateReceived (Update e) {
        Message msg = e.getMessage();
        addToLog(msg.getFrom().getUserName() + ": "+ msg.getText());
        String result;
        if (random) {
            result = "Ваше случайное число - " + getRand(msg.getText());
            sendMsg (msg, result);
            addToLog("Bot: "+result);
            random = false;
            error_count--;
        }
        random = false;
        if (msg.getText().equals ("/random")) {
            sendMsg (msg, "Введите область рандома");
            random = true;
        }
        else if (msg.getText().equals("/quote")) {
            result = generateQuote()+ " (с) Евгений Степанцов";
            sendMsg (msg, result);
            addToLog("Bot: "+ result);
        }
        else if (msg.getText().equals("/memes")) {
            int i = new Random().nextInt(MEMES.length);
            sendImageFromUrl(MEMES[i], Long.toString(msg.getChatId()));
            if (i==3) sendMsg (msg, "Этот мем сделала Настя, вьювер дискрешн из эдвайст");
            addToLog ("Мем отправлен");
        }
        /*else if (newtxt.equals("/test")) {
            //тест
        }*/
        else if (msg.getText().equals("/sticker")) {
            sendStickerFromURL(STICKER[new Random().nextInt(STICKER.length)],Long.toString(msg.getChatId()));
            addToLog("Стикер отправлен");
        }
        else if (msg.getText().equals("/hello")||msg.getText().equals("/start")) {
            result = generateHello()+", "+msg.getFrom().getFirstName()+"!\nТыкай /help чтобы начать";
            sendMsg (msg, result);
            addToLog("Bot: "+ result);
        }
        else if (msg.getText().equals("/help")) {
            sendMsg (msg, "Список команд:\n" +
                    "/start или /hello - приветствие\n" +
                    "/help - помощь\n" +
                    "/random - рандомит число\n" +
                    "/quote - выводит цитату Степанцова\n" +
                    "/flip или /coin - бросить монетку\n" +
                    "/memes - присылает мем\n" +
                    "/sticker - отправляет стикер");
            addToLog("Помощь выведена");
        }
        else if (msg.getText().equals ("/flip") || msg.getText().equals("/coin")) {
            sendMsg(msg, "Бросаем монетку...");
            result = randomCoin();
            sendMsg(msg, result);
            addToLog(result);
        }
        else if (error_count == ERROR_CONST) {
            result = "Хм, что-то пошло не так, попробуй команду /help";
            sendMsg (msg, result);
            addToLog ("Ошибка ввода");
            error_count = 0;
        }
        else error_count++;
    }

    /**
     * @return Токен бота
     */
    @Override
    public String getBotToken() {
        return BOT_TOKEN; //токен бота
    }

    @SuppressWarnings("deprecation")
    private void sendMsg (Message msg, String text) {
        SendMessage s = new SendMessage();
        setButtons(s);
        s.setChatId(msg.getChatId()); //боту может писать не один человек,
        //поэтому чтобы отправить сообщение нужно узнать куда его отправить
        s.setText(text);
        try {
            sendMessage(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод генерирует приветственное сообщение
     * @return сообщение приветствия
     */
    private String generateHello () {
        return HELLO[new Random().nextInt(HELLO.length)];
    }

    private String randomCoin() {
        String coin ="";
        switch (new Random().nextInt(2)) {
            case 0: coin= "Орёл"; break;
            case 1: coin= "Решка"; break;
        }
        return coin;
    }

    private String generateQuote() {
        return QUOTE[new Random().nextInt(QUOTE.length)];
    }

    /**
     * Метод генерирует случайное число
     * @param str строка, из которой выбирается подстрока с числом-областью рандома
     * @return строка, являющаяся случайным числом
     */
    @NotNull
    private String getRand(String str) {
        return Integer.toString(new Random().nextInt(Integer.parseInt(str)));
    }

    private void sendImageFromUrl(String url, String chatId) {
        // Create send method
        SendPhoto sendPhotoRequest = new SendPhoto();
        // Set destination chat id
        sendPhotoRequest.setChatId(chatId);
        // Set the photo url as a simple photo
        sendPhotoRequest.setPhoto(url);
        try {
            // Execute the method
            sendPhoto(sendPhotoRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void sendStickerFromURL(String url, String chatId) {
        // Create send method
        SendSticker sendStickerRequest = new SendSticker();
        // Set destination chat id
        sendStickerRequest.setChatId(chatId);
        // Set the photo url as a simple photo
        sendStickerRequest.setSticker(url);
        try {
            // Execute the method
            sendSticker(sendStickerRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



    void addToLog(String txt) {
        try(FileWriter writer = new FileWriter("C:\\Users\\yurev\\Documents\\GitHub\\Java-Labs\\Telegram Bot\\src\\data\\log.txt", true)) {
            writer.write(Integer.toString(log_count));
            writer.write(" " + txt);
            writer.append('\n');
            log_count++;
            writer.flush();
        } catch (IOException ex) {
            addToLog(ex.getMessage());
        }
    }
    private void setInline() {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        buttons1.add(new InlineKeyboardButton().setText("Помощь").setCallbackData("/help"));
        buttons.add(buttons1);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
    }

    private synchronized void setButtons(SendMessage sendMessage) {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("/help"));
        keyboardFirstRow.add(new KeyboardButton("/random"));
        keyboardFirstRow.add(new KeyboardButton("/quote"));


        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("/flip"));
        keyboardSecondRow.add(new KeyboardButton("/memes"));
        keyboardSecondRow.add(new KeyboardButton("/sticker"));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
}