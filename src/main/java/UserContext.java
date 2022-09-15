import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UserContext {

    private String InputRace;
    private String InputClass;
    private String InputBackstory;
    private HashMap<String,Boolean> SkillAndSaveProficiency;

    private int Hp;
    private int Speed;
    private int[] Stats;
    private long UserID;
    private ArrayList<ITool> Abilities;
    private ArrayList<ITool> Inventory;





    public UserContext(String race,String clss, String backstory){
        this.InputRace=race;
        this.InputBackstory=backstory;
        this.InputClass=clss;
        this.Stats= new int[6];
        Arrays.fill(this.Stats,0);
    }


}
