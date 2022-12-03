package Enums;

public enum SkillsEnum {
    Acrobatics("Акробатика",StatsEnum.Dexterity),
    Animal("Уход за животными",StatsEnum.Wisdom),
    Arcana("Магия",StatsEnum.Intelligence),
    Athletics("Атлетика",StatsEnum.Strength),
    Deception("Обман",StatsEnum.Charisma),
    History("История",StatsEnum.Intelligence),
    Insight("Проницательность",StatsEnum.Wisdom),
    Intimidation("Запугивание",StatsEnum.Charisma),
    Medicine("Медицина",StatsEnum.Wisdom),
    Nature("Природа",StatsEnum.Intelligence),
    Perception("Восприятие",StatsEnum.Wisdom),
    Performance("Выступление",StatsEnum.Charisma),
    Persuasion("Убеждение",StatsEnum.Charisma),
    Religion("Религия",StatsEnum.Intelligence),
    SleightOfHand("Ловкость рук",StatsEnum.Dexterity),
    Stealth("Скрытность",StatsEnum.Dexterity),
    Survival("Выживание",StatsEnum.Wisdom),
    Investigation("Расследование",StatsEnum.Intelligence);
    private String name;
    public StatsEnum parent;
    SkillsEnum(String name,StatsEnum parent){
        this.name=name;
        this.parent=parent;
    }
    public String getName(){
        return name;
    }
}
