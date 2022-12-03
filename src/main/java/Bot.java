import PDFListGeneration.HtmlList;
import PlayerManagement.QuestionIterators.PlayerQuestionManager;
import PlayerManagement.SheetInfo.InfoAdapter;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

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
        if (!(update.hasMessage() && update.getMessage().hasText())){
            return;
        }
        String MessageText = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
        switch (MessageText){
            case "/start"->onStart(chatId);
            case "/restart"->onReset(chatId);
            default -> Update(chatId,MessageText);
        }
    }
    private void Update(long chatId, String MessageText){
        UserQuestion uq=users.get(chatId).AskQuestion();
        if(!uq.isAnswerCorrect(MessageText)){
            SendText(chatId,"Неверный ввод");
            return;
        }
        uq.SetAnswer(MessageText);
        users.get(chatId).NextQuestion();
        if(users.get(chatId).IsOver()){
            FileSendCommand(chatId,users.get(chatId).getData());
            onReset(chatId);
        }
        SendText(chatId, ConvertQuestionToString(users.get(chatId).AskQuestion()));
    }
    private void onStart(long chatid){

        if(users.containsKey(chatid)){

            onReset(chatid);
        }
        users.put(chatid,new PlayerQuestionManager());

        if(!users.get(chatid).IsOver()){

            SendText(chatid,ConvertQuestionToString(users.get(chatid).AskQuestion()));
        }
        else{
            SendText(chatid,"Список вопросов для вас пуст");
        }
    };
    private void onReset(long chatid){
        users.remove(chatid);
    };

    private void FileSendCommand(long chatId, SheetInfoHolder info)  {

        SendDocument message=new SendDocument();
        //File initfile=new File("C:/Users/as-pa/IdeaProjects/TelegramBot/src/main/dororo.txt");
        message.setChatId(chatId);

            InputStream ff = new ByteArrayInputStream(HtmlList.listGeneration(new InfoAdapter(info)));

            InputFile f = new InputFile(ff, "dororo.html");
            message.setDocument(f);

        try {
            execute(message);
        }
        catch (TelegramApiException e){
            e.printStackTrace();
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
    private String ConvertQuestionToString(UserQuestion ques){
        StringBuilder b=new StringBuilder();
        b.append(ques.getQuestionName());
        b.append("\n");
        for (String a:ques.getOptions()) {
            b.append(a);
            b.append("\n");
        }
        return b.toString();
    }
}
