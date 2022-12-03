package PlayerManagement.QuestionIterators.BackStories;

import Enums.SkillsEnum;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.NoOptionQuestion;
import Tools.DefaultTool;

public class GuildMaster extends BackStoryTemplate{
    public GuildMaster(SheetInfoHolder d) {
        super(d);
        data.numbers.addSkillProf(SkillsEnum.Insight.getName());
        data.numbers.addSkillProf(SkillsEnum.Persuasion.getName());
        addLanQ();
        addRemeslo();
        addRemeslo2();
        data.toolLists.Equipment.add(new DefaultTool("Рекомендательное письмо из гильдии",""));
        data.toolLists.Equipment.add(new DefaultTool("Комплект дорожной одежды",""));
        data.toolLists.Equipment.add(new DefaultTool("Кошель с 15 зм",""));
        data.toolLists.Abilities.add(new DefaultTool("Членство в гильдии","Будучи авторитетным и уважаемым членом гильдии, вы можете пользоваться особыми преимуществами, предоставляемыми этим членством. Ваши товарищи по гильдии при необходимости предоставят вам жилище и питание, и даже оплатят ваши похороны. В некоторых городах у гильдий есть место для сбора, и там можно потенциально встретить покровителей, союзников и наёмников. Гильдии часто обладают значительной политической властью. Если вас обвинят в преступлении, гильдия может помочь, если существует вероятность оправдательного приговора. Благодаря гильдии вы получаете доступ к влиятельным политикам, если состоите в гильдии на хорошем счету. Для таких связей может потребоваться жертвование денег или магических предметов в казну гильдии. Каждый месяц вы должны выплачивать гильдии 5 зм. Если вы пропустите платёж, вы должны вначале оплатить все долги, и только тогда восстановите своё доброе имя в гильдии."));
    }

    private void addRemeslo2(){
        questionQueue.add(new NoOptionQuestion("Введите ниже название одного вида инструментов ремесленника, с которыми вы начнете игру",
                (s)->{data.toolLists.Equipment.add(new DefaultTool(s,""));}));
    }
}
