package PlayerManagement.QuestionIterators.Classes;

import Enums.StatsEnum;
import Enums.Weapon;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.*;
import Enums.SkillsEnum;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.Arrays;

public class BarbarQuestions extends ClassQuestions {
    public BarbarQuestions(SheetInfoHolder data){
        super(data);


        questionQueue.add(createSkillsQuestion());
        questionQueue.add(createEquipmentQuestion());
        questionQueue.add(createSecondaryEquipQuestion());
        addEquipmentProf();
        data.gameNums.hitDice=12;
        data.numbers.SavingThrowProf.add(StatsEnum.Strength);
        data.numbers.SavingThrowProf.add(StatsEnum.Constitution);
        data.toolLists.AddEquipment(new DefaultTool("Набор путешественника",""));
        for (int i = 0; i < 4; i++) {
            data.toolLists.AddEquipment(Weapon.ThrowingSpear);
        }
    }
    private void addEquipmentProf(){
        data.toolLists.EquipmentProf.add("Легкие доспехи");
        data.toolLists.EquipmentProf.add("Средние доспехи");
        data.toolLists.EquipmentProf.add("Простое оружие");
        data.toolLists.EquipmentProf.add("Воинское оружие");
    }
    private UserQuestion createSkillsQuestion(){
        ArrayList<SkillsEnum>opts=new ArrayList<>(Arrays.asList(
                SkillsEnum.Athletics,
                SkillsEnum.Perception,
                SkillsEnum.Survival,
                SkillsEnum.Intimidation,
                SkillsEnum.Nature,
                SkillsEnum.Animal
        ));

        return new AdvancedSkillQuestion(
                opts,
                data.numbers::addSkillProf,
                3,
                data::FilterSkills);
    }
    private UserQuestion createEquipmentQuestion(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        for (var a:Weapon.values()) {
            if(a.isMelee && !a.isSimple){
                opts.add(new EquipmentOption(1,a));
            }
        }
        return new AdvancedWeaponQuestion("Выберите оружие из нижеперечисленных", opts,data.toolLists::AddEquipment);
    }
    private UserQuestion createSecondaryEquipQuestion(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(2,Weapon.HandAxe));
        for (var a:Weapon.values()) {
            if(a.isSimple){
                opts.add(new EquipmentOption(1,a));
            }
        }
        return new AdvancedWeaponQuestion("Выберите дополнительное оружие", opts,data.toolLists::AddEquipment);
    }

    public static void main(String[] args) {
        ArrayList<String>opts=new ArrayList<>(Arrays.asList(
                SkillsEnum.Athletics.getName(),
                SkillsEnum.Perception.getName(),
                SkillsEnum.Survival.getName(),
                SkillsEnum.Intimidation.getName(),
                SkillsEnum.Nature.getName(),
                SkillsEnum.Animal.getName()
        ));

        UserQuestion q= new MultipleEntryUserQuestion(
                "Выберите навык из нижеперечисленных",
                "Выберите дополнительно навык из нижеперечисленных",
                3,
                opts,
                System.out::println);

        q.SetAnswer(SkillsEnum.Athletics.getName());
        if (q.isAnswerOver()) {
            System.out.println("1");
        }

        q.SetAnswer(SkillsEnum.Perception.getName());
        if (q.isAnswerOver()) {
            System.out.println("1");
        }

        q.SetAnswer(SkillsEnum.Survival.getName());
        if (q.isAnswerOver()) {
            System.out.println("1");
        }

    }


}
