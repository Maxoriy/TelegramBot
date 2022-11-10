package PlayerManagement.questions;


import java.util.ArrayList;

public interface UserQuestion {
    String getQuestionName();
    ArrayList<String> getOptions();
    boolean isAnswerCorrect(String message);
    void SetAnswer(String ans);
    boolean isAnswerOver();
}
/*
* question spawner: Вопросы отправляются в очередь
*
*
* */