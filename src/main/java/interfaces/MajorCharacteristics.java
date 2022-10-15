package interfaces;

public enum MajorCharacteristics {
    ArmorClass(0),
    Initiative(1),
    HitPoints(2),
    ProficiencyBonus(3),
    Speed(4),
    HitDice(5),
    Level(6);
    private final int code;
    MajorCharacteristics(int x){
        this.code=x;
    }
    int GetCode(){return this.code;}
}
