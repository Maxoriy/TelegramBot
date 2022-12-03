package PlayerManagement.QuestionIterators.Classes;


import Enums.Kits;
import Enums.SkillsEnum;
import Enums.StatsEnum;
import Enums.Weapon;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.*;
import Tools.DefaultTool;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;

public class Monke extends ClassQuestions {
    public Monke(SheetInfoHolder dat) {
        super(dat);
        setHitDices();
        setProficiencies();
        setSkillProf();
        setEquipment();
        createEquipQ();
        createGametoolsQ();
        createKitQ();

    }
    private void setHitDices(){
        data.gameNums.hitDice=8;
    }
    private void setProficiencies(){
        data.toolLists.EquipmentProf.add("Простое оружие");
        data.toolLists.EquipmentProf.add("Короткие мечи");
        data.numbers.SavingThrowProf.add(StatsEnum.Strength);
        data.numbers.SavingThrowProf.add(StatsEnum.Dexterity);

    }
    private void setSkillProf(){
        ArrayList<SkillsEnum> opts=new ArrayList<>(Arrays.asList(
                SkillsEnum.Athletics,
                SkillsEnum.Acrobatics,
                SkillsEnum.History,
                SkillsEnum.Insight,
                SkillsEnum.Religion,
                SkillsEnum.Stealth
        ));
        questionQueue.add(new AdvancedSkillQuestion(
                opts,
                data.numbers::addSkillProf,
                2,
                data::FilterSkills));


    }
    private void setEquipment(){
        data.toolLists.Equipment.add(new DefaultTool(Weapon.Dart.name+ "(" + "10" + ")" ,Weapon.Dart.getDescription()));
    }
    private void createEquipQ(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        for (var a:Weapon.values()) {
            if(a.isSimple){
                opts.add(new EquipmentOption(1,a));
            }
        }
        opts.add(new EquipmentOption(1,Weapon.ShordSword) );
        questionQueue.add( new AdvancedWeaponQuestion(
                "Выберите оружие из представленных",
                opts,
                data.toolLists::AddEquipment));
    }
    private void createGametoolsQ(){
        questionQueue.add(new NoOptionQuestion(
                "Выберите один вид инструмента ремесленников, либо музыкальных инструментов, напишите название",
                (a)->{data.toolLists.Equipment.add(new DefaultTool(a,""));}
        ));
    }
    private void createKitQ(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Kits.DungeonExplorer));
        opts.add(new EquipmentOption(1, Kits.Traveller));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите набор предметов из представленных",
                opts,
                data.toolLists::AddEquipment
                ));
    }
}
