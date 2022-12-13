package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class ClericBura extends BackStoryTemplate {

    public ClericBura(SheetInfoHolder d, ArrayList<UserQuestion>a) {
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
        data.toolLists.Abilities.add(new DefaultTool("Гнев бури","Вы можете громогласно покарать атакующих. Если существо в пределах 5 футов от вас, которое вы можете видеть, успешно попадает по вам атакой, вы можете реакцией заставить существо совершить спасбросок Ловкости. Существо получает урона звуком или электричеством (по вашему выбору) 2к8, если провалит спасбросок, и половину этого урона если преуспеет. Вы можете использовать это умение количество раз, равное вашему модификатору Мудрости (минимум 1 раз). Вы восстанавливаете все потраченные применения, когда завершаете продолжительный отдых."));

    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный канал: Разрушительный рев","Вы можете использовать «Божественный канал», чтобы овладеть могуществом бури с необузданной свирепостью.\n" +
                "\n" +
                "Когда вы совершаете бросок урона звуком или электричеством, вы можете использовать «Божественный канал», чтобы нанести максимальный урон вместо броска."));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Удар грома","Когда вы наносите урон электричеством существу с размером Большое или меньше, вы также можете оттолкнуть его на 10 футов от себя."));

    }
    private void lvl8(){
        if(data.gameNums.level<8){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный удар","Вы получаете способность наполнять удары своего оружия божественной энергией. Один раз в каждый свой ход, когда вы попадаете по существу атакой оружием, вы можете причинить цели дополнительный урон звуком 1к8. Когда вы достигаете 14-го уровня, дополнительный урон возрастает до 2к8."));

    }
    private void lvl17(){
        if(data.gameNums.level<17){return;}
        data.toolLists.Abilities.add(new DefaultTool("Рожденный бурей","У вас появляется скорость полёта, равная вашей текущей наземной скорости ходьбы, когда вы не под землёй и не в помещении."));
        data.toolLists.Abilities.add(new DefaultTool("",""));


    }
}
