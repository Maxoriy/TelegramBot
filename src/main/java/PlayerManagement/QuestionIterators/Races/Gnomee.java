package PlayerManagement.QuestionIterators.Races;

import Enums.Languages;
import Enums.StatsEnum;
import PlayerManagement.QuestionIterators.BackStories.BackStoryTemplate;
import PlayerManagement.SheetInfo.SheetInfoHolder;
import PlayerManagement.questions.SingleEntryUserQuestion;
import Tools.DefaultTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Gnomee extends BackStoryTemplate {
    public Gnomee(SheetInfoHolder d) {
        super(d);
        data.numbers.addStatValue(StatsEnum.Intelligence.getName(), 2);
        data.toolLists.Abilities.add(new DefaultTool("Возраст гномов(350-500)","Гномы взрослеют с той же скоростью, что и люди, и вероятнее всего к 40 годам переходят к спокойной взрослой жизни. Они способны прожить от 350 до почти 500 лет."));
        data.toolLists.Abilities.add(new DefaultTool("Размер:Маленький","Рост гномов между 3 и 4 футами (91 и 122 сантиметрами), а средний вес составляет 40 фунтов (18 килограмм). Ваш размер — Маленький."));
        data.gameNums.speed=25;
        data.toolLists.Abilities.add(new DefaultTool("Темное зрение(60)","Привыкнув к жизни под землёй, вы обладаете превосходным зрением в темноте и при тусклом освещении. На расстоянии в 60 футов вы при тусклом освещении можете видеть так, как будто это яркое освещение, и в темноте так, как будто это тусклое освещение. В темноте вы не можете различать цвета, только оттенки серого."));
        data.toolLists.Abilities.add(new DefaultTool("Гномья хитрость","Вы совершаете с преимуществом спасброски Интеллекта, Мудрости и Харизмы против магии."));
        data.toolLists.EquipmentProf.add(Languages.Gnome.name);
        data.toolLists.EquipmentProf.add(Languages.Common.name);
        SubRaceQ();
    }
    private void SubRaceQ(){
        questionQueue.add(new SingleEntryUserQuestion("Выберите разновидность гномов",
                new ArrayList<String>(Arrays.asList("Лесной гном","Скальный гном")),
                (ans)->{
                    if(Objects.equals(ans, "Лесной гном")){
                        data.numbers.addStatValue(StatsEnum.Dexterity.getName(), 1);
                        data.toolLists.Abilities.add(new DefaultTool("Природная иллюзия","Вы знаете заклинание малая иллюзия [minor illusion]. Базовой характеристикой заклинаний для его использования является Интеллект."));
                        data.toolLists.Abilities.add(new DefaultTool("Общение с маленькими зверями","С помощью звуков и жестов вы можете передавать простые понятия Маленьким или еще меньшим зверям. Лесные гномы любят животных и часто держат белок, барсуков, кроликов, кротов, дятлов и других животных в качестве питомцев."));

                    }
                    else{
                        data.numbers.addStatValue(StatsEnum.Constitution.getName(), 1);
                        data.toolLists.Abilities.add(new DefaultTool("Ремесленные знания","При совершении проверки Интеллекта (История) применительно к магическому, алхимическому или технологическому объекту, вы можете добавить к проверке удвоенный бонус мастерства вместо обычного."));
                        data.toolLists.Abilities.add(new DefaultTool("Жестянщик","Вы владеете ремесленными инструментами (инструменты ремонтника). С их помощью вы можете, потратив 1 час времени и материалы на сумму в 10 зм, создать Крошечное механическое устройство (КД 5, 1 хит). Это устройство перестаёт работать через 24 часа (если вы не потратите 1 час на поддержание его работы). Вы можете действием разобрать его; в этом случае вы можете получить обратно использованные материалы. Одновременно вы можете иметь не более трёх таких устройств."));

                    }
                }
                ));
    }
}
