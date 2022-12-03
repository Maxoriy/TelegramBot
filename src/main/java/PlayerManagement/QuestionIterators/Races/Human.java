package PlayerManagement.QuestionIterators.Races;

import Enums.Languages;
import Enums.SkillsEnum;
import Enums.StatsEnum;
import PlayerManagement.QuestionIterators.PlayerQuestionIterator;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.MultipleEntryUserQuestion;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;
import org.apache.commons.codec.language.bm.Lang;
import org.intellij.lang.annotations.Language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Human implements PlayerQuestionIterator {
    protected SheetInfoHolder data;
    protected ArrayList<UserQuestion> qque;
    protected int qquePoint;
    public Human(SheetInfoHolder data) {
        this.data=data;
        data.gameNums.speed=30;
        qque=new ArrayList<>();
        qquePoint=0;

        qque.add(createAlterQ());
        qque.add(createLangQ());
    };
    @Override
    public UserQuestion AskQuestion() {
        return qque.get(qquePoint);
    }
    private UserQuestion createAlterQ(){
        return new SingleEntryUserQuestion("Использовать альтернативные особенности человека?",
                new ArrayList<>(Arrays.asList("Да","Нет")),
                this::SetAttributes);
    }
    private UserQuestion createLangQ(){
        data.toolLists.EquipmentProf.add(Languages.Common.name);
        ArrayList<String> opts=new ArrayList<>();
        for (Languages a:Languages.values()) {
            if(!data.toolLists.EquipmentProf.contains(a.name)){
                opts.add(a.name);
            }
        }
        return new SingleEntryUserQuestion(
                "Выберите язык из нижеперечисленных",
                opts,
                (d)->{data.toolLists.EquipmentProf.add(d);});
    }

    @Override
    public void NextQuestion() {
        qquePoint++;
    }
    public void SetAttributes(String answer){
        //plus one for each characteristic
        if(Objects.equals(answer, "Нет")){
            for (var a: StatsEnum.values()) {
                data.numbers.addStatValue(a.getName(),1);
            }
            data.toolLists.AddAbility(new DefaultTool("Возраст","Люди становятся взрослыми в районе 20 лет, и живут менее столетия."));
            data.toolLists.AddAbility(new DefaultTool("Размер:Средний","Люди сильно различаются по размерам. Некоторые с трудом достигают 5 футов (152 сантиметров) ростом, тогда как другие имеют рост, превосходящий 6 футов (183 сантиметра). Вне зависимости от роста, ваш размер — Средний."));
            data.gameNums.speed=30;
        }
        else{
            createalter();
            data.toolLists.Abilities.add(new DefaultTool("Черта","Вы получаете одну черту на ваш выбор"));
        }

    }
    private void createalter(){
        ArrayList<String> opts=new ArrayList<>();
        for (var a:StatsEnum.values()) {
            opts.add(a.getName());
        }
        qque.add(new MultipleEntryUserQuestion(
                "Выберите 2 характеристики из нижеперечисленных",
                "Выберите дополнительно характеристику",
                2,opts
                ,(a)->{data.numbers.addStatValue(a,1);}));
        ArrayList<SkillsEnum> opt2 = new ArrayList<>(Arrays.asList(SkillsEnum.values()));

        qque.add(new AdvancedSkillQuestion(
                opt2,
                data.numbers::addSkillProf,
                1,
                data::FilterSkills));
    }
    @Override
    public boolean IsOver() {
        return qquePoint>=qque.size();
    }
}
