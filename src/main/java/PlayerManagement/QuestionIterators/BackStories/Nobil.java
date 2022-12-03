package PlayerManagement.QuestionIterators.BackStories;

import Enums.Languages;
import Enums.SkillsEnum;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.NoOptionQuestion;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class Nobil extends BackStoryTemplate{
    public Nobil(SheetInfoHolder d) {
        super(d);
        data.numbers.addSkillProf(SkillsEnum.History.getName());
        data.numbers.addSkillProf(SkillsEnum.Persuasion.getName());
        data.toolLists.Equipment.add(new DefaultTool("Комплект отличной одежды",""));
        data.toolLists.Equipment.add(new DefaultTool("Кольцо-печатка",""));
        data.toolLists.Equipment.add(new DefaultTool("Свиток с генеалогическим древом",""));
        data.toolLists.Equipment.add(new DefaultTool("Кошелек с 25 зм",""));
        data.toolLists.Abilities.add(new DefaultTool("Привелегированность","Благодаря знатному происхождению, другие хорошо к вам относятся. Вас принимают в высшем обществе, и считается, что у вас есть право посещать любые места. Обыватели изо всех сил стараются сделать вам приятно и избежать вашего гнева, а другие высокородные считают вас своей ровней. Если нужно, вы можете получить аудиенцию местного дворянина."));
        addLanQ();
        addGameQ();
    }

    private void addGameQ(){
        questionQueue.add(new NoOptionQuestion("Введите ниже название 1 игрового набора, которым вы владеете",
                (a)->{data.toolLists.EquipmentProf.add(a);}));
    }
}
