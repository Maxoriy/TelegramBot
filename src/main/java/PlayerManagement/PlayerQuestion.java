package PlayerManagement;

import java.util.ArrayList;

public class PlayerQuestion {
    private String QuestionName;
    private ArrayList<String> Options;
    public PlayerQuestion(String description, ArrayList<String> options){
        this.QuestionName=description;
        this.Options=options;
    }

    public String GetQuestionName(){
        return QuestionName;
    };
    public ArrayList<String> GetOptions(){
        return  Options;
    }

}
