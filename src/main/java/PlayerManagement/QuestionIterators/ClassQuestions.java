package PlayerManagement.QuestionIterators;

import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.MultipleEntryUserQuestion;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;
import interfaces.DataBaseManager;
import Tools.ITool;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ClassQuestions implements PlayerQuestionIterator{
    protected SheetInfoHolder data;

    protected ArrayList<UserQuestion> questionQueue;
    protected int currentques;


    protected UserQuestion CreateSubClassesQuestion(){
        String statement=String.format("""
                select classes.name, subclasses.name
                from classes
                join ClassToSubClass on classes.classId = ClassToSubClass.ClassId
                join subclasses on classtosubclass.SubClassId=subclasses.classId
                where classes.name="%s";""",data.getClassName());
        return new SingleEntryUserQuestion("Выберите подкласс своего персонажа из представленных",DataBaseManager.getInstance().GetDataFromDB(statement),this.data::setSubclassName);
    }
    protected UserQuestion CreateSkillProficiencyQuestion(){
        ArrayList<String> opts=new ArrayList<>();
        opts.add("Сила");
        opts.add("Ловкость");
        opts.add("Телосложение");
        opts.add("Интеллект");
        opts.add("Мудрость");
        opts.add("Харизма");
        String StartingQuest="Выберите 2 владения из нижеперечисленнных";
        String SecondaryQuestion="Выберите дополнительно владение из нижеперечисленных";
        Consumer<String> a=this::AddProficiency;
        return new MultipleEntryUserQuestion(StartingQuest,SecondaryQuestion,2,opts,a);

    };

    public void AddProficiency(String a){
        System.out.println(a);
    }
    public ClassQuestions(){
        currentques=0;
        questionQueue=new ArrayList<>();
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



