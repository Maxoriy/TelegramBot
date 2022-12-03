package PlayerManagement.QuestionIterators.Classes;

import PlayerManagement.QuestionIterators.PlayerQuestionIterator;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassQuestions implements PlayerQuestionIterator {
    protected SheetInfoHolder data;

    private void subClassQuestion(){
        //todo implement subclass question
    }
    private void createLevelQ(){
        questionQueue.add(new SingleEntryUserQuestion("Выберите уровень персонажа",
                new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20")),
                (St)->{data.gameNums.level=Integer.parseInt(St);}));

    }

    protected ArrayList<UserQuestion> questionQueue;
    protected int currentques;
    public ClassQuestions(SheetInfoHolder dat){
        currentques=0;
        questionQueue=new ArrayList<>();
        createLevelQ();
        data=dat;
    }
    @Override
    public UserQuestion AskQuestion() {
        return questionQueue.get(currentques);
    }
    @Override
    public void NextQuestion() {
        currentques++;
    }
    @Override
    public boolean IsOver() {
        return currentques>=questionQueue.size();
    }

}



