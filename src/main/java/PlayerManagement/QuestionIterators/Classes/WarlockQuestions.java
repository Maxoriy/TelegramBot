package PlayerManagement.QuestionIterators.Classes;

import Enums.*;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.QuestionIterators.Subclasses.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.*;
import Tools.DefaultTool;
import Tools.ITool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class WarlockQuestions extends ClassQuestions {

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
        data.toolLists.Abilities.add(new DefaultTool("Расширенный список заклинаний","Ваш покровитель расширяет список заклинаний, доступных вам. Подробнее читайте в книге игрока"));
        SubClassQ();
        lvl2();
        dogovor();
        AddCharacts();
        Arcanum();
        ArcaneMaster();
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
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Таинственные воззвания","В процессе изучения оккультных знаний вы раскопали таинственные воззвания: фрагменты запрещенных знаний, которые даруют магические способности.\n" +
                "\n" +
                "Вы получаете два воззвания на свой выбор. Смотрите список воззваний. Получая новые уровни колдуна, вы получаете дополнительные воззвания на свой выбор, как показано в колонке «известные воззвания».\n" +
                "\n" +
                "Кроме того, когда вы получаете новый уровень этого класса, вы можете выбрать одно известное вам воззвание и заменить его другим, которое вы способны выучить на этом уровне."));
    }
    private void dogovor(){
        if(data.gameNums.level<3){return;}
        HashMap<String,String> opts=new HashMap<>();
        opts.put("Договор гримуара","Ваш покровитель дарует вам гримуар, который называется «Книга теней». Когда вы получаете это умение, выберите 3 заговора из списков любых классов. Пока книга с вами, вы можете применять эти заговоры неограниченно. Они не учитываются при подсчёте максимального числа заговоров, которые вы можете знать, и считаются для вас заклинаниями колдуна.\n" +
                "\n" +
                "Если вы теряете книгу, вам нужно провести ритуал длительностью в 1 час, чтобы получить замену от своего покровителя. Вы можете провести этот ритуал во время короткого или продолжительного отдыха. Предыдущая книга при этом уничтожается. Книга обращается в прах при вашей смерти.");
        opts.put("Договор клинка","Вы можете действием создать оружие договора в своей пустой руке. Вы сами выбираете форму этого рукопашного оружия каждый раз, когда создаёте. Вы получаете владение этим оружием, пока используете его. Оружие считается магическим при определении преодоления сопротивления и иммунитета от немагических атак и урона.\n" +
                "\n" +
                "Оружие договора исчезает, если оно в течении 1 минуты находится дальше 5 футов от вас. Оно также исчезает, если вы используете это умение еще раз, отзываете оружие (действие не требуется), или умираете. Вы можете трансформировать одно магическое оружие в своё оружие договора, проведя специальный ритуал, держа это оружие. Ритуал совершается 1 час, его можно провести во время короткого отдыха. Впоследствии вы можете отозвать оружие, помещая его между измерениями. Оно будет появляться в руке, когда вы будете в дальнейшем создавать оружие договора. Вы не можете сделать это с артефактом или разумным оружием. Оружие перестаёт быть оружием договора, когда вы умираете, выполняете часовой ритуал с другим оружием или когда вы исполните ритуал длиной в час для того, чтобы разорвать связь. Оружие материализуется у ваших ног, если в момент разрыва связи оно находилось между измерениями.");
        opts.put("Договор цепи","Вы узнаёте заклинание поиск фамильяра [find familiar] и можете сотворять его как ритуал. Это заклинание не учитывается при подсчёте числа заклинаний, которые вы можете знать.\n" +
                "\n" +
                "Когда вы накладываете это заклинание, вы можете выбрать одну из обычных форм для вашего фамильяра, либо одну из особых форм: бес [imp], квазит [quasit], псевдодракон [pseudodragon] или спрайт [sprite].\n" +
                "\n" +
                "Кроме того, когда вы совершаете действие Атака, вы можете вместо одной своей атаки позволить атаковать один раз фамильяру. При этом он совершает свою атаку реакцией.");
        questionQueue.add(new SingleEntryUserQuestion("Выберите предмет договора",new ArrayList<>(opts.keySet()),
                (str)->{
                    data.toolLists.Abilities.add(new DefaultTool(str,opts.get(str)));
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
    private void Arcanum(){
        if(data.gameNums.level<11){
            return;
        }
        data.toolLists.Abilities.add(new DefaultTool("Таинственный арканум","Ваш покровитель дарует вам магический секрет, называемый арканумом. Выберите одно заклинание 6-го уровня из списка заклинаний колдуна в качестве арканума.\n" +
                "\n" +
                "Вы можете наложить это заклинание, не используя ячейку заклинаний. Вы должны окончить продолжительный отдых, чтобы сделать это еще раз.\n" +
                "\n" +
                "На следующих уровнях вы получаете новые заклинания, которые можно применить таким образом — одно 7-го уровня на 13-м уровне, одно 8-го уровня на 15-м уровне и одно 9-го уровня на 17-м уровне. После окончания продолжительного отдыха вы восстанавливаете все потраченные использования арканумов."));
    }
    private void ArcaneMaster(){
        if(data.gameNums.level<20){
            return;
        }
        data.toolLists.Abilities.add(new DefaultTool("Таинственный мастер","Вы можете обратиться к внутреннему резерву мистической силы, умоляя при этом покровителя восстановить потраченные ячейки заклинаний. Вам надо потратить 1 минуту, умоляя покровителя, чтобы восстановить все использованные ячейки заклинаний, дарованные умением «Магия договора». Вы должны закончить продолжительный отдых, чтобы применить это умение вновь."));
    }
    private void SubClassQ(){
        if(data.gameNums.level<3){return;}
        questionQueue.add(new SingleEntryUserQuestion("Выберите подкласс",new ArrayList<>(Arrays.asList("Архифея","Исчадие","Великий древний")),
                (a)->{
                    if(Objects.equals(a, "Архифея")){
                        BackStoryTemplate sub=new WarlockFei(data,questionQueue);
                    }
                    if(Objects.equals(a, "Исчадие")){
                        BackStoryTemplate sub=new WarlockDevil(data,questionQueue);
                    }
                    if(Objects.equals(a, "Великий древний")){
                        BackStoryTemplate sub=new WarlockCtylhu(data,questionQueue);
                    }
                }

        ));
    }
}
