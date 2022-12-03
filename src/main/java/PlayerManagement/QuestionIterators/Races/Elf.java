package PlayerManagement.QuestionIterators.Races;

import Enums.Languages;
import Enums.SkillsEnum;
import Enums.StatsEnum;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.QuestionIterators.BackStories.Hikka;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Elf extends BackStoryTemplate {
    public Elf(SheetInfoHolder d) {
        super(d);
        data.numbers.addStatValue(StatsEnum.Dexterity.getName(), 2);
        data.toolLists.Abilities.add(new DefaultTool("Возраст эльфов","Несмотря на то, что физически эльфы взрослеют в том же возрасте, что и люди, их понимание о взрослении выходит за рамки физического развития, и располагается в сфере житейского опыта. Обычно эльф получает статус взрослого и взрослое имя в возрасте 100 лет, и может прожить до 750 лет."));
        data.toolLists.Abilities.add(new DefaultTool("Размер: Средний","Рост эльфов колеблется между 5 и 6 футами (152 и 183 сантиметрами), у них стройное телосложение. Ваш размер — Средний."));
        data.gameNums.speed=30;
        data.toolLists.Abilities.add(new DefaultTool("Темное зрение(60)","Привыкнув к сумраку леса и ночному небу, вы обладаете превосходным зрением в темноте и при тусклом освещении. На расстоянии в 60 футов вы при тусклом освещении можете видеть так, как будто это яркое освещение, и в темноте так, как будто это тусклое освещение. В темноте вы не можете различать цвета, только оттенки серого."));
        data.toolLists.Abilities.add(new DefaultTool("Обостренное восприятие","Вы владеете навыком Восприятие"));
        data.numbers.SkillProf.add(SkillsEnum.Perception);
        data.toolLists.Abilities.add(new DefaultTool("Наследие эльфов"," Вы совершаете с преимуществом спасброски от состояния очарованный, и вас невозможно магически усыпить."));
        data.toolLists.Abilities.add(new DefaultTool("Транс","Эльфы не спят. Вместо этого они погружаются в глубокую медитацию, находясь в полубессознательном состоянии до 4 часов в сутки (обычно такую медитацию называют трансом). Во время этой медитации вы можете грезить о разных вещах. Некоторые из этих грёз являются ментальными упражнениями, выработанными за годы тренировок. После такого отдыха вы получаете все преимущества, которые получает человек после 8 часов сна."));
        data.toolLists.EquipmentProf.add(Languages.Common.name);
        data.toolLists.EquipmentProf.add(Languages.Elf.name);
        ElfishShit();
    }
    private void highElf(){
        data.numbers.addStatValue(StatsEnum.Intelligence.getName(), 1);
        data.toolLists.EquipmentProf.add("Длинные мечи");
        data.toolLists.EquipmentProf.add("Короткие мечи");
        data.toolLists.EquipmentProf.add("Короткие луки");
        data.toolLists.EquipmentProf.add("Длинные луки");
        data.toolLists.Abilities.add(new DefaultTool("Магия высших эльфов","Вы знаете один заговор из списка заклинаний волшебника. Базовой характеристикой заклинаний для его использования является Интеллект."));
        addLanQ();
    }
    private void Hippi(){
        data.numbers.addStatValue(StatsEnum.Wisdom.getName(), 1);
        data.toolLists.EquipmentProf.add("Длинные мечи");
        data.toolLists.EquipmentProf.add("Короткие мечи");
        data.toolLists.EquipmentProf.add("Короткие луки");
        data.toolLists.EquipmentProf.add("Длинные луки");
        data.gameNums.speed=35;
        data.toolLists.Abilities.add(new DefaultTool("Маскировка в дикой местности","Вы можете предпринять попытку спрятаться, даже если вы слабо заслонены листвой, сильным дождём, снегопадом, туманом или другими природными явлениями."));

    }
    private void JustAPhase(){
        data.numbers.addStatValue(StatsEnum.Charisma.getName(), 1);
        data.toolLists.Abilities.add(new DefaultTool("Превосходное темное зрение","Ваше тёмное зрение имеет радиус 120 футов."));
        data.toolLists.Abilities.add(new DefaultTool("Чувствительность к солнцу","Вы совершаете с помехой броски атаки и проверки Мудрости (Восприятие), основанные на зрении, если вы, цель вашей атаки или изучаемый предмет расположены на прямом солнечном свете."));
        data.toolLists.Abilities.add(new DefaultTool("Магия дроу","Начиная с 3-го уровня, вы можете накладывать заклинание огонь фей [faerie fire] с помощью этой особенности. Начиная с 5-го уровня вы также можете накладывать заклинание тьма [darkness] с помощью этой особенности. После накладывания одного из этих заклинаний с помощью особенности вы должны закончить продолжительный отдых, прежде чем сможете вновь наложить его таким образом.\n" +
                "\n" +
                "Кроме того, вы знаете заговор пляшущие огоньки [dancing lights]. Базовой характеристикой для этих заклинаний является Харизма."));
        data.toolLists.EquipmentProf.add("Рапиры");
        data.toolLists.EquipmentProf.add("Короткие мечи");
        data.toolLists.EquipmentProf.add("Ручные арбалеты");
    }
    private void ElfishShit()   {
        questionQueue.add(new SingleEntryUserQuestion("Выберите разновидность эльфов",
        new ArrayList<String>(Arrays.asList("Высший эльф","Лесной эльф","Темный эльф")),
                (a)->{
                    if(Objects.equals(a, "Высший эльф")){
                        highElf();
                    } else if (Objects.equals(a, "Лесной эльф")) {
                        Hippi();
                    }
                    else{
                        JustAPhase();
                    }
                }
        ));
    }
}
