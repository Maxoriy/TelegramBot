package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class BardDoblest extends BackStoryTemplate {
    public BardDoblest(SheetInfoHolder d, ArrayList<UserQuestion> q) {
        super(d);
        questionQueue=q;
        data.toolLists.EquipmentProf.add("Средние доспехи");
        data.toolLists.EquipmentProf.add("Щиты");
        data.toolLists.EquipmentProf.add("Воинское оружие");
        data.toolLists.Abilities.add(new DefaultTool("Боевое вдохновение","Вы узнаёте, как вдохновлять других в бою. Существо, получившее от вас кость бардовского вдохновения, может бросить эту кость и добавить результат к своему броску урона оружием. В качестве альтернативы, если существо атаковано, оно может реакцией совершить бросок кости вдохновения и добавить результат к своему КД от этой атаки. Оно может сделать это после броска атаки, но до того, как узнает, попали ли по нему."));
        lvl6();
        lvl14();
    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Дополнительная атака","Если вы в свой ход совершаете действие Атака, вы можете совершить две атаки вместо одной."));
    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Боевая магия","Вы научились сплетать использование заклинаний и оружия в одно гармоничное действие. Если вы действием используете заклинание барда, вы можете бонусным действием совершить одну атаку оружием."));

    }
}
