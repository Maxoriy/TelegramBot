package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class WarlockDevil extends BackStoryTemplate {
    public WarlockDevil(SheetInfoHolder d, ArrayList<UserQuestion> a) {
        super(d);
        questionQueue=a;
        lvl1();
        lvl6();
        lvl10();
        lvl14();
    }
    private void lvl1(){
        data.toolLists.Abilities.add(new DefaultTool("Благословение темнейшего","Когда вы опускаете хиты враждебного существа до 0, вы получаете временные хиты, равные вашему модификатору Харизмы + ваш уровень колдуна (минимум 1)."));
    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Удача темнейшего","Вы можете воззвать к своему покровителю, чтобы изменить судьбу в свою пользу. Когда вы совершаете проверку характеристики или спасбросок, вы можете использовать это умение, чтобы добавить к10 к броску. Вы можете так сделать после основного броска, но до того, как его эффект вступит в силу.\n" +
                "\n" +
                "Использовав это умение, вы не можете использовать его снова до окончания короткого или продолжительного отдыха."));
    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Устойчивость исчадия","Вы можете выбрать один вид урона, когда заканчиваете короткий или продолжительный отдых. Вы получаете сопротивление этому виду урона, пока вы не выберете другой вид урона при помощи этого умения. Урон от магического или серебряного оружия игнорирует это сопротивление."));
    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Бросок сквозь ад","Когда вы попадаете по существу атакой, вы можете использовать это умение, чтобы мгновенно переместить цель сквозь нижние планы. Существо исчезает и несётся через кошмарный ландшафт.\n" +
                "\n" +
                "В конце вашего следующего хода цель возвращается в пространство, которое занимало, или ближайшее свободное пространство. Если цель — не исчадие, она получает урон психической энергией 10к10 от испытанных жутких ощущений.\n" +
                "\n" +
                "Использовав это умение, вы не можете использовать его снова до окончания продолжительного отдыха."));

    }
}
