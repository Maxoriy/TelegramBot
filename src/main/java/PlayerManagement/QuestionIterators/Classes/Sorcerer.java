package PlayerManagement.QuestionIterators.Classes;

import Enums.Kits;
import Enums.SkillsEnum;
import Enums.StatsEnum;
import Enums.Weapon;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.AdvancedWeaponQuestion;
import PlayerManagement.questions.EquipmentOption;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Sorcerer extends ClassQuestions{
    public Sorcerer(SheetInfoHolder dat) {
        super(dat);
        data.gameNums.hitDice=6;
        data.numbers.SavingThrowProf.add(StatsEnum.Constitution);
        data.numbers.SavingThrowProf.add(StatsEnum.Charisma);
        data.toolLists.EquipmentProf.add("Боевые посохи");
        data.toolLists.EquipmentProf.add("Дротики");
        data.toolLists.EquipmentProf.add("Кинжалы");
        data.toolLists.EquipmentProf.add("Легкие арбалеты");
        data.toolLists.EquipmentProf.add("Пращи");
        data.toolLists.Equipment.add(new EquipmentOption(2, Weapon.Dagger));
        SQ();
        E2();
        Equipment2();
        EquipmentQ4();
    }
    private void SQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        opts.add(SkillsEnum.Intimidation);
        opts.add(SkillsEnum.Arcana);
        opts.add(SkillsEnum.Deception);
        opts.add(SkillsEnum.Insight);
        opts.add(SkillsEnum.Religion);
        opts.add(SkillsEnum.Persuasion);
        questionQueue.add(new AdvancedSkillQuestion(opts,data.numbers::addSkillProf,2,data::FilterSkills));
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
                        "Арбалет и 20 болтов",
                        "Любое простое оружие"
                )),
                (st_ans)->{
                    if(Objects.equals(st_ans, "Арбалет и 20 болтов")){
                        data.toolLists.AddEquipment(new EquipmentOption(1,Weapon.LightCrossBow));
                        data.toolLists.AddEquipment(new DefaultTool("20 болтов",""));

                    }
                    else{
                        simpleWeaponQ();
                    }
                }
        ));
    }
    private void Equipment2(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1,new DefaultTool("Мешочек с компонентами","")));
        opts.add(new EquipmentOption(1,new DefaultTool("Магическая фокусировка","")));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите снаряжение из представленного",
                opts,data.toolLists::AddEquipment));
    }
    private void EquipmentQ4(){
        questionQueue.add(new AdvancedWeaponQuestion(
                "Выберите опцию снаряжения",
                new ArrayList<>(Arrays.asList(new EquipmentOption(1, Kits.DungeonExplorer),new EquipmentOption(1,Kits.Traveller))),
                data.toolLists::AddEquipment
        ));
    }
}
