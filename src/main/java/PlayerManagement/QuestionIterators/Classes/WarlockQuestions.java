package PlayerManagement.QuestionIterators.Classes;

import Enums.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.*;
import Tools.DefaultTool;
import Tools.ITool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class    WarlockQuestions extends ClassQuestions {

    public WarlockQuestions(SheetInfoHolder dat) {
        super(dat);
         data.gameNums.hitDice=8;
        data.toolLists.EquipmentProf.add("Легкие доспехи");
        data.toolLists.EquipmentProf.add("Простое оружие");
        data.numbers.SavingThrowProf.add(StatsEnum.Charisma);
        data.numbers.SavingThrowProf.add(StatsEnum.Wisdom);
        setSkillQ();
        Q1();
        Q2();
        Q3();
        Q4();
    }
    private void setSkillQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        opts.add(SkillsEnum.Intimidation);
        opts.add(SkillsEnum.History);
        opts.add(SkillsEnum.Arcana);
        opts.add(SkillsEnum.Deception);
        opts.add(SkillsEnum.Nature);
        opts.add(SkillsEnum.Investigation);
        opts.add(SkillsEnum.Religion);
        questionQueue.add(new AdvancedSkillQuestion(opts,data.numbers::addSkillProf,2,data::FilterSkills));
        data.toolLists.Equipment.add(Armors.Hide);
        data.toolLists.Equipment.add(new DefaultTool(Weapon.Dagger.name+ "(" + "2" + ")" ,Weapon.Dagger.getDescription()));
    }
    private void Q1(){
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
    private void Q2(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1,new DefaultTool("Мешочек с компонентами","")));
        opts.add(new EquipmentOption(1,new DefaultTool("Магическая фокусировка","")));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите снаряжение из представленного",
                opts,data.toolLists::AddEquipment));
    }
    private void Q3(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Kits.Scientist));
        opts.add(new EquipmentOption(1, Kits.DungeonExplorer));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите снаряжение из представленного",opts,
                data.toolLists::AddEquipment));
    }
    private void Q4(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        for (var a:Weapon.values()) {
            if(a.isSimple){opts.add(new EquipmentOption(1,a));}
        }
        questionQueue.add(new AdvancedWeaponQuestion("Выберите оружие из представленного",opts,data.toolLists::AddEquipment));
    }

}
