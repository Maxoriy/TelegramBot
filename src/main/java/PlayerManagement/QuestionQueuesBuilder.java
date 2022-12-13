package PlayerManagement;

import PlayerManagement.QuestionIterators.BackStories.*;
import PlayerManagement.QuestionIterators.Classes.*;
import PlayerManagement.QuestionIterators.PlayerQuestionIterator;
import PlayerManagement.QuestionIterators.PlayerQuestionManager;
import PlayerManagement.QuestionIterators.Races.*;
import PlayerManagement.QuestionIterators.SelfStorageQuestionIterator;
import PlayerManagement.SheetInfo.SheetInfoHolder;

public class QuestionQueuesBuilder {
    public static QuestionQueuesBuilder getInstance(){
    if(instance==null){
        instance=new QuestionQueuesBuilder();
        }
        return instance;
    }
    private static QuestionQueuesBuilder instance;

    public SelfStorageQuestionIterator CreateQueue(SheetInfoHolder hold){
        PlayerQuestionIterator clss;
        PlayerQuestionIterator rss;
        PlayerQuestionIterator bckstr;
        switch (hold.naming.className){
            case "Колдун"->clss=warlockConstructor(hold);
            case "Варвар"->clss=new BarbarQuestions(hold);
            case "Монах"->clss=new Monke(hold);
            case "Бард"->clss=new Bard(hold);
            case "Воин"->clss=new Fighter(hold);
            case "Волшбеник"->clss=new Wizard(hold);
            case "Друид"->clss=new Druid(hold);
            case "Жрец"->clss=new Cleric(hold);
            case "Паладин"->clss=new Paladin(hold);
            case "Плут"->clss=new Rogue(hold);
            case "Следопыт"->clss=new Ranger(hold);
            case "Чародей"->clss=new Sorcerer(hold);
            default -> throw new RuntimeException();
        }
        switch (hold.naming.raceName){
            case "Гном"->rss=new Gnomee(hold);
            case "Дварф"->rss=new BeerMan(hold);
            case "Драконорожденный"->rss=new DragonBorn(hold);
            case "Полуорк"->rss=new HalfOrc(hold);
            case "Полурослик"->rss=new HalfOrc(hold);
            case "Полуэльф"->rss=new HalfElf(hold);
            case "Тифлинг"->rss=new Tiefling(hold);
            case "Эльф"->rss=new Elf(hold);
            case "Человек"->rss=new Human(hold);
            default -> throw new RuntimeException();
        }
        switch (hold.naming.backStoryName){
            case "Артист"->bckstr=new ArtistB(hold);
            case "Беспризорник"->bckstr=new Besprizornik(hold);
            case "Благородный"->bckstr=new Nobil(hold);
            case "Гильдейский ремесленник"->  bckstr=new GuildMaster(hold);
            case "Моряк"->bckstr=new Sailor(hold);
            case "Мудрец"->bckstr=new WizdomMan(hold);
            case "Народный герой"->bckstr=new NoNameMotors(hold);
            case "Отшельник"->bckstr=new Hikka(hold);
            case "Преступник"->bckstr=new Criminal(hold);
            case "Солдат"->bckstr=new Soldier(hold);
            case "Чужеземец"->bckstr=new Wildling(hold);
            case "Шарлатан"->bckstr=new Sharlatan(hold);
            default -> throw new RuntimeException();
        }

        return new SelfStorageQuestionIterator(hold, clss,rss,bckstr);
    }
    private PlayerQuestionIterator warlockConstructor(SheetInfoHolder dat){
        return new WarlockQuestions(dat);
    }




}
