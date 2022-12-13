package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class BarBarBerserker extends BackStoryTemplate {
    public BarBarBerserker(SheetInfoHolder d, ArrayList<UserQuestion> a) {
        super(d);
        questionQueue=a;
        data.toolLists.Abilities.add(new DefaultTool("Бешенство","Находясь в состоянии ярости, вы можете впасть в бешенство. В этом случае, пока ваша ярость не прекратилась, вы можете в каждый свой ход после текущего совершать бонусным действием одну рукопашную атаку оружием. После окончания ярости вы получаете одну степень истощения."));
        lvl6();
        lvl10();
        lvl14();
    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Бездумная ярость","Вы не можете быть испуганы или очарованы, пока находитесь в состоянии ярости. Если вы были испуганы или очарованы до того, как впали в состояние ярости, эти эффекты приостанавливаются до окончания вашей ярости."));
    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Пугающее присутствие","Вы можете действием пугать других своим ужасающим видом. Чтобы сделать это, выберите существо в пределах 30 футов от себя, которое вы можете видеть. Если оно может видеть или слышать вас, оно должно совершить успешный спасбросок Мудрости (Сл равна 8 + ваш бонус мастерства + ваш модификатор Харизмы), иначе станет испуганным вами до конца вашего следующего хода. В последующие ходы вы можете действием поддерживать этот эффект до конца своего следующего хода.\n" +
                "\n" +
                "Эффект оканчивается, если цель оказалась вне линии обзора, или далее чем в 60 футах от вас. Если существо преуспело в спасброске, вы не можете использовать на нём это умение следующие 24 часа."));
    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Ответный удар","При получении урона от существа, находящегося в пределах 5 футов от вас, вы можете реакцией совершить по нему рукопашную атаку оружием."));
    }

}
