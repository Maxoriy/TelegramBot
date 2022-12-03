package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import Tools.DefaultTool;

public class Hikka extends BackStoryTemplate{
    public Hikka(SheetInfoHolder d) {
        super(d);
        data.numbers.SkillProf.add(SkillsEnum.Medicine);
        data.numbers.SkillProf.add(SkillsEnum.Religion);
        data.toolLists.EquipmentProf.add("Набор травника");
        addLanQ();
        data.toolLists.Equipment.add(new DefaultTool("Контейнер для свитков, полный вашими молитвами и изысканиями",""));
        data.toolLists.Equipment.add(new DefaultTool("Теплое одеяло",""));
        data.toolLists.Equipment.add(new DefaultTool("Комплект обычной одежды",""));
        data.toolLists.Equipment.add(new DefaultTool("Набор травника",""));
        data.toolLists.Equipment.add(new DefaultTool("5 зм",""));
        data.toolLists.Abilities.add(new DefaultTool("Откровение","Тихое уединение в долгом отшельничестве дало вам доступ к великому откровению. Точная природа этого откровения зависит от характера вашего уединения. Это может быть истина о вселенной, божествах, влиятельных созданиях на внешних планах, или силах природы. Это может быть место, которое никто и никогда не видел. Вы могли обнаружить что-то, что давно было забыто, или найти реликвию прошлого, способную переписать историю. Это может быть информация, которая может причинить вред тем, кто изгнал вас, и тем самым ставшая причиной возвращения в общество.\n" +
                "\n" +
                "Придумайте вместе с Мастером детали вашего откровения и его влияние на кампанию."));

    }
}
