package PlayerManagement.QuestionIterators;
import PlayerManagement.QuestionQueuesBuilder;
import PlayerManagement.SelfStorageQuestionIterator;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;
import interfaces.DataBaseManager;

import java.util.ArrayList;


public class PlayerQuestionManager implements PlayerQuestionIterator {


    private SheetInfoHolder data;
    private ArrayList<UserQuestion> starterQuestions;
    int startQIterator=0;
    boolean userAnsweredDefaultQuestions=false;
    private SelfStorageQuestionIterator otherq;
    public PlayerQuestionManager(){
        starterQuestions=new ArrayList<>();
        data=new SheetInfoHolder();
        starterQuestions.add(CreateClassNameQuestion());
        starterQuestions.add(CreateRaceNameQuestion());
        starterQuestions.add(CreateBackStoryQuestion());
    }

    @Override
    public UserQuestion AskQuestion() {
        if(!userAnsweredDefaultQuestions){
            return starterQuestions.get(startQIterator);
        }
        return otherq.AskQuestion();
    }

    @Override
    public void NextQuestion() {
        if(data.getAbilities()!=null && data.getAbilities().size()!=0){
            System.out.println(data.getAbilities().get(0));
        }
        if(!userAnsweredDefaultQuestions){
            startQIterator++;
            if(starterQuestions.size()<=startQIterator){
                otherq=QuestionQueuesBuilder.getInstance().CreateQueue(data);
                System.out.println("default answers recieved");
                userAnsweredDefaultQuestions=true;
            }
        }
        else{
            otherq.NextQuestion();
        }
    }

    @Override
    public boolean IsOver() {
        if(!userAnsweredDefaultQuestions){
            return startQIterator>=starterQuestions.size();
        }
        else{
            return otherq.IsOver();
        }
    }

    private UserQuestion CreateClassNameQuestion(){
        return new SingleEntryUserQuestion("Выберите класс персонажа", DataBaseManager.getInstance().GetDataFromDB("select * from classes"),this.data::setClassName);
    }
    private UserQuestion CreateRaceNameQuestion(){
        return new SingleEntryUserQuestion("Выберите расу персонажа", DataBaseManager.getInstance().GetDataFromDB("select * from races"),this.data::setRaceName);
    }
    private UserQuestion CreateBackStoryQuestion(){
        return new SingleEntryUserQuestion("Выберите предысторию персонажа", DataBaseManager.getInstance().GetDataFromDB("select * from backstories"),this.data::setBackStoryName);
    }
}

/*
* thesis: query does not wor in this case
* what will work? quadrio sheetinfo,class,race,backstory
* complex object with inner interconnection
*
* this object can be constructed by calling
*
*how to build this trio? trio will be built by builder(call builder with 3 params, it will return trio). builder will have 1 static method
*how to use it from outside
*
*
* bulider:
* it will have hashmap name-lambda that return new obj
*
* */
