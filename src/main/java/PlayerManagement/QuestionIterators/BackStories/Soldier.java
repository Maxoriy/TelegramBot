package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.NoOptionQuestion;
import Tools.DefaultTool;

public class Soldier extends BackStoryTemplate{
    public Soldier(SheetInfoHolder d) {
        super(d);
        data.numbers.SkillProf.add(SkillsEnum.Athletics);
        data.numbers.SkillProf.add(SkillsEnum.Intimidation);
        addGameQ();
        addRemeslo2();
        data.toolLists.Equipment.add(new DefaultTool("Знак отличия",""));
        data.toolLists.Equipment.add(new DefaultTool("Трофей с убитого врага",""));
        data.toolLists.Equipment.add(new DefaultTool("Набор игровых костей",""));
        data.toolLists.Equipment.add(new DefaultTool("Комплект обычной одежды",""));
        data.toolLists.Equipment.add(new DefaultTool("10 зм",""));
        data.toolLists.Abilities.add(new DefaultTool("Воинское звание","Будучи солдатом, вы заслужили звание. Солдаты, верные военной организации, которой вы раньше принадлежали, всё еще признают вашу власть и влияние, и они подчиняются вам, если их звание ниже вашего. С помощью своего звания вы можете оказывать влияние на других солдат и брать во временное пользование простое снаряжение или лошадей. Возможно, вас пропустят внутрь военного лагеря или крепости, если к вашему званию отнесутся с уважением."));
    }
    private void addGameQ(){
        questionQueue.add(new NoOptionQuestion("Введите ниже название 1 игрового набора, которым вы владеете",
                (a)->{data.toolLists.EquipmentProf.add(a);}));
    }
    private void addRemeslo2(){
        questionQueue.add(new NoOptionQuestion("Введите ниже название одного вида инструментов ремесленника, с которыми вы начнете игру",
                (s)->{data.toolLists.Equipment.add(new DefaultTool(s,""));}));
    }
}
