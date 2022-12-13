package PlayerManagement.QuestionIterators.Classes;

import Enums.StatsEnum;
import Enums.Weapon;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.QuestionIterators.Subclasses.BarBarBerserker;
import PlayerManagement.QuestionIterators.Subclasses.BarBarTotemWarrior;
import PlayerManagement.QuestionIterators.Subclasses.DruidEarth;
import PlayerManagement.QuestionIterators.Subclasses.DruidMoon;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.*;
import Enums.SkillsEnum;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
        lvl1();
        lvl2();
        SubClassQ();
        AddCharacts();
        lvl5();
        lvl7();
        lvl9();
        lvl11();
        lvl15();
        lvl18();
        lvl20();
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
    private void lvl1(){
        data.toolLists.Abilities.add(new DefaultTool("Защита без доспехов","Если вы не носите доспехов, ваш Класс Доспеха равен 10 + модификатор Ловкости + модификатор Телосложения. Вы можете использовать щит, не теряя этого преимущества."));
        data.toolLists.Abilities.add(new DefaultTool("Ярость","В бою вы сражаетесь с первобытной свирепостью. В свой ход вы можете бонусным действием войти в состояние ярости.\n" +
                "\n" +
                "В состоянии ярости вы получаете следующие преимущества, если не носите тяжёлую броню:\n" +
                "\n" +
                "Вы совершаете с преимуществом проверки и спасброски Силы.\n" +
                "Если вы совершаете рукопашную атаку оружием, используя Силу, вы получаете бонус к броску урона, соответствующий вашему уровню варвара, как показано в колонке «урон ярости» таблицы «Варвар».\n" +
                "Вы получаете сопротивление дробящему, колющему и рубящему урону.\n" +
                "Если вы способны накладывать заклинания, то вы не можете накладывать или концентрироваться на заклинаниях, пока находитесь в состоянии ярости.\n" +
                "\n" +
                "Ваша ярость длится 1 минуту. Она прекращается раньше, если вы потеряли сознание или если вы закончили ход, не получив урон или не атаковав враждебное по отношению к вам существо с момента окончания прошлого хода. Также вы можете прекратить свою ярость бонусным действием.\n" +
                "\n" +
                "Если вы впадали в состояние ярости максимальное для вашего уровня количество раз (смотрите колонку «ярость»), то вы должны совершить продолжительный отдых, прежде чем сможете использовать ярость еще раз."));

    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Безрассудная атака","Вы способны отбросить любую заботу о защите, чтобы атаковать ожесточённо и безрассудно. Когда вы совершаете первую атаку в свой ход, вы можете решить, что будете атаковать безрассудно. Решившись на это, вы в этом ходу совершаете рукопашные атаки оружием, использующие Силу, с преимуществом, но все броски атаки по вам до вашего следующего хода тоже совершаются с преимуществом."));
        data.toolLists.Abilities.add(new DefaultTool("Чувство опасности","Вы получаете обострённое ощущение происходящего вокруг, помогающее вам избегать опасности.\n" +
                "\n" +
                "Вы совершаете с преимуществом спасброски Ловкости от эффектов, которые вы можете видеть, такие как заклинания и ловушки. Для использования этого преимущества вы не должны быть ослеплены, оглушены и не должны быть недееспособны."));
    }
    private void SubClassQ(){
        if(data.gameNums.level<3){return;}
        questionQueue.add(new SingleEntryUserQuestion("Выберите подкласс",new ArrayList<>(Arrays.asList("Путь берсерка","Путь тотемного воина")),
                (a)->{
                    if(Objects.equals(a, "Путь берсерка")){
                        BackStoryTemplate sub=new BarBarBerserker(data,questionQueue);
                    }
                    if(Objects.equals(a, "Путь тотемного воина")){
                        BackStoryTemplate sub=new BarBarTotemWarrior(data,questionQueue);
                    }

                }

        ));
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
    private void lvl5(){
        if(data.gameNums.level<5){return;}
        data.toolLists.Abilities.add(new DefaultTool("Быстрое передвижение","Ваша скорость увеличивается на 10 футов, если вы не носите тяжёлые доспехи."));
        data.toolLists.Abilities.add(new DefaultTool("Дополнительная атака","Если вы в свой ход совершаете действие Атака, вы можете совершить две атаки вместо одной."));
    }
    private void lvl7(){
        if(data.gameNums.level<7){return;}
        data.toolLists.Abilities.add(new DefaultTool("Дикий инстинкт","Ваши инстинкты настолько обостряются, что вы совершаете с преимуществом броски инициативы.\n" +
                "\n" +
                "Кроме того, если вы были захвачены врасплох в начале боя, и вы не являетесь недееспособным, вы можете в первом ходу действовать нормальным образом, но только если вы впадёте в ярость раньше всех других действий в этом ходу."));
    }
    private void lvl9(){
        if(data.gameNums.level<9){return;}
        data.toolLists.Abilities.add(new DefaultTool("Сильный критический удар","Вы можете бросать одну дополнительную кость урона оружия, когда определяете дополнительный урон от критического попадания рукопашной атакой. Количество костей увеличивается до двух на 13-м уровне и трёх на 17-м уровне."));
    }
    private void lvl11(){
        if(data.gameNums.level<11){return;}
        data.toolLists.Abilities.add(new DefaultTool("Непреклонная ярость","Ваша ярость позволяет вам сражаться, несмотря на тяжелейшие раны. Если ваши хиты опускаются до 0, когда вы в состоянии ярости, и вы не умерли сразу, вы можете совершить спасбросок Телосложения Сл 10. При успехе ваши хиты опускаются всего лишь до 1 хита.\n" +
                "\n" +
                "Каждый раз, когда вы используете это умение повторно, Сл спасброска повышается на 5. Когда вы закончите короткий либо продолжительный отдых, Сл снова равняется 10."));
    }
    private void lvl15(){
        if(data.gameNums.level<15){return;}
        data.toolLists.Abilities.add(new DefaultTool("Непрерывная ярость","Ваша ярость становится настолько сильной, что досрочно прекращается, только если вы теряете сознание или сами прекращаете её."));
    }
    private void lvl18(){
        if(data.gameNums.level<18){return;}
        data.toolLists.Abilities.add(new DefaultTool("Неукротимая мощь","Если результат вашей проверки Силы оказался меньше значения вашей Силы, то вы можете использовать значение характеристики вместо результата проверки."));
    }
    private void lvl20(){
        if(data.gameNums.level<20){return;}
        data.toolLists.Abilities.add(new DefaultTool("Дикий чемпион","Вы становитесь воплощением силы дикой природы. Значение ваших Силы и Телосложения увеличивается на 4. Максимальное значение для этих характеристик теперь 24."));
    }

}
