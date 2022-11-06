import PlayerManagement.PlayerQuestionManager;
import PlayerManagement.questions.UserQuestion;
import interfaces.UserAnswer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;
import java.util.HashMap;

public final class Bot extends TelegramLongPollingBot {

    private final String BOT_TOKEN;
    private final String BOT_NAME;
    private HashMap<Long,PlayerQuestionManager> users;
    public Bot(String BOT_NAME, String BOT_TOKEN) {
        super();
        this.BOT_NAME = BOT_NAME;
        this.BOT_TOKEN = BOT_TOKEN;
        this.users=new HashMap<>();
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String MessageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            redirectEntryAndCheckState(chatId,MessageText);
        }
    }
    private void FileSendCommand(long chatId)  {

        SendDocument message=new SendDocument();
        File initfile=new File("C:/Users/as-pa/IdeaProjects/TelegramBot/src/main/dororo.txt");
        message.setChatId(chatId);
        try {
            InputStream ff = new FileInputStream(initfile);

            InputFile f = new InputFile(ff, "dororo.txt");
            message.setDocument(f);
        }
        catch (FileNotFoundException e){e.printStackTrace();}
        try {
            execute(message);
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    private void redirectEntryAndCheckState(long chatId,String Message){
       /*
       * после того как пользователь введет что-то не может произойти выключение менеджера-> проверка на
       * это должна быть в самом конце функции
       * В этой функции мы должны ТОЛЬКО скармливать вводы программе, выдавать тексты с вопросами и проверять,
       *  а не закончил ли работу менеджер
       *
       *
       * */
        users.get(chatId).update(Message);
        SendText(chatId,users.get(chatId).GetCurrentText());
        if(users.get(chatId).ManagerWorkEnded()){
            FileSendCommand(chatId);
        }

    }
    private void SendText(long chatId, String TextToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(TextToSend);

        try{
            execute(message);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
