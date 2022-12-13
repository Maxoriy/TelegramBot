package PlayerManagement.QuestionIterators.Classes;

import Enums.*;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.QuestionIterators.Subclasses.BardDoblest;
import PlayerManagement.QuestionIterators.Subclasses.BardKnowledge;
import PlayerManagement.QuestionIterators.Subclasses.DruidEarth;
import PlayerManagement.QuestionIterators.Subclasses.DruidMoon;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.*;
import Tools.DefaultTool;
import org.checkerframework.checker.units.qual.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Bard extends ClassQuestions{
    public Bard(SheetInfoHolder dat) {
        super(dat);
    data.gameNums.hitDice=8;
    data.toolLists.EquipmentProf.add("Легкие доспехи");
    data.toolLists.EquipmentProf.add("Длинные мечи");
    data.toolLists.EquipmentProf.add("Корочткие мечи");
    data.toolLists.EquipmentProf.add("Рапиры");
    data.toolLists.EquipmentProf.add("Ручные арбалеты");
    data.toolLists.EquipmentProf.add("3 Музыкальных инструмента на ваш выбор");
    data.numbers.SavingThrowProf.add(StatsEnum.Dexterity);
    data.numbers.SavingThrowProf.add(StatsEnum.Charisma);
    createSkillQ();
    createWeaponQ();
    createKitQ();
    data.toolLists.Equipment.add(Weapon.Dagger);
    data.toolLists.Equipment.add(Armors.Hide);
    casting();
    Vdohnovenie();
    lvl2();
    lvl3();
    AddCharacts();
    lvl5();
    lvl6();
    lvl10();
    lvl20();
    SubClassQ();
    }
    private void createSkillQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        Collections.addAll(opts, SkillsEnum.values());
        questionQueue.add(new AdvancedSkillQuestion(
                opts,
                data.numbers::addSkillProf,
                3,
                data::FilterSkills));
    }
    private void createWeaponQ(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Weapon.Saber));
        opts.add(new EquipmentOption(1, Weapon.LongSword));
        for (var a:Weapon.values()) {
            if(a.isSimple){
                opts.add(new EquipmentOption(1,a));
            }
        }
        questionQueue.add(new AdvancedWeaponQuestion(
                "Выберите оружие из представленных",
                opts,
                data.toolLists::AddEquipment
        ));
    }
    private void createKitQ(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Kits.Diplomat));
        opts.add(new EquipmentOption(1, Kits.Artist));
        questionQueue.add(new AdvancedWeaponQuestion(
                    "Выберите набор из представленных",
                    opts,
                    data.toolLists::AddEquipment));
    }

    private void casting(){
        data.toolLists.Abilities.add(new DefaultTool("Использование заклинаний(Бард)","Базовой характеристикой заклинаний является харизма. Подробное объяснение механики магии вы найдете в книге игрока"));
    }
    private void Vdohnovenie(){
        data.toolLists.Abilities.add(new DefaultTool("Вдохновение барда","Своими словами или музыкой вы можете вдохновлять других. Для этого вы должны бонусным действием выбрать одно существо, отличное от вас, в пределах 60 футов, которое может вас слышать. Это существо получает кость бардовского вдохновения — к6.\n" +
                "\n" +
                "В течение следующих 10 минут это существо может один раз бросить эту кость и добавить результат к проверке характеристики, броску атаки или спасброску, который оно совершает. Существо может принять решение о броске кости вдохновения уже после броска к20, но должно сделать это прежде, чем Мастер объявит результат броска. Как только кость бардовского вдохновения брошена, она исчезает. Существо может иметь только одну такую кость одновременно.\n" +
                "\n" +
                "Вы можете использовать это умение количество раз, равное модификатору вашей Харизмы, но как минимум один раз. Потраченные использования этого умения восстанавливаются после продолжительного отдыха.\n" +
                "\n" +
                "Ваша кость бардовского вдохновения изменяется с ростом вашего уровня в этом классе. Она становится к8 на 5-м уровне, к10 на 10-м уровне и к12 на 15-м уровне."));
    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Мастер на все руки","Вы можете добавлять половину бонуса мастерства, округлённую в меньшую сторону, ко всем проверкам характеристики, куда этот бонус еще не включён."));
        data.toolLists.Abilities.add(new DefaultTool("Песнь отдыха","Вы с помощью успокаивающей музыки или речей можете помочь своим раненым союзникам восстановить их силы во время короткого отдыха. Если вы или любые союзные существа, способные слышать ваше исполнение, восстанавливаете хиты в конце короткого отдыха, используя Кости Хитов, каждое потратившее Кость Хитов существо восстанавливает дополнительно 1к6 хитов.\n" +
                "\n" +
                "Количество дополнительно восстанавливаемых хитов растёт с вашим уровнем в этом классе: 1к8 на 9-м уровне, 1к10 на 13 уровне и 1к12 на 17 уровне."));
    }
    private void lvl3(){
        if(data.gameNums.level<3){return;}
        data.toolLists.Abilities.add(new DefaultTool("Компетентность","Выберите 2 навыка из тех, которыми вы владеете. Ваш бонус мастерства для этих навыков удваивается.\n" +
                "\n" +
                "На 10-м уровне вы можете выбрать еще 2 навыка и получить для них это преимущество."));

    }
    private void AddCharacts(){
        if(data.gameNums.level<4){return;}
        ImproveCharacteristicQ();
        if(data.gameNums.level<8){return;}
        ImproveCharacteristicQ();
        if(data.gameNums.level<12){return;}
        ImproveCharacteristicQ();

        if(data.gameNums.level<16){return;}
        ImproveCharacteristicQ();

        if(data.gameNums.level<19){return;}
        ImproveCharacteristicQ();
    }
    private void lvl5(){
        if(data.gameNums.level<5){return;}
        data.toolLists.Abilities.add(new DefaultTool("Источник вдохновения","Вы восстанавливаете истраченные вдохновения барда и после короткого и после продолжительного отдыха."));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Контрочарование","Вы получаете возможность использовать звуки или слова силы для разрушения воздействующих на разум эффектов. Вы можете действием начать исполнение, которое продлится до конца вашего следующего хода. В течение этого времени вы и все дружественные существа в пределах 30 футов от вас совершают спасброски от запугивания и очарования с преимуществом. Чтобы получить это преимущество, существа должны слышать вас. Исполнение заканчивается преждевременно, если вы оказываетесь недееспособны, теряете способность говорить, или прекращаете исполнение добровольно (на это не требуется действие)."));

    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Тайны магии","Вы успели набрать знаний из самого широкого спектра магических дисциплин. Выберите два заклинания любых классов, включая ваш собственный. Эти заклинания должны быть того уровня, который вы можете использовать, или являться заговорами.\n" +
                "\n" +
                "Теперь эти заклинания считаются для вас заклинаниями барда и учитываются в общем количестве известных вам заклинаний согласно таблице «Бард». Ещё по два заклинания других классов вы выучите на 14-м и 18-м уровнях."));
    }
    private void lvl20(){
        if(data.gameNums.level<20){return;}
        data.toolLists.Abilities.add(new DefaultTool("Превосходное вдохновение","Если на момент броска инициативы у вас не осталось неиспользованных вдохновений, вы получаете одно."));
    }
    private void SubClassQ(){
        if(data.gameNums.level<2){return;}
        questionQueue.add(new SingleEntryUserQuestion("Выберите подкласс",new ArrayList<>(Arrays.asList("Коллегия доблести","Коллегия знаний")),
                (a)->{
                    if(Objects.equals(a, "Коллегия доблести")){
                        BackStoryTemplate sub=new BardDoblest(data,questionQueue);
                    }
                    if(Objects.equals(a, "Коллегия знаний")){
                        BackStoryTemplate sub=new BardKnowledge(data,questionQueue);
                    }

                }

        ));
    }
}
