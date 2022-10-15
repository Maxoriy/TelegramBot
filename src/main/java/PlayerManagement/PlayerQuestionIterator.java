package PlayerManagement;

public interface PlayerQuestionIterator {
    PlayerQuestion AskQuestion();
    void NextQuestion();
    boolean IsOver();

}
