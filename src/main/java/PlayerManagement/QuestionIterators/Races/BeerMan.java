package PlayerManagement.QuestionIterators.Races;

import Enums.Languages;
import Enums.StatsEnum;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class BeerMan extends BackStoryTemplate {
    public BeerMan(SheetInfoHolder d) {
        super(d);
        data.numbers.addStatValue(StatsEnum.Constitution.getName(), 2);
        data.gameNums.speed=25;
        data.toolLists.Abilities.add(new DefaultTool("Возраст дварфов(350)","Дварфы взрослеют с той же скоростью, что и люди, но считаются юными, пока не достигнут пятидесятилетнего возраста. В среднем, они живут свыше 350 лет."));
        data.toolLists.Abilities.add(new DefaultTool("Размер дварфов(Средний)"," Рост дварфов находится между 4 и 5 футами (122 и 152 сантиметрами), и весят они около 150 фунтов (68 килограмм). Ваш размер — Средний."));
        data.toolLists.Abilities.add(new DefaultTool("Дварфийская скорость","Ваша базовая скорость ходьбы составляет 25 футов. Ношение тяжёлых доспехов не снижает вашу скорость."));
        data.toolLists.Abilities.add(new DefaultTool("Темное зрение(60)","Привыкнув к жизни под землёй, вы обладаете превосходным зрением в темноте и при тусклом освещении. На расстоянии в 60 футов вы при тусклом освещении можете видеть так, как будто это яркое освещение, и в темноте так, как будто это тусклое освещение. В темноте вы не можете различать цвета, только оттенки серого."));
        data.toolLists.Abilities.add(new DefaultTool("Дварфская устойчивость","Вы совершаете с преимуществом спасброски от яда, и вы получаете сопротивление урону ядом."));
        data.toolLists.Abilities.add(new DefaultTool("Дварфская боевая тренировка","Вы владеете боевым топором, ручным топором, лёгким и боевым молотами."));
        data.toolLists.Abilities.add(new DefaultTool("Знание камня","Если вы совершаете проверку Интеллекта (История), связанную с происхождением работы по камню, вы считаетесь владеющим навыком История, и добавляете к проверке удвоенный бонус мастерства вместо обычного."));
        data.toolLists.EquipmentProf.add("Боевые топоры");
        data.toolLists.EquipmentProf.add("Ручные топоры");
        data.toolLists.EquipmentProf.add("Легкие молоты");
        data.toolLists.EquipmentProf.add("Боевые молоты");
        data.toolLists.EquipmentProf.add(Languages.Common.name);
        data.toolLists.EquipmentProf.add(Languages.Dwarf.name);

        instruments();
        Species();
    }
    private void instruments(){
        questionQueue.add(new SingleEntryUserQuestion("Выберите владение инструментами",
                new ArrayList<>(Arrays.asList("Инструменты кузнеца","Инструменты пивовара","Инструменты каменщика")),
                (s)->{data.toolLists.EquipmentProf.add(s);}
                ));
    }
    private void Species(){
        questionQueue.add(new SingleEntryUserQuestion("Выберите подрасу дварфов",
                new ArrayList<String>(Arrays.asList("Горный дварф","Холмовой дварф")),
                (a)->{
                    if(Objects.equals(a, "Холмовой дварф")){
                        data.numbers.addStatValue(StatsEnum.Wisdom.getName(),1);
                        data.toolLists.Abilities.add(new DefaultTool("Дварфская выдержка","Максимальное значение ваших хитов увеличивается на 1, и вы получаете 1 дополнительный хит с каждым новым уровнем."));
                    }
                    else{
                        data.numbers.addStatValue(StatsEnum.Wisdom.getName(),2);
                        data.toolLists.Abilities.add(new DefaultTool("Владение доспехами дварфов"," Вы владеете лёгкими и средними доспехами"));
                        data.toolLists.EquipmentProf.add("Легкие доспехи");
                        data.toolLists.EquipmentProf.add("Средние доспехи");
                    }
                }
                ));
     }
}
