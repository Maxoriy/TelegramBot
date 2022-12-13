package PlayerManagement.QuestionIterators.Classes;

import Enums.*;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.QuestionIterators.Subclasses.*;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedSkillQuestion;
import PlayerManagement.questions.AdvancedWeaponQuestion;
import PlayerManagement.questions.EquipmentOption;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;
import org.checkerframework.checker.units.qual.A;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Cleric extends ClassQuestions{

    public Cleric(SheetInfoHolder dat) {
        super(dat);
        data.gameNums.hitDice=8;
        data.toolLists.EquipmentProf.add("Легкие доспехи");
        data.toolLists.EquipmentProf.add("Средние доспехи");
        data.toolLists.EquipmentProf.add("Щиты");
        data.toolLists.EquipmentProf.add("Простое оружие");
        data.numbers.SavingThrowProf.add(StatsEnum.Wisdom);
        data.numbers.SavingThrowProf.add(StatsEnum.Charisma);
        data.toolLists.Equipment.add(Armors.Shield);
        data.toolLists.Equipment.add(new DefaultTool("Священный символ",""));
        SkillQ();
        E1();
        E2();
        E3();
        E4();
        data.toolLists.Abilities.add(new DefaultTool("Заклинания домена","У каждого домена есть список заклинаний, которые вы получаете на новых уровнях жреца. Как только вы получаете заклинание домена, оно всегда считается подготовленным и не учитывается при подсчёте количества заклинаний, которые можно подготовить.\n" +
                "\n" +
                "Если вы получаете доступ к заклинанию, отсутствующему в списке заклинаний жреца, оно всё равно будет считаться для вас заклинанием жреца."));
        lvl1();
        SubClassQ();
        lvl2();
        AddCharacts();
        lvl5();
        lvl10();

    }
    private void SkillQ(){
        ArrayList<SkillsEnum> opts=new ArrayList<>();
        opts.add(SkillsEnum.History);
        opts.add(SkillsEnum.Medicine);
        opts.add(SkillsEnum.Insight);
        opts.add(SkillsEnum.Religion);
        opts.add(SkillsEnum.Persuasion);
        questionQueue.add(new AdvancedSkillQuestion(opts,data.numbers::addSkillProf,2,data::FilterSkills));
    }
    private void E1(){
        ArrayList<EquipmentOption> opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Weapon.Mace));
        opts.add(new EquipmentOption(1, Weapon.WarHammer));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите опцию из представленных. Учтите, что без соответствующего домена вы не сможете использовать боевой молот",opts,data.toolLists::AddEquipment));
    }
    private void E2(){
        ArrayList<EquipmentOption> opts =new ArrayList<>();
        opts.add(new EquipmentOption(1, Armors.Scale));
        opts.add(new EquipmentOption(1, Armors.Hide));
        opts.add(new EquipmentOption(1, Armors.Kolchuga));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите опцию из представленных. Учтите, что без соответствующего домена вы не сможете использовать кольчугу",opts,data.toolLists::AddEquipment));

    }
    private void E3(){
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
    private void E4(){
        ArrayList<EquipmentOption>opts=new ArrayList<>();
        opts.add(new EquipmentOption(1, Kits.Traveller));
        opts.add(new EquipmentOption(1, Kits.Priest));
        questionQueue.add(new AdvancedWeaponQuestion("Выберите опцию из представленных",opts,data.toolLists::AddEquipment));
    }
    private void lvl1(){
        data.toolLists.Abilities.add(new DefaultTool("Использование заклинаний","Базовой характеристикой вашей магии является мудрость. Подробнее об этом умении читайте в книге игрока"));
    }
    private void SubClassQ(){
        if(data.gameNums.level<3){return;}
        questionQueue.add(new SingleEntryUserQuestion("Выберите подкласс",new ArrayList<>(Arrays.asList(
                "Домен бури",
                "Домен войны",
                "Домен жизни",
                "Домен знаний",
                "Домен обмана",
                "Домен природы",
                "Домен света")),
                (a)->{
                    if(Objects.equals(a, "Домен бури")){
                        BackStoryTemplate sub=new ClericBura(data,questionQueue);
                    }
                    if(Objects.equals(a, "Домен войны")){
                        BackStoryTemplate sub=new ClericWar(data,questionQueue);
                    }
                    if(Objects.equals(a, "Домен жизни")){
                        BackStoryTemplate sub=new ClericLife(data,questionQueue);
                    }
                    if(Objects.equals(a, "Домен знаний")){
                        BackStoryTemplate sub=new ClericZnania(data,questionQueue);
                    }
                    if(Objects.equals(a, "Домен обмана")){
                        BackStoryTemplate sub=new ClericObman(data,questionQueue);
                    }
                    if(Objects.equals(a, "Домен природы")){
                        BackStoryTemplate sub=new ClericNature(data,questionQueue);
                    }
                    if(Objects.equals(a, "Домен света")){
                        BackStoryTemplate sub=new ClericLight(data,questionQueue);
                    }
                }

        ));
    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный канал","Вы получаете возможность направлять божественную энергию непосредственно от своего божества, используя её для подпитки магических эффектов. Вы начинаете с двумя такими эффектами: «Изгнание Нежити» и эффектом, определяемым вашим доменом. Некоторые домены дают вам дополнительные эффекты, как только вы получите новые уровни.\n" +
                "\n" +
                "Когда вы используете «Божественный канал», вы выбираете, какой эффект создать. Затем вы должны окончить короткий или продолжительный отдых, чтобы использовать «Божественный канал» снова. Некоторые эффекты «Божественного канала» требуют совершить спасбросок. Когда вы используете эффекты такого рода, Сл равна Сл спасброска от ваших заклинаний жреца.\n" +
                "\n" +
                "Начиная с 6-го уровня вы можете использовать «Божественный канал» дважды перед отдыхом, а начиная с 18-го уровня вы можете использовать его три раза перед отдыхом: по окончании короткого или продолжительного отдыха вы восстановите все потраченные использования.\n" +
                "\n" +
                "БОЖЕСТВЕННЫЙ КАНАЛ: ИЗГНАНИЕ НЕЖИТИ\n" +
                "Вы действием демонстрируете свой священный символ и читаете молитву, изгоняющую Нежить. Вся Нежить, которая может видеть или слышать вас в пределах 30 футов, должна совершить спасбросок Мудрости. Если существо провалило спасбросок, оно изгоняется на 1 минуту, или пока не получит урон. Изгнанное существо должно тратить свои ходы, пытаясь уйти от вас как можно дальше, и не может добровольно переместиться в пространство, находящееся в пределах 30 футов от вас. Оно также не может совершать реакции. Действием существо может использовать только Рывок или пытаться освободиться от эффекта, препятствующего его передвижению. Если двигаться некуда, существо может использовать действие Уклонение."));
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
        data.toolLists.Abilities.add(new DefaultTool("Уничтожение нежити","Когда Нежить проваливает спасбросок от вашего умения «Изгнание Нежити», существо мгновенно уничтожается, если его показатель опасности не превышает значения, указанного в таблице:\n" +
                "\n" +
                "Уровень жреца\tУничтожается Нежить с ПО...\n" +
                "5\t1/2 или ниже\n" +
                "8\t1 или ниже\n" +
                "11\t2 или ниже\n" +
                "14\t3 или ниже\n" +
                "17\t4 или ниже"));
    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественное вмешательство","Вы можете воззвать к своему божеству о помощи, когда сильно в этом нуждаетесь. Мольба о помощи совершается действием. Опишите помощь, которую вы ждёте, и киньте процентную кость. Если выпадет число, не превышающее ваш уровень жреца, ваше божество вмешается. Мастер сам выбирает природу вмешательства; подойдёт эффект какого-либо заклинания жреца или заклинания домена.\n" +
                "\n" +
                "Если божество вмешивается, вы не можете использовать это умение в течение 7 дней. В противном случае вы можете использовать это умение после продолжительного отдыха. На 20-м уровне ваше воззвание автоматически успешно и не требует проверки."));
    }

}
