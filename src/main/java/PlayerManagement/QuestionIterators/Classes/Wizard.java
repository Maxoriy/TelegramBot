package PlayerManagement.QuestionIterators.Classes;

import Enums.Kits;
import Enums.SkillsEnum;
import Enums.StatsEnum;
import Enums.Weapon;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.QuestionIterators.Subclasses.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.AdvancedWeaponQuestion;
import PlayerManagement.questions.EquipmentOption;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Wizard extends ClassQuestions{
    public Wizard(SheetInfoHolder dat) {
        super(dat);
        data.gameNums.hitDice=6;
        data.toolLists.EquipmentProf.add("Кинжалы");
        data.toolLists.EquipmentProf.add("Дротики");
        data.toolLists.EquipmentProf.add("Пращи");
        data.toolLists.EquipmentProf.add("боевые посохи");
        data.toolLists.EquipmentProf.add("легкие арбалеты");
        data.numbers.SavingThrowProf.add(StatsEnum.Intelligence);
        data.numbers.SavingThrowProf.add(StatsEnum.Wisdom);
        data.toolLists.Equipment.add(new DefaultTool("Книга заклинаний","В этой книге хранятся ваши заклинания"));
        SkillQ();
        Equipment1();
        Equipment2();
        Equipment3();
        lvl1();
        AddCharacts();
        SubClassQ();
        lvl18();
        lvl20();
    }
    private void SkillQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        opts.add(SkillsEnum.History);
        opts.add(SkillsEnum.Arcana);
        opts.add(SkillsEnum.Medicine);
        opts.add(SkillsEnum.Insight);
        opts.add(SkillsEnum.Investigation);
        opts.add(SkillsEnum.Religion);
        questionQueue.add(new AdvancedSkillQuestion(
                opts,data.numbers::addSkillProf,2,
                data::FilterSkills

        ));
    }
    private void Equipment1(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Weapon.QuaterStaff));
        opts.add(new EquipmentOption(1, Weapon.Dagger));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите снаряжение из представленного",
                opts,data.toolLists::AddEquipment
                ));
    }
    private void Equipment2(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1,new DefaultTool("Мешочек с компонентами","")));
        opts.add(new EquipmentOption(1,new DefaultTool("Магическая фокусировка","")));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите снаряжение из представленного",
                opts,data.toolLists::AddEquipment));
    }
    private void Equipment3(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Kits.Traveller));
        opts.add(new EquipmentOption(1,Kits.Scientist));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите снаряжение из представленного",
                opts,data.toolLists::AddEquipment));
    }
    private void lvl1(){
        data.toolLists.Abilities.add(new DefaultTool("Использование заклинаний и книга заклинаний","Заклинательной характеристикой является Интеллект. Вы получаете книгу заклинаний, в которую можете копировать заклинания. Подробнее читайте в книге игрока"));
        data.toolLists.Abilities.add(new DefaultTool("Магическое восстановление","Вы знаете как восстанавливать часть магической энергии, изучая книгу заклинаний. Один раз в день, когда вы заканчиваете короткий отдых, вы можете восстановить часть использованных ячеек заклинаний. Ячейки заклинаний могут иметь суммарный уровень, который не превышает половину уровня вашего волшебника (округляя в большую сторону), и ни одна из ячеек не может быть шестого уровня или выше.\n" +
                "\n" +
                "Например, если вы волшебник 4-го уровня, вы можете восстановить ячейки заклинаний с суммой уровней не больше двух. Вы можете восстановить одну ячейку заклинаний 2-го уровня, или две ячейки заклинаний 1-го уровня."));

    }
    private void AddCharacts(){
        if(data.gameNums.level<4){return;}
        ImproveCharacteristicQ();
        if(data.gameNums.level<8){return;}
        ImproveCharacteristicQ();
        if(data.gameNums.level<12){return;}
        ImproveCharacteristicQ();

        if(data.gameNums.level<16){return;}
        ImproveCharacteristicQ();

        if(data.gameNums.level<19){return;}
        ImproveCharacteristicQ();
    }
    private void SubClassQ(){
        if(data.gameNums.level<3){return;}
        questionQueue.add(new SingleEntryUserQuestion("Выберите подкласс",new ArrayList<>(Arrays.asList(
                "Школа воплощения",
                "Школа вызова",
                "Школа иллюзии",
                "Школа некромантии",
                "Школа ограждения",
                "Школа очарования",
                "Школа преобразования",
                "Школа прорицания")),
                (a)->{
                    if(Objects.equals(a, "Школа воплощения")){
                        BackStoryTemplate sub=new WizzardVoploshenie(data,questionQueue);
                    }
                    if(Objects.equals(a, "Школа вызова")){
                        BackStoryTemplate sub=new WizardVizov(data,questionQueue);
                    }
                    if(Objects.equals(a, "Школа иллюзии")){
                        BackStoryTemplate sub=new WizardIllusion(data,questionQueue);
                    }
                    if(Objects.equals(a, "Школа некромантии")){
                        BackStoryTemplate sub=new WizardNecromancy(data,questionQueue);
                    }
                    if(Objects.equals(a, "Школа ограждения")){
                        BackStoryTemplate sub=new WizardOgrazdenie(data,questionQueue);
                    }
                    if(Objects.equals(a, "Школа очарования")){
                        BackStoryTemplate sub=new WizardOcharovanie(data,questionQueue);
                    }
                    if(Objects.equals(a, "Школа преобразования")){
                        BackStoryTemplate sub=new WizardTransmogrif(data,questionQueue);
                    }
                    if(Objects.equals(a, "Школа прорицания")){
                        BackStoryTemplate sub=new WizardProritzatel(data,questionQueue);
                    }
                }

        ));
    }

    private void lvl18(){
        if(data.gameNums.level<18){return;}
        data.toolLists.Abilities.add(new DefaultTool("Мастерство заклинателя","Вы достигаете такого мастерства в отношении некоторых заклинаний, что можете накладывать их неограниченное количество раз. Выберите одно заклинание волшебника 1-го уровня и одно заклинание волшебника 2-го уровня, которые есть в вашей книге заклинаний. Вы можете накладывать эти заклинания без увеличения их уровня, не тратя ячейки заклинаний, при условии, что вы их подготовили. Если вы хотите увеличить уровень этих заклинаний, вы должны потратить ячейку заклинаний как обычно.\n" +
                "\n" +
                "Потратив 8 часов на обучение, вы можете изменить одно или оба эти заклинания по своему усмотрению на заклинания тех же уровней."));
    }
    private void lvl20(){
        if(data.gameNums.level<20){return;}
        data.toolLists.Abilities.add(new DefaultTool("Фирменное заклинание","Вы получаете власть над двумя мощными заклинаниями и можете накладывать их без усилий. Выберите два заклинания волшебника 3-го уровня из своей книги заклинаний в качестве фирменных заклинаний. Для вас эти заклинания всегда считаются подготовленными, они не учитываются в количестве подготовленных заклинаний, и вы можете наложить каждое из этих заклинаний 3-го уровня, не тратя ячейку заклинаний. Когда вы так поступаете, вы не можете наложить их повторно таким же образом, пока не закончите короткий или продолжительный отдых.\n" +
                "\n" +
                "Если вы хотите наложить заклинание более высокого уровня, вы должны потратить ячейку заклинаний как обычно."));
    }

}
