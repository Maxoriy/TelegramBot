package PlayerManagement.QuestionIterators.BackStories;

import Enums.Languages;
import PlayerManagement.QuestionIterators.PlayerQuestionIterator;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.NoOptionQuestion;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;

import java.util.ArrayList;

public class BackStoryTemplate implements PlayerQuestionIterator {
    protected SheetInfoHolder data;
    protected ArrayList<UserQuestion> questionQueue;
    protected int current;
    public BackStoryTemplate(SheetInfoHolder d){
        data=d;
        questionQueue =new ArrayList<>();
        current=0;
    }
    protected void addLanQ(){
        ArrayList<String> opts=new ArrayList<>();
        for (var a: Languages.values()) {
            opts.add(a.name);
        }
        questionQueue.add(new SingleEntryUserQuestion("Выберите язык из представленных",opts,
                (a)->{data.toolLists.EquipmentProf.add(a);}
        ));
    }
    @Override
    public UserQuestion AskQuestion() {
        return questionQueue.get(current);
    }
    protected void addRemeslo(){
        questionQueue.add(new NoOptionQuestion("Введите ниже название одного вида инструментов ремесленника, с которым ваш персонаж умеет обращаться",
                (s)->{data.toolLists.EquipmentProf.add(s);}));
    }

    @Override
    public void NextQuestion() {
        current++;
    }

    @Override
    public boolean IsOver() {
        return current>=questionQueue.size();
    }
}
