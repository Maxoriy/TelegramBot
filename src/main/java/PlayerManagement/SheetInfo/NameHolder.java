package PlayerManagement.SheetInfo;

public class NameHolder {
    public String className;
    public String subclassName;
    public String raceName;
    public String characterName;
    public String backStoryName;

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setBackStoryName(String backStoryName) {
        this.backStoryName = backStoryName;
    }

    public NameHolder(){
        className="";
        subclassName="";
        raceName="";
        characterName="";
        backStoryName="";
    }

}
