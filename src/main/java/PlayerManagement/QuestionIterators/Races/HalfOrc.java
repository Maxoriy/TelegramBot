package PlayerManagement.QuestionIterators.Races;

import Enums.Languages;
import Enums.SkillsEnum;
import Enums.StatsEnum;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import Tools.DefaultTool;
import org.apache.commons.codec.language.bm.Lang;

public class HalfOrc extends BackStoryTemplate {
    public HalfOrc(SheetInfoHolder d) {
        super(d);
        data.numbers.addStatValue(StatsEnum.Strength.getName(), 2);
        data.numbers.addStatValue(StatsEnum.Constitution.getName(), 1);
        data.gameNums.speed=30;
        data.toolLists.Abilities.add(new DefaultTool("Возраст полуорков","Полуорки взрослеют немного быстрее людей, достигая зрелости к 14 годам. Стареют они заметно быстрее, и редко живут дольше 75 лет."));
        data.toolLists.Abilities.add(new DefaultTool("Размер:Средний","Полуорки несколько выше и массивнее людей. Их рост находится в промежутке от 5 до сильно выше 6 футов. Ваш размер — Средний."));
        data.toolLists.Abilities.add(new DefaultTool("Тёмное зрение(60)","Благодаря орочьей крови, вы обладаете превосходным зрением в темноте и при тусклом освещении. На расстоянии в 60 футов вы при тусклом освещении можете видеть так, как будто это яркое освещение, и в темноте так, как будто это тусклое освещение. В темноте вы не можете различать цвета, только оттенки серого."));
        data.toolLists.Abilities.add(new DefaultTool("Угрожающий вид"," Вы получаете владение навыком Запугивание."));
        data.numbers.SkillProf.add(SkillsEnum.Intimidation);
        data.toolLists.Abilities.add(new DefaultTool("Непоколебимая стойкость","Если ваши хиты опустились до нуля, но вы при этом не убиты, ваши хиты вместо этого опускаются до 1. Вы не можете использовать эту способность снова, пока не завершите продолжительный отдых."));
        data.toolLists.Abilities.add(new DefaultTool("Свирепые атаки","Если вы совершили критическое попадание рукопашной атакой оружием, вы можете добавить к урону еще одну кость урона оружия."));
        data.toolLists.EquipmentProf.add(Languages.Common.name);
        data.toolLists.EquipmentProf.add(Languages.Ork.name);
    }
}
