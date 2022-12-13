package PlayerManagement.QuestionIterators.Subclasses;

import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.HashMap;

public class WarrirorChampion extends BackStoryTemplate {
    public WarrirorChampion(SheetInfoHolder d, ArrayList<UserQuestion> a) {
        super(d);
        questionQueue=a;
    }
    private void addAbs(){
        int lvl=data.gameNums.level;
        data.toolLists.Abilities.add(new DefaultTool("Улучшенные критическип попадания","Ваши атаки оружием совершают критическое попадание при выпадении «19» или «20» на кости атаки."));
        if(lvl<7){return;}

        data.toolLists.Abilities.add(new DefaultTool("Выдающийся атлет","Вы можете добавлять половину бонуса мастерства, округлённую в большую сторону, ко всем проверкам Силы, Ловкости или Телосложения, куда этот бонус еще не включён.\n" +
                "\n" +
                "Кроме того, если вы совершаете прыжок в длину с разбега, дальность прыжка увеличивается на количество футов, равное модификатору Силы."));
        if(lvl<10){return;}

        BattleStyleQ();
        if(lvl<15){return;}

        data.toolLists.Abilities.add(new DefaultTool("Превосходные критические попадания","Ваши атаки оружием совершают критическое попадание при выпадении «18–20» на кости атаки."));
        if(lvl<18){return;}
        data.toolLists.Abilities.add(new DefaultTool("Уцелевший","Вы достигаете вершин стойкости в бою. В начале каждого своего хода вы восстанавливаете количество хитов, равное 5 + ваш модификатор Телосложения, если количество ваших хитов не превышает половины от максимума. Эта способность не работает, если у вас 0 хитов."));
    }

    private void BattleStyleQ(){
        HashMap<String,String> a=new HashMap<>();
        a.put("Дуэлянт","Пока вы держите рукопашное оружие в одной руке и не используете другого оружия, вы получаете бонус +2 к броскам урона этим оружием.");
        a.put("Защита","Если существо, которое вы видите, атакует не вас, а другое существо, находящееся в пределах 5 футов от вас, вы можете реакцией создать помеху его броску атаки. Для этого вы должны использовать щит.");
        a.put("Оборона","Пока вы носите доспехи, вы получаете бонус +1 к КД.");
        a.put("Сражение большим оружием","Если у вас выпало «1» или «2» на кости урона оружия при атаке, которую вы совершали рукопашным оружием, удерживая его двумя руками, то вы можете перебросить эту кость, и должны использовать новый результат, даже если снова выпало «1» или «2». Чтобы воспользоваться этим преимуществом, ваше оружие должно иметь свойство « двуручное» или «универсальное».");
        a.put("Сражение двумя оружиями","Если вы сражаетесь двумя оружиями, вы можете добавить модификатор характеристики к урону от второй атаки.");
        a.put("Стрельба","Вы получаете бонус +2 к броску атаки, когда атакуете дальнобойным оружием.");
        questionQueue.add(new SingleEntryUserQuestion("Выберите боевой стиль из представленных",new ArrayList<>(a.keySet()),
                (s)->{
                    data.toolLists.Abilities.add(new DefaultTool(s,a.get(s)));
                } ));
    }
}
