package PlayerManagement.QuestionIterators.Classes;


import Enums.*;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.QuestionIterators.Subclasses.MysticKnight;
import PlayerManagement.QuestionIterators.Subclasses.WarrirorChampion;
import PlayerManagement.QuestionIterators.Subclasses.WeaponMaster;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.*;
import Tools.DefaultTool;
import Tools.ITool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

        BattleStyleQ();

        int lvl=data.gameNums.level;

        data.toolLists.Abilities.add(new DefaultTool("Второе дыхание","Вы обладаете ограниченным источником выносливости, которым можете воспользоваться, чтобы уберечь себя. В свой ход вы можете бонусным действием восстановить хиты в размере 1к10 + ваш уровень воина.\n" +
                "\n" +
                "Использовав это умение, вы должны завершить короткий либо продолжительный отдых, чтобы получить возможность использовать его снова."));
        if(lvl<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Всплеск действий","Вы получаете возможность на мгновение преодолеть обычные возможности. В свой ход вы можете совершить одно дополнительное действие помимо обычного и бонусного действий. Использовав это умение, вы должны завершить короткий или продолжительный отдых, чтобы получить возможность использовать его снова. Начиная с 17-го уровня, вы можете использовать это умение дважды, прежде чем вам понадобится отдых, но в течение одного хода его всё равно можно использовать лишь один раз."));
        if(lvl<4){return;}
        ImproveCharacteristicQ();
        if(lvl<5){return;}

        data.toolLists.Abilities.add(new DefaultTool("Дополнительная атака","Если вы в свой ход совершаете действие Атака, вы можете совершить две атаки вместо одной.\n" +
                "\n" +
                "Количество атак увеличивается до трёх на 11-м уровне этого класса, и до четырёх на 20-м уровне."));

        if(lvl<6){return;}
        ImproveCharacteristicQ();
        if(lvl<8){return;}
        ImproveCharacteristicQ();

        if(lvl<9){return;}

        data.toolLists.Abilities.add(new DefaultTool("Упорный","Вы можете перебросить проваленный спасбросок и должны использовать новый результат. После этого вы можете повторно использовать это умение только после завершения продолжительного отдыха.\n" +
                "\n" +
                "Вы можете использовать это умение дважды между периодами продолжительного отдыха после достижения 13-го уровня, и трижды после достижения 17-го уровня.\n" +
                "\n"));

        if(lvl<12){return;}
        ImproveCharacteristicQ();
        if(lvl<14){return;}
        ImproveCharacteristicQ();
        if(lvl<16){return;}
        ImproveCharacteristicQ();
        if(lvl<19){return;}
        ImproveCharacteristicQ();
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
    private void BattleStyleQ(){
        HashMap<String,String> a=new HashMap<>();
        a.put("Дуэлянт","Пока вы держите рукопашное оружие в одной руке и не используете другого оружия, вы получаете бонус +2 к броскам урона этим оружием.");
        a.put("Защита","Если существо, которое вы видите, атакует не вас, а другое существо, находящееся в пределах 5 футов от вас, вы можете реакцией создать помеху его броску атаки. Для этого вы должны использовать щит.");
        a.put("Оборона","Пока вы носите доспехи, вы получаете бонус +1 к КД.");
        a.put("Сражение большим оружием","Если у вас выпало «1» или «2» на кости урона оружия при атаке, которую вы совершали рукопашным оружием, удерживая его двумя руками, то вы можете перебросить эту кость, и должны использовать новый результат, даже если снова выпало «1» или «2». Чтобы воспользоваться этим преимуществом, ваше оружие должно иметь свойство « двуручное» или «универсальное».");
        a.put("Сражение двумя оружиями","Если вы сражаетесь двумя оружиями, вы можете добавить модификатор характеристики к урону от второй атаки.");
        a.put("Стрельба","Вы получаете бонус +2 к броску атаки, когда атакуете дальнобойным оружием.");
        questionQueue.add(new SingleEntryUserQuestion("Выберите боевой стиль из представленных",new ArrayList<>(a.keySet()),
                (s)->{
                    data.toolLists.Abilities.add(new DefaultTool(s,a.get(s)));
                } ));
    }

    private void SubClassQ(){
        if(data.gameNums.level<3){return;}
        questionQueue.add(new SingleEntryUserQuestion("Выберите подкласс",new ArrayList<>(Arrays.asList("Мастер боевых искусств","Мистический рыцарь","Чемпион")),
                (a)->{
                    if(Objects.equals(a, "Мастер боевых искусств")){
                        BackStoryTemplate sub=new WeaponMaster(data,questionQueue);
                    }
                    if(Objects.equals(a, "Мистический рыцарь")){
                        BackStoryTemplate sub=new MysticKnight(data,questionQueue);
                    }
                    if(Objects.equals(a, "Чемпион")){
                        BackStoryTemplate sub=new WarrirorChampion(data,questionQueue);
                    }
                }

                ));
    }




}
