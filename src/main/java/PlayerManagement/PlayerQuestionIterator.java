package PlayerManagement;

public interface PlayerQuestionIterator {
    UserQuestion AskQuestion();
    void NextQuestion();
    boolean IsOver();

}
