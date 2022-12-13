package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class WizardVizov extends BackStoryTemplate {
    public WizardVizov(SheetInfoHolder d, ArrayList<UserQuestion> a) {
        super(d);
        questionQueue=a;
        lvl2();
        lvl6();
        lvl10();
        lvl14();
    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Мастер Созидания","Золото и время, которое вы тратите на копирование заклинания школы Вызова в свою книгу заклинаний, уменьшаются вдвое."));
        data.toolLists.Abilities.add(new DefaultTool("Малый вызов","Вы можете действием создать неодушевлённый предмет в своей руке или на земле в свободном пространстве, которое вы можете видеть, и которое расположено в пределах 10 футов от вас. Этот предмет не должен превышать в длину 3 фута (90 сантиметров) и весить более 10 фунтов, и его форма должна быть как у немагического предмета, который вы уже видели. Видно, что предмет магический, и он излучает тусклый свет в пределах 5 футов.\n" +
                "\n" +
                "Предмет исчезает через 1 час, когда вы используете это умение вновь, или когда он получает или наносит любой урон."));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Безопасное перемещение","Вы можете действием телепортироваться на 30 футов в свободное пространство, которое можете видеть. В качестве альтернативы, вы можете выбрать пространство в пределах этого диапазона, занятое существом Маленького или Среднего размера. Если это существо согласно, вы оба телепортируетесь, меняясь местами. Использовав это умение один раз, вы не можете использовать его вновь до окончания продолжительного отдыха или пока не наложите заклинание школы Вызова 1-го уровня или выше."));
    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Фокусированный вызов","Когда вы концентрируетесь на заклинании школы Вызова, ваша концентрация не может быть нарушена в результате получения урона."));
    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Надежный вызов","Все призванные или созданные вами заклинанием школы Вызова существа имеют 30 временных хитов."));
    }
}