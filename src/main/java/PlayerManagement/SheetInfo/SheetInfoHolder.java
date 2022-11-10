package PlayerManagement.SheetInfo;

import Tools.ITool;
import interfaces.SkillsEnum;
import interfaces.StatsEnum;

import java.util.ArrayList;
import java.util.HashMap;

public class SheetInfoHolder {


    private String className;



    private String subclassName;
    private String raceName;
    private String backStoryName;
    private int hitpoints;
    private int AC;
    private int speed;
    private int initiative;
    private int temporaryHits;
    private int proficiencyModifier;
    private HashMap<StatsEnum,Integer> characterCharacteristic;
    private HashMap<SkillsEnum,Integer> characterSkillProfiecicy;
    private HashMap<StatsEnum,Boolean> characterSavingThrowProficiency;
    private int hitDice;
    private String characterName;
    private ArrayList<ITool> EquipProficiencies;
    private ArrayList<ITool> Equipment;



    private ArrayList<ITool> Abilities;

    public void addAbbility(ITool Ability){
        Abilities.add(Ability);
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getSubclassName() {
        return subclassName;
    }

    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
    }
    public ArrayList<ITool> getAbilities() {
        return Abilities;
    }

}
