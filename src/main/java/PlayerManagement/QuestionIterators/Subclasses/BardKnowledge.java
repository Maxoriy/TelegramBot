package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class BardKnowledge extends BackStoryTemplate {
    public BardKnowledge(SheetInfoHolder d, ArrayList<UserQuestion> q) {
        super(d);
        questionQueue=q;
        data.toolLists.Abilities.add(new DefaultTool("Дополнительные навыки","Если вы присоединяетесь к коллегии знаний, вы овладеваете тремя навыками на ваш выбор."));
        data.toolLists.Abilities.add(new DefaultTool("Острое словцо","Вы узнаёте, как использовать собственное остроумие, чтобы отвлечь, смутить или по-другому подорвать способности и уверенность противников. Если существо, которое вы можете видеть, в пределах 60 футов от вас совершает бросок атаки, урона или проверку характеристики, вы можете реакцией потратить одну из ваших костей бардовского вдохновения, и вычесть результат броска этой кости из броска этого существа. Вы можете принять решение об использовании этого умения после броска существа, но до того момента, когда Мастер объявит результат броска или проверки. Существо не подвержено этому умению, если не может слышать вас, или обладает иммунитетом к очарованию."));
        lvl6();
        lvl14();
    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Дополнительные тайны магии","Вы можете выучить 2 заклинания из доступных любому классу на свой выбор. Их уровень не должен превышать уровня заклинаний, которые вы можете использовать на этом уровне, как показано в таблице Барда. Они также могут быть заговорами. Выбранные заклинания теперь считаются для вас заклинаниями барда, но они не учитываются в общем количестве известных вам заклинаний барда."));
    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Непревзойденный навык","Если вы совершаете проверку характеристики, вы можете бросить кость бардовского вдохновения и добавить результат к проверке. Вы можете принять решение об использовании этого умения после броска проверки, но до того, как Мастер объявит результат этой проверки."));
    }
}
