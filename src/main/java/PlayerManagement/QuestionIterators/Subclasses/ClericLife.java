package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class ClericLife extends BackStoryTemplate {
    public ClericLife(SheetInfoHolder d, ArrayList<UserQuestion> a) {
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
        data.toolLists.Abilities.add(new DefaultTool("Бонусное владение","Вы осваиваете владение тяжелыми доспехами."));
        data.toolLists.Abilities.add(new DefaultTool("Поборник природы","Ваши лечащие заклинания становятся более эффективными. Каждый раз, когда вы используете заклинание 1-го уровня или выше, восстанавливающее хиты существу, это существо восстанавливает дополнительно число хитов, равное 2 + уровень заклинания."));

    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный канал: Сохранение жизни","Вы можете использовать «Божественный канал», чтобы лечить тяжёлые ранения. Вы действием демонстрируете свой священный символ и призываете целительную энергию, которая может восстановить число хитов, равное вашему уровню жреца, умноженному на пять. Выберите любых существ в пределах 30 футов от себя и распределите эти хиты между ними. Это умение не может восстановить существу хиты выше половины от его максимума. Вы не можете использовать это умение на Нежити и Конструктах.\n"
                ));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Благословенный целитель","Заклинания лечения, которое вы накладываете на других, также лечат и вас. Когда вы накладываете заклинание 1-го уровня или выше, которое восстанавливает хиты другому существу, вы восстанавливаете себе число хитов, равное 2 + уровень заклинания."));

    }
    private void lvl8(){
        if(data.gameNums.level<8){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный удар","Вы получаете способность наполнять удары своего оружия божественной энергией. Один раз в каждый свой ход, когда вы попадаете по существу атакой оружием, вы можете причинить цели дополнительный урон излучением 1к8. Когда вы достигаете 14-го уровня, дополнительный урон возрастает до 2к8.\n" +
                "\n"));

    }
    private void lvl17(){
        if(data.gameNums.level<17){return;}
        data.toolLists.Abilities.add(new DefaultTool("Высшее исцеление","Если вы должны бросить одну или несколько костей, чтобы восстановить заклинанием хиты, вы для каждой кости используете максимальное значение. Например, вместо восстановления существу 2к6 хитов, вы восстанавливаете 12."));
        data.toolLists.Abilities.add(new DefaultTool("",""));


    }
}
