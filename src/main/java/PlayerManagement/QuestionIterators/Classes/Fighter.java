package PlayerManagement.QuestionIterators.Classes;


import Enums.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.*;
import Tools.DefaultTool;
import Tools.ITool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Fighter extends ClassQuestions {
    public Fighter(SheetInfoHolder dat) {
        super(dat);
        data.gameNums.hitDice=10;
        data.toolLists.EquipmentProf.add("Все доспехи");
        data.toolLists.EquipmentProf.add("Щиты");
        data.toolLists.EquipmentProf.add("Простое оружие");
        data.toolLists.EquipmentProf.add("Воинское оружие");
        data.numbers.SavingThrowProf.add(StatsEnum.Strength);
        data.numbers.SavingThrowProf.add(StatsEnum.Constitution);
        Skillq();
        EquipmentQ1();
        EquipmentQ2();
        EquipmentQ3();
        EquipmentQ4();
    }
    private void Skillq(){
        ArrayList<SkillsEnum>opts=new ArrayList<>();
        opts.add(SkillsEnum.Acrobatics);
        opts.add(SkillsEnum.Athletics);
        opts.add(SkillsEnum.Perception);
        opts.add(SkillsEnum.Survival);
        opts.add(SkillsEnum.Intimidation);
        opts.add(SkillsEnum.History);
        opts.add(SkillsEnum.Insight);
        opts.add(SkillsEnum.Animal);
        questionQueue.add(new AdvancedSkillQuestion(opts,
                data.numbers::addSkillProf,
                2,
                data::FilterSkills));
    }
    private void EquipmentQ1(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1,Armors.Kolchuga) );
        opts.add(new EquipmentOption(1,new DefaultTool("кожаный доспех, длинный лук и 20 стрел","")));

        questionQueue.add(new AdvancedWeaponQuestion(
                "Выберите снаряжение из представленного",
                opts,
                (ITl)->{
                    if (Objects.equals(ITl.getName(), "кожаный доспех, длинный лук и 20 стрел")){
                        data.toolLists.Equipment.add(Armors.Hide);
                        data.toolLists.Equipment.add(Weapon.LongBow);
                        data.toolLists.Equipment.add(new DefaultTool("Стрелы(20)",""));
                    }
                    else{
                        data.toolLists.Equipment.add(ITl);
                    }
                }
        ));
    }
    private void EquipmentQ2(){

        questionQueue.add(new SingleEntryUserQuestion(
                "Выберите опцию снаряжения:",
                new ArrayList<>(Arrays.asList("воинское оружие и щит","два воинских оружия")),
                (st_ans)->{
                    if(Objects.equals(st_ans, "воинское оружие и щит")){
                        data.toolLists.Equipment.add(Armors.Shield);
                        ArrayList<EquipmentOption> opts = new ArrayList<>();
                        for (var a:Weapon.values()) {
                            if(!a.isSimple){
                                opts.add(new EquipmentOption(1,a));
                            }
                        }
                        questionQueue.add(new AdvancedWeaponQuestion("Выберите оружие из представленных",
                                opts,
                                data.toolLists::AddEquipment
                                ));
                    }
                    else{
                        ArrayList<EquipmentOption> opts = new ArrayList<>();
                        for (var a:Weapon.values()) {
                            if(!a.isSimple){
                                opts.add(new EquipmentOption(1,a));
                            }
                        }
                        questionQueue.add(new AdvancedWeaponQuestion("Выберите оружие из представленных",
                                opts,
                                data.toolLists::AddEquipment
                        ));
                        questionQueue.add(new AdvancedWeaponQuestion("Выберите оружие из представленных",
                                opts,
                                data.toolLists::AddEquipment
                        ));
                    }
                }
        ));
    }
    private void EquipmentQ3(){
        questionQueue.add(new SingleEntryUserQuestion(
                "Выберите опцию снаряжения",
                new ArrayList<>(Arrays.asList("лёгкий арбалет и 20 болтов","два ручных топора")),
                (St_ans)->{
                    if(Objects.equals(St_ans, "лёгкий арбалет и 20 болтов")){
                        data.toolLists.Equipment.add(Weapon.LightCrossBow);
                        data.toolLists.Equipment.add(new EquipmentOption(20,new DefaultTool("Арбалетный болт","")));
                    }
                    else{
                        data.toolLists.Equipment.add(new EquipmentOption(2,Weapon.HandAxe));
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
