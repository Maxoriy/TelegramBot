package PlayerManagement.questions;


import java.util.ArrayList;

public interface UserQuestion {
    String getQuestionName();
    ArrayList<String> getOptions();
    int getAmountOfOptionsToChoose();
    boolean isRepeatAcceptable();
    String getSpecifiedFeedback();
    boolean isAnswerCorrect(ArrayList<String> Message);
    boolean isAnswerOver
}
/*
* question spawner: Вопросы отправляются в очередь
*
*
* */