package PlayerManagement;

import interfaces.DataBaseManager;
import interfaces.ITool;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ClassQuestions implements PlayerQuestionIterator{

    private String className;
    private String subClass;
    private ArrayList<ITool> FeaturesAndTraits;
    private int statecounter;

    private UserQuestion CreateClassNameQuestion(){
        return new SingleEntryUserQuestion("Выберите класс персонажа",DataBaseManager.getInstance().GetDataFromDB("select * from classes"),new InputReader(this::SetClass));
    }
    private UserQuestion CreateSubClassesQuestion(){
        String statement=String.format("""
                select classes.name, subclasses.name
                from classes
                join ClassToSubClass on classes.classId = ClassToSubClass.ClassId
                join subclasses on classtosubclass.SubClassId=subclasses.classId
                where classes.name="%s";""",className);
        return new SingleEntryUserQuestion("Выберите подкласс своего персонажа из представленных",DataBaseManager.getInstance().GetDataFromDB(statement),new InputReader(this::SetSubClass));
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
    public UserQuestion AskQuestion() {
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

/*
* class question(single entry from user
* subclass question(single entry from user) -> catching abilities from class(multiple Tool answer from db) thesis: some abilities can influence on char sheet(ex competension, no armor defence, no armor movement)
* ammunition question(multiple Tool Question from user) thesis: ammunition not only have description,but influence on main stats(ex shield add 2 cd)
* skills question(multiple entry from user)
* saving question()
*
*
* thesis: questions with multiple entries can be implemented by reasking the same queston with removeing option that user already used
* */