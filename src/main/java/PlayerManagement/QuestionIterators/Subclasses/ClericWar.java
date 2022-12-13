package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class ClericWar extends BackStoryTemplate {
    public ClericWar(SheetInfoHolder d, ArrayList<UserQuestion> a) {
        super(d);
        questionQueue = a;
        lvl1();
        lvl2();
        lvl6();
        lvl8();
        lvl17();
    }
    private void lvl1(){
        if(data.gameNums.level<1){return;}
        data.toolLists.Abilities.add(new DefaultTool("Бонусное владение","Вы осваиваете владение воинским оружием и тяжелыми доспехами."));
        data.toolLists.Abilities.add(new DefaultTool("Боевой священник","Ваш бог наделяет вас воодушевлением, когда вы вступаете в битву. Когда вы используете действие Атака, вы можете совершить одну атаку оружием бонусным действием. Вы можете использовать это умение количество раз, равное вашему модификатору Мудрости (минимум 1 раз). Вы восстанавливаете все потраченные использования, когда завершаете продолжительный отдых.\n"));

    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный канал: Направленный удар","Вы можете использовать «Божественный канал», чтобы нанести удар со сверхъестественной точностью. Когда вы совершаете бросок атаки, вы можете использовать «Божественный канал», чтобы получить бонус +10 к броску. Вы можете решить, применять ли это умение, после того как увидите результат броска, но до того как Мастер скажет, попала атака или промахнулась.\n" +
                "\n"));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный канал: Благословение бога войны","Если существо в пределах 30 футов от вас совершает бросок атаки, вы можете реакцией предоставить этому существу бонус +10 к броску, использовав «Божественный канал». Вы можете решить, применять ли это умение, после того как увидели результат броска, но до того как Мастер скажет, попала атака или промахнулась."));

    }
    private void lvl8(){
        if(data.gameNums.level<8){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный удар","Вы получаете способность наполнять удары своего оружия божественной энергией. Один раз в каждый свой ход, когда вы попадаете по существу атакой оружием, вы можете причинить цели дополнительный урон 1к8 того же вида, что и у оружия. Когда вы достигаете 14 уровня, дополнительный урон увеличивается до 2к8."));

    }
    private void lvl17(){
        if(data.gameNums.level<17){return;}
        data.toolLists.Abilities.add(new DefaultTool("Воплощение битвы","Вы получаете сопротивление дробящему, колющему и рубящему урону от немагических атак."));
        data.toolLists.Abilities.add(new DefaultTool("",""));
    }
}
