package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.QuestionIterators.PlayerQuestionIterator;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

public class Besprizornik extends BackStoryTemplate{

    public Besprizornik(SheetInfoHolder d) {
        super(d);
        data.numbers.SkillProf.add(SkillsEnum.SleightOfHand);
        data.numbers.SkillProf.add(SkillsEnum.Stealth);
        data.toolLists.EquipmentProf.add("Воровские инструменты");
        data.toolLists.EquipmentProf.add("Набор для грима");
        data.toolLists.Equipment.add(new DefaultTool("Маленький нож",""));
        data.toolLists.Equipment.add(new DefaultTool("Карта родного города",""));
        data.toolLists.Equipment.add(new DefaultTool("Ручная мышь",""));
        data.toolLists.Equipment.add(new DefaultTool("Безделушка в память о родителях",""));
        data.toolLists.Equipment.add(new DefaultTool("Комплект обычной одежды",""));
        data.toolLists.Equipment.add(new DefaultTool("Поясной кошель с 10 зм",""));
        data.toolLists.Abilities.add(new DefaultTool("Городские тайны","Вы знаете тайные лазы и проходы городских улиц, позволяющие пройти там, где другие не увидят пути. Вне боя вы (и ведомые вами союзники) можете перемещаться по городу вдвое быстрее обычного."));
    }
}
