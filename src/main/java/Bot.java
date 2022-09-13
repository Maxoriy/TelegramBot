import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/*heёllo world by as-pasa*/
public final class Bot extends TelegramLongPollingBot{
    public static void main(String[] args) {
        System.out.println(System.getenv("test"));
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }

    @Override
    public void onUpdateReceived(Update update) {

    }
}
