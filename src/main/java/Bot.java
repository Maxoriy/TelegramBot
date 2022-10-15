import PlayerManagement.PlayerQuestionManager;
import PlayerManagement.UserHandler;
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

            switch (MessageText) {
                case "/start" -> startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                case "/help" -> helpCommandReceived(chatId);
                default -> HandleReaction(chatId,update);
            }
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
    private void HandleReaction(long chatid, Update update){
       int code=  users.get(chatid).HandleReaction(update);

       if(code==0){
           FileSendCommand(chatid);
            users.remove(chatid);
       }
       else{
           SendText(chatid, users.get(chatid).GetQuestionToAskText());
       }
    }

    private void helpCommandReceived(long chatId) {
        String answer = "In the future, here will be the help for working with the bot!";
        SendText(chatId, answer);
    }
    private void startCommandReceived(long chatId, String name) {
        SendText(chatId,"recieved");
         users.put(chatId,new PlayerQuestionManager());
        SendText(chatId, users.get(chatId).GetQuestionToAskText());
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
