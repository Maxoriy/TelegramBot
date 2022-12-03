package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.NoOptionQuestion;
import Tools.DefaultTool;

public class NoNameMotors extends BackStoryTemplate{
    public NoNameMotors(SheetInfoHolder d) {
        super(d);
        data.numbers.SkillProf.add(SkillsEnum.Survival);
        data.numbers.SkillProf.add(SkillsEnum.Animal);
        addRemeslo();
        addGameQ();
        addRemeslo2();
        data.toolLists.AddEquipment(new DefaultTool("Лопата",""));
        data.toolLists.AddEquipment(new DefaultTool("Железный горшок",""));
        data.toolLists.AddEquipment(new DefaultTool("Комплект обычной одежды",""));
        data.toolLists.AddEquipment(new DefaultTool("Поясной кошель с 10 зм",""));
        data.toolLists.Abilities.add(new DefaultTool("Деревенское гостеприимство","Вы сами из простого народа, и потому легко находите с ними общий язык. Вы можете найти место, чтобы спрятаться, отдохнуть или подлечиться среди обывателей, если только вы не угрожаете им. Они укроют вас от представителей закона и тех, кто ищет вас, но своими жизнями за вас они рисковать не будут."));
    }
    private void addGameQ(){
        questionQueue.add(new NoOptionQuestion("Введите ниже название 1 наземного транспорта, с которым ваш персонаж умеет обращаться",
                (a)->{data.toolLists.EquipmentProf.add(a);}));
    }
    private void addRemeslo2(){
        questionQueue.add(new NoOptionQuestion("Введите ниже название одного вида инструментов ремесленника, с которыми вы начнете игру",
                (s)->{data.toolLists.Equipment.add(new DefaultTool(s,""));}));
    }
}
