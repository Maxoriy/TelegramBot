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

public class Paladin extends ClassQuestions{
    public Paladin(SheetInfoHolder dat) {
        super(dat);
        data.gameNums.hitDice=10;
        data.toolLists.EquipmentProf.add("Любые доспехи");
        data.toolLists.EquipmentProf.add("Щиты");
        data.toolLists.EquipmentProf.add("Простое оружие");
        data.toolLists.EquipmentProf.add("Воинское оружие");
        data.numbers.SavingThrowProf.add(StatsEnum.Wisdom);
        data.numbers.SavingThrowProf.add(StatsEnum.Charisma);
        data.toolLists.Equipment.add(Armors.Kolchuga);
        data.toolLists.Equipment.add(new DefaultTool("Священный символ",""));
        Sq();
        E1();
        E2();
        E3();
    }
    private void Sq(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        opts.add(SkillsEnum.Athletics);
        opts.add(SkillsEnum.Intimidation);
        opts.add(SkillsEnum.Medicine);
        opts.add(SkillsEnum.Insight);
        opts.add(SkillsEnum.Religion);
        opts.add(SkillsEnum.Persuasion);
        questionQueue.add(new AdvancedSkillQuestion(opts,data.numbers::addSkillProf,2,data::FilterSkills));
    }
    private void E1(){
        questionQueue.add(new SingleEntryUserQuestion("Выберите опцию из представленных",
                new ArrayList<>(Arrays.asList("Воинское оружие и щит","Два воинских оружия")),
                (st_ans)->{
                    if(Objects.equals(st_ans, "Воинское оружие и щит")){
                        data.toolLists.Equipment.add(Armors.Shield);
                        warweapons();
                    }
                    else{
                        warweapons();
                        warweapons();
                    }

                }

                ));
    }
    private void E2(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        for (var a:Weapon.values()
             ) {
            if(a.isMelee && a.isSimple){
                opts.add(new EquipmentOption(1,a));
            }
        }
        opts.add(new EquipmentOption(5,Weapon.ThrowingSpear));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите оружие из списка",opts,data.toolLists::AddEquipment));
    }
    private void E3(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Kits.Traveller));
        opts.add(new EquipmentOption(1, Kits.Priest));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите опцию из представленных",opts,data.toolLists::AddEquipment));
    }
    private void warweapons(){
        ArrayList<EquipmentOption>opts1= new ArrayList<>();
        for (var a: Weapon.values()) {
            if(!a.isSimple){
                opts1.add(new EquipmentOption(1,a));
            }
        }
        questionQueue.add(new AdvancedWeaponQuestion(
                "Выберите оружие из представленных",opts1,data.toolLists::AddEquipment

        ));
    }
}
