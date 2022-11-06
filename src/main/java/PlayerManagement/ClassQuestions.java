package PlayerManagement;

import PlayerManagement.questions.MultipleEntryUserQuestion;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;
import interfaces.DataBaseManager;
import interfaces.ITool;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ClassQuestions implements PlayerQuestionIterator{
    protected String className;
    protected String subClass;
    protected ArrayList<ITool> FeaturesAndTraits;
    protected ArrayList<Supplier<UserQuestion>> questionQueue;
    protected int currentques;

    protected UserQuestion CreateClassNameQuestion(){
        return new SingleEntryUserQuestion("Выберите класс персонажа",DataBaseManager.getInstance().GetDataFromDB("select * from classes"),this::SetClass);
    }
    protected UserQuestion CreateSubClassesQuestion(){
        String statement=String.format("""
                select classes.name, subclasses.name
                from classes
                join ClassToSubClass on classes.classId = ClassToSubClass.ClassId
                join subclasses on classtosubclass.SubClassId=subclasses.classId
                where classes.name="%s";""",className);
        return new SingleEntryUserQuestion("Выберите подкласс своего персонажа из представленных",DataBaseManager.getInstance().GetDataFromDB(statement),this::SetSubClass);
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
    protected UserQuestion CreateEquipmentQuestion(){
        return null;
    }
    public void AddProficiency(String a){
        System.out.println(a);
    }
    public ClassQuestions(){
        currentques=0;
        questionQueue=new ArrayList<>();
        //questionQueue.add(this::CreateClassNameQuestion);
        //questionQueue.add(this::CreateSubClassesQuestion);
        //questionQueue.add(this::CreateSkillProficiencyQuestion);
    }

    @Override
    public UserQuestion AskQuestion() {
        return questionQueue.get(currentques).get();
    }
    @Override
    public void NextQuestion() {
        currentques++;
    }
    @Override
    public boolean IsOver() {
        return currentques>=questionQueue.size();
    }
    public void SetClass(String s){
        className=s;
    };
    public void SetSubClass(String s){
        subClass=s;
    }

    public void SetFeaturesAndTraits(ArrayList<ITool> data){
        FeaturesAndTraits=data;
    }


}



