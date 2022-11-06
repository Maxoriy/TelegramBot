package PlayerManagement;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;
import interfaces.DataBaseManager;

import java.util.ArrayList;


public class PlayerQuestionManager {

    public void AddQuestion(UserQuestion qustion){
        questions.add(qustion);
    }
    private SheetInfoHolder storage;
    private ArrayList<UserQuestion> questions;
    public void setClass(String clss){
        this.storage.className=clss;
    }
    public void setRace(String clss){
        this.storage.raceName=clss;
    }
    public void setBackStory(String clss){this.storage.backStoryName=clss;}
    private int qindex;
    private String currentAnswerText;

    public PlayerQuestionManager(){
        questions=new ArrayList<>();
        qindex=0;

        questions.add(new SingleEntryUserQuestion("Выберите класс персонажа", DataBaseManager.getInstance().GetDataFromDB("select * from classes"),this::setClass));
        questions.add(new SingleEntryUserQuestion("Выберите расу персонажа", DataBaseManager.getInstance().GetDataFromDB("select * from races"), this::setRace));
        questions.add(new SingleEntryUserQuestion("Выберите предысторию персонажа", DataBaseManager.getInstance().GetDataFromDB("select * from backstories"), this::setBackStory));
    }
    public void update(String message){
        if(!questions.get(qindex).isAnswerCorrect(message)){
            currentAnswerText="Недопустимый вариант ответа";
            return;
        }

    }

    public boolean ManagerWorkEnded(){
        return true;
    }

    public String GetCurrentText() {
        return "";
    }
    private String ConvertQuestionToString(UserQuestion ques){
        StringBuilder b=new StringBuilder();
        b.append(ques.getQuestionName());
        b.append("\n");
        for (String a:ques.getOptions()) {
            b.append("/");
            b.append(a);
            b.append("\n");
        }
        return b.toString();
    }
}
