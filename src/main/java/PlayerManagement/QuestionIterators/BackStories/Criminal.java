package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.NoOptionQuestion;
import Tools.DefaultTool;

public class Criminal extends BackStoryTemplate{
    public Criminal(SheetInfoHolder d) {
        super(d);
        data.numbers.SkillProf.add(SkillsEnum.Deception);
        data.numbers.SkillProf.add(SkillsEnum.Stealth);
        data.toolLists.EquipmentProf.add("Воровские инструменты");
        addGameQ();
        data.toolLists.Equipment.add(new DefaultTool("Ломик",""));
        data.toolLists.Equipment.add(new DefaultTool("Комплект обычной темной одежды с капюшоном",""));
        data.toolLists.Equipment.add(new DefaultTool("15 зм",""));
        data.toolLists.Abilities.add(new DefaultTool("Криминальные связи","У вас есть надёжное доверенное лицо, которое выступает в роли вашего связного в криминальных кругах. Вы умеете получать и отправлять сведения связному, даже через большие расстояния: например, вы знаете местных посыльных, продажных караванщиков и нечистых на руку матросов, которые могут доставить сообщение для вас."));

    }
    private void addGameQ(){
        questionQueue.add(new NoOptionQuestion("Введите ниже название 1 игрового набора, которым вы владеете",
                (a)->{data.toolLists.EquipmentProf.add(a);}));
    }
}
