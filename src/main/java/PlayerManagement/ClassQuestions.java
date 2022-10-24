package PlayerManagement;

import interfaces.DataBaseManager;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ClassQuestions implements PlayerQuestionIterator{
    String qname;
    private String className;
    ArrayList<String> qoptions;
    public void SetClass(String s){
        className=s;
    };
    public ClassQuestions(){
        qname="Выберите класс персонажа";
        qoptions= DataBaseManager.getInstance().GetDataFromDB("select * from classes");
    }
    boolean myQyestionIsAnswered=false;
    @Override
    public PlayerQuestion AskQuestion() {
        return new PlayerQuestion(qname,qoptions, new InputReader(this::SetClass));
    }
    @Override
    public void NextQuestion() {
        myQyestionIsAnswered=true;
    }
    @Override
    public boolean IsOver() {
        System.out.println("answer");
        System.out.println(className);
        return myQyestionIsAnswered;
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


