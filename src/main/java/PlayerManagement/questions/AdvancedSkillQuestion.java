package PlayerManagement.questions;

import Enums.SkillsEnum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class AdvancedSkillQuestion implements UserQuestion{
    private String QuestionName;
    private Consumer<String> callback;

    private ArrayList<SkillsEnum> Options;
    private int entryNum;
    private int currentEntry;

    private Function<ArrayList<SkillsEnum>, ArrayList<String>>filter;
    public AdvancedSkillQuestion(String description, ArrayList<SkillsEnum> options,int amountofOpts, Consumer<String> imp,Function<ArrayList<SkillsEnum>, ArrayList<String>> filt ){
        this.QuestionName=description;
        this.Options=options;
        this.callback=imp;
        this.filter=filt;
        this.entryNum=amountofOpts;
        currentEntry=0;
    }
    public AdvancedSkillQuestion( ArrayList<SkillsEnum> options, Consumer<String> imp,int Amountofopts,Function<ArrayList<SkillsEnum>, ArrayList<String>> filt ){
        this.QuestionName="Выберите владение навыком из представленных";
        this.Options=options;
        this.callback=imp;
        this.filter=filt;
        this.entryNum=Amountofopts;
        currentEntry=0;
    }

    @Override
    public String getQuestionName() {
        return  QuestionName;
    }

    @Override
    public ArrayList<String> getOptions() {
        return filter.apply(Options);
    }

    @Override
    public boolean isAnswerCorrect(String message) {
        for (var a:Options) {
            if(Objects.equals(a.getName(), message)){return true;}
        }
        return false;
    }

    @Override
    public void SetAnswer(String ans) {
        callback.accept(ans);

        currentEntry++;
        Options.removeIf(n->(Objects.equals(n.getName(), ans)));
    }

    @Override
    public boolean isAnswerOver() {
        return currentEntry>=entryNum || Options.size() == 0;
    }
}
