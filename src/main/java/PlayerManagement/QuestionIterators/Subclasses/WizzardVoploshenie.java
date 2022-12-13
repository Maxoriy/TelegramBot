package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class WizzardVoploshenie extends BackStoryTemplate {
    public WizzardVoploshenie(SheetInfoHolder d, ArrayList<UserQuestion> a) {
        super(d);
        questionQueue=a;
        lvl2();
        lvl6();
        lvl10();
        lvl14();
    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Мастер воплощения","Золото и время, которое вы тратите на копирование заклинания школы Воплощения в свою книгу заклинаний, уменьшаются вдвое."));
        data.toolLists.Abilities.add(new DefaultTool("Построение заклинаний","Когда вы накладываете разрушительное заклинание, то можете создать относительно безопасные участки внутри зоны поражения, которые оно не затрагивает. При накладывании заклинания школы Воплощения, воздействующего на других существ, которых вы видите, вы можете выбрать количество существ, равное 1 + уровень заклинания. Выбранные существа автоматически преуспевают в спасбросках от этого заклинания и не получают урона, если по описанию должны получить половину урона от заклинания при успешном спасении."));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Мощный заговор","Ваши наносящие урон заговоры воздействуют даже на тех существ, которые избегают основного эффекта. Если существо преуспевает в спасброске от вашего заговора, оно получает половину урона от него (если есть), но не получает дополнительных эффектов от него."));
    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Усиленное воплощение","При броске урона от заклинания школы Воплощения волшебника, наложенного вами, вы добавляете к одному броску урона свой модификатор Интеллекта."));
    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Перегрузка","Вы можете увеличить силу своих простейших заклинаний. Когда вы накладываете наносящее урон заклинание волшебника от 1-го до 5-го уровня, вы можете нанести им максимальный урон.\n" +
                "\n" +
                "Без вреда для себя вы можете использовать это умение один раз. Если вы повторно используете это умение до окончания продолжительного отдыха, то получаете 2к12 урона некротической энергией за каждый уровень заклинания сразу после его накладывания. Каждый следующий раз при использовании данного умения до окончания продолжительного отдыха урон некротической энергией увеличивается на 1к12. Этот урон игнорирует сопротивление и иммунитет."));
    }

}
