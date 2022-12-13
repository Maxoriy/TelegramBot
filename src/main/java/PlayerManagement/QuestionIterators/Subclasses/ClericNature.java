package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class ClericNature extends BackStoryTemplate {
    public ClericNature(SheetInfoHolder d, ArrayList<UserQuestion> a) {
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
        data.toolLists.Abilities.add(new DefaultTool("Бонусное владение","Вы получаете владение тяжёлыми доспехами."));

        data.toolLists.Abilities.add(new DefaultTool("Послушник природы","Вы изучаете один заговор друида на свой выбор. Этот заговор считается заговором жреца для вас, но он не учитывается в общем количестве известных вам заговоров жреца. Вы также получаете владение одним из следующих навыков: Выживание, Природа, Уход за животными."));

    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный канал: Очарование животных и растений","Вы можете использовать «Божественный канал», чтобы очаровать животных и растения.\n" +
                "\n" +
                "Вы действием демонстрируете свой священный символ и называете имя своего божества. Все Звери и Растения, которые могут видеть вас, и находятся в пределах 30 футов от вас, должны совершить спасбросок Мудрости. Если существо провалит спасбросок, оно становится очарованным вами на 1 минуту, или пока не получит урон. Пока существо очаровано, оно дружелюбно к вам и другим существам, которых вы укажете."));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Сдерживание стихий","Когда вы или существо в пределах 30 футов от вас получает урон звуком, кислотой, огнём, холодом или электричеством, вы можете реакцией предоставить существу сопротивление этому виду урона."));

    }
    private void lvl8(){
        if(data.gameNums.level<8){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный удар","Вы получаете способность наполнять удары своего оружия божественной энергией. Один раз в каждый свой ход, когда вы попадаете по существу атакой оружием, вы можете причинить цели дополнительный урон огнём, холодом или электричеством (на ваш выбор) 1к8. Когда вы достигаете 14-го уровня, дополнительный урон возрастает до 2к8.\n" +
                "\n"));

    }
    private void lvl17(){
        if(data.gameNums.level<17){return;}
        data.toolLists.Abilities.add(new DefaultTool("Мастер природы","Вы получаете способность командовать животными и растительными существами. Пока существа очарованы вашим умением «Очарование животных и растений», вы можете бонусным действием в свой ход устно указать, что каждое из них будет делать в свой следующий ход."));
        data.toolLists.Abilities.add(new DefaultTool("",""));


    }
}
