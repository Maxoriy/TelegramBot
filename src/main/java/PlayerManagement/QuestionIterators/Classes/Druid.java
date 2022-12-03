package PlayerManagement.QuestionIterators.Classes;

import Enums.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.AdvancedWeaponQuestion;
import PlayerManagement.questions.EquipmentOption;
import Tools.DefaultTool;

import java.util.ArrayList;

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

}

