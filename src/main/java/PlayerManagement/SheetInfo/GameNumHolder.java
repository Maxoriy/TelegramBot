package PlayerManagement.SheetInfo;

public class GameNumHolder {
    public int level;
    public int hitDice;
    public int hitPoints;
    public int AC;
    public int speed;

    public GameNumHolder() {
        this.level = 0;
        this.hitDice =0;
        this.hitPoints =0;
        this.AC = 0;
        this.speed =0;
        this.initiative =0;
        this.proficiencyModifier =0;
    }

    public int initiative;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setProficiencyModifier(int proficiencyModifier) {
        this.proficiencyModifier = proficiencyModifier;
    }

    public int proficiencyModifier;
}
