package PlayerManagement.questions;

import java.util.ArrayList;
import java.util.function.Consumer;

public class NoOptionQuestion implements UserQuestion{
    private String QuestionName;
    private Consumer<String> callback;
    private boolean isOver=false;
    public NoOptionQuestion(String description, Consumer<String>  imp){
        this.QuestionName=description;

        this.callback=imp;
    }

    @Override
    public String getQuestionName() {
        return  QuestionName;
    }

    @Override
    public ArrayList<String> getOptions() {
        return new ArrayList<String>();
    }

    @Override
    public boolean isAnswerCorrect(String message) {
        return true;
    }

    @Override
    public void SetAnswer(String ans) {
        callback.accept(ans);
        isOver=true;
    }

    @Override
    public boolean isAnswerOver() {
        return isOver;
    }
}
