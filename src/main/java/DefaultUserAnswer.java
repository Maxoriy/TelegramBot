import interfaces.UserAnswer;

public class DefaultUserAnswer implements UserAnswer {
    String Text;
    long userId;
    public DefaultUserAnswer(long userid, String tx){
        this.Text=tx;
        this.userId=userid;
    }

    @Override
    public String GetText() {
        return Text;
    }

    @Override
    public long GetChatId() {
        return userId;
    }
}
