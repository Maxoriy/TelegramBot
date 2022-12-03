package PlayerManagement.QuestionIterators.Races;

import Enums.Languages;
import Enums.SkillsEnum;
import Enums.StatsEnum;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.MultipleEntryUserQuestion;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;
import org.apache.commons.codec.language.bm.Lang;

import java.util.ArrayList;
import java.util.Arrays;

public class HalfElf extends BackStoryTemplate {
    public HalfElf(SheetInfoHolder d) {
        super(d);
        data.numbers.addStatValue(StatsEnum.Charisma.getName(),2);
        addStatQ();
        data.toolLists.Abilities.add(new DefaultTool("Возраст полуэльфов","Полуэльфы взрослеют с той же скоростью, что и люди, и достигают зрелости к 20 годам. Они живут гораздо дольше людей, часто пересекая рубеж в 180 лет."));
        data.toolLists.Abilities.add(new DefaultTool("Размер:Средний"," Полуэльфы почти такого же размера, как и люди. Их рост колеблется от 5 до 6 футов (от 155 до 183 сантиметров). Ваш размер — Средний."));
        data.gameNums.speed=30;
        data.toolLists.Abilities.add(new DefaultTool("Темное зрение(60)","Благодаря вашей эльфийской крови, вы обладаете превосходным зрением в темноте и при тусклом освещении. На расстоянии в 60 футов вы при тусклом освещении можете видеть так, как будто это яркое освещение, и в темноте так, как будто это тусклое освещение. В темноте вы не можете различать цвета, только оттенки серого."));
        data.toolLists.Abilities.add(new DefaultTool("Наследие фей","Вы совершаете с преимуществом спасброски от состояния очарованный, и вас невозможно магически усыпить."));
        data.toolLists.Abilities.add(new DefaultTool("Универсальность навыков","Вы получаете владение двумя навыками на ваш выбор."));
        data.toolLists.EquipmentProf.add(Languages.Common.name);
        data.toolLists.EquipmentProf.add(Languages.Elf.name);
        addLanQ();
        skillQ();
    }
    private void addStatQ(){
        questionQueue.add(new MultipleEntryUserQuestion(
                "Выберите характеристику из представленных, ее значение увеличится на 1",
                "Выберите характеристику из представленных, ее значение увеличится на 1",
                2,
                new ArrayList<>(Arrays.asList(StatsEnum.Strength.getName(),
                        StatsEnum.Dexterity.getName(),
                        StatsEnum.Constitution.getName(),
                        StatsEnum.Intelligence.getName(),
                        StatsEnum.Wisdom.getName()
                        )),
                (a)->{
                    switch (a){
                        case "Сила":data.numbers.addStatValue("Сила",1);
                        case "Ловкость":data.numbers.addStatValue("Ловкость",1);
                        case "Телосложение":data.numbers.addStatValue("Телосложение",1);
                        case "Интеллект":data.numbers.addStatValue("Интеллект",1);
                        case "Мудрость":data.numbers.addStatValue("Мудрость",1);
                    }
                }
        ));
    }
    private void skillQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        opts.addAll(Arrays.asList(SkillsEnum.values()));
        questionQueue.add(new AdvancedSkillQuestion(opts,
                data.numbers::addSkillProf,2,data::FilterSkills));
    }
}
