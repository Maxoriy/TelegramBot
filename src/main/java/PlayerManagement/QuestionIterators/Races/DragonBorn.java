package PlayerManagement.QuestionIterators.Races;

import Enums.Languages;
import Enums.StatsEnum;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;
import Tools.ITool;


import java.util.ArrayList;
import java.util.Objects;

public class DragonBorn extends BackStoryTemplate {
    public DragonBorn(SheetInfoHolder d) {
        super(d);
        data.numbers.addStatValue(StatsEnum.Strength.getName(), 2);
        data.numbers.addStatValue(StatsEnum.Charisma.getName(), 1);
        data.toolLists.Abilities.add(new DefaultTool("Возраст драконорожденных","Юные драконорождённые растут быстро. Они начинают ходить через час после вылупления, к трём годам достигают роста и сложения 10-летнего человека, и становятся взрослыми в 15. Живут они примерно до 80 лет."));
        data.toolLists.Abilities.add(new DefaultTool("Размер(Средний)","Драконорождённые выше и тяжелее людей, их рост заметно больше 6 футов (1,8 метра) и вес около 250 фунтов (115 килограмм). Ваш размер — Средний."));
        data.gameNums.speed=30;
        DragonShit();
        data.toolLists.EquipmentProf.add(Languages.Common.name);
        data.toolLists.EquipmentProf.add(Languages.Dragon.name);
    }
    private void DragonShit(){

         class dragonSh implements ITool{

            public dragonSh(String nme, int typeOfDamage, int typeOfBreath) {
                 this.nme = nme;
                 switch (typeOfDamage){
                     case 1: TypeOfDamage="Холод";
                     case 2: TypeOfDamage="Электричество";
                     case 3: TypeOfDamage="Яд";
                     case 4: TypeOfDamage="Огонь";
                     case 5: TypeOfDamage="Кислота";
                 }
                 switch (typeOfBreath){
                     case 1:TypeOfBreath="15 футов конус (спас. ТЕЛ)";
                     case 2:TypeOfBreath="Линия 5 на 30 футов (спас. ЛОВ)";
                 }
             }
            public String getstr(){
                 return nme+"Вид урона: "+TypeOfDamage+" Вид оружия дыхания: "+TypeOfBreath;
            }
             public String nme;
            public String TypeOfDamage;
            public String TypeOfBreath;

             @Override
             public String getName() {
                 return nme;
             }

             @Override
             public String getDescription() {
                 return "Вид урона: "+TypeOfDamage+" Вид оружия дыхания: "+TypeOfBreath;
             }
         }
        ArrayList<dragonSh> opts=new ArrayList<>();
        opts.add(new dragonSh("Наследие белого дракона",1,1));
        opts.add(new dragonSh("Наследие бронзового дракона",2,2));
        opts.add(new dragonSh("Наследие зеленого дракона",3,1));
        opts.add(new dragonSh("Наследие золотого дракона",4,1));
        opts.add(new dragonSh("Наследие красного дракона",4,1));
        opts.add(new dragonSh("Наследие латунного дракона",4,2));
        opts.add(new dragonSh("Наследие медного дракона",5,2));
        opts.add(new dragonSh("Наследие серебрянного дракона",1,1));
        opts.add(new dragonSh("Наследие синего дракона",2,2));
        opts.add(new dragonSh("Наследие черного дракона",5,2));
        ArrayList<String> ropts=new ArrayList<>();
        for (var a:opts
             ) {ropts.add(a.getstr());
        }
        questionQueue.add(new SingleEntryUserQuestion(
                "выберите свое наследие дракона",
                ropts,
                (str_a)->{
                    for (var a:opts) {
                        if(Objects.equals(a.getstr(), str_a)){
                            data.toolLists.Abilities.add(a);
                            data.toolLists.Abilities.add(new DefaultTool("Сопротивление урону: "+a.TypeOfDamage,"Вы получаете сопротивление урону того вида, который указан в вашем наследии драконов."));
                            data.toolLists.Abilities.add(new DefaultTool("Оружие дыхания","Вы можете действием выдохнуть разрушительную энергию. Ваше наследие драконов определяет размер, форму и вид урона вашего выдоха.\n" +
                                    "\n" +
                                    "Когда вы используете оружие дыхания, все существа в зоне выдоха должны совершить спасбросок, вид которого определяется вашим наследием. Сложность этого спасброска равна 8 + ваш модификатор Телосложения + ваш бонус мастерства. Существа получают урона 2к6 в случае проваленного спасброска, или половину этого урона, если спасбросок был успешен. Урон повышается до 3к6 на 6-м уровне, до 4к6 на 11-м, и до 5к6 на 16-м уровне."));
                        }
                    }

                }
    ));
    }
}
