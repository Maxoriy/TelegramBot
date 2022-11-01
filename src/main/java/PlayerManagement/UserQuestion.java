package PlayerManagement;

import interfaces.UserAnswer;

import java.util.ArrayList;

public interface UserQuestion {
    String getQuestionName();
    ArrayList<String> getOptions();
    boolean isAnswerCorrect(UserAnswer answer);
    boolean isAnswerOver();
}
