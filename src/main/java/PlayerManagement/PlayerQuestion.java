package PlayerManagement;
import interfaces.UserAnswer;
import java.util.ArrayList;
import java.util.Objects;
public class PlayerQuestion {
    private String QuestionName;
    private InputReader imp;
    private boolean isOver;
    private ArrayList<String> Options;
    public PlayerQuestion(String description, ArrayList<String> options,InputReader imp){
        this.QuestionName=description;
        this.Options=options;
        this.imp=imp;
    }
    public String GetQuestionName(){
        return QuestionName;
    };
    public ArrayList<String> GetOptions(){
        return  Options;
    }
    public boolean IsAnswerCorrect(UserAnswer ans){
        boolean flag=false;
        for (String option : Options) {
            if (Objects.equals(option, ans.GetText())) {
                flag = true;
                break;
            }
        }
        if(flag){
            isOver=true;
            imp.onInput(ans.GetText());
            return true;
        }
        return false;
    }
    public boolean IsAnswerOver(){
        return isOver;
    }

}
