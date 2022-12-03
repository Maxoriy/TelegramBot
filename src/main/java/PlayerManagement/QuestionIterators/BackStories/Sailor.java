package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import Enums.Weapon;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.NoOptionQuestion;
import Tools.DefaultTool;

public class Sailor extends BackStoryTemplate{
    public Sailor(SheetInfoHolder d) {
        super(d);
        data.numbers.addSkillProf(SkillsEnum.Athletics.getName());
        data.numbers.addSkillProf(SkillsEnum.Perception.getName());
        data.toolLists.EquipmentProf.add("Инструменты навигатора");
        addGameQ();
        data.toolLists.Equipment.add(new DefaultTool("Кофель-нагель", Weapon.Club.getDescription()));
        data.toolLists.Equipment.add(new DefaultTool("50 футов шелковой веревки", ""));
        data.toolLists.Equipment.add(new DefaultTool("Талисман", ""));
        data.toolLists.Equipment.add(new DefaultTool("Комплект обычной одежды", ""));
        data.toolLists.Equipment.add(new DefaultTool("Кошель с 10 зм", ""));
        data.toolLists.Abilities.add(new DefaultTool("Умение поездка на корабле", "Если понадобится, вы можете получить бесплатную поездку на паруснике для себя и своих спутников. Это может быть ваш старый корабль, или другой корабль, с которым вы находитесь в хороших отношениях (возможно, им командует ваш бывший напарник). Вам оказывают услугу, поэтому вы не можете устанавливать распорядок и прокладывать маршрут. Мастер сообщит, сколько времени уйдёт на плавание. В обмен на бесплатную поездку от вас и ваших спутников ожидают посильную помощь экипажу во время плавания."));
    }
    private void addGameQ(){
        questionQueue.add(new NoOptionQuestion("Введите ниже название 1 водного транспорта, с которым ваш персонаж умеет обращаться",
                (a)->{data.toolLists.EquipmentProf.add(a);}));
    }
}
