package PlayerManagement.QuestionIterators.Classes;

import Enums.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.*;
import org.checkerframework.checker.units.qual.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Bard extends ClassQuestions{
    public Bard(SheetInfoHolder dat) {
        super(dat);
    data.gameNums.hitDice=8;
    data.toolLists.EquipmentProf.add("Легкие доспехи");
    data.toolLists.EquipmentProf.add("Длинные мечи");
    data.toolLists.EquipmentProf.add("Корочткие мечи");
    data.toolLists.EquipmentProf.add("Рапиры");
    data.toolLists.EquipmentProf.add("Ручные арбалеты");
    data.toolLists.EquipmentProf.add("3 Музыкальных инструмента на ваш выбор");
    data.numbers.SavingThrowProf.add(StatsEnum.Dexterity);
    data.numbers.SavingThrowProf.add(StatsEnum.Charisma);
    createSkillQ();
    createWeaponQ();
    createKitQ();
    data.toolLists.Equipment.add(Weapon.Dagger);
    data.toolLists.Equipment.add(Armors.Hide);
    }
    private void createSkillQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        Collections.addAll(opts, SkillsEnum.values());
        questionQueue.add(new AdvancedSkillQuestion(
                opts,
                data.numbers::addSkillProf,
                3,
                data::FilterSkills));
    }
    private void createWeaponQ(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Weapon.Saber));
        opts.add(new EquipmentOption(1, Weapon.LongSword));
        for (var a:Weapon.values()) {
            if(a.isSimple){
                opts.add(new EquipmentOption(1,a));
            }
        }
        questionQueue.add(new AdvancedWeaponQuestion(
                "Выберите оружие из представленных",
                opts,
                data.toolLists::AddEquipment
        ));
    }
    private void createKitQ(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Kits.Diplomat));
        opts.add(new EquipmentOption(1, Kits.Artist));
        questionQueue.add(new AdvancedWeaponQuestion(
                    "Выберите набор из представленных",
                    opts,
                    data.toolLists::AddEquipment));
    }

}
