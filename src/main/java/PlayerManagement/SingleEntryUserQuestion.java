package PlayerManagement;
import interfaces.UserAnswer;
import java.util.ArrayList;
import java.util.Objects;
public class SingleEntryUserQuestion implements UserQuestion {
    private String QuestionName;
    private InputReader imp;
    private boolean isOver;
    private ArrayList<String> Options;
    public SingleEntryUserQuestion(String description, ArrayList<String> options, InputReader imp){
        this.QuestionName=description;
        this.Options=options;
        this.imp=imp;
    }
    public String getQuestionName(){
        return QuestionName;
    };
    public ArrayList<String> getOptions(){
        return  Options;
    }
    public boolean isAnswerCorrect(UserAnswer ans){
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
    public boolean isAnswerOver(){
        return isOver;
    }

}
