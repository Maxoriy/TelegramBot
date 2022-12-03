package PlayerManagement.QuestionIterators.Races;

import Enums.Languages;
import Enums.StatsEnum;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import Tools.DefaultTool;

public class Tiefling extends BackStoryTemplate {
    public Tiefling(SheetInfoHolder d) {
        super(d);
        data.numbers.addStatValue(StatsEnum.Intelligence.getName(), 1);
        data.numbers.addStatValue(StatsEnum.Charisma.getName(), 2);
        data.toolLists.Abilities.add(new DefaultTool("Возраст тифлингов","Тифлинги взрослеют тогда же, когда и люди, но живут немного дольше."));
        data.toolLists.Abilities.add(new DefaultTool("Размер:Средний","Тифлинги по росту и телосложению схожи с людьми. Ваш размер — Средний."));
        data.gameNums.speed=30;
        data.toolLists.Abilities.add(new DefaultTool("Темное зрение(60)","Благодаря вашему дьявольскому наследию, вы отлично видите при тусклом свете и в темноте. На расстоянии в 60 футов вы при тусклом освещении можете видеть так, как будто это яркое освещение, и в темноте так, как будто это тусклое освещение. В темноте вы не можете различать цвета, только оттенки серого."));
        data.toolLists.Abilities.add(new DefaultTool("Адское сопротивление","Вы получаете сопротивление урону огнём."));
        data.toolLists.Abilities.add(new DefaultTool("Дьявольское наследние","Начиная с 3-го уровня, вы можете один раз наложить заклинание адское возмездие [hellish rebuke] как заклинание 2-го уровня с помощью этой особенности. Начиная с 5-го уровня, вы также можете накладывать заклинание тьма [darkness] с помощью этой особенности. После накладывания одного из этих заклинаний с помощью особенности вы должны закончить продолжительный отдых, прежде чем сможете вновь наложить это заклинания таким образом. Кроме того, вы знаете заговор чудотворство [thaumaturgy].\n" +
                "\n" +
                "Базовой характеристикой заклинаний для этих заклинаний является Харизма."));
        data.toolLists.EquipmentProf.add(Languages.Common.name);
        data.toolLists.EquipmentProf.add(Languages.Infernal.name);
    }
}
