package PlayerManagement.QuestionIterators;

import PlayerManagement.questions.UserQuestion;

public interface PlayerQuestionIterator {
    UserQuestion AskQuestion();
    void NextQuestion();
    boolean IsOver();

}
