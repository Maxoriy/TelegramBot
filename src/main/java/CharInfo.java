import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CharInfo {

    public String InputRace;
    public String InputClass;
    public String InputBackstory;
    public ArrayList<String> SkillAndSaveProficiency;

    public int Hp;
    public int Speed;
    public int[] Stats;
    public long UserID;
    public ArrayList<ITool> Abilities;
    public ArrayList<ITool> Inventory;





    public CharInfo(String race,String clss, String backstory){
        this.InputRace=race;
        this.InputBackstory=backstory;
        this.InputClass=clss;
        this.Stats= new int[6];
        Arrays.fill(this.Stats,0);
        SkillAndSaveProficiency=new ArrayList<>();Abilities=new ArrayList<>();Inventory=new ArrayList<>();
    }


}
