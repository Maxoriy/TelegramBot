package PlayerManagement;

import PlayerManagement.QuestionIterators.ClassQuestions;
import PlayerManagement.QuestionIterators.PlayerQuestionIterator;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.ArrayList;

public class SelfStorageQuestionIterator implements PlayerQuestionIterator {
    private SheetInfoHolder data;

    private ArrayList<PlayerQuestionIterator> holders;
    private int currentStage;
    public SelfStorageQuestionIterator(SheetInfoHolder dh,PlayerQuestionIterator cq,PlayerQuestionIterator rq, PlayerQuestionIterator bq){
        holders=new ArrayList<>();
        data=dh;
        currentStage=0;
        holders.add(cq);
        holders.add(rq);
        holders.add(bq);
    }
    @Override
    public UserQuestion AskQuestion() {
       return holders.get(currentStage).AskQuestion();
    }

    @Override
    public void NextQuestion() {
        holders.get(currentStage).NextQuestion();
        if(holders.get(currentStage).IsOver()){
            currentStage++;
        }
    }

    @Override
    public boolean IsOver() {
        return currentStage>=holders.size();
    }
    public SheetInfoHolder getData(){return data;}
}
