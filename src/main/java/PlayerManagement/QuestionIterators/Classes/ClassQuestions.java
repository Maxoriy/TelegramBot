package PlayerManagement.QuestionIterators.Classes;

import PlayerManagement.QuestionIterators.PlayerQuestionIterator;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.NoOptionQuestion;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ClassQuestions implements PlayerQuestionIterator {
    protected SheetInfoHolder data;

    private void subClassQuestion(){
        //todo implement subclass question
    }


    protected ArrayList<UserQuestion> questionQueue;
    protected int currentques;
    public ClassQuestions(SheetInfoHolder dat){
        currentques=0;
        questionQueue=new ArrayList<>();
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


    protected void ImproveCharacteristicQ(){
        questionQueue.add(new SingleEntryUserQuestion("Увеличение характеристик:выберите опцию из представленных",
                new ArrayList<String>(Arrays.asList("Повысить 1 характеристику на 2","Увеличить 2 характеристики на 1","Взять черту")),


                (a)->{
                    if(Objects.equals(a, "Повысить 1 характеристику на 2")){
                        Select1StatToImprove();
                    }
                    if(Objects.equals(a, "Увеличить 2 характеристики на 1")){
                        Select2StatsToImprove();
                        Select2StatsToImprove();
                    }
                    if(Objects.equals(a, "Взять черту")){
                        SelectTrait();
                    }
                }



                ));
    }
    protected void Select1StatToImprove(){
        questionQueue.add(new SingleEntryUserQuestion("Выберите 1 характеристику, ее значение увеличится на 2",
                new ArrayList<>(Arrays.asList("Сила","Ловкость","Телосложение","Интеллект","Мудрость","Харизма")),
                (a)->{data.numbers.addStatValue(a,2);}
                ));

    }
    protected void Select2StatsToImprove(){
        questionQueue.add(new SingleEntryUserQuestion("Выберите 1 характеристику, ее значение увеличится на 1",
                new ArrayList<>(Arrays.asList("Сила","Ловкость","Телосложение","Интеллект","Мудрость","Харизма")),
                (a)->{data.numbers.addStatValue(a,1);}
        ));
    }
    protected void SelectTrait(){
        questionQueue.add(new NoOptionQuestion("Введите название черты",(a)->{data.toolLists.Abilities.add(new DefaultTool("Черта"+a,""));}));
    }

}



