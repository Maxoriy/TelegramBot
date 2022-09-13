import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public final class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) throws TelegramApiException {

        // Instantiate Telegram Bots API
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        // Register our bot
        try {
            telegramBotsApi.registerBot(new Bot(System.getenv("BOT_NAME"), System.getenv("BOT_TOKEN")));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

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
        try {

            if (update.hasMessage() && update.getMessage().hasText()) {

                Message inMessage = update.getMessage();

                SendMessage outMessage = new SendMessage();

                outMessage.setChatId(String.valueOf(inMessage.getChatId()));

                outMessage.setText(inMessage.getText());

                execute(outMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
