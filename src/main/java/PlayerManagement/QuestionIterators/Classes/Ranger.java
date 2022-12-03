package PlayerManagement.QuestionIterators.Classes;

import Enums.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.AdvancedWeaponQuestion;
import PlayerManagement.questions.EquipmentOption;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Ranger extends ClassQuestions{
    public Ranger(SheetInfoHolder dat) {
        super(dat);
        data.gameNums.hitDice=10;
        data.toolLists.EquipmentProf.add("Простое оружие");
        data.toolLists.EquipmentProf.add("Воинское оружие");
        data.toolLists.EquipmentProf.add("Легкие доспехи");
        data.toolLists.EquipmentProf.add("Средние доспехи");
        data.toolLists.EquipmentProf.add("Щиты");
        data.numbers.SavingThrowProf.add(StatsEnum.Dexterity);
        data.numbers.SavingThrowProf.add(StatsEnum.Strength);
        data.toolLists.Equipment.add(Weapon.LongBow);
        data.toolLists.Equipment.add(new DefaultTool("Колчан(20 стрел)",""));
        SQ();
        E1();
        E2();
        EquipmentQ4();
    }
    private void SQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        opts.add(SkillsEnum.Athletics);
        opts.add(SkillsEnum.Perception);
        opts.add(SkillsEnum.Survival);
        opts.add(SkillsEnum.Nature);
        opts.add(SkillsEnum.Insight);
        opts.add(SkillsEnum.Investigation);
        opts.add(SkillsEnum.Stealth);
        opts.add(SkillsEnum.Animal);
        questionQueue.add(new AdvancedSkillQuestion(opts,data.numbers::addSkillProf,3,data::FilterSkills));
    }
    private void E1(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1,Armors.Scale));
        opts.add(new EquipmentOption(1,Armors.Hide));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите доспех из представленных",
                opts,data.toolLists::AddEquipment));
    }
    private void simpleWeaponQ(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        for (var a:Weapon.values()) {
            if(a.isSimple && a.isMelee){opts.add(new EquipmentOption(1,a));}
        }
        questionQueue.add(new AdvancedWeaponQuestion("Выберите оружие из представленных",opts,data.toolLists::AddEquipment));
    }
    private void E2(){
        questionQueue.add(new SingleEntryUserQuestion("Выберите варианты оружия",
                new ArrayList<String>(Arrays.asList(
                        "Два коротких меча",
                        "Два простых рукопашных оружия"
                )),
                (st_ans)->{
                    if(Objects.equals(st_ans, "Два коротких меча")){
                        data.toolLists.AddEquipment(new EquipmentOption(2,Weapon.ShordSword));
                    }
                    else{
                        simpleWeaponQ();
                        simpleWeaponQ();
                    }
                }
                ));
    }
    private void EquipmentQ4(){
        questionQueue.add(new AdvancedWeaponQuestion(
                "Выберите опцию снаряжения",
                new ArrayList<>(Arrays.asList(new EquipmentOption(1, Kits.DungeonExplorer),new EquipmentOption(1,Kits.Traveller))),
                data.toolLists::AddEquipment
        ));
    }

}
