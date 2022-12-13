package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class ClericObman extends BackStoryTemplate {
    public ClericObman(SheetInfoHolder d, ArrayList<UserQuestion> a) {
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
        data.toolLists.Abilities.add(new DefaultTool("Благословение обманщика","Вы можете действием коснуться согласного существа, отличного от вас, чтобы позволить ему совершать с преимуществом проверки Ловкости (Скрытность). Это благословение длится 1 час, или вы не используете это умение снова."));

    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный канал: Двуличность","Вы можете использовать «Божественный канал», чтобы создать иллюзорную копию себя.\n" +
                "\n" +
                "Вы действием создаёте идеальную иллюзию себя, которая существует в течение 1 минуты, или пока вы не потеряете концентрацию (как если бы вы концентрировались на заклинании). Иллюзия появляется в свободном пространстве, которое вы можете видеть в пределах 30 футов от себя. Бонусным действием в свой ход вы можете переместить иллюзию на расстояние до 30 футов в пространство, которое вы можете видеть, но иллюзия должна оставаться в пределах 120 футов от вас. На протяжении действия умения вы можете накладывать заклинания, как если бы вы находились в пространстве иллюзии, но вы должны использовать собственные чувства. Кроме того, когда и вы и ваша иллюзия находитесь в пределах 5 футов от существа, которое может видеть иллюзию, вы совершаете броски атаки по этому существу с преимуществом, так как иллюзия отвлекает его."));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный канал: Плащ теней","Вы можете использовать «Божественный канал», чтобы исчезать. Вы действием становитесь невидимым до конца своего следующего хода. Вы становитесь видимым, если атакуете или накладываете заклинание."));

    }
    private void lvl8(){
        if(data.gameNums.level<8){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный удар","Вы получаете способность наполнять удары своего оружия ядом — это дар вашего божества. Один раз в каждый свой ход, когда вы попадаете по существу атакой оружием, вы можете причинить цели дополнительный урон ядом 1к8. Когда вы достигаете 14-го уровня, дополнительный урон возрастает до 2к8.\n" +
                "\n"));

    }
    private void lvl17(){
        if(data.gameNums.level<17){return;}
        data.toolLists.Abilities.add(new DefaultTool("Улучшенная двуличность","Вы можете создать до четырёх копий себя, вместо одной, когда вы используете «Двуличность». Бонусным действием в свой ход вы можете переместить любое количество копий на 30 футов, максимальная дистанция от вас не должна превышать 120 футов."));
        data.toolLists.Abilities.add(new DefaultTool("",""));
    }
}
