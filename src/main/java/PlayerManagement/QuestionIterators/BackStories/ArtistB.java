package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.QuestionIterators.PlayerQuestionIterator;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

public class ArtistB implements PlayerQuestionIterator {
    protected SheetInfoHolder data;
    public ArtistB(SheetInfoHolder d){
        data=d;
        addSkillProfs();
        addEquipProf();
        addEquipment();
        data.toolLists.AddAbility(new DefaultTool("По многочисленным просьбам","Вы всегда можете найти место для выступления. Обычно это таверна или постоялый двор, но это может быть цирк, театр или даже двор знатного господина. В этом месте вы получаете бесплатный постой и еду по скромным или комфортным стандартам (в зависимости от качества заведения), если вы выступаете каждый вечер. Кроме того, ваши выступления делают вас местной знаменитостью. Когда посторонние узнают вас в городе, в котором вы давали представление, они, скорее всего, будут к вам относиться хорошо."));
    }
    private void addSkillProfs(){
        data.numbers.addSkillProf(SkillsEnum.Acrobatics.getName());
        data.numbers.addSkillProf(SkillsEnum.Performance.getName());
    }
    private void addEquipProf(){
        data.toolLists.EquipmentProf.add("Набор для грима");
        data.toolLists.EquipmentProf.add("1 вид музыкального инструмента");
    }
    private void addEquipment(){
        data.toolLists.AddEquipment(new DefaultTool("Музыкальный инструмент",""));
        data.toolLists.AddEquipment(new DefaultTool("Подарок от поклонницы","любовное письмо, локон волос или безделушка"));
        data.toolLists.AddEquipment(new DefaultTool("Костюм",""));
        data.toolLists.AddEquipment(new DefaultTool("Поясной кошель с 15 зм",""));


    }
    @Override
    public UserQuestion AskQuestion() {
        return null;
    }

    @Override
    public void NextQuestion() {

    }

    @Override
    public boolean IsOver() {
        return true;
    }
}
