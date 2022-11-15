package PlayerManagement.SheetInfo;

import Tools.ITool;
import interfaces.SkillsEnum;
import interfaces.StatsEnum;

import java.util.ArrayList;
import java.util.HashMap;

public class SheetInfoHolder {
    public SheetInfoHolder(){
        className="";
        subclassName="";
        raceName="";
        backStoryName="";
        hitpoints=0;
        AC=0;
        speed=0;
        initiative=0;
        temporaryHits=0;
        proficiencyModifier=0;
        characterCharacteristic=new HashMap<>();
        characterSkillProfiecicy=new HashMap<>();
        characterSavingThrowProficiency=new HashMap<>();
        hitDice=0;
        characterName="";
        EquipProficiencies=new ArrayList<>();
        Equipment=new ArrayList<>();
        Abilities=new ArrayList<>();
    }

    private String className;
    private String subclassName;

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    private String raceName;

    public String getBackStoryName() {
        return backStoryName;
    }

    public void setBackStoryName(String backStoryName) {
        this.backStoryName = backStoryName;
    }

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
