package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class WizardOgrazdenie extends BackStoryTemplate {
    public WizardOgrazdenie(SheetInfoHolder d, ArrayList<UserQuestion>a) {

        super(d);
        questionQueue=a;
        lvl2();
        lvl6();
        lvl10();
        lvl14();
    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Мастер Ограждения","Золото и время, которое вы тратите на копирование заклинания школы Ограждения в свою книгу заклинаний, уменьшаются вдвое."));
        data.toolLists.Abilities.add(new DefaultTool("Магическая защита","Вы можете плести вокруг себя магию для защиты. Когда вы накладываете заклинание школы Ограждения 1-го уровня или выше, вы можете одновременно с этим использовать прядь магии для создания магической защиты, существующей до окончания продолжительного отдыха. Защита имеет хиты, равные вашему удвоенному уровню волшебника + модификатор Интеллекта. Когда вы получаете урон, его вместо вас получает защита. Если урон опускает хиты защиты до 0, то оставшийся после этого урон получаете вы. Когда у защиты остаётся 0 хитов, она не может поглощать урон, но её магия остаётся. Если вы накладываете заклинание школы Ограждения 1-го уровня или выше, защита восстанавливает количество хитов, равное удвоенному уровню заклинания. Единожды создав защиту, вы не можете создать её вновь, пока не завершите продолжительный отдых."));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Проекция защиты","Когда видимое вами существо, находящееся в пределах 30 футов от вас, получает урон, вы можете реакцией поглотить этот урон вашей «Магической защитой». Если урон опускает хиты защиты до 0, то защищаемое существо получает весь оставшийся урон"));
    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Улучшенное ограждение","Когда вы накладываете заклинание школы Ограждения, которое требует совершить проверку характеристики частью накладываемого заклинания (как в случае заклинаний контрзаклинание [counterspell] и рассеивание магии [dispel magic]), вы добавляете к этой проверке ваш бонус мастерства."));
    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Сопротивление заклинаниям","Вы совершаете спасброски от заклинаний с преимуществом.\n" +
                "\n" +
                "Кроме того, вы получаете сопротивление урону от заклинаний."));
    }
}
