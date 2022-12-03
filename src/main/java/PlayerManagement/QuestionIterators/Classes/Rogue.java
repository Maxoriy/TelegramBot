package PlayerManagement.QuestionIterators.Classes;

import Enums.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.AdvancedWeaponQuestion;
import PlayerManagement.questions.EquipmentOption;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.Objects;

public class Rogue extends ClassQuestions{
    public Rogue(SheetInfoHolder dat) {
        super(dat);
        data.gameNums.hitDice=8;
        data.toolLists.EquipmentProf.add("Легкие доспехи");
        data.toolLists.EquipmentProf.add("Простое оружие");
        data.toolLists.EquipmentProf.add("Ручные арбалеты");
        data.toolLists.EquipmentProf.add("Длинные мечи");
        data.toolLists.EquipmentProf.add("Рапиры");
        data.toolLists.EquipmentProf.add("Короткие мечи");
        data.toolLists.EquipmentProf.add("Воровские инструменты");
        data.numbers.SavingThrowProf.add(StatsEnum.Dexterity);
        data.numbers.SavingThrowProf.add(StatsEnum.Intelligence);
        data.toolLists.Equipment.add(Armors.Hide);
        data.toolLists.Equipment.add(new EquipmentOption(2, Weapon.Dagger));
        data.toolLists.Equipment.add(GameTools.Thief);
        SQ();
        E1();
        E2();
        E3();
    }
    private void SQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        opts.add(SkillsEnum.Athletics);
        opts.add(SkillsEnum.Acrobatics);
        opts.add(SkillsEnum.Perception);
        opts.add(SkillsEnum.Performance);
        opts.add(SkillsEnum.Intimidation);
        opts.add(SkillsEnum.SleightOfHand);
        opts.add(SkillsEnum.Deception);
        opts.add(SkillsEnum.Insight);
        opts.add(SkillsEnum.Investigation);
        opts.add(SkillsEnum.Stealth);
        opts.add(SkillsEnum.Persuasion);
        questionQueue.add(new AdvancedSkillQuestion(opts,data.numbers::addSkillProf,4,data::FilterSkills));
    }
    private void E1(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1,Weapon.Saber));
        opts.add(new EquipmentOption(1,Weapon.ShordSword));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите оружие из представленных",opts,
                data.toolLists::AddEquipment));
    }
    private void E2(){
        ArrayList<String> opts=new ArrayList<>();
        opts.add("Короткий лук и колчан с 20 стрелами");
        opts.add("Короткий меч");
        questionQueue.add(new SingleEntryUserQuestion(
                "Выберите опцию из представленных",
                opts,
                (st_ans)->{
                    if(Objects.equals(st_ans, "Короткий меч")){
                        data.toolLists.Equipment.add(Weapon.ShordSword);
                    }
                    else{
                        data.toolLists.Equipment.add(Weapon.ShortBow);
                        data.toolLists.Equipment.add(new DefaultTool("Колчан(20 стрел)",""));
                    }
                }
        ));
    }
    private void E3(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1,Kits.DungeonExplorer));
        opts.add(new EquipmentOption(1,Kits.Burglar));
        opts.add(new EquipmentOption(1,Kits.Traveller));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите набор из представленных",opts,data.toolLists::AddEquipment));
    }


}
