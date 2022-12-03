package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import Tools.DefaultTool;

public class Cultist extends BackStoryTemplate{
    public Cultist(SheetInfoHolder d) {
        super(d);
        data.numbers.SkillProf.add(SkillsEnum.Religion);
        data.numbers.SkillProf.add(SkillsEnum.Insight);
        addLanQ();
        addLanQ();
        data.toolLists.Equipment.add(new DefaultTool("Священный символ",""));
        data.toolLists.Equipment.add(new DefaultTool("Молитвенник",""));
        data.toolLists.Equipment.add(new DefaultTool( "5 палочек благовоний",""));
        data.toolLists.Equipment.add(new DefaultTool( "Ряса",""));
        data.toolLists.Equipment.add(new DefaultTool( "Комплект обычной одежды",""));
        data.toolLists.Equipment.add(new DefaultTool( "15 зм",""));
        data.toolLists.Abilities.add(new DefaultTool( "Приют для верующих","Вы и ваши спутники можете рассчитывать на бесплатное лечение и уход в храмах, святынях и других подобных местах, посвящённых вашей вере. Вам придётся предоставить материальные компоненты для заклинаний, если таковые понадобятся. Те, кто разделяют вашу веру, могут обеспечить вам (но только вам) скромное существование.\n" +
                "\n" +
                "У вас также могут быть связи с каким-то конкретным храмом, посвящённым вашему божеству или пантеону, в котором у вас есть жилая комната. Пока вы находитесь с этим храмом в хороших отношениях, находясь неподалёку от него, вы можете попросить у его служителей помощи, если она не подвергнет их опасности."));
    }
}
