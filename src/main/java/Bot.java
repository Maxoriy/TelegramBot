import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public final class Bot extends TelegramLongPollingBot {

    private final String BOT_TOKEN;
    private final String BOT_NAME;

    public Bot(String BOT_NAME, String BOT_TOKEN) {
        super();
        this.BOT_NAME = BOT_NAME;
        this.BOT_TOKEN = BOT_TOKEN;
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


            switch (MessageText){
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;

                case "/help":
                    helpCommandReceived(chatId);
                    break;

                default:
                    SendMessage(chatId, update.getMessage().getText());
            }
        }
    }

    private void helpCommandReceived(long chatId) {
        String answer = "In the future, here will be the help for working with the bot!";
        SendMessage(chatId, answer);
    }

    private void startCommandReceived(long chatId, String name) {
        String answer = "Hello, " + name + "!";
        SendMessage(chatId, answer);
    }
    private void SendMessage(long chatId, String TextToSend){
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
