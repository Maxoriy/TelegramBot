package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class ClericLight extends BackStoryTemplate {
    public ClericLight(SheetInfoHolder d, ArrayList<UserQuestion> a) {
        super(d);
        questionQueue = a;
        lvl1();
        lvl2();
        lvl6();
        lvl8();
        lvl17();
    }
    private void lvl1(){
        if(data.gameNums.level<1){return;}
        data.toolLists.Abilities.add(new DefaultTool("Дополнительный заговор","Вы изучаете заговор свет [light], если еще не имели его раньше. Этот заговор не учитывается в количестве известных вам заговоров жреца."));
        data.toolLists.Abilities.add(new DefaultTool("Защищающая вспышка","Вы можете создать божественный свет между собой и атакующим противником. Если вы атакованы видимым вами существом, находящимся в пределах 30 футов, вы можете реакцией создать помеху его броску атаки, вызывая перед атакующим вспышку света, до того как он попадёт или промажет. Существа, которые не могут быть ослеплены, обладают иммунитетом к этому умению. Вы можете использовать это умение количество раз, равное вашему модификатору Мудрости (минимум один раз). Вы восстанавливаете все потраченные использования, когда завершаете продолжительный отдых."));

    }
    private void lvl2(){
        if(data.gameNums.level<2){return;}
        data.toolLists.Abilities.add(new DefaultTool("Божественный канал: Сияние рассвета","Вы можете использовать «Божественный канал», чтобы призывать солнечный свет, прогоняющий тьму и причиняющий урон излучением врагам.\n" +
                "\n" +
                "Вы действием демонстрируете свой священный символ, и вся магическая тьма в пределах 30 футов от вас рассеивается. Кроме того, все враждебные существа в пределах 30 футов от вас должны совершить спасбросок Телосложения. Существа получают урон излучением, равный 2к10 + ваш уровень жреца в случае провала, и половину этого урона в случае успешного спасброска. Существа с полным укрытием от вас не подвержены воздействию."));

    }
    private void lvl6(){
        if(data.gameNums.level<6){return;}
        data.toolLists.Abilities.add(new DefaultTool("Улучшенная вспышка","Вы можете использовать умение «Защищающая вспышка», когда существо, которое вы можете видеть в пределах 30 футов от себя, атакует не вас, а другое существо."));

    }
    private void lvl8(){
        if(data.gameNums.level<8){return;}
        data.toolLists.Abilities.add(new DefaultTool("Могущественнаое колдовство","Вы добавляете модификатор Мудрости к урону, который причиняете заговорами жреца."));

    }
    private void lvl17(){
        if(data.gameNums.level<17){return;}
        data.toolLists.Abilities.add(new DefaultTool("Корона света","Вы можете действием создать ауру солнечного света, которая существует 1 минуту или пока вы не рассеете её еще одним действием. Вы испускаете яркий свет в радиусе 60 футов и тусклый свет в радиусе еще 30 футов. Ваши противники, находящиеся на ярком свету, совершают с помехой спасброски от любых заклинаний, причиняющих урон огнём или излучением."));
        data.toolLists.Abilities.add(new DefaultTool("",""));


    }
}
