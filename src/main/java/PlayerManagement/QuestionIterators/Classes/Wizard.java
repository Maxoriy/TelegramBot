package PlayerManagement.QuestionIterators.Classes;

import Enums.Kits;
import Enums.SkillsEnum;
import Enums.StatsEnum;
import Enums.Weapon;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.AdvancedWeaponQuestion;
import PlayerManagement.questions.EquipmentOption;
import Tools.DefaultTool;

import java.util.ArrayList;

public class Wizard extends ClassQuestions{
    public Wizard(SheetInfoHolder dat) {
        super(dat);
        data.gameNums.hitDice=6;
        data.toolLists.EquipmentProf.add("Кинжалы");
        data.toolLists.EquipmentProf.add("Дротики");
        data.toolLists.EquipmentProf.add("Пращи");
        data.toolLists.EquipmentProf.add("боевые посохи");
        data.toolLists.EquipmentProf.add("легкие арбалеты");
        data.numbers.SavingThrowProf.add(StatsEnum.Intelligence);
        data.numbers.SavingThrowProf.add(StatsEnum.Wisdom);
        data.toolLists.Equipment.add(new DefaultTool("Книга заклинаний","В этой книге хранятся ваши заклинания"));
        SkillQ();
        Equipment1();
        Equipment2();
        Equipment3();
    }
    private void SkillQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        opts.add(SkillsEnum.History);
        opts.add(SkillsEnum.Arcana);
        opts.add(SkillsEnum.Medicine);
        opts.add(SkillsEnum.Insight);
        opts.add(SkillsEnum.Investigation);
        opts.add(SkillsEnum.Religion);
        questionQueue.add(new AdvancedSkillQuestion(
                opts,data.numbers::addSkillProf,2,
                data::FilterSkills

        ));
    }
    private void Equipment1(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Weapon.QuaterStaff));
        opts.add(new EquipmentOption(1, Weapon.Dagger));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите снаряжение из представленного",
                opts,data.toolLists::AddEquipment
                ));
    }
    private void Equipment2(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1,new DefaultTool("Мешочек с компонентами","")));
        opts.add(new EquipmentOption(1,new DefaultTool("Магическая фокусировка","")));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите снаряжение из представленного",
                opts,data.toolLists::AddEquipment));
    }
    private void Equipment3(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Kits.Traveller));
        opts.add(new EquipmentOption(1,Kits.Scientist));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите снаряжение из представленного",
                opts,data.toolLists::AddEquipment));
    }

}
