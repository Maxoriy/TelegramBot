package PlayerManagement.SheetInfo;

import Tools.ITool;
import Enums.SkillsEnum;
import Enums.StatsEnum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class SheetInfoHolder {
    public ArraysHolder toolLists;
    public NameHolder naming;
    public CharsAndSkills numbers;
    public GameNumHolder gameNums;

    public SheetInfoHolder(){
        toolLists=new ArraysHolder();
        naming=new NameHolder();
        numbers=new CharsAndSkills();
        gameNums=new GameNumHolder();
    }
    public ArrayList<String> FilterSkills(ArrayList<SkillsEnum> d){
        ArrayList<String> rop=new ArrayList<>();
        for (var a:d) {
            if(!numbers.SkillProf.contains(a)){
                rop.add(a.getName());
            }
        }
        return rop;
    }




}
