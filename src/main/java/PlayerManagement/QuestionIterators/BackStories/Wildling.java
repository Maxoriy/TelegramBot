package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.NoOptionQuestion;
import Tools.DefaultTool;

public class Wildling extends BackStoryTemplate{
    public Wildling(SheetInfoHolder d) {
        super(d);
        data.numbers.SkillProf.add(SkillsEnum.Athletics);
        data.numbers.SkillProf.add(SkillsEnum.Survival);
        addGameQ();
        addLanQ();
        data.toolLists.Equipment.add(new DefaultTool("Посох",""));
        data.toolLists.Equipment.add(new DefaultTool("Капкан",""));
        data.toolLists.Equipment.add(new DefaultTool("Трофей убитого зверя",""));
        data.toolLists.Equipment.add(new DefaultTool("Комплект дорожной одежды",""));
        data.toolLists.Equipment.add(new DefaultTool("10 зм",""));
        data.toolLists.Abilities.add(new DefaultTool("Странник","Вы отлично запоминаете карты и местность, и всегда можете вспомнить общие характеристики местности, поселения, и прочие особенности в окрестностях. Кроме того, вы каждый день можете находить еду и пресную воду для себя и пяти других товарищей, при условии, что вокруг вас можно найти ягоды, дичь, воду и так далее."));

    }
    private void addGameQ(){
        questionQueue.add(new NoOptionQuestion("Введите ниже название 1 музыкального инструмента, которым вы владеете",
                (a)->{data.toolLists.EquipmentProf.add(a);}));
    }
}
