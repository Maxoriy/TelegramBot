package PlayerManagement.QuestionIterators.Races;

import Enums.Languages;
import Enums.StatsEnum;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;
import com.google.common.math.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Hafling extends BackStoryTemplate {
    public Hafling(SheetInfoHolder d) {
        super(d);
        data.gameNums.speed=25;
        data.numbers.addStatValue(StatsEnum.Dexterity.getName(), 2);
        data.toolLists.Abilities.add(new DefaultTool("Возраст полуросликов","Полурослики достигают зрелости к 20 годам, и обычно живут до середины своего второго столетия."));
        data.toolLists.Abilities.add(new DefaultTool("Размер:Маленький","Полурослики в среднем примерно 3 фута (90 сантиметров) ростом и весят около 40 фунтов (18 килограмм). Ваш размер — Маленький."));
        data.toolLists.Abilities.add(new DefaultTool("Везучий","Если при броске атаки, проверке характеристики или спасброске у вас выпало «1», вы можете перебросить кость, и должны использовать новый результат, даже если это «1»."));
        data.toolLists.Abilities.add(new DefaultTool("Храбрый","Вы совершаете с преимуществом спасброски от состояния испуганный."));
        data.toolLists.Abilities.add(new DefaultTool("Проворство полуросликов"," Вы можете проходить сквозь пространство, занятое существами, чей размер больше вашего."));
        data.toolLists.EquipmentProf.add(Languages.Common.name);
        data.toolLists.EquipmentProf.add(Languages.Hafling.name);
    }
    private void aa(){
        questionQueue.add(new SingleEntryUserQuestion("Выберите разновидность полуросликов",
                new ArrayList<>(Arrays.asList("Коренастый","Легконогий")
                        ),
        (a)->{
            if(Objects.equals(a, "Коренастый")){
                data.numbers.addStatValue(StatsEnum.Constitution.getName(), 1);
                data.toolLists.Abilities.add(new DefaultTool("Устойчивость коренастых","Вы совершаете с преимуществом спасброски от яда, и вы получаете сопротивление урону ядом."));

            }
            else{
                data.numbers.addStatValue(StatsEnum.Charisma.getName(), 1);
                data.toolLists.Abilities.add(new DefaultTool("Естественная скрытность","Вы можете предпринять попытку скрыться даже если заслонены только существом, превосходящими вас в размере как минимум на одну категорию."));

            }
        }));
    }
}
