package PlayerManagement.QuestionIterators;
import Enums.StatsEnum;
import PlayerManagement.QuestionQueuesBuilder;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.NoOptionQuestion;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;
import Enums.DataBaseManager;
import org.telegram.telegrambots.meta.api.objects.User;

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
        starterQuestions.add(CreateCharacterNameQuestion());
        starterQuestions.add(CreateClassNameQuestion());
        starterQuestions.add(CreateRaceNameQuestion());
        starterQuestions.add(CreateBackStoryQuestion());
        for (StatsEnum a:StatsEnum.values()) {
            starterQuestions.add(CreateStrengthQuestion(a));
        }
    }
    public SheetInfoHolder getData(){
        return data;
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

        if(otherq.IsOver()) {
            fetchAbilitiesAndEquipmentFromDatabase();

        }
        return otherq.IsOver();

    }
    private void fetchAbilitiesAndEquipmentFromDatabase(){
        //todo implement fetching from the database
    }
    private UserQuestion CreateClassNameQuestion(){
        return new SingleEntryUserQuestion("Выберите класс персонажа", DataBaseManager.getInstance().GetDataFromDB("select * from classes"),this.data.naming::setClassName);
    }
    private UserQuestion CreateRaceNameQuestion(){
        return new SingleEntryUserQuestion("Выберите расу персонажа", DataBaseManager.getInstance().GetDataFromDB("select * from races"),this.data.naming :: setRaceName);
    }
    private UserQuestion CreateBackStoryQuestion(){
        return new SingleEntryUserQuestion("Выберите предысторию персонажа", DataBaseManager.getInstance().GetDataFromDB("select * from backstories"),this.data.naming ::setBackStoryName);
    }
    private UserQuestion CreateCharacterNameQuestion(){
        return new NoOptionQuestion("Выберите имя персонажа",(st)->{data.naming.characterName=st;});
    }
    private UserQuestion CreateStrengthQuestion(StatsEnum skill){
        return new NoOptionQuestion( new StringBuilder().append("Введите значение от 3 до 18, для характеристики:").append(skill.getName()).toString(),
        (ans)->{data.numbers.StatValue.put(skill,Integer.parseInt(ans));});
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