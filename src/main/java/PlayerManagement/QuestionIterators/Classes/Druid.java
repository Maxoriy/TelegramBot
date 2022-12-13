package PlayerManagement.QuestionIterators.Classes;

import Enums.*;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.QuestionIterators.Subclasses.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.AdvancedWeaponQuestion;
import PlayerManagement.questions.EquipmentOption;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Druid extends ClassQuestions {
    public Druid(SheetInfoHolder dat) {
        super(dat);
        data.gameNums.hitDice=8;
        data.toolLists.EquipmentProf.add("Легкие доспехи");
        data.toolLists.EquipmentProf.add("Средние доспехи");
        data.toolLists.EquipmentProf.add("Щиты");
        data.toolLists.EquipmentProf.add("Боевые посохи");
        data.toolLists.EquipmentProf.add("Булавы");
        data.toolLists.EquipmentProf.add("Дротики");
        data.toolLists.EquipmentProf.add("Дубинки");
        data.toolLists.EquipmentProf.add("Кинжалы");
        data.toolLists.EquipmentProf.add("Копья");
        data.toolLists.EquipmentProf.add("Метательные копья");
        data.toolLists.EquipmentProf.add("Пращи");
        data.toolLists.EquipmentProf.add("Серпы");
        data.toolLists.EquipmentProf.add("Скимитары");
        data.toolLists.EquipmentProf.add("Набор травника");
        data.numbers.SavingThrowProf.add(StatsEnum.Intelligence);
        data.numbers.SavingThrowProf.add(StatsEnum.Wisdom);
        data.toolLists.Equipment.add(Armors.Hide);
        data.toolLists.Equipment.add(Kits.Traveller);
        data.toolLists.Equipment.add(new DefaultTool("Магическая фокусировка",""));
        SkillQ();
        Eq1();
        Eq2();
        CastingAbility();
        WildNature();
        SubClassQ();
        AddCharacts();
        NoTimeBodyAnd();
        lvl20();
    }
    private void SkillQ(){
        ArrayList<SkillsEnum>opts=new ArrayList<>();
        opts.add(SkillsEnum.Perception);
        opts.add(SkillsEnum.Survival);
        opts.add(SkillsEnum.Arcana);
        opts.add(SkillsEnum.Medicine);
        opts.add(SkillsEnum.Animal);
        opts.add(SkillsEnum.Nature);
        opts.add(SkillsEnum.Insight);
        opts.add(SkillsEnum.Religion);
        questionQueue.add(new AdvancedSkillQuestion(opts,data.numbers::addSkillProf,
                2,data::FilterSkills));
    }
    private void Eq1(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        for (var a: Weapon.values()) {
            if(a.isSimple){
                opts.add(new EquipmentOption(1,a));
            }
        }
        opts.add(new EquipmentOption(1,Armors.Shield));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите опцию из представленных",opts,
                data.toolLists::AddEquipment));
    }
    private void Eq2(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        for (var a: Weapon.values()) {
            if(a.isSimple && a.isMelee){
                opts.add(new EquipmentOption(1,a));
            }
        }
        opts.add(new EquipmentOption(1,Weapon.Skimitar));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите опцию из представленных",opts, data.toolLists::AddEquipment));
    }

    private void CastingAbility(){
        data.toolLists.Abilities.add(new DefaultTool("Использование заклинаний(Друид)","" +
                "Базовой характеристикой для магии вашего класса является мудрость. Подробнее о магии читайте в книге игрока"));
    }
    private void WildNature(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Дикий облик","вы можете превращаться в известного вам зверя. На 2 уровне ПО зверя не должен превышать 1/4, на 4 уровне 1/2, на 8 - 1, подробнее об умении читайте в книге игрока"));
    }
    private void SubClassQ(){
        if(data.gameNums.level<2){return;}
        questionQueue.add(new SingleEntryUserQuestion("Выберите подкласс",new ArrayList<>(Arrays.asList("Круг земли","Круг луны")),
                (a)->{
                    if(Objects.equals(a, "Круг земли")){
                        BackStoryTemplate sub=new DruidEarth(data,questionQueue);
                    }
                    if(Objects.equals(a, "Круг луны")){
                        BackStoryTemplate sub=new DruidMoon(data,questionQueue);
                    }

                }

        ));
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
    private void NoTimeBodyAnd(){
        if(data.gameNums.level<18){return;}
        data.toolLists.Abilities.add(new DefaultTool("Безвременное тело","Пронизывающая вас природная магия замедляет старение. За каждые 10 лет ваше тело стареет только на 1 год."));

        data.toolLists.Abilities.add(new DefaultTool("Заклинания зверя","Персонаж может накладывать в диком облике заклинания друида. Будучи Зверем, вы можете использовать соматический и вербальный компоненты заклинаний друида, но не можете обеспечить материальные компоненты."));
    }
    private void lvl20(){
        if(data.gameNums.level<20){return;}
        data.toolLists.Abilities.add(new DefaultTool("Архидруид","Количество применений умения «Дикий облик» не ограничено. Кроме того, вы можете игнорировать соматический и вербальный компоненты заклинаний друида, а также материальные компоненты без указанной стоимости и не расходуемые заклинанием. Это действует как в нормальном облике, так и в облике Зверя."));

    }

}

