package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class DruidMoon extends BackStoryTemplate {
    public DruidMoon(SheetInfoHolder d, ArrayList<UserQuestion> q) {
        super(d);
        questionQueue=q;
        lvl2();
        lvl6();
        lvl10();
        lvl14();
    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Боевой дикий облик","Вы можете использовать умение «Дикий облик» бонусным действием, а не действием.\n" +
                "\n" +
                "Кроме того, пока вы перевоплощены умением «Дикий облик», вы можете бонусным действием потратить ячейку заклинания, чтобы восстановить 1к8 хитов за каждый уровень потраченной ячейки."));
        data.toolLists.Abilities.add(new DefaultTool("Облики круга","Обряды круга луны позволяют принимать облик более опасных животных. Вы можете превращаться в Зверя с показателем опасности до 1 (игнорируйте столбец «Макс. ПО» таблицы «Облик животного»).\n" +
                "\n" +
                "Начиная с 6-го уровня, вы можете превращаться в Зверя с показателем опасности вплоть до уровня друида, поделённого на 3 (округляя в меньшую сторону)."));
    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Природный удар","Ваши атаки в облике Зверя считаются магическими для преодоления сопротивления и иммунитета к немагическим атакам и урону."));
    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Стихийный дикий облик","Вы можете потратить сразу два использования «Дикого облика», чтобы принять облик водяного, воздушного, земляного или огненного элементаля."));

    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Тысяча лиц","Вы понимаете, как магически изменять детали своего облика. Вы можете неограниченно накладывать заклинание смена обличья [alter self]."));
    }
}
