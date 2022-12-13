package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.AdvancedEquipmentProfQ;
import PlayerManagement.questions.NoOptionQuestion;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;

public class WeaponMaster extends BackStoryTemplate {
    public WeaponMaster(SheetInfoHolder d, ArrayList<UserQuestion> qq) {
        super(d);
        questionQueue=qq;
        data.toolLists.Abilities.add(new DefaultTool("Боевое превосходство","Если вы выбираете этот архетип, вы изучаете приёмы, использующие специальные кости, называемые костями превосходства.\n" +
                "\n" +
                "Приёмы. Вы изучаете три приёма на ваш выбор. Большинство приёмов тем или иным образом усиливают атаку. Во время одной атаки вы можете использовать только один приём. Вы изучаете два дополнительных приёма при достижении 7-го, 10-го и 15-го уровней. Каждый раз, при изучении новых приёмов, вы можете также заменить один из известных вам приёмов на другой.\n" +
                "\n" +
                "Кости превосходства. У вас есть четыре кости превосходства. Это кости к8. Кости превосходства тратятся при использовании. Вы восполняете все потраченные кости в конце короткого или продолжительного отдыха.\n" +
                "\n" +
                "Вы получаете ещё по одной кости превосходства на 7-м и 15-м уровнях.\n" +
                "\n" +
                "Спасброски. Некоторые из ваших приёмов требуют от цели спасброска, чтобы избежать эффекта приёма. Сложность такого спасброска рассчитывается следующим образом:\n" +
                "\n" +
                "Сложность спасброска приёма = 8 + ваш бонус мастерства + ваш модификатор Силы или Ловкости (на ваш выбор)"));
        WarStudent();
        if(data.gameNums.level>=7){
            KnowYourEnemy();
        }
        if(data.gameNums.level>=10){
            GoodPrefoshodstvo();
        }
        if(data.gameNums.level>=15){
            Unbreakable();
        }
    }
    private void WarStudent(){

        questionQueue.add(new AdvancedEquipmentProfQ("Напишите ниже владение инструментами ремесленника на ваш выбор",data));
    }
    private void KnowYourEnemy(){
        data.toolLists.Abilities.add(new DefaultTool("Познай своего врага","Если вы потратите как минимум 1 минуту, рассматривая, или по другому взаимодействуя с существом вне боя, вы можете узнать некоторую информацию о его способностях в сравнении с вашими. Мастер сообщит вам, равняется ли существо, превосходит или уступает вам в двух характеристиках на ваш выбор из перечисленных:\n" +
                "\n" +
                "Значение Силы\n" +
                "Значение Ловкости\n" +
                "Значение Телосложения\n" +
                "Класс Доспеха\n" +
                "Текущие хиты\n" +
                "Общее количество уровней (если есть)\n" +
                "Количество уровней в классе Воин (если есть)"));
    }
    private void GoodPrefoshodstvo(){
        data.toolLists.Abilities.add(new DefaultTool("Улучшенное боевое превосходство","" +
                "Ваша кость превосходства увеличивается до к10. На 18-м уровне — до к12."));
    }
    private void Unbreakable(){
        data.toolLists.Abilities.add(new DefaultTool("Неослабевающий","Если вы совершаете бросок инициативы, не имея костей превосходства, вы получаете одну."));
    }
}
