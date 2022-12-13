package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class WarlockCtylhu extends BackStoryTemplate {
    public WarlockCtylhu(SheetInfoHolder d, ArrayList<UserQuestion> a) {
        super(d);
        questionQueue=a;
        lvl1();
        lvl6();
        lvl10();
        lvl14();
    }
    private void lvl1(){
        data.toolLists.Abilities.add(new DefaultTool("Пробужденный разум","Ваше чуждое знание даёт вам возможность касаться разума других существ. Вы можете общаться телепатически с любым существом, которое видите в пределах 30 футов от себя. Вам не нужно знать общий с существом язык для того, чтобы оно понимало ваши телепатические высказывания, но существо должно быть в состоянии понимать как минимум один язык."));
    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Энтропическая опека","Вы научитесь магически опекать себя от атак и использовать неудачную вражескую атаку на пользу себе. Если существо совершает бросок атаки по вам, вы можете реакцией создать помеху для этого броска. Если атака промахнётся по вам, ваш следующий бросок атаки по этому существу совершается с преимуществом, если вы совершите его до конца своего следующего хода. Использовав это умение, вы не можете использовать его снова до окончания короткого или продолжительного отдыха."));
    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Ментальный щит","Ваши мысли не могут быть прочитаны телепатически или иными средствами, если вы не пожелаете обратного. Вы также получаете сопротивление урону психической энергией, и каждый раз, когда существо причиняет вам урон психической энергией, это существо получает такое же количество урона, что и вы."));
    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Создать раба","Вы получаете способность инфицировать разум гуманоидов чужеродной магией своего покровителя. Вы можете действием коснуться недееспособного гуманоида. Это существо становится очарованным вами до тех пора, пока на него не будет наложено заклинание снятие проклятья [remove curse], либо пока оно не перестанет быть очарованным, либо пока вы не используете это умение еще раз. Вы можете общаться телепатически с очарованным существом, пока вы оба находитесь на одном плане существования."));

    }
}
