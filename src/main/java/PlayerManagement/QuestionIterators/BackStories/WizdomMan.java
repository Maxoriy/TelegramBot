package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import Tools.DefaultTool;

public class WizdomMan extends BackStoryTemplate{
    public WizdomMan(SheetInfoHolder d) {
        super(d);
        data.numbers.SkillProf.add(SkillsEnum.History);
        data.numbers.SkillProf.add(SkillsEnum.Arcana);
        addLanQ();
        addLanQ();
        data.toolLists.Equipment.add(new DefaultTool("Бутылочка чернил, писчее перо",""));
        data.toolLists.Equipment.add(new DefaultTool("Небольшой нож",""));
        data.toolLists.Equipment.add(new DefaultTool("Письмо от мертвого коллеги с неотвеченным вопросом",""));
        data.toolLists.Equipment.add(new DefaultTool("Комплект обычной одежды",""));
        data.toolLists.Equipment.add(new DefaultTool("Поясной кошель с 10 зм",""));
        data.toolLists.Abilities.add(new DefaultTool("Исследователь","Если вы пытаетесь изучить или вспомнить информацию, которой вы не обладаете, вы часто знаете, где и от кого её можно получить. Обычно это библиотека, скрипторий, университет, мудрец или другое образованное существо. Мастер может решить, что искомое знание является тайной и хранится в практически недоступном месте, или что оно вообще недоступно. Поиски глубочайших тайн вселенной могут потребовать отдельного приключения или даже целой кампании."));

    }
}
