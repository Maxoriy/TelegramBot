package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import Tools.DefaultTool;

public class Sharlatan extends BackStoryTemplate{
    public Sharlatan(SheetInfoHolder d) {
        super(d);
        data.numbers.SkillProf.add(SkillsEnum.SleightOfHand);
        data.numbers.SkillProf.add(SkillsEnum.Deception);
        data.toolLists.EquipmentProf.add("Набор для грима");
        data.toolLists.EquipmentProf.add("Набор для фальсификаций");
        data.toolLists.Equipment.add(new DefaultTool("Комплект отличной одежды",""));
        data.toolLists.Equipment.add(new DefaultTool("Набор для грима",""));
        data.toolLists.Equipment.add(new DefaultTool("Приспособление для жульничества",""));
        data.toolLists.Equipment.add(new DefaultTool("15 зм",""));
        data.toolLists.Abilities.add(new DefaultTool("Поддельная личность","Вы создали себе вторую личность, включая необходимые документы, знакомства и маскировку, что позволяет вам перевоплощаться в этот образ. В дополнение к этому вы можете подделывать документы, включая официальные документы и личные письма, если ранее видели пример подобного документа или почерк, который пытаетесь скопировать."));

    }
}
