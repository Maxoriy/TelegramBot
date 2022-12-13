package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class WizardIllusion extends BackStoryTemplate {
    public WizardIllusion(SheetInfoHolder d, ArrayList<UserQuestion> a) {
        super(d);
        questionQueue=a;
        lvl2();
        lvl6();
        lvl10();
        lvl14();
    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Мастер Иллюзий","Золото и время, которое вы тратите на копирование заклинания школы Иллюзии в свою книгу заклинаний, уменьшаются вдвое."));
        data.toolLists.Abilities.add(new DefaultTool("Улучшенная малая иллюзия","Вы узнаёте заговор малая иллюзия [minor illusion]. Если вам уже известен этот заговор, то вы изучаете любой другой заговор волшебника на свой выбор. Этот заговор не учитывается в общем количестве известных вам заговоров.\n" +
                "\n" +
                "При накладывании заклинания малая иллюзия [minor illusion] вы можете использовать эффекты звука и изображения вместе единым заклинанием."));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Пластичные иллюзии","Если вы наложили заклинание школы Иллюзии длительностью как минимум 1 минута, вы можете действием изменить характер этой иллюзии (используя обычные ограничения для этой иллюзии), при условии, что можете видеть эту иллюзию."));
    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Собственная иллюзорность","Вы можете инстинктивно создать иллюзорную копию самого себя в ответ на внезапную опасность. Если существо совершает по вам бросок атаки, вы можете реакцией создать иллюзорную копию между атакующим и собой. Атака автоматически промахивается по вам и уничтожает иллюзию.\n" +
                "\n" +
                "После использования данного умения вы должны закончить короткий или продолжительный отдых, прежде чем сможете воспользоваться им вновь."));
    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Иллюзорная реальность","Вы постигли секреты плетения теневых заклятий, что делает ваши иллюзии наполовину реальными. Когда вы накладываете заклинание Иллюзии 1-го уровня или выше, вы можете выбрать любой неодушевлённый и немагический объект, являющийся частью данной иллюзии, чтобы сделать его реальным. Вы можете сделать это в свой ход бонусным действием, пока действует заклинание. Объект становится реальным на 1 минуту. Например, вы можете создать иллюзию моста через разлом и держать его реальным достаточно долго, чтобы ваши союзники могли по нему перебраться. Объект не может причинять урон или непосредственно навредить кому-либо."));
    }
}
