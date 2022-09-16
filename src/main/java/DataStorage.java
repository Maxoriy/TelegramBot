import java.util.ArrayList;
import java.util.HashMap;

public interface DataStorage {
    ArrayList<ITool> getAbilityList(String race,String clss, String backstory,int level);
    ArrayList<ITool> getItemList(String race,String clss, String backstory);
    ArrayList<String> getProficiencies(String race,String clss, String backstory);

}
