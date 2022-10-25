package PlayerManagement;

import interfaces.DataBaseManager;
import interfaces.ITool;

import java.util.ArrayList;
import java.util.Queue;
import java.util.function.Consumer;

public class ClassQuestions implements PlayerQuestionIterator{

    private String className;
    private String subClass;
    private ArrayList<ITool> FeaturesAndTraits;
    private int statecounter;

    private PlayerQuestion CreateClassNameQuestion(){
        return new PlayerQuestion("Выберите класс персонажа",DataBaseManager.getInstance().GetDataFromDB("select * from classes"),new InputReader(this::SetClass));
    }
    private PlayerQuestion CreateSubClassesQuestion(){
        String statement=String.format("""
                select classes.name, subclasses.name
                from classes
                join ClassToSubClass on classes.classId = ClassToSubClass.ClassId
                join subclasses on classtosubclass.SubClassId=subclasses.classId
                where classes.name="%s";""",className);
        return new PlayerQuestion("Выберите подкласс своего персонажа из представленных",DataBaseManager.getInstance().GetDataFromDB(statement),new InputReader(this::SetSubClass));
    }

    public ClassQuestions(){
        statecounter=0;
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

    @Override
    public PlayerQuestion AskQuestion() {
        if(statecounter==0){
            return CreateClassNameQuestion();
        }
        if(statecounter==1){
            return CreateSubClassesQuestion();
        }
        return null;
    }
    @Override
    public void NextQuestion() {
        statecounter++;
    }
    @Override
    public boolean IsOver() {
        return statecounter>1;

    }
}



class InputReader {
    private Consumer<String> callback;

    public InputReader(Consumer<String> callback) {
        this.callback = callback;
    }
    public void onInput(String s) {
        callback.accept(s);
    }
}


