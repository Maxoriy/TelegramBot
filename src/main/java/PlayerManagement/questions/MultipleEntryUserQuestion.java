package PlayerManagement.questions;

import interfaces.UserAnswer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

public class MultipleEntryUserQuestion implements UserQuestion{
    private String fdescr;
    private String secdescr;
    private ArrayList<String> opts;
    private int entrynum;
    private int currententries;
    private boolean isfirstanswercorrect;
    private Consumer<String> callback;
    public MultipleEntryUserQuestion(String maindescription, String secondarydescription,int entrynum, ArrayList<String>options, Consumer<String> callback){
        this.fdescr=maindescription;
        this.secdescr=secondarydescription;
        this.opts=options;
        this.callback=callback;
        this.isfirstanswercorrect=false;
        this.entrynum=entrynum;
        this.currententries=0;
    }
    @Override
    public String getQuestionName() {
        if(isfirstanswercorrect){
            return secdescr;
        }
        return fdescr;
    }
    @Override
    public ArrayList<String> getOptions() {
        return opts;
    }
    @Override
    public boolean isAnswerCorrect(UserAnswer answer) {
        boolean flag=false;
        for (String option : opts) {
            if (Objects.equals(option, answer.GetText())) {
                flag = true;
                break;
            }
        }
        if(flag && !isfirstanswercorrect){
            isfirstanswercorrect=true;
        }
        if(flag){
            currententries++;
            opts.removeIf(s->s.equals(answer.GetText()));
            callback.accept(answer.GetText());
        }
        return flag;
    }
    @Override
    public boolean isAnswerOver() {
        return entrynum <= currententries || opts.size()==0;
    }
}
