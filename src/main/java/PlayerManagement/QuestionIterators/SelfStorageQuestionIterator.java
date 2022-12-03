package PlayerManagement.QuestionIterators;

import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;

import java.util.ArrayList;

public class SelfStorageQuestionIterator implements PlayerQuestionIterator {
    private SheetInfoHolder data;

    private ArrayList<PlayerQuestionIterator> holders;
    private int currentStage;
    public SelfStorageQuestionIterator(SheetInfoHolder dh,PlayerQuestionIterator cq,PlayerQuestionIterator rq, PlayerQuestionIterator bq){
        holders=new ArrayList<>();
        data=dh;
        currentStage=0;
        if(!rq.IsOver()){
            holders.add(rq);

        }
        if(!bq.IsOver()){
            holders.add(bq);

        }
        if(!cq.IsOver()){
            holders.add(cq);

        }
    }
    @Override
    public UserQuestion AskQuestion() {
       return holders.get(currentStage).AskQuestion();
    }

    @Override
    public void NextQuestion() {
        if(!holders.get(currentStage).AskQuestion().isAnswerOver()){
            return;
        }
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
