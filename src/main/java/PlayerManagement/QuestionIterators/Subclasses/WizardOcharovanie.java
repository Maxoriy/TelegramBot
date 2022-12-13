package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class WizardOcharovanie extends BackStoryTemplate {
    public WizardOcharovanie(SheetInfoHolder d, ArrayList<UserQuestion>a) {
        super(d);
        questionQueue=a;
        lvl2();
        lvl6();
        lvl10();
        lvl14();
    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Мастер Очарования","Золото и время, которое вы тратите на копирование заклинания школы Очарования в свою книгу заклинаний, уменьшаются вдвое."));
        data.toolLists.Abilities.add(new DefaultTool("Гипнотический взгляд"," Ваши тихие слова и завораживающий взгляд волшебным образом могут одурманить другое существо. Выберите действием одно видимое вами существо в пределах 5 футов от себя. Если цель может видеть или слышать вас, она должна преуспеть в спасброске Мудрости против Сл вашего заклинания волшебника, иначе она будет очарована вами до конца вашего следующего хода. Скорость очарованного существа падает до 0, оно недееспособно и выглядит потрясённым. В следующие ходы вы можете действием поддерживать этот эффект, продлевая его до конца своего следующего хода. Однако эффект прекращается, если вы удалитесь от существа более чем на 5 футов, если существо не может больше ни видеть, ни слышать вас, или если существо получает урон.\n" +
                "\n" +
                "После окончания эффекта, или если существо успешно совершило спасбросок от него, вы не можете использовать данное умение против этого существа, пока не завершите продолжительный отдых."
                ));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Инстинктивное очарование","Когда существо, которое вы видите, и которое находится в пределах 30 футов от вас, совершает бросок атаки по вам, вы можете реакцией перенаправить атаку, при условии, что есть другое существо, находящееся в пределах досягаемости этой атаки. Атакующий должен совершить спасбросок Мудрости против Сл вашего заклинания волшебника. При провале атакующий должен выбрать в качестве цели ближайшее существо (кроме вас и себя). Если есть несколько потенциальных целей, атакующий сам выбирает из них цель. В случае успеха вы не можете использовать данное умение против атакующего, пока не завершите продолжительный отдых.\n" +
                "\n" +
                "Вы обязаны решить, будете ли использовать это умение, до того как будет известно, попала атака или промахнулась. Существа, которых нельзя очаровать, обладают иммунитетом к этому эффекту."));
    }
    private void lvl10(){
        if(data.gameNums.level<10){return;}
        data.toolLists.Abilities.add(new DefaultTool("Усиленное очарование","При накладывании вами заклинания школы Очарования 1-го уровня или выше, которое нацеливается только на одно существо, вы можете сделать целью второе существо."));
    }
    private void lvl14(){
        if(data.gameNums.level<14){return;}
        data.toolLists.Abilities.add(new DefaultTool("Ложные воспоминания","Вы получаете способность заставить существо забыть о магическом воздействии, которое вы на него оказали. При накладывании заклинания школы Очарования, которое очаровывает одно или несколько существ, вы можете изменить восприятие и воспоминания одного из них так, что оно забудет о том, что было очаровано. Кроме того, перед тем как заклинание развеется, вы можете действием попытаться заставить выбранное существо забыть некоторые моменты его пребывания в очарованном состоянии. Существо должно преуспеть в спасброске Интеллекта против Сл вашего заклинания волшебника, или оно потеряет воспоминания за промежуток времени, измеряемый в часах и равный 1 + ваш модификатор Харизмы (минимум 1). Вы можете заставить существо забыть меньшее количество времени. Количество забытого времени не может превышать продолжительность самого заклинания."));
    }
}
