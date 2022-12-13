package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import javax.validation.groups.Default;
import java.util.ArrayList;

public class MysticKnight extends BackStoryTemplate {
    public MysticKnight(SheetInfoHolder d, ArrayList<UserQuestion> a) {
        super(d);
        questionQueue=a;
        addAbs();

    }
    private void addAbs(){
        data.toolLists.Abilities.add(new DefaultTool("Использование заклинаний","" +
                "К своим воинским талантам вы добавляете возможность накладывать заклинания. Смотрите общие правила о заклинаниях и список заклинаний волшебника. За информацией об известных заклинаниях и доступных ячейках обращайтесть в руководство игрока"));
        data.toolLists.Abilities.add(new DefaultTool("Связь с оружием","Вы узнаёте ритуал, позволяющий создать магическую связь между вами и одним оружием. Вы выполняете ритуал в течение 1 часа, и он может быть совершён в течение короткого отдыха. Оружие во время проведения ритуала должно находиться на доступном расстоянии от вас, и в конце вы должны прикоснуться к нему и создать связь.\n" +
                "\n" +
                "Как только вы привязали к себе оружие, вы не можете быть обезоруженным, пока не станете недееспособным. Если оружие находится на одном плане существования с вами, вы можете в свой ход бонусным действием призвать его, телепортируя себе в руку.\n" +
                "\n" +
                "У вас может быть не более двух привязанных оружий одновременно, и бонусным действием вы призываете их по одному. Если вы попытаетесь создать связь с третьим оружием, вам придётся разорвать связь с одним из первых двух."));
        if(data.gameNums.level<7){return;}
        data.toolLists.Abilities.add(new DefaultTool("Боевая магия","Если вы действием накладываете заговор, вы можете бонусным действием совершить одну атаку оружием."));
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Мистический удар","Вы узнаёте, как с помощью удара оружием снизить сопротивляемость цели вашим заклинаниям. Если вы попадаете по существу атакой оружием, это существо совершает следующий спасбросок от вашего заклинания, использованного до конца вашего следующего хода, с помехой."));
        if(data.gameNums.level<15){return;}
        data.toolLists.Abilities.add(new DefaultTool("Волшебный рывок","Вы получаете возможность телепортироваться на 30 футов в свободное пространство, которое вы видите, когда используете «Всплеск действий». Вы можете телепортироваться до или после дополнительного действия."));
        if(data.gameNums.level<18){return;}
        data.toolLists.Abilities.add(new DefaultTool("Улучшенная боевая магия","Если вы действием накладываете заклинание, вы можете бонусным действием совершить одну атаку оружием."));
    }
}
