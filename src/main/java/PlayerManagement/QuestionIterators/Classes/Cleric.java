package PlayerManagement.QuestionIterators.Classes;

import Enums.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.AdvancedWeaponQuestion;
import PlayerManagement.questions.EquipmentOption;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;
import org.checkerframework.checker.units.qual.A;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Cleric extends ClassQuestions{

    public Cleric(SheetInfoHolder dat) {
        super(dat);
        data.gameNums.hitDice=8;
        data.toolLists.EquipmentProf.add("Легкие доспехи");
        data.toolLists.EquipmentProf.add("Средние доспехи");
        data.toolLists.EquipmentProf.add("Щиты");
        data.toolLists.EquipmentProf.add("Простое оружие");
        data.numbers.SavingThrowProf.add(StatsEnum.Wisdom);
        data.numbers.SavingThrowProf.add(StatsEnum.Charisma);
        data.toolLists.Equipment.add(Armors.Shield);
        data.toolLists.Equipment.add(new DefaultTool("Священный символ",""));
        SkillQ();
        E1();
        E2();
        E3();
        E4();

    }
    private void SkillQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        opts.add(SkillsEnum.History);
        opts.add(SkillsEnum.Medicine);
        opts.add(SkillsEnum.Insight);
        opts.add(SkillsEnum.Religion);
        opts.add(SkillsEnum.Persuasion);
        questionQueue.add(new AdvancedSkillQuestion(opts,data.numbers::addSkillProf,2,data::FilterSkills));
    }
    private void E1(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Weapon.Mace));
        opts.add(new EquipmentOption(1, Weapon.WarHammer));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите опцию из представленных. Учтите, что без соответствующего домена вы не сможете использовать боевой молот",opts,data.toolLists::AddEquipment));
    }
    private void E2(){
        ArrayList<EquipmentOption> opts =new ArrayList<>();
        opts.add(new EquipmentOption(1, Armors.Scale));
        opts.add(new EquipmentOption(1, Armors.Hide));
        opts.add(new EquipmentOption(1, Armors.Kolchuga));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите опцию из представленных. Учтите, что без соответствующего домена вы не сможете использовать кольчугу",opts,data.toolLists::AddEquipment));

    }
    private void E3(){
        questionQueue.add(new SingleEntryUserQuestion(
                "Выберите опцию снаряжения",
                new ArrayList<>(Arrays.asList("лёгкий арбалет и 20 болтов","простое оружие")),
                (St_ans)->{
                    if(Objects.equals(St_ans, "лёгкий арбалет и 20 болтов")){
                        data.toolLists.Equipment.add(Weapon.LightCrossBow);
                        data.toolLists.Equipment.add(new EquipmentOption(20,new DefaultTool("Арбалетный болт","")));
                    }
                    else{
                        ArrayList<EquipmentOption> opts=new ArrayList<>();
                        for (var a:Weapon.values()) {
                            if(a.isSimple){opts.add(new EquipmentOption(1,a));}
                        }
                        questionQueue.add(new AdvancedWeaponQuestion("Выберите оружие из представленных",opts,data.toolLists::AddEquipment));
                    }
                }
        ));
    }
    private void E4(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Kits.Traveller));
        opts.add(new EquipmentOption(1, Kits.Priest));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите опцию из представленных",opts,data.toolLists::AddEquipment));
    }
}
