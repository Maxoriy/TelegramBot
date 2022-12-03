package PlayerManagement.SheetInfo;

import Enums.*;
import Tools.ListIteratorImp;
import Tools.StringToolIterImp;
import Tools.ToolField;
import Tools.ToolIterator;

public class InfoAdapter implements CharInfo {
    private SheetInfoHolder data;
    public InfoAdapter(SheetInfoHolder d){
        this.data=d;
        data.gameNums.proficiencyModifier=2+data.gameNums.level/4;
        if(data.gameNums.hitPoints==0){
            data.gameNums.hitPoints=data.gameNums.hitDice+((data.gameNums.hitDice/2)+1+
                    (data.numbers.StatValue.get(StatsEnum.Constitution)-10)/2
            )*data.gameNums.level;
        }

    }
    @Override
    public int GetMajorStatVal(StatsEnum stat) {
        return data.numbers.StatValue.get(stat);
    }

    @Override
    public int GetSkillVal(SkillsEnum stat) {
        int v=data.numbers.StatValue.get(stat.parent);
        v=(v-10)/2;
        if(data.numbers.SkillProf.contains(stat)){
            v+=data.gameNums.proficiencyModifier;
        }
        return v;
    }

    @Override
    public int GetSavingThrows(StatsEnum stat) {
        int v= data.numbers.StatValue.get(stat);
        v=(v-10)/2;
        if(data.numbers.SavingThrowProf.contains(stat)){
            v+=data.gameNums.proficiencyModifier;
        }
        return v;
    }

    @Override
    public String GetNames(Names stat) {
        switch (stat){
            case Race -> {return data.naming.raceName;}
            case ClassName -> {return data.naming.className;}
            case Background -> {return data.naming.backStoryName;}
            case PlayerName -> {return data.naming.characterName;}
            case CharacterName -> {return data.naming.characterName;}
            default -> throw new RuntimeException();
        }
    }

    @Override
    public int GetMajorCharacteristics(MajorCharacteristics stats) {
        switch (stats){
            case Speed -> {return data.gameNums.speed;}
            case  ArmorClass-> {return data.gameNums.AC;}
            case Initiative -> {return (data.numbers.StatValue.get(StatsEnum.Dexterity)-10)/2;}
            case HitDice -> {return data.gameNums.hitDice;}
            case HitPoints -> {return data.gameNums.hitPoints;}
            case ProficiencyBonus -> {return data.gameNums.proficiencyModifier;}
            case ClassLevel -> {return data.gameNums.level;}
            default -> throw new RuntimeException();
        }
    }

    @Override
    public ToolIterator GetStringField(ToolField st) {
        switch (st){
            case FeaturesAndTraits -> {return new ListIteratorImp(data.toolLists.Abilities);}
            case Equipment -> {return new ListIteratorImp(data.toolLists.Equipment);}
            case OtherProfAndLanguages -> {return new StringToolIterImp(data.toolLists.EquipmentProf);}
            default -> throw new RuntimeException();
        }
    }
}

