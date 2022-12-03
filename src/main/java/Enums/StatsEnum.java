package Enums;

public enum StatsEnum {


    Strength("Сила"),
    Dexterity("Ловкость"),
    Constitution("Телосложение"),
    Intelligence("Интеллект"),
    Wisdom("Мудрость"),
    Charisma("Харизма");

    private String name;
    StatsEnum(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

}
